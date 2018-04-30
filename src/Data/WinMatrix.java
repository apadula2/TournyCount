package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WinMatrix {
	
	public ArrayList<String> teams;
	public int[][] winMatrix;

	public int[][] getWinMatrix() throws IOException{
		ArrayList<int[]> games = getGames("2018Games.txt");
		teams = getTeams("2018Teams.txt");
		winMatrix = new int[teams.size()+1][teams.size()+1];
		for(int[] game : games){
			winMatrix[game[2]][game[5]]+=1;
		}
		return winMatrix;
	}
	
	public ArrayList<int[]> getGames(String gameFile) throws IOException{
		BufferedReader abc = new BufferedReader(new FileReader(gameFile));
		ArrayList<int[]> games = new ArrayList<int[]>();
		String lines ="";
		while((lines = abc.readLine()) != null) {
			String[] arrayLine = lines.split(",");
			int[] integerLine = new int[arrayLine.length];
			for(int i =0; i < arrayLine.length; i++){
				integerLine[i] = Integer.parseInt(arrayLine[i].replaceAll("\\s+",""));
			}
			//System.out.println(integerLine[0]);
			if(integerLine[1]<=20180304){
		    games.add(integerLine);
			}
		}
		abc.close(); 
		System.out.println(games.size());
		return games;
	}
	
	public ArrayList<String> getTeams(String teamFile) throws IOException{
		BufferedReader abc = new BufferedReader(new FileReader(teamFile));
		ArrayList<String> teams = new ArrayList<String>();
		String lines ="";
		while((lines = abc.readLine()) != null) {
			String[] arrayLine = lines.split(",");
		    teams.add(arrayLine[1]);
		}
		abc.close();
		System.out.println(teams.size());
		return teams;
	}
	
	public int getLength(){
		return teams.size();
	} 
	
	public int getValue(int a,int b) {
		return winMatrix[a][b];
	}
	
};

