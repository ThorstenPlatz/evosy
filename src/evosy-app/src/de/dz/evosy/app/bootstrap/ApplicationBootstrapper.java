package de.dz.evosy.app.bootstrap;

import de.dz.evosy.sim.creature.CreatureFactory;
import de.dz.evosy.sim.creature.life.rules.LifeRules;

public interface ApplicationBootstrapper {

	CreatureFactory getCreatureFactory();

	LifeRules getBioRules();
}
