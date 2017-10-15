package de.dz.evosy.sim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

import de.dz.evosy.sim.creature.life.CreatureLife;
import de.dz.evosy.sim.creature.life.CreatureLifes;

class SimulationLoop {
	private final CreatureLifes creatureLifes;

	private final CheckCreatureIsDeceasing findDeceasingCreatures;

	SimulationLoop(final CreatureLifes creatureLifes) {
		this.creatureLifes = creatureLifes;
		findDeceasingCreatures = new CheckCreatureIsDeceasing();
	}

	public void runLoop(final Time time) {
		creatureLifes.getLivingCreatures().forEach(findDeceasingCreatures);
		findDeceasingCreatures.killThemAll();
	}

	class CheckCreatureIsDeceasing implements Consumer<CreatureLife> {
		Collection<CreatureLife> lifesToEnd = new ArrayList<>();

		@Override
		public void accept(CreatureLife life) {
			if (life.isDeceasing())
				lifesToEnd.add(life);
		}

		void killThemAll() {
			lifesToEnd.forEach(l -> creatureLifes.kill(l));
		}
	}
}
