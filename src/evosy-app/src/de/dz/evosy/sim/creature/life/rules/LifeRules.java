package de.dz.evosy.sim.creature.life.rules;

import java.util.Arrays;
import java.util.Collection;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.characteristic.age.AgeRule;
import de.dz.evosy.sim.creature.characteristic.metabolism.MetabolismRule;

public class LifeRules {

	public Collection<LifeRule> createLifeRules(final Creature creature) {
		LifeRule ageRule = new AgeRule(creature);
		LifeRule metabolismRule = new MetabolismRule(creature);

		return Arrays.asList( //
				ageRule, //
				metabolismRule //
		);
	}

}
