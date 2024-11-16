package com.gully_cricket_application;

public class Player {

	private String playername;
	private int noOfBallsPlayed;
	private int noOfBallsBowled;
	private int runsScored;
	private int runsGiven;
	private int wicketsTaken;
	private boolean isStillBatting=true;
	private boolean isStillBowling=true;;
	public Player() {
		
	}
	public Player(String playername, int noOfBallsPlayed, int noOfBallsBowled, int runsScored, int wicketsTaken) {
		super();
		this.playername = playername;
		this.noOfBallsPlayed = noOfBallsPlayed;
		this.noOfBallsBowled = noOfBallsBowled;
		this.runsScored = runsScored;
		this.wicketsTaken = wicketsTaken;
	}
	public String getPlayername() {
		return playername;
	}
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	public int getNoOfBallsPlayed() {
		return noOfBallsPlayed;
	}
	public void setNoOfBallsPlayed(int noOfBallsPlayed) {
		this.noOfBallsPlayed = noOfBallsPlayed;
	}
	public int getNoOfBallsBowled() {
		return noOfBallsBowled;
	}
	public void setNoOfBallsBowled(int noOfBallsBowled) {
		this.noOfBallsBowled = noOfBallsBowled;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public boolean isStillBatting() {
		return isStillBatting;
	}
	public void setStillBatting(boolean isStillBatting) {
		this.isStillBatting = isStillBatting;
	}
	public boolean isStillBowling() {
		return isStillBowling;
	}
	public void setStillBowling(boolean isStillBowling) {
		this.isStillBowling = isStillBowling;
	}
	public int getRunsGiven() {
		return runsGiven;
	}
	public void setRunsGiven(int runsGiven) {
		this.runsGiven = runsGiven;
	}
	
	
	
	
}
