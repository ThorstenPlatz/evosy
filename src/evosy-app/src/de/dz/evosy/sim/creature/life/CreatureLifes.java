package de.dz.evosy.sim.creature.life;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.life.rules.LifeRules;

public class CreatureLifes {

	private final Collection<CreatureLife> creatureLifes;
	private final LifeRules bioRules;

	public CreatureLifes(final LifeRules bioRules) {
		this.creatureLifes = new HashSet<>();
		this.bioRules = bioRules;
	}

	public CreatureLife awakeCreature(final Creature creature) {
		final CreatureLife creatureLife = new CreatureLife(creature, bioRules);
		creatureLifes.add(creatureLife);
		return creatureLife;
	}

	public void kill(CreatureLife creatureLife) {
		creatureLifes.remove(creatureLife);
	}

	public Collection<CreatureLife> getLivingCreatures() {
		return Collections.unmodifiableCollection(creatureLifes);
	}

	public long countLivingCreatures() {
		return creatureLifes.size();
	}

	@Override
	public String toString() {
		return "CreatureLifes: " + countLivingCreatures() + " alive";
	}

}
