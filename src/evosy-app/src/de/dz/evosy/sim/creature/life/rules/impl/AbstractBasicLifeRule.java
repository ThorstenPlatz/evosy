package de.dz.evosy.sim.creature.life.rules.impl;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.life.rules.LifeRule;

public abstract class AbstractBasicLifeRule implements LifeRule {

	private final Creature creature;

	protected AbstractBasicLifeRule(final Creature creature) {
		this.creature = creature;
	}

	public Creature getCreature() {
		return creature;
	}

	@Override
	public boolean applyAndCheckRule() {
		applyRule();
		return checkRule();
	}

	protected abstract void applyRule();

}
