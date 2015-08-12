package org.purushree.gravahal.game;

import java.util.List;

import org.purushree.gravahal.model.Board;
import org.purushree.gravahal.model.Pit;
import org.purushree.gravahal.model.Player;

public class Game {
	private Board gameBoard;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private String currentMessage;
	
	public Game() {
		gameBoard = new Board();
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		currentMessage = "Game started. Player 1 to move.";
		currentPlayer = player1;
		linkPitToPlayers();
	}
	
	public List<Pit> getBoard() {
		return gameBoard.getPits();
	}
	
	public Pit getOpposingPit(Pit p) {
		int indexOfPit = gameBoard.getPits().indexOf(p);
		if (p.isGravaHalPit()) {
			return null;
		}
		return gameBoard.getPits().get(12 - indexOfPit);
	}
	
	private void linkPitToPlayers() {
		player1.linkPitsToPlayer(gameBoard.getPits().subList(0, 7));
		player2.linkPitsToPlayer(gameBoard.getPits().subList(7, gameBoard.getPits().size()));
	}
	
	private boolean isGameOver() {
		return (player1.playerHasNoStoneInPits() || player2.playerHasNoStoneInPits());
	}
	
	public String getCurrentMessage() {
		return currentMessage;
	}
	
	public void updateGame(int selectedPitIndex) {
		if (isGameOver()) {
			currentMessage = "Game ended. Start a new one.";
			return;
		}
		Pit selectedPit = gameBoard.getPits().get(selectedPitIndex-1);
		if (!currentPlayer.ownsPit(selectedPit)) {
			currentMessage = currentPlayer.getPlayerName() + " does not own the selected pit";
			return;
		}
		if (selectedPit.isGravaHalPit()) {
			currentMessage = "Cannot move stones from GravaHal. " + currentPlayer.getPlayerName() + " to move.";
			return;
		}
		Pit endPit = moveStones(selectedPit);
		captureIfPossible(endPit);
		if (isGameOver()) {
			determineWinner();
			return;
		}
		determineNextPlayer(endPit);
	}

	private void determineWinner() {
		player1.moveAllStonesToGraval();
		player2.moveAllStonesToGraval();
		
		Player winner = (player1.getPlayerGravaHal().getStoneCount() > player2.getPlayerGravaHal().getStoneCount()) ? player1 : player2;
		currentMessage = "Winner: " + winner.getPlayerName() + " !";
	}

	private void determineNextPlayer(Pit endPit) {
		if (endPit.isGravaHalPit() && currentPlayer.ownsPit(endPit)) {
			currentMessage = "Landed on " + currentPlayer.getPlayerName() + " GravaHal. Keeps turn.";
			return;
		}
		
		switchCurrentPlayer();
	}

	private void captureIfPossible(Pit endPit) {
		int numberOfCapturedStones = 0;
		if (endPit.getStoneCount() == 1 && currentPlayer.ownsPit(endPit) && !endPit.isGravaHalPit()) {
			numberOfCapturedStones++;
			endPit.emptyPit();
			Pit oppositePit = getOpposingPit(endPit);
			numberOfCapturedStones += oppositePit.getStoneCount();
			oppositePit.emptyPit();
			Pit playerGravaHalPit = currentPlayer.getPlayerGravaHal();
			playerGravaHalPit.addStonesToPit(numberOfCapturedStones);
		}
	}

	private void switchCurrentPlayer() {
		currentMessage = "";
		if (currentPlayer.equals(player1)) {
			currentPlayer = player2;
			currentMessage = "Player switched.";
		} else {
			currentPlayer = player1;
		}
		currentMessage += " Current player: " + currentPlayer.getPlayerName();
	}

	private Pit moveStones(Pit selectedPit) {
		Pit currentPit = null;
		int stonesInHand = selectedPit.getStoneCount();
		selectedPit.emptyPit();
		int index = gameBoard.getPits().indexOf(selectedPit);
		while (stonesInHand > 0) {
			++index;
			if (index > 13) {
				index = 0;
			}
			currentPit = gameBoard.getPits().get(index);
			if (currentPit.isGravaHalPit() && !currentPlayer.ownsPit(currentPit)) {
				continue;
			}
			currentPit.addStonesToPit(1);
			--stonesInHand;
		}
		return currentPit;
	}
}
