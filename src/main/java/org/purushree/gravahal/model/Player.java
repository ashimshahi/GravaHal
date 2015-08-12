package org.purushree.gravahal.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Pit> playerPits;
	private String playerName;
	
	public String getPlayerName() {
		return playerName;
	}

	public Player(String playerName) {
		this.playerName = playerName;
	}

	public void linkPitsToPlayer(List<Pit> pits) {
		playerPits = new ArrayList<Pit>();
		playerPits.addAll(pits);
	}
	
	public boolean ownsPit(Pit pit) {
		return playerPits.contains(pit);
	}
	
	public boolean playerHasNoStoneInPits() {
		for (Pit p: playerPits) {
			if (!p.isEmpty() && !p.isGravaHalPit()) {
				return false;
			}
		}
		return true;
	}
	
	public Pit getPlayerGravaHal() {
		for (Pit p: playerPits) {
			if (p.isGravaHalPit()) {
				return p;
			}
		}
		return null;
	}
	
	public void moveAllStonesToGraval() {
		Pit gravaHal = getPlayerGravaHal();
		int total = 0;
		for (Pit p: playerPits) {
			total += p.getStoneCount();
			p.emptyPit();
		}
		gravaHal.emptyPit();
		gravaHal.addStonesToPit(total);
	}
}
