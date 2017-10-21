package de.dz.evosy.sim.creature.energy.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractMinMaxEnergyLevelTest {

	static final int MIN_VALUE = 0;
	static final int MAX_VALUE = 1_000;
	static final int INIT_VALUE = 100;

	private DummyEnergyLevel energyLevel;

	@BeforeEach
	void setUp() throws Exception {
		energyLevel = new DummyEnergyLevel();
	}

	@Test
	void testInitialValue() {
		assertEquals(INIT_VALUE, energyLevel.getCurrentValue());
		assertEquals(10, energyLevel.getLevel());
	}

	@Test
	void testCurrentValue() {
		energyLevel.setCurrentValue(500);

		assertEquals(500, energyLevel.getCurrentValue());
		assertEquals(50, energyLevel.getLevel());
	}

	static class DummyEnergyLevel extends AbstractMinMaxEnergyLevel {
		public DummyEnergyLevel() {
			super(MIN_VALUE, MAX_VALUE, INIT_VALUE);
		}
	}

}
