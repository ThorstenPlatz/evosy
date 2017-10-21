package de.dz.evosy.sim.creature.energy.impl;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dz.evosy.sim.creature.energy.impl.AbstractMinMaxEnergyLevelTest.DummyEnergyLevel;

class AbstractInvertedEnergyLevelTest {

	private DummyInvertedEnergyLevel energyLevel;

	@BeforeEach
	void setUp() throws Exception {
		DummyEnergyLevel levelToInvert = new DummyEnergyLevel();
		energyLevel = new DummyInvertedEnergyLevel(levelToInvert);
	}

	@Test
	void testGetLevel() {
		assertEquals(90, energyLevel.getLevel());
	}

	class DummyInvertedEnergyLevel extends AbstractInvertedEnergyLevel<DummyEnergyLevel> {
		public DummyInvertedEnergyLevel(DummyEnergyLevel levelToInvert) {
			super(levelToInvert);
		}
	}

}
