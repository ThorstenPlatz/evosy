package de.dz.evosy.sim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.CreatureFactory;
import de.dz.evosy.sim.creature.life.CreatureLifes;
import de.dz.evosy.sim.creature.life.rules.LifeRules;

/**
 * The Simulator runs the simulation by handling the {@link Creature}s over
 * {@link Time} in the {@link World}.
 */
public class Simulator {
	private static final Logger LOG = LoggerFactory.getLogger(Simulator.class);

	private TimeTicker ticker = new TimeTicker();

	private CreatureLifes creatureLifes;

	public Simulator(final CreatureFactory creatureFactory, final LifeRules bioRules) {
		this.creatureLifes = new CreatureLifes(bioRules);

		initCreatures(creatureFactory);
	}

	public void run() {
		long numLivingCreatures = creatureLifes.countLivingCreatures();
		LOG.info("Simulation of " + numLivingCreatures + " creatures running ...");

		SimulationLoop loop = new SimulationLoop(creatureLifes);
		while (numLivingCreatures > 0) {
			ticker.increment();
			loop.runLoop(ticker);

			numLivingCreatures = creatureLifes.countLivingCreatures();

			final String time = String.format("%08d", ticker.getTime());
			LOG.info("T+" + time + ": " + numLivingCreatures + " creatures alive: "
					+ creatureLifes.getLivingCreatures());

			if (ticker.getTime() > 101)
				System.exit(1);
		}

		LOG.info("Simulation terminated.");
	}

	private void initCreatures(final CreatureFactory creatureFactory) {
		final int num_initial_creatures = 5;

		for (int i = 0; i < num_initial_creatures; ++i) {
			final Creature creature = creatureFactory.createCreature();
			creatureLifes.awakeCreature(creature);
		}
	}
}
