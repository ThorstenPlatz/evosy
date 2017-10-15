package de.dz.evosy.sim.creature.energy.impl;

import de.dz.evosy.sim.creature.energy.EnergyLevel;

/**
 * Implementation of EnergyLevel using a value range between a given minimum and
 * maximum.
 */
public abstract class AbstractMinMaxEnergyLevel implements EnergyLevel {

	private int minValue;
	private int maxValue;
	private int currentValue;

	private int percentage;

	public AbstractMinMaxEnergyLevel(final int minValue, final int maxValue, final int initialValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		setCurrentValue(initialValue);
	}

	@Override
	public int getLevel() {
		return percentage;
	}

	public void setCurrentValue(final int currentValue) {
		int newValue = currentValue;
		if (currentValue > maxValue)
			newValue = maxValue;
		if (currentValue < minValue)
			newValue = minValue;
		this.currentValue = newValue;

		refreshPercentage();
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	private void refreshPercentage() {
		double normalizedMaxValue = maxValue - minValue;
		double normalizedCurrentValue = currentValue - minValue;
		percentage = (int) Math.round(100 * (normalizedCurrentValue / normalizedMaxValue));
	}

}
