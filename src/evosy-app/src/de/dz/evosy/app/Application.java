package de.dz.evosy.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dz.evosy.app.bootstrap.ApplicationBootstrapper;
import de.dz.evosy.app.bootstrap.DefaultBootstrapper;
import de.dz.evosy.sim.Simulator;

/** This is the entry point for the evosy application. */
public class Application {
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	private static ApplicationBootstrapper bootstrapper;

	public static void main(String[] args) {
		LOG.info("Starting Evosy Application");

		bootstrapper = new DefaultBootstrapper();

		Simulator simulator = new Simulator(bootstrapper.getCreatureFactory(), bootstrapper.getBioRules());
		simulator.run();

		LOG.info("Evosy Application terminated.");
	}

}
