package com.montyhall.test.business;

/**
 * A game's door having doorId.
 * @author Shivang
 *
 */
public class MontyhallDoor {
	
private final int doorId;
    
    public MontyhallDoor(int doorId)
    {
        this.doorId = doorId;
    }
    
    public int getDoorId()
    {
        return this.doorId;
    }

	@Override
	public String toString() {
		return "[DoorId=" + doorId + "]";
	}
}
