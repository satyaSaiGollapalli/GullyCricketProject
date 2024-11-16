package com.gully_cricket_application;

public interface Display {
	
	void welcome();
	void displayPlayers(String [] team);
	void getLiveScore();
	void gameResults();
	void instructions();
	void enterNext();
	void toss(Team taeamA,Team taeamB) throws InterruptedException;
	void firstInnings(Team A,Team B);
	void secondInnings(Team A,Team B);
	void toSleep(String message);
	void winnerDeclaration(Team teamA,Team teamB);
	void matchSummary(Team teamA,Team teamB);
	void playerStatistics(Team teamA,Team teamB);

}
