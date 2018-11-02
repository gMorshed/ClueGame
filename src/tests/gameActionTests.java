package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;
import clueGame.ComputerPlayer;

public class gameActionTests {
	private static Board board;
	@Before
	public void setUp() {
		board = Board.getInstance();
		board.setConfigFiles("Board_Layout.csv", "ClueRooms.txt");
		board.setPlayerConfigFile("people.txt");
		board.setWeaponConfigFile("weapon.txt");
		board.initialize();
	}

	@Test
	public void test1targetLocation() {
		ComputerPlayer player = new ComputerPlayer(5,0, Color.blue, "Mr. Stark");
		//a location with no rooms in target, just three targets
		board.calcTargets(17, 0, 2);
		boolean loc_16_0 = false;
		boolean loc_17_2 = false;
		boolean loc_16_1 = false;
		// Run the test a large number of times
		for (int i=0; i<100; i++)  { 
			BoardCell selected = player.pickLocation(board.getTargets());
			if (selected == board.getCellAt(12, 0)) 
				loc_16_0 = true; 
			else if (selected == board.getCellAt(14, 2)) 
				loc_17_2 = true;
			else if (selected == board.getCellAt(15, 1)) 
				loc_16_1 = true;
			else fail("Invalid target selected"); 
		}
		// Ensure each target was selected at least once
		assertTrue(loc_16_0); 
		assertTrue(loc_17_2); 
		assertTrue(loc_16_1);
		
		//One ensures that the room is always selected if it isn't the last visited
		//One ensures that if the room is the last visited, a random choice is made.
		player.setRow(2);
		player.setColumn(5);
		board.calcTargets(2, 5, 1);
		BoardCell lastVisted = (player.getVisited_list()).get((player.getVisited_list()).size()-1);
		Set<BoardCell> targets  = board.getTargets();
		assertFalse(targets.contains(lastVisted)); // stuck here
		for( BoardCell cell: board.getTargets()) {
			if((player.getVisited_list()).get((player.getVisited_list()).size()-1).equals(cell)) {
				
			}
		}
 
		
	}
	
	
}

