package com.montyhall.test.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A Montyhall game session, consisting of a list of Doors and the 
 * winning door id.
 * @author Shivang
 *
 */
public class MontyhallGameSession {

	 private final List<MontyhallDoor> doors;
	 private final int winningDoorId;
	    
	    public MontyhallGameSession(int numDoors)
	    {
	        Random random = new Random();
	        
	        winningDoorId = random.nextInt(numDoors);
	        
	        doors = IntStream.range(0, numDoors)
	                .mapToObj(id -> new MontyhallDoor(id))
	                .collect(Collectors.toList());
	    }
	    
	    public int getWinningDoorId()
	    {
	        return this.winningDoorId;
	    }
	    
	    public List<MontyhallDoor> getDoors()
	    {
	        return new ArrayList<MontyhallDoor>(this.doors);
	    }
}
