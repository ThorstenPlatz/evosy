package de.dz.evosy.sim.creature.energy.impl;

import de.dz.evosy.sim.creature.energy.EnergyLevel;

public abstract class AbstractInvertedEnergyLevel<I extends EnergyLevel> implements EnergyLevel {

	private I invertedLevel;

	public AbstractInvertedEnergyLevel(final I levelToInvert) {
		this.invertedLevel = levelToInvert;
	}

	@Override
	public int getLevel() {
		return 100 - invertedLevel.getLevel();
	}

	protected I getInvertedLevel() {
		return invertedLevel;
	}
}
