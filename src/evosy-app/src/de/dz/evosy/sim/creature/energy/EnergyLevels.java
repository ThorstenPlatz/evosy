package de.dz.evosy.sim.creature.energy;

import java.util.Collection;
import java.util.Collections;

public class EnergyLevels {

	private Collection<EnergyLevel> energyLevels;

	public EnergyLevels(Collection<EnergyLevel> energyLevels) {
		this.energyLevels = energyLevels;
	}

	public Collection<EnergyLevel> getEnergyLevels() {
		return Collections.unmodifiableCollection(energyLevels);
	}

	@SuppressWarnings("unchecked")
	public <E> E getEnergyLevel(Class<E> clazz) {
		return energyLevels.stream() //
				.filter(e -> clazz.isAssignableFrom(e.getClass())) //
				.map(e -> (E) e) //
				.findFirst().orElse(null);
	}

}
