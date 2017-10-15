package de.dz.evosy.app.bootstrap;

import de.dz.evosy.sim.creature.CreatureFactory;
import de.dz.evosy.sim.creature.impl.gen1.Gen1CreatureFactory;
import de.dz.evosy.sim.creature.life.rules.LifeRules;

public class DefaultBootstrapper implements ApplicationBootstrapper {

	@Override
	public CreatureFactory getCreatureFactory() {
		return new Gen1CreatureFactory();
	}

	@Override
	public LifeRules getBioRules() {
		return new LifeRules();
	}
}
