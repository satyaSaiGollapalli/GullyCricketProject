package com.gully_cricket_application;
import java.util.*;

public class MainClass {
	public void welcomeMessage() throws InterruptedException {
		System.out.println();
		System.out.println();
		Display display=DisplayDetails.displayDetails();
		display.welcome();
		System.out.println();
		System.out.println("...............!!");
		
		display.enterNext();
		//Thread.sleep(4000);
		display.instructions();
		display.enterNext();
		//Thread.sleep(4000);
		System.out.println("...............!!");
		
		display.displayPlayers(Team.team);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		MainClass mainClass=new MainClass();
		DisplayImple display=(DisplayImple)DisplayDetails.displayDetails();
		
		Team teamA=new Team();
		Team teamB=new Team();
		mainClass.welcomeMessage();
		display.enterNext();
		//Thread.sleep(3000);
		display.teamSelection(teamA,teamB,Team.team);
		display.displayBothTeams(teamA, teamB);
		display.toss(teamA, teamB);
		display.firstInnings(teamA, teamB);
		display.secondInnings(teamA, teamB);
		display.winnerDeclaration(teamA,teamB);
		display.matchSummary(teamA, teamB);
		display.playerStatistics(teamA, teamB);
		
	
	}

}
