package de.dz.evosy.sim.creature.characteristic.age;

import de.dz.evosy.sim.creature.characteristic.age.AgeEnergyLevel.InvertedAgeEnergyLevel;
import de.dz.evosy.sim.creature.energy.impl.AbstractInvertedEnergyLevel;
import de.dz.evosy.sim.creature.energy.impl.AbstractMinMaxEnergyLevel;

/** Represents the age of a creature. */
public class AgeEnergyLevel extends AbstractInvertedEnergyLevel<InvertedAgeEnergyLevel> {

	public AgeEnergyLevel(int maxAge) {
		super(new InvertedAgeEnergyLevel(maxAge));
	}

	public void increaseAge() {
		InvertedAgeEnergyLevel invertedAge = getInvertedLevel();
		invertedAge.setCurrentValue(invertedAge.getCurrentValue() + 1);
	}

	public int getAge() {
		return getInvertedLevel().getCurrentValue();
	}

	public static class InvertedAgeEnergyLevel extends AbstractMinMaxEnergyLevel {
		public InvertedAgeEnergyLevel(int maxValue) {
			super(0, maxValue, 0);
		}
	}
}
