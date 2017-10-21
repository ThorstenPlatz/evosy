package de.dz.evosy.sim.creature.characteristic.age;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.energy.EnergyLevels;

class AgeRuleTest {

	static final int MAX_AGE = 5;

	private DummyCreature creature;
	private AgeRule ageRule;
	private AgeEnergyLevel ageEnergyLevel;

	@BeforeEach
	void setUp() throws Exception {
		ageEnergyLevel = new AgeEnergyLevel(MAX_AGE);
		creature = new DummyCreature();
		ageRule = new AgeRule(creature);
	}

	@Test
	void testApplyRule() {
		assertEquals(0, ageEnergyLevel.getAge());
		assertEquals(100, ageEnergyLevel.getLevel());

		ageRule.applyRule();
		assertEquals(1, ageEnergyLevel.getAge());

		ageRule.applyRule();
		ageRule.applyRule();
		ageRule.applyRule();
		ageRule.applyRule();
		assertEquals(5, ageEnergyLevel.getAge());
		assertEquals(0, ageEnergyLevel.getLevel());

		// cannot get older than MAX_AGE
		ageRule.applyRule();
		assertEquals(MAX_AGE, ageEnergyLevel.getAge());
	}

	@Test
	void testCheckRule() {
		assertTrue(ageRule.checkRule());

		ageEnergyLevel.increaseAge();
		ageEnergyLevel.increaseAge();
		ageEnergyLevel.increaseAge();
		ageEnergyLevel.increaseAge();
		assertTrue(ageRule.checkRule());

		// too old
		ageEnergyLevel.increaseAge();
		assertFalse(ageRule.checkRule());
	}

	class DummyCreature implements Creature {

		@Override
		public String getName() {
			return "DummyCreature";
		}

		@Override
		public EnergyLevels getEnergyLevels() {
			return new EnergyLevels(Collections.singleton(ageEnergyLevel));
		}

	}

}
