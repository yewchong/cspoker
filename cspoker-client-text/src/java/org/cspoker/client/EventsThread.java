package org.cspoker.client;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.cspoker.client.request.GameEventsAckRequest;
import org.cspoker.client.request.contenthandler.EventsContentHandler;
import org.cspoker.client.savedstate.Cards;
import org.cspoker.client.savedstate.Pot;

public class EventsThread implements Runnable {
	private static Logger logger = Logger.getLogger(EventsThread.class);

    private final EventsContentHandler handler;
    private final GameEventsAckRequest request;

    private boolean running;
    private volatile int waitSlots;
    private final int waitUnit;

    public EventsThread(String address, Cards cards, Pot pot) throws MalformedURLException {
	handler = new EventsContentHandler(cards, pot);
	request = new GameEventsAckRequest(address, handler);
	running = true;
	waitSlots=1;
	waitUnit = 200;
    }

    public void run() {
	while (running) {
	    try {
		request.execute("");
		List<String> events = handler.getEvents();
		if(events.size()>0){
			EventsThread.logger.info("");
		    for(String line:events){
		    	EventsThread.logger.info(line);
		    }
		    System.out.print(">");
		    halfWait();
		}else{
		    doubleWait();
		}
	    } catch (Exception e) {
		doubleWait();
	    }

	    int i=0;
	    while(i<waitSlots){
		try {
		    Thread.sleep(waitUnit);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		i++;
	    }
	}

    }

    public boolean isRunning() {
	return running;
    }

    public void setRunning(boolean running) {
	this.running = running;
    }

    public synchronized void doubleWait () {
	if(waitSlots<20)
	    waitSlots*=2;
    }

    public synchronized void halfWait () {
	if(waitSlots>=4)
	    waitSlots/=4;
    }

    public synchronized void resetWait(){
	waitSlots = 1;
    }

}
