package clueGame;

import java.awt.Color;

public class HumanPlayer extends Player {

	public HumanPlayer(int row, int column, Color color, String playerName) {
		super(row, column, color, playerName);
	}
	@Override
	public boolean isHuman() {
		return true;
	}
}