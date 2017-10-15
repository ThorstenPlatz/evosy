package de.dz.evosy.sim.creature.characteristic.age;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.life.rules.impl.AbstractBasicLifeRule;

public class AgeRule extends AbstractBasicLifeRule {

	private final AgeEnergyLevel ageEnergyLevel;

	public AgeRule(final Creature creature) {
		super(creature);
		this.ageEnergyLevel = creature.getEnergyLevels().getEnergyLevel(AgeEnergyLevel.class);
		if (ageEnergyLevel == null)
			throw new IllegalStateException("No age on creature: " + creature);
	}

	@Override
	public void applyRule() {
		ageEnergyLevel.increaseAge();
	}

	@Override
	public boolean checkRule() {
		return ageEnergyLevel.getLevel() > 0;
	}

}
