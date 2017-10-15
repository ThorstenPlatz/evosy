package de.dz.evosy.sim;

public class TimeTicker implements Time {

	private long ticker = 0;

	@Override
	public long getTime() {
		return ticker;
	}

	public void increment() {
		++ticker;
	}

}
