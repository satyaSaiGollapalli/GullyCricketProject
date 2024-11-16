package com.gully_cricket_application;
import java.util.*;





public class DisplayImple implements Display{

	//DisplayImple displayImple=new DisplayImple();
	@Override
	public void welcome() {
		// TODO Auto-generated method stub
		System.out.println("|--------------------------------------------------------------------|");
		System.out.println("|                                                                    |");
		System.out.println("|             WELCOME TO GULLY CRICKET APPLICATION                   |");
		System.out.println("|                                                                    |");
		System.out.println("|--------------------------------------------------------------------|");
		
	}
	@Override
	public void instructions() {
		
		    System.out.println("----------------------------------------------------------");
		    System.out.println("|===================== Instructions =====================|");
		    System.out.println("----------------------------------------------------------");
		    System.out.println("|                                                        |");
		    System.out.println("| 1. Create 2 teams ( Team-A and Team-B ) with 5 players |");
		    System.out.println("|    each ) from a given pool of 12 players.             |");
		    System.out.println("| 2. Lead the toss and decide the choice of play.        |");
		    System.out.println("| 3. Each innings will be of 12 balls(2 overs).          |");
		    System.out.println("----------------------------------------------------------");
		
	}
	@Override
	public void displayPlayers(String [] team) {
		// TODO Auto-generated method stub
		 
		    System.out.println("----------------------------------------------");
		    System.out.println("|=================== Pool ===================|");
		    System.out.println("----------------------------------------------");
		for(int i=0;i<team.length;i++) {
			System.out.println("                "+(i+1)+" "+team[i]);
		}
	}

	@Override
	public void getLiveScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameResults() {
		// TODO Auto-generated method stub
		
	}
	
	public void teamSelection(Team teamA,Team teamB,String[] team) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("----------------------------------------------");
		System.out.println("|========= Create Team-A and Team-B =========|");
		System.out.println("----------------------------------------------");
		int count=teamA.noOfPlayersPerTeam+teamB.noOfPlayersPerTeam;
		while(count!=0) {
			if(count%2==0) {
				System.out.println("Select a player for TEAM A");
				int index=scanner.nextInt();
				if(index>0 && index<=team.length) {
					if(teamA.myTeam.indexOf(team[index-1])<0 && teamB.myTeam.indexOf(team[index-1])<0) {
						teamA.myTeam.add(team[index-1]);
						System.out.println(team[index-1]+" is added to TEAM A succesfully..");
						System.out.println();
						count--;
					}else {
						System.out.println("Selected player is already chosen please go for another ..!!!");
					}
				}
				else {
					System.out.println("Enter valid player Index....!!!");
				}
			}
			else {
				System.out.println("Select a player for TEAM B");
				int index=scanner.nextInt();
				if(index>0 && index<=team.length) {
					if(teamB.myTeam.indexOf(team[index-1])<0 && teamA.myTeam.indexOf(team[index-1])<0) {
						teamB.myTeam.add(team[index-1]);
						System.out.println(team[index-1]+" is added to TEAM B succesfully");
						System.out.println();
						count--;
					}
					else {
						System.out.println("Selected player is already chosen please go for another ..!!!");
					}
				}
				else {
					System.out.println("Enter valid player Index....!!!");
				}
			}
		}
		
	}
	
	public void displayBothTeams(Team teamA,Team teamB) {
		
		    System.out.println("--------------------------\t\t--------------------------" );
		    System.out.println("|=======  Team-A  =======|\t\t|=======  Team-B  =======|");
		    System.out.println("--------------------------\t\t--------------------------");
		for(int i=0;i<teamA.myTeam.size();i++) {
			String s=teamA.myTeam.get(i);
			String s2=teamB.myTeam.get(i);
			int index=i+1;
			
			//System.out.println("  "+teamA.myTeam.get(i)+"        "+teamB.myTeam.get(i));
			System.out.printf("      %d.%-20S                  %d.%-20S",index,s,index,s2);
			System.out.println();
		}
		
		
	}
	@Override
	public void enterNext() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Enter any key to continue......");
		Scanner scanner=new Scanner(System.in);
		char ch=scanner.next().charAt(0);		
	}
	@Override
	public void toss(Team teamA,Team teamB) throws InterruptedException {
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		System.out.println();
		System.out.println();
		System.out.println("Be ready for toss...!!");
		System.out.println();
		Thread.sleep(1000);
		System.out.println("If toss is 1 TEAM-A can opt else for 2 TEAM-B can choose.");
		System.out.println();
		new DisplayImple().toSleep("............");
		System.out.println();
		int toss=random.nextInt(10);
		//System.out.println(toss);
		if(toss%2==0) {
			toss=2;
		}else {
			toss=1;
		}
		//System.out.println(toss);
		 outer:
		while(teamA.isbatting!=true && teamB.isbatting!=true) {
		if(toss==1) {
			System.out.println();
			System.out.println(" Team-A won the Toss");
			System.out.println("Choose...........");
			System.out.println("1.Batting");
			System.out.println("2.Bowlingg");
			System.out.println();
			int option=scanner.nextInt();
			inner:
			if(option==1) {
			
				teamA.isbatting=true;
				System.out.println();
				System.out.println("TEAM-A elect to bat first....");
				System.out.println("BATTING TEAM IS--->TEAM A");
				System.out.println("BOWLING TEAM IS--->TEAM B");
				System.out.println();
				
				break;
				
			}

			else if(option==2){
				teamB.isbatting=true;
				System.out.println();
				System.out.println("TEAM-A elect to bowl first....");
				System.out.println("BATTING TEAM IS--->TEAM B");
				System.out.println("BOWLING TEAM IS--->TEAM A");
				System.out.println();
				break;
			}
			
			else{
				System.out.println();
				System.err.println("Invalid option please choose.. 1 or 2");
				System.out.println();
			}
			}
			
		
		else if(toss==2){
			System.out.println();
			System.out.println(" Team-B won the Toss");
			System.out.println("Choose...........");
			System.out.println("1.Batting");
			System.out.println("2.Bowling");
			System.out.println();
			int option=scanner.nextInt();
			if(option==1) {
				
				teamB.isbatting=true;
				System.out.println();
				System.out.println("TEAM-B elect to bat first....");
				System.out.println("BATTING TEAM IS--->TEAM B");
				System.out.println("BOWLING TEAM IS--->TEAM A");
				System.out.println();
				break;
				
			}

			else if(option==2){
				teamA.isbatting=true;
				System.out.println();
				System.out.println("TEAM-B elect to bowl first....");
				System.out.println("BATTING TEAM IS--->TEAM A");
				System.out.println("BOWLING TEAM IS--->TEAM B");
				System.out.println();
				break;
			}
			
			else{
				System.out.println();
				System.err.println("Invalid option please choose.. 1 or 2");
				System.out.println();
			}
			}
		
		
		}
		
		
		
	}
	@Override
	public void firstInnings(Team teamA, Team teamB) {
		DisplayImple displayImple=new DisplayImple();
		//List<Player> battingTeam=new ArrayList<Player>();
		//List<Player> bowlingTeam=new ArrayList<Player>();
		// TODO Auto-generated method stub
		if(teamA.isbatting) {
			
			int overCount=0;
			int batsmanIndex=0;
			int totalballCount=0;
			int bowlerRun=0;
			int bowlerWicketCount=0;
			Random random=new Random();
			int index=random.nextInt(teamB.myTeam.size());
			Player bowler=new Player();
			teamB.bowlingTeam.add(bowler);
			bowler.setPlayername(teamB.myTeam.get(index));
			Player batsmen=new Player();
			teamA.battingTeam.add(batsmen);
			batsmen.setPlayername(teamA.myTeam.get(batsmanIndex));
			teamA.totalRunsRunsScored=0;
			teamA.totalRunsRunsGiven=0;
			int ballCount=0;
			int batsmenPlayedballs=0;
			int currentScore=0;
			while(overCount!=2 && teamA.totalWicketsLost!=teamA.myTeam.size()) {
				System.out.println();
				System.out.println("Batsman from TEAM-A is :"+batsmen.getPlayername()+"          Bowler from TEAM-B is : "+bowler.getPlayername());
				System.out.println();
				
				while(true) {
					System.out.println();
					System.out.println("Bowler ready to bowl..!");
					System.out.println();
					new DisplayImple().enterNext();
					int run=random.nextInt(7);
					teamA.totalRunsRunsScored+=run;
					bowlerRun+=run;
					currentScore+=run;
					totalballCount++;
					if(run==0) {
						displayImple.toSleep(".....it's an OUT!!!");
						batsmenPlayedballs++;
						bowlerWicketCount++;
						System.out.println();
						ballCount++;
						batsmanIndex++;
						teamA.totalWicketsLost++;
						teamB.totalWicketsTaken++;
						bowler.setNoOfBallsBowled(ballCount);
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
						batsmen.setRunsScored(currentScore);
						System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getRunsScored()+")"+batsmen.getNoOfBallsPlayed()+"  got OUT.");
						System.out.println();
						batsmen=new Player();
						teamA.battingTeam.add(batsmen);
						//Player batsmen=new Player();
						batsmen.setPlayername(teamA.myTeam.get(batsmanIndex));
						System.out.println("New Batsmen..."+batsmen.getPlayername());
						System.out.println();
						batsmenPlayedballs=0;
						currentScore=0;
						//break;
					}
					else {
						displayImple.toSleep("....it's  "+run+" run!");
						System.out.println();
						ballCount++;
						//bowler.setNoOfBallsBowled(ballCount);
						batsmen.setNoOfBallsPlayed(ballCount);
						batsmen.setNoOfBallsBowled(run);
						batsmen.setRunsScored(currentScore);
						batsmenPlayedballs++;
						bowler.setNoOfBallsBowled(ballCount);
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
						batsmen.setRunsScored(currentScore);
						
					}
					if(totalballCount==6 ) {
						overCount++;
						index=random.nextInt(teamB.myTeam.size());
						bowler.setRunsGiven(bowlerRun);
						bowler.setWicketsTaken(bowlerWicketCount);
						bowler.setNoOfBallsBowled(ballCount);
						bowler=new Player();
						teamB.bowlingTeam.add(bowler);
						index=random.nextInt(teamB.myTeam.size());
						bowler.setPlayername(teamB.myTeam.get(index));
						bowlerRun=0;
						bowlerWicketCount=0;
						ballCount=0;
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
						batsmen.setRunsScored(currentScore);
						//System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getNoOfBallsPlayed()+")"+batsmen.getRunsScored()+"  got OUT.");
						System.out.println("Over completed bowler changed to "+bowler.getPlayername());
						System.out.println();
						new DisplayImple().toSleep("       CurrentScore is.. "+teamA.totalRunsRunsScored+" runs and lost "+teamA.totalWicketsLost+" wickets");
						System.out.println();
						break;
						
					}
					if(totalballCount==12) {
						bowler.setRunsGiven(bowlerRun);
						bowler.setWicketsTaken(bowlerWicketCount);
						batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
						bowler.setNoOfBallsBowled(ballCount);
						batsmen.setRunsScored(currentScore);
						overCount++;
						new DisplayImple().toSleep("Over completed");
						System.out.println();
						new DisplayImple().toSleep("First Innings  Completed...");
						System.out.println();
						System.out.println("|-----------------------INNINGS SUMMARY IS-------------------|");
						break;
					}
				}
				//battingTeam.add(batsmen);
				if(teamA.totalWicketsLost==teamA.myTeam.size()) {
					new DisplayImple().toSleep("TEAM-A got all OUT..!!!!!");
				}
				//teamA.totalRunsRunsScored=currentScore;
				teamB.totalRunsRunsGiven=teamA.totalRunsRunsScored;
				
				
			}
			String so=" ";
			System.out.printf("%5s TEAM- A Total score      %3d  and lost    %3d    wickets",so,teamA.totalRunsRunsScored,teamA.totalWicketsLost);
			System.out.println();
			int i=1;
			for(Player p:teamA.battingTeam) {
				
				System.out.printf("%5s Player "+i+" ["+p.getPlayername()+"] made ("+p.getRunsScored()+") in ("+p.getNoOfBallsPlayed()+") balls",so);
				System.out.println();
				i++;
			}
			System.out.println();
			System.out.printf("%5s TEAM- B Total wickets taken  %3d  and gave   %3d     runs",so,teamB.totalWicketsTaken,teamB.totalRunsRunsGiven);
			System.out.println();
			int j=1;
			for(Player p:teamB.bowlingTeam) {
				
				System.out.printf("%5s Player "+j+" ["+p.getPlayername()+"] took wickets ("+p.getWicketsTaken()+") in ("+p.getNoOfBallsBowled()+") balls and gave ("+p.getRunsGiven()+") runs ",so);
				System.out.println();
				j++;
				
			}
			teamA.isbatting=false;
			teamB.isbatting=true;
			
		}else
		{
			int overCount=0;
			int batsmanIndex=0;
			int totalballCount=0;
			int batsmenBallCouunt=0;
			int bowlerWickets=0;
			int bowlerRun=0;
			Random random=new Random();
			int index=random.nextInt(teamA.myTeam.size());
			Player bowler=new Player();
			teamA.bowlingTeam.add(bowler);
			bowler.setPlayername(teamA.myTeam.get(index));
			teamB.totalRunsRunsScored=0;
			teamA.totalRunsRunsGiven=0;
			Player batsmen=new Player();
			teamB.battingTeam.add(batsmen);
			batsmen.setPlayername(teamB.myTeam.get(batsmanIndex));
			int ballCount=0;
			int currentScore=0;
			while(overCount!=2 && teamB.totalWicketsLost!=teamB.myTeam.size()) {
				
				System.out.println("Batsman from TEAM-B is :"+batsmen.getPlayername()+"          Bowler from TEAM-A is : "+bowler.getPlayername());
				System.out.println();
				
				
				while(true) {
					
					System.out.println("Bowler ready to bowl..!");
					new DisplayImple().enterNext();
					System.out.println();
					int run=random.nextInt(7);
					bowlerRun+=run;
					teamB.totalRunsRunsScored+=run;
					totalballCount++;
					currentScore+=run;
					if(run==0) {
						displayImple.toSleep(".....it's an OUT!!!");
						batsmenBallCouunt++;
						bowlerWickets++;
						//totalballCount++;
						System.out.println();
						ballCount++;
						batsmanIndex++;
						teamB.totalWicketsLost++;
						teamA.totalWicketsTaken++;
						bowler.setNoOfBallsBowled(ballCount);
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getRunsScored()+")"+batsmen.getNoOfBallsPlayed()+"  got OUT.");
						 batsmen=new Player();
						 teamB.battingTeam.add(batsmen);
						batsmen.setPlayername(teamB.myTeam.get(batsmanIndex));
						System.out.println("New Batsmen..."+batsmen.getPlayername());
						batsmenBallCouunt=0;
						currentScore=0;
						
						
					}
					else {
						displayImple.toSleep("....it's  "+run+" run!");
						System.out.println();
						ballCount++;
						//totalballCount++;
						bowler.setNoOfBallsBowled(ballCount);
						batsmen.setNoOfBallsPlayed(ballCount);
						batsmen.setNoOfBallsBowled(run);
						batsmen.setRunsScored(currentScore);
						batsmenBallCouunt++;
						bowler.setNoOfBallsBowled(ballCount);
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						
					}
					if(totalballCount==6) {
						overCount++;
						index=random.nextInt(teamA.myTeam.size());
						bowler.setRunsGiven(bowlerRun);
						bowler.setWicketsTaken(bowlerWickets);
						bowler.setNoOfBallsBowled(ballCount);
						bowler=new Player();
						teamA.bowlingTeam.add(bowler);
						bowlerRun=0;
						bowlerWickets=0;
						ballCount=0;
						index=random.nextInt(teamA.myTeam.size());
						bowler.setPlayername(teamA.myTeam.get(index));
						System.out.println("Over completed bowler changed to "+bowler.getPlayername());
						System.out.println();
						new DisplayImple().toSleep("CurrentScore is "+teamB.totalRunsRunsScored+" runs and lost "+teamB.totalWicketsLost+" wickets");
						System.out.println();
						
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						//System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getNoOfBallsPlayed()+")"+batsmen.getRunsScored()+"  got OUT.");
						break;
						
					}
					if(totalballCount==12) {
						bowler.setRunsGiven(bowlerRun);
						bowler.setWicketsTaken(bowlerWickets);
						bowler.setNoOfBallsBowled(ballCount);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						overCount++;
						new DisplayImple().toSleep("Over completed");
						System.out.println();
						new DisplayImple().toSleep("First Innings Completed...");
						System.out.println();
						System.out.println("|-----------------------INNINGS SUMMARY IS-------------------|");
						System.out.println();
						break;
					}
				}
				//battingTeam.add(batsmen);
				if(teamB.totalWicketsLost==teamA.myTeam.size()) {
					new DisplayImple().toSleep("TEAM-B got all OUT..!!!!!");
				}
				//teamB.totalRunsRunsScored=currentScore;
				teamA.totalRunsRunsGiven=teamB.totalRunsRunsScored;
			}
			String sp=" ";
			System.out.printf("%5s TEAM- B Total score      %3d  and lost    %3d    wickets",sp,teamB.totalRunsRunsScored,teamB.totalWicketsLost);
			System.out.println();
			int i=1;
			for(Player p:teamB.battingTeam) {
				
				System.out.printf("%5s Player "+i+" ["+p.getPlayername()+"] made ("+p.getRunsScored()+") in ("+p.getNoOfBallsPlayed()+") balls",sp);
				System.out.println();
				i++;
			}
			System.out.println();
			System.out.printf("%5s TEAM- B Total wickets taken  %3d  and gave   %3d     runs",sp,teamA.totalWicketsTaken,teamA.totalRunsRunsGiven);
			System.out.println();
			int j=1;
			for(Player p:teamA.bowlingTeam) {
				
				System.out.printf("%5s Player "+j+" ["+p.getPlayername()+"] took ("+p.getWicketsTaken()+") wickets  in ("+p.getNoOfBallsBowled()+") balls and gave ("+p.getRunsGiven()+") runs",sp);
				System.out.println();
				j++;
				
			}
			teamB.isbatting=false;
			teamA.isbatting=true;
			
		}
		
	}
	@Override
	public void toSleep(String message) {
		
		
		for(int i=0;i<message.length();i++) {
			char ch=message.charAt(i);
			System.out.print(ch);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void secondInnings(Team teamA, Team teamB) {
		
		System.out.println();
		System.out.println();
		new DisplayImple().toSleep("---****---SECOND INNINGS STARTED----***-----");
		System.out.println();
		////List<Player> battingTeam=new ArrayList<Player>();
		//List<Player> bowlingTeam=new ArrayList<Player>();
		if(teamA.isbatting) {
			System.out.println();
			new DisplayImple().toSleep("TEAM-A has to score "+(teamB.totalRunsRunsScored+1)+" to WIN");
			System.out.println();
		
		
			if(teamA.isbatting) {
				
				int overCount=0;
				int batsmanIndex=0;
				int totalballCount=0;
				int bowlerRun=0;
				int bowlerWicketCount=0;
				Random random=new Random();
				int index=random.nextInt(teamB.myTeam.size());
				Player bowler=new Player();
				teamB.bowlingTeam.add(bowler);
				bowler.setPlayername(teamB.myTeam.get(index));
				Player batsmen=new Player();
				teamA.battingTeam.add(batsmen);
				batsmen.setPlayername(teamA.myTeam.get(batsmanIndex));
				teamA.totalRunsRunsScored=0;
				teamA.totalRunsRunsGiven=0;
				int ballCount=0;
				int batsmenPlayedballs=0;
				int currentScore=0;
				while(overCount!=2 && teamA.totalWicketsLost!=teamA.myTeam.size()) {
					System.out.println();
					System.out.println("Batsman from TEAM-A is :"+batsmen.getPlayername()+"          Bowler from TEAM-B is : "+bowler.getPlayername());
					System.out.println();
					
					while(true) {
						
						System.out.println("Bowler ready to bowl..!");
						System.out.println();
						new DisplayImple().enterNext();
						int run=random.nextInt(7);
						teamA.totalRunsRunsScored+=run;
						bowlerRun+=run;
						currentScore+=run;
						totalballCount++;
						if(teamA.totalRunsRunsScored<teamB.totalRunsRunsScored) {
						if(run==0) {
							new DisplayImple().toSleep(".....it's an OUT!!!");
							batsmenPlayedballs++;
							bowlerWicketCount++;
							System.out.println();
							ballCount++;
							batsmanIndex++;
							teamA.totalWicketsLost++;
							teamB.totalWicketsTaken++;
							bowler.setNoOfBallsBowled(ballCount);
							//batsmen.setNoOfBallsBowled(run);
							batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
							batsmen.setRunsScored(currentScore);
							System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getNoOfBallsPlayed()+")"+batsmen.getRunsScored()+"  got OUT.");
							batsmen=new Player();
							teamA.battingTeam.add(batsmen);
							//Player batsmen=new Player();
							batsmen.setPlayername(teamA.myTeam.get(batsmanIndex));
							System.out.println("New Batsmen..."+batsmen.getPlayername());
							batsmenPlayedballs=0;
							currentScore=0;
							//break;
						}
						else {
							new DisplayImple().toSleep("....it's  "+run+" run!");
							System.out.println();
							ballCount++;
							//bowler.setNoOfBallsBowled(ballCount);
							batsmen.setNoOfBallsPlayed(ballCount);
							batsmen.setNoOfBallsBowled(run);
							batsmen.setRunsScored(currentScore);
							batsmenPlayedballs++;
							bowler.setNoOfBallsBowled(ballCount);
							//batsmen.setNoOfBallsBowled(run);
							batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
							batsmen.setRunsScored(currentScore);
							
						}
						if(totalballCount==6 ) {
							overCount++;
							index=random.nextInt(teamB.myTeam.size());
							bowler.setRunsGiven(bowlerRun);
							bowler.setWicketsTaken(bowlerWicketCount);
							bowler.setNoOfBallsBowled(ballCount);
							bowler=new Player();
							teamB.bowlingTeam.add(bowler);
							index=random.nextInt(teamB.myTeam.size());
							bowler.setPlayername(teamB.myTeam.get(index));
							bowlerRun=0;
							bowlerWicketCount=0;
							ballCount=0;
							//batsmen.setNoOfBallsBowled(run);
							batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
							batsmen.setRunsScored(currentScore);
							//System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getNoOfBallsPlayed()+")"+batsmen.getRunsScored()+"  got OUT.");
							System.out.println("Over completed bowler changed to "+bowler.getPlayername());
							new DisplayImple().toSleep("Current score is "+teamA.totalRunsRunsScored+" runs and lost "+teamA.totalWicketsLost+" wickets");
							break;
							
						}
						if(totalballCount==12) {
							bowler.setRunsGiven(bowlerRun);
							bowler.setWicketsTaken(bowlerWicketCount);
							batsmen.setNoOfBallsPlayed(batsmenPlayedballs);
							bowler.setNoOfBallsBowled(ballCount);
							batsmen.setRunsScored(currentScore);
							overCount++;
							new DisplayImple().toSleep("Over completed");
							System.out.println();
							new DisplayImple().toSleep("First Innings  Completed...");
							System.out.println();
							System.out.println("|-----------------------MATCH SUMMARY IS-------------------|");
							break;
						}
					}else {
						
						new DisplayImple().toSleep("           TEAM-A WON BY "+(teamA.noOfPlayersPerTeam-teamA.totalWicketsLost)+" WICKETS ");
						System.out.println();
						overCount=2;
						break;
					}
						
					}
					//battingTeam.add(batsmen);
					if(teamA.totalWicketsLost==teamA.myTeam.size()) {
						System.out.println();
						new DisplayImple().toSleep("TEAM-A got all OUT..!!!!!");
						System.out.println();
					}
					//teamA.totalRunsRunsScored=currentScore;
					teamB.totalRunsRunsGiven=teamA.totalRunsRunsScored;
					
					
				}
				String so=" ";
				System.out.printf("%5s TEAM- A Total score      %3d  and lost    %3d    wickets",so,teamA.totalRunsRunsScored,teamA.totalWicketsLost);
				System.out.println();
				int i=1;
				for(Player p:teamA.battingTeam) {
					
					System.out.printf("%5s Player "+i+" ["+p.getPlayername()+"] made ("+p.getRunsScored()+") in ("+p.getNoOfBallsPlayed()+") balls",so);
					System.out.println();
					i++;
				}
				System.out.println();
				System.out.printf("%5s TEAM- B Total wickets taken  %3d  and gave   %3d     runs",so,teamB.totalWicketsTaken,teamB.totalRunsRunsGiven);
				System.out.println();
				int j=1;
				for(Player p:teamB.bowlingTeam) {
					
					System.out.printf("%5s Player "+j+" ["+p.getPlayername()+"] took wickets ("+p.getWicketsTaken()+") in ("+p.getNoOfBallsBowled()+") balls and gave ("+p.getRunsGiven()+") runs",so);
					System.out.println();
					j++;
					
				}
			}
			teamA.isbatting=false;
			teamB.isbatting=true;
		}
			
		    else if(teamB.isbatting){
		    	System.out.println();
			new DisplayImple().toSleep("TEAM-B has to score "+(teamA.totalRunsRunsScored+1)+" to WIN");
			System.out.println();
			
			int overCount=0;
			int batsmanIndex=0;
			int totalballCount=0;
			int batsmenBallCouunt=0;
			int bowlerWickets=0;
			int bowlerRun=0;
			Random random=new Random();
			int index=random.nextInt(teamA.myTeam.size());
			Player bowler=new Player();
			teamA.bowlingTeam.add(bowler);
			bowler.setPlayername(teamA.myTeam.get(index));
			teamB.totalRunsRunsScored=0;
			teamA.totalRunsRunsGiven=0;
			Player batsmen=new Player();
			teamB.battingTeam.add(batsmen);
			batsmen.setPlayername(teamB.myTeam.get(batsmanIndex));
			int ballCount=0;
			int currentScore=0;
			while(overCount!=2 && teamB.totalWicketsLost!=teamB.myTeam.size()) {
				System.out.println();
				System.out.println("Batsman from TEAM-B is :"+batsmen.getPlayername()+"          Bowler from TEAM-A is : "+bowler.getPlayername());
				System.out.println();
				//boolean flag=true;
				
				while(true) {
					
					System.out.println("Bowler ready to bowl..!");
					new DisplayImple().enterNext();
					System.out.println();
					int run=random.nextInt(7);
					bowlerRun+=run;
					teamB.totalRunsRunsScored+=run;
					totalballCount++;
					currentScore+=run;
					if(teamB.totalRunsRunsScored<teamA.totalRunsRunsScored) {
					if(run==0) {
						new DisplayImple().toSleep(".....it's an OUT!!!");
						batsmenBallCouunt++;
						bowlerWickets++;
						//totalballCount++;
						System.out.println();
						ballCount++;
						batsmanIndex++;
						teamB.totalWicketsLost++;
						teamA.totalWicketsTaken++;
						bowler.setNoOfBallsBowled(ballCount);
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getNoOfBallsPlayed()+")"+batsmen.getRunsScored()+"  got OUT.");
						 batsmen=new Player();
						teamB. battingTeam.add(batsmen);
						batsmen.setPlayername(teamB.myTeam.get(batsmanIndex));
						System.out.println("New Batsmen..."+batsmen.getPlayername());
						batsmenBallCouunt=0;
						currentScore=0;
						
						
					}
					else {
						new DisplayImple().toSleep("....it's  "+run+" run!");
						System.out.println();
						ballCount++;
						//totalballCount++;
						bowler.setNoOfBallsBowled(ballCount);
						batsmen.setNoOfBallsPlayed(ballCount);
						batsmen.setNoOfBallsBowled(run);
						batsmen.setRunsScored(currentScore);
						batsmenBallCouunt++;
						bowler.setNoOfBallsBowled(ballCount);
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						
					}
					if(totalballCount==6) {
						overCount++;
						index=random.nextInt(teamA.myTeam.size());
						bowler.setRunsGiven(bowlerRun);
						bowler.setWicketsTaken(bowlerWickets);
						bowler.setNoOfBallsBowled(ballCount);
						bowler=new Player();
						teamA.bowlingTeam.add(bowler);
						bowlerRun=0;
						bowlerWickets=0;
						ballCount=0;
						index=random.nextInt(teamA.myTeam.size());
						bowler.setPlayername(teamA.myTeam.get(index));
						System.out.println("Over completed bowler changed to "+bowler.getPlayername());
						new DisplayImple().toSleep("Current score "+teamB.totalRunsRunsScored+" runs and lost "+teamB.totalWicketsLost+" wickets");
						//batsmen.setNoOfBallsBowled(run);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						//System.out.println("Batsmen "+batsmen.getPlayername()+" ("+batsmen.getNoOfBallsPlayed()+")"+batsmen.getRunsScored()+"  got OUT.");
						break;
						
					}
					if(totalballCount==12) {
						bowler.setRunsGiven(bowlerRun);
						bowler.setWicketsTaken(bowlerWickets);
						bowler.setNoOfBallsBowled(ballCount);
						batsmen.setNoOfBallsPlayed(batsmenBallCouunt);
						batsmen.setRunsScored(currentScore);
						overCount++;
						new DisplayImple().toSleep("Over completed");
						System.out.println();
						new DisplayImple().toSleep("Second Innings Completed...");
						System.out.println();
						System.out.println("|-----------------------MATCH SUMMARY IS-------------------|");
						break;
					}
				
				}else {
					System.out.println();
					new DisplayImple().toSleep("....it's  "+run+" run!");
					System.out.println();
					new DisplayImple().toSleep("    TEAM-B WON THE MATCH BY "+(teamB.noOfPlayersPerTeam-teamB.totalWicketsLost)+" WICKETS  ");
					overCount=2;
					break;
				}
				//battingTeam.add(batsmen);
				if(teamB.totalWicketsLost==teamA.myTeam.size()) {
					new DisplayImple().toSleep("TEAM-B got all OUT..!!!!!");
				}
				//teamB.totalRunsRunsScored=currentScore;
				teamA.totalRunsRunsGiven=teamB.totalRunsRunsScored;
			}
			}
			String sp=" ";
			System.out.printf("%5s TEAM- B Total score      %3d  and lost    %3d    wickets",sp,teamB.totalRunsRunsScored,teamB.totalWicketsLost);
			System.out.println();
			int i=1;
			for(Player p:teamB.battingTeam) {
				
				System.out.printf("%5s Player "+i+" ["+p.getPlayername()+"] made ("+p.getRunsScored()+") in ("+p.getNoOfBallsPlayed()+") balls",sp);
				System.out.println();
				i++;
			}
			System.out.println();
			System.out.printf("%5s TEAM- B Total wickets taken  %3d  and gave   %3d     runs",sp,teamA.totalWicketsTaken,teamA.totalRunsRunsGiven);
			System.out.println();
			int j=1;
			for(Player p:teamB.bowlingTeam) {
				
				System.out.printf("%5s Player "+j+" ["+p.getPlayername()+"] took ("+p.getWicketsTaken()+") wickets  in ("+p.getNoOfBallsBowled()+") balls and gave ("+p.getRunsGiven()+") runs",sp);
				System.out.println();
				j++;
				
			}
			
			teamB.isbatting=false;
			teamA.isbatting=true;
		
		}
	
	
	}
	@Override
	public void winnerDeclaration(Team teamA, Team teamB) {
		if(teamA.totalRunsRunsScored==teamB.totalRunsRunsScored) {
			System.out.println();
			new DisplayImple().toSleep("        Match Tied between two Teams     ");
			System.out.println();
		}
		if(teamA.isbatting) {
		if(teamA.totalRunsRunsScored>teamB.totalRunsRunsScored) {
			System.out.println();
			System.out.println();
			new DisplayImple().toSleep("                   TEAM A WON THE MATCH BY "+(teamA.totalRunsRunsScored-teamB.totalRunsRunsScored)+" RUNS");
			System.out.println();
		}
		}
		if(teamB.isbatting) {
		if(teamA.totalRunsRunsScored<teamB.totalRunsRunsScored) {
			System.out.println();
			System.out.println();
			new DisplayImple().toSleep("                   TEAM B WON THE MATCH BY "+(teamB.totalRunsRunsScored-teamA.totalRunsRunsScored)+" RUNS");
			System.out.println();
		}}
		
	}
	@Override
	public void matchSummary(Team teamA, Team teamB) {
		System.out.println();
		System.out.println();
		new DisplayImple().toSleep("|                      MATCH SUMMARY   -  FIRST INNINGS              |");
		System.out.println();
		System.out.println();
		if(teamA.isbatting) {
			new DisplayImple().toSleep("             TEAM-A   SCORECARD     ");
			System.out.println();
			for(Player p:teamA.battingTeam) {
				System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Played: ("+p.getNoOfBallsPlayed()+") Runs Scored: ("+p.getRunsScored()+")");
			}
			System.out.println();
			new DisplayImple().toSleep("             TEAM-B   BOWLING REPORT     ");
			System.out.println();
		   for(Player p:teamB.bowlingTeam) {
			   System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Bowled: ("+p.getNoOfBallsBowled()+") Wickets Taken: ("+p.getWicketsTaken()+")");
		   }
		   System.out.println();
		   new DisplayImple().toSleep("|                      MATCH SUMMARY   -  SECOND INNINGS              |");
			System.out.println();
			System.out.println();
			new DisplayImple().toSleep("             TEAM-B   SCORECARD     ");
			System.out.println();
			for(Player p:teamB.battingTeam) {
				System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Played: ("+p.getNoOfBallsPlayed()+") Runs Scored: ("+p.getRunsScored()+")");
			}
			System.out.println();
			new DisplayImple().toSleep("             TEAM-A   BOWLING REPORT     ");
			System.out.println();
		   for(Player p:teamA.bowlingTeam) {
			   System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Bowled: ("+p.getNoOfBallsBowled()+") Wickets taken: ("+p.getWicketsTaken()+")");
		   }
		   System.out.println();
		   System.out.println();
		}else {
			
			new DisplayImple().toSleep("             TEAM-B   SCORECARD     ");
			System.out.println();
			for(Player p:teamB.battingTeam) {
				System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Played: ("+p.getNoOfBallsPlayed()+") Runs Scored: ("+p.getRunsScored()+")");
			}
			System.out.println();
			new DisplayImple().toSleep("             TEAM-A   BOWLING REPORT     ");
			System.out.println();
		   for(Player p:teamA.bowlingTeam) {
			   System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Bowled: ("+p.getNoOfBallsBowled()+") Wickets taken: ("+p.getWicketsTaken()+")");
		   }
		   System.out.println();
		   new DisplayImple().toSleep("|                      MATCH SUMMARY   -  SECOND INNINGS              |");
			System.out.println();
			System.out.println();
			new DisplayImple().toSleep("             TEAM-A   SCORECARD     ");
			System.out.println();
			for(Player p:teamA.battingTeam) {
				System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Played: ("+p.getNoOfBallsPlayed()+") Runs Scored: ("+p.getRunsScored()+")");
			}
			System.out.println();
			new DisplayImple().toSleep("             TEAM-B   BOWLING REPORT     ");
			System.out.println();
		   for(Player p:teamB.bowlingTeam) {
			   System.out.println("        Player Name: ["+p.getPlayername()+"]   Balls Bowled: ("+p.getNoOfBallsBowled()+") Wickets taken: ("+p.getWicketsTaken()+")");
		   }
		   System.out.println();
		   System.out.println();
			
			
		}
		
	}
	@Override
	public void playerStatistics(Team teamA, Team teamB) {
		
		String batterName="";
		int topScorer=0;
		String bowlerName="";
		int topWickets=0;
		
		for(Player p:teamA.battingTeam) {
	
			if(topScorer<p.getRunsScored()) {
				topScorer=p.getRunsScored();
				batterName=p.getPlayername();
			}
		}
		for(Player p:teamB.battingTeam) {
			
			if(topScorer<p.getRunsScored()) {
				topScorer=p.getRunsScored();
				batterName=p.getPlayername();
			}
		}
		
		for(Player p:teamA.bowlingTeam) {
			
			if(topWickets<p.getWicketsTaken()) {
				topWickets=p.getWicketsTaken();
				bowlerName=p.getPlayername();
			}
		}
		for(Player p:teamB.battingTeam) {
			
			if(topWickets<p.getWicketsTaken()) {
				topWickets=p.getWicketsTaken();
				bowlerName=p.getPlayername();
			}
		}
		System.out.println();
		System.out.println();
		
		new DisplayImple().toSleep("\t TOP PERFORMERS OF THE MATCH ARE..........");
		System.out.println();
		System.out.println();
		new DisplayImple().toSleep("\t TOP RUN SCORER IS ----> "+batterName+" WITH "+topScorer+"   RUNS");
		System.out.println();
		System.out.println();
		new DisplayImple().toSleep("\t TOP WICKET TAKER IS ----> "+bowlerName+" WITH "+topWickets+"   WICKETS");
		
	}
}
		
		
		
		
	


	
	


