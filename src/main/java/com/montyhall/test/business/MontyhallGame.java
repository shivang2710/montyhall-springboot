package com.montyhall.test.business;

import java.util.ArrayList;
import java.util.List;
/**
 *  Monty Hall game implementation.
 * <p>
 * Executes a {@link MontyhallGameSession} once initialized.
 * @author Shivang
 *
 */
public class MontyhallGame {

    
    private final int winningDoorId;
    private List<MontyhallDoor> doors ;
    private int selectedDoorId = -1;
    private int reselectedDoorId = -1;
    
    public MontyhallGame(MontyhallGameSession session, Boolean switchSelection)
    {
        doors = new ArrayList<MontyhallDoor>();
        doors.addAll(session.getDoors());
        this.winningDoorId = session.getWinningDoorId();
        play(switchSelection);
    }
    
    public boolean playerWon()
    {
        return this.selectedDoorId == this.winningDoorId;
    }
    
    
    private void play(Boolean switchSelection)
    {
    	selectedDoorId = selectDoor();
    	boolean isDone = false;
        
		while (!isDone) {
			openDoor();
			if (switchSelection == Boolean.TRUE) {
				selectedDoorId = selectDoor();
				this.reselectedDoorId = selectedDoorId;
			}

			isDone = this.doors.size() == 2; // no choice left when two doors are left
		}
		
    }
    
    private int selectDoor()
    {
    	MontyhallDoor door = this.doors.stream()
                .filter(d -> d.getDoorId()!= this.selectedDoorId)
                .findAny().get();
        return door != null? door.getDoorId() : -1; // non-existent id if null
    }
    
    private void openDoor()
    {
    	MontyhallDoor door = this.doors.stream()
                .filter(d -> d.getDoorId() != this.winningDoorId && d.getDoorId() != this.selectedDoorId)
                .findAny().get();
        
        this.doors.remove(door); // removal signifies opening the door
    }

	public int getSelectedDoorId() {
		return this.selectedDoorId;
	}

	public int getReselectedDoorId() {
		return this.reselectedDoorId;
	}

	public int getWinningDoorId() {
		return this.winningDoorId;
	}

	public List<MontyhallDoor> getDoors() {
		return this.doors;
	}
    
    
}
