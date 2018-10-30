package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.Player;

public class gameSetupTests {

	private static Board board;
	@Before
	public void setUp() {
		/**
		 * This test will set up the board  of variety of cards of each type that 
		 * will be required for testing
		 */
		board = Board.getInstance();
		board.setConfigFiles("BoardLayout.csv", "Legends.txt");
		board.setPlayerConfigFile("Players.txt");
		//board.setWeaponConfigFile("Weapons.txt");
		board.initialize();
	}

	@Test
	public void testLoadPeople() {
		ArrayList<Player> playerList = board.getPlayerList(); //get the playerList from board
		
		assertEquals(playerList.get(0).getPlayerName(), "Mr. Stark"); //one computer player and the first player
		assertEquals(playerList.get(3).getPlayerName(), "Steve Rogers"); //one human player and the 3rd player
		assertEquals(playerList.get(5).getPlayerName(), "Thor"); //last player
		
	}
	
	

}