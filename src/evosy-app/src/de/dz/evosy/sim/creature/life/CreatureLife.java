package de.dz.evosy.sim.creature.life;

import java.util.Collection;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.life.rules.LifeRule;
import de.dz.evosy.sim.creature.life.rules.LifeRules;

public class CreatureLife {

	private Creature creature;

	private Collection<LifeRule> bioRules;

	public CreatureLife(final Creature creature, final LifeRules bioRules) {
		this.creature = creature;
		this.bioRules = bioRules.createLifeRules(creature);

	}

	public Creature getCreature() {
		return creature;
	}

	public boolean isDeceasing() {
		for (LifeRule bioRule : bioRules) {
			if (!bioRule.applyAndCheckRule())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return creature.toString();
	}

}
