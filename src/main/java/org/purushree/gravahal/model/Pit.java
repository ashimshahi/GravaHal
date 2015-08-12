package org.purushree.gravahal.model;

public final class Pit {
	private final String id;
	private int stoneCount = 6;
	private boolean isGravaHal;
	
	public Pit(String id, boolean isGravaHal) {
		this.id = id;
		this.isGravaHal = isGravaHal;
		if (this.isGravaHal) {
			emptyPit();
		}
	}
	
	public boolean isGravaHalPit() {
		return isGravaHal;
	}
	
	public String getId() {
		return id;
	}
	
	public void emptyPit() {
		this.stoneCount = 0;
	}
	
	public boolean isEmpty() {
		return stoneCount == 0;
	}
	
	public void addStonesToPit(int count) {
		this.stoneCount += count;
	}
	
	public int getStoneCount() {
		return stoneCount;
	}
}
