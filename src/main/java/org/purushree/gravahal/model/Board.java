package org.purushree.gravahal.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Pit> board;
	
	public Board() {
		board = new ArrayList<Pit>();
		for (int i = 1; i <= 14; i++) {
			boolean isGravaHal = false;
			if (i % 7 == 0) {
				isGravaHal = true;
			}
			board.add(new Pit(Integer.toString(i), isGravaHal));
		}
	}

	public List<Pit> getPits() {
		return board;
	}
}
