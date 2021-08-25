package edu.escuelaing.arem;

import static spark.Spark.*;

/**
 * Minimal web app example for Heroku using SparkWeb
 *
 * @author daniel and alejandra
 */
public class App {
	/**
	 * This main method uses SparkWeb static method to get the port. Additionally,
	 * load static files, the stocks' s controller and service.
	 */
	public static void main(String[] args) {
		port(getPort());
		System.out.println("Server is starting...");

		staticFiles.location("/public"); // load static files
		new StocksController(new StocksService());
	}

	/**
	 * This method reads the default port as specified by the PORT variable in the
	 * environment.
	 *
	 * Heroku provides the port automatically so you need this to run the project on
	 * Heroku.
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
	}

}
