package de.dz.evosy.sim.creature.characteristic.metabolism;

public class MetabolismBehavior {

	private MetabolismEnergyLevel metabolismEnergyLevel;

	public MetabolismBehavior(final MetabolismEnergyLevel metabolismEnergyLevel) {
		this.metabolismEnergyLevel = metabolismEnergyLevel;
	}

	public void invoke() {
		eat();
	}

	public int evaluatePriority() {
		return 120 - metabolismEnergyLevel.getLevel();
	}

	private void eat() {
		metabolismEnergyLevel.increaseBy(5);
	}

}
