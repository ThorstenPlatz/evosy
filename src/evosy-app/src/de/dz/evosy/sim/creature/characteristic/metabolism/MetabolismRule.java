package de.dz.evosy.sim.creature.characteristic.metabolism;

import de.dz.evosy.sim.creature.Creature;
import de.dz.evosy.sim.creature.life.rules.impl.AbstractBasicLifeRule;

public class MetabolismRule extends AbstractBasicLifeRule {

	private final MetabolismEnergyLevel metabolsimEnergyLevel;

	public MetabolismRule(final Creature creature) {
		super(creature);
		metabolsimEnergyLevel = creature.getEnergyLevels().getEnergyLevel(MetabolismEnergyLevel.class);
	}

	@Override
	public boolean checkRule() {
		return metabolsimEnergyLevel.getLevel() > 0;
	}

	@Override
	public void applyRule() {
		metabolsimEnergyLevel.decreaseBy(1);
	}

}
