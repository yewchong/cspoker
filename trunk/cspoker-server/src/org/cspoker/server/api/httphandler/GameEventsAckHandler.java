/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.server.api.httphandler;


import javax.xml.transform.sax.TransformerHandler;

import org.cspoker.server.api.PlayerCommunicationFactory;
import org.cspoker.server.api.events.EventsToEventsTag;
import org.cspoker.server.api.httphandler.abstracts.HttpHandlerImpl;
import org.cspoker.server.api.httphandler.abstracts.RequestStreamHandler;
import org.cspoker.server.api.httphandler.exception.HttpSaxException;
import org.cspoker.server.game.gameControl.IllegalActionException;
import org.cspoker.server.game.playerCommunication.GameEvents;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.net.httpserver.HttpExchange;

public class GameEventsAckHandler extends RequestStreamHandler {

    
    private final EventsToEventsTag eventsToXml;
    
    public GameEventsAckHandler() {
	super();
	eventsToXml = new EventsToEventsTag();
    }
    
    @Override
    protected ContentHandler getRequestHandler(final HttpExchange http, final TransformerHandler response){

	return new DefaultHandler(){

	    private final StringBuilder sb=new StringBuilder();
	    private String ack;


	    @Override
	    public void startElement(String uri, String localName, String name,
	            Attributes attributes) throws SAXException {
	        sb.setLength(0);
	    }

	    @Override
	    public void endElement(String uri, String localName, String name)
	            throws SAXException {
	        if(name.equalsIgnoreCase("ack"))
	            ack=sb.toString();
		sb.setLength(0);
	    }

	    @Override
	    public void characters(char[] ch, int start, int length)
	            throws SAXException {
		sb.append(ch, start, length);
	    }

	    @Override
	    public void endDocument() throws SAXException {
		String username= HttpHandlerImpl.toPlayerName(http.getRequestHeaders());
		GameEvents events;
		try {
		    events=PlayerCommunicationFactory.getRegisteredPlayerCommunication(username)
		        	.getLatestGameEventsAndAck(Integer.parseInt(ack));
		} catch (NumberFormatException e) {
		    throw new HttpSaxException(e, 400);
		} catch (IllegalActionException e) {
		    throw new HttpSaxException(e, 403);
		}
		
		eventsToXml.transform(response, events);
	    }
	};
    }

    @Override
    protected int getDefaultStatusCode() {
	return 200;
    }

}