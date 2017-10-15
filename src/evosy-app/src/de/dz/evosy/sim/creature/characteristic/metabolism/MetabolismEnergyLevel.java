package de.dz.evosy.sim.creature.characteristic.metabolism;

import de.dz.evosy.sim.creature.energy.impl.AbstractMinMaxEnergyLevel;

/** Represents the energy the creature has to support it's metabolism. */
public class MetabolismEnergyLevel extends AbstractMinMaxEnergyLevel {

	public MetabolismEnergyLevel(int maxValue, int initalValue) {
		super(0, maxValue, initalValue);
	}

	public void increaseBy(int anabolicAmount) {
		setCurrentValue(getCurrentValue() + anabolicAmount);
	}

	public void decreaseBy(int katabolicAmount) {
		setCurrentValue(getCurrentValue() - katabolicAmount);
	}

}
