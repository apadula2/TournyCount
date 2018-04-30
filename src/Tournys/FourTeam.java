package Tournys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import Data.WinMatrix;
public class FourTeam {
	
 	private Map<Integer, ArrayList<int[]>> fourTeam;
	private int[][] tournyCount;
	private int totalTournys=0;
	
	public FourTeam(){
		
	}
	

	public void tornyWork(int[][] matrix){
		
		fourTeam = new HashMap<Integer,  ArrayList<int[]>>();
		tournyCount = new int[matrix.length][2];
		for(int a =0; a<matrix.length; a++){
			int teamA = a;
			ArrayList<int[]> empty = new ArrayList<int[]>();
			fourTeam.put(teamA, empty);
			for(int e =0; e<matrix.length;e++){
				int teamE = e;
				for(int c =0; c<matrix.length;c++){
					int teamC = c;
					for(int f=0; f<matrix.length;f++){
						int teamF = f;
						int tournyNum = (matrix[teamA][teamC])*(matrix[teamA][ teamE])*(matrix[teamC][teamF]);
						if(tournyNum!=0 && f!=a && f!=e && c!=e && e!=a && c!=a && f!=c ){
						int [] tournament = {teamE,teamC,teamF,tournyNum};
						ArrayList<int[]> list = fourTeam.get(teamA);
						list.add(tournament);
						fourTeam.put((Integer)(teamA),list);
						//System.out.println(fourTeam.get(teamA));
						tournyCount[teamA][0]= teamA; 
						tournyCount[teamA][1]= tournyCount[teamA][1]+ tournyNum;
						}
					}
				} 
			}
		}

		
	}
	public Map<Integer, ArrayList<int[]>> getFourTournys(int[][] matrix){
		tornyWork(matrix);
		return fourTeam;
	}
	public int[][] getFourCounts(int[][] winMatrix){
		tornyWork(winMatrix);
		return tournyCount;
	}
	
	public int[][] getRankings(int[][] matrix){
		int[][] tournamentCounts = getFourCounts(matrix);
		Arrays.sort(tournamentCounts, Comparator.comparingInt(arr -> arr[1]));
		return tournamentCounts;

	}
}
