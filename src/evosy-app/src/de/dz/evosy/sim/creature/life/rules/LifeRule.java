package de.dz.evosy.sim.creature.life.rules;

public interface LifeRule {

	/**
	 * Does only the checking part of this rule (readonly access to the creature).
	 */
	boolean checkRule();

	/**
	 * Applying this rule might change properties of the creature (write access).
	 */
	boolean applyAndCheckRule();

}
