package com.montyhall.test.business;
/**
 * This class contains the result of the montyhall game simulator
 */
import java.util.HashMap;
import java.util.Map;

public class MontyhallResultDTO {

	private int iterationNumber;
	private Map<String, String> doorDetailMap = new HashMap<String, String>();
	private int originalSelectedDoor;
	private int finalSelectedDoor;
	private boolean gameResult;
	private double winPercentage;
	
	
	public MontyhallResultDTO(MontyhallGame game, int iteration) {
		this.iterationNumber = iteration;
		this.originalSelectedDoor = game.getSelectedDoorId();
		this.finalSelectedDoor = game.getReselectedDoorId();
		game.getDoors().stream().forEach(door -> {
			if(game.getWinningDoorId() == door.getDoorId()) {
				doorDetailMap.put(door.toString(), "1");
			}
			doorDetailMap.put(door.toString(), "0");
		});
		
	}
	public MontyhallResultDTO(double winPercent) {
		this.winPercentage = winPercent;
	}
	
	public int getIterationNumber() {
		return iterationNumber;
	}
	public void setIterationNumber(int iterationNumber) {
		this.iterationNumber = iterationNumber;
	}
	public int getOriginalSelectedDoor() {
		return originalSelectedDoor;
	}
	public void setOriginalSelectedDoor(int originalSelectedDoor) {
		this.originalSelectedDoor = originalSelectedDoor;
	}
	public int getFinalSelectedDoor() {
		return finalSelectedDoor;
	}
	public void setFinalSelectedDoor(int finalSelectedDoor) {
		this.finalSelectedDoor = finalSelectedDoor;
	}
	public boolean isGameResult() {
		return gameResult;
	}
	public void setGameResult(boolean gameResult) {
		this.gameResult = gameResult;
	}
	public Map<String, String> getDoorDetailMap() {
		return doorDetailMap;
	}
	public void setDoorDetailMap(Map<String, String> doorDetailMap) {
		this.doorDetailMap = doorDetailMap;
	}
	public double getWinPercentage() {
		return winPercentage;
	}
	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}
	
}
