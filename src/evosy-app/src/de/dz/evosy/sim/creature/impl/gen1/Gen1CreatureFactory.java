package de.dz.evosy.sim.creature.impl.gen1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.CreatureFactory;
import de.dz.evosy.sim.creature.characteristic.age.AgeEnergyLevel;
import de.dz.evosy.sim.creature.characteristic.metabolism.MetabolismEnergyLevel;
import de.dz.evosy.sim.creature.energy.EnergyLevels;

public class Gen1CreatureFactory implements CreatureFactory {

	private static AtomicLong creatureIdCounter = new AtomicLong();

	@Override
	public Creature createCreature() {
		final String name = generateCreatureName(creatureIdCounter.incrementAndGet());
		final EnergyLevels energyLevels = buildEnergyLevels();

		return new Gen1Creature(name, energyLevels);
	}

	private EnergyLevels buildEnergyLevels() {
		// sleep to refill
		AgeEnergyLevel ageEnergy = new AgeEnergyLevel(100);

		// eat to refill
		MetabolismEnergyLevel metabolismEnergyLevel = new MetabolismEnergyLevel(100, 50);

		return new EnergyLevels(Arrays.asList( //
				ageEnergy, //
				metabolismEnergyLevel //
		));
	}

	private static String generateCreatureName(final long creatureId) {
		return "Gen1Creature#" + String.format("%04d", creatureId);
	}

}
