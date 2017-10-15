package de.dz.evosy.sim.creature;

import de.dz.evosy.sim.creature.characteristic.age.AgeEnergyLevel;
import de.dz.evosy.sim.creature.energy.EnergyLevels;

public class AbstractBasicCreature implements Creature {

	private final String name;
	private final EnergyLevels energyLevels;

	protected AbstractBasicCreature(final String name, final EnergyLevels energyLevels) {
		this.name = name;
		this.energyLevels = energyLevels;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public EnergyLevels getEnergyLevels() {
		return energyLevels;
	}

	@Override
	public String toString() {
		return name + " (" + getAge() + ")";
	}

	public int getAge() {
		return energyLevels.getEnergyLevel(AgeEnergyLevel.class).getAge();
	}

}
