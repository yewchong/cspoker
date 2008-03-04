package org.cspoker.server.rmi;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.cspoker.common.util.Log4JPropertiesLoader;

public class RunRMIServer {

	static {
		Log4JPropertiesLoader
				.load("org/cspoker/server/rmi/logging/log4j.properties");
	}

	private final static Logger logger = Logger.getLogger(RunRMIServer.class);

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		if (args.length != 1) {
			usage();
		}
		int port = Integer.parseInt(args[0]);
		logger.info("Starting RMI server at port "+port);
		//need to do this in two steps to prevent GC!!
		RMIServer server = new RMIServer(port);
		server.start();
	}

	private static void usage() {
		logger.fatal("usage: java -jar cspoker-server-rmi.jar [portnumber]");
		System.exit(0);
	}

}