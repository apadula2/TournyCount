package Tournys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import Data.WinMatrix;
public class EightTeam {
	
 	private Map<Integer, ArrayList<int[]>> fourTournys;
 	private Map<Integer, ArrayList<int[]>> eightTeam;
 	private int[][] tournyCount;
	private int totalTournys=0;
	private FourTeam fourTeam = new FourTeam();
	private int[][] winMatrix;
	
	public EightTeam(int[][] matrix){
		winMatrix = matrix;
		fourTournys = fourTeam.getFourTournys(winMatrix);
		tournyCount = new int[matrix.length][2];
	}
	
	public void tournyWork(){
		for(int a =0; a< winMatrix.length; a++){
			int aTeam = a;
			for(int b =0; b<winMatrix.length; b++){
				
				int bTeam = b;
				
				if(winMatrix[aTeam][bTeam]!=0){
				ArrayList<int[]>aTournaments = fourTournys.get(aTeam);
				ArrayList<int[]>bTournaments =fourTournys.get(bTeam);
				for(int i=0; i< aTournaments.size(); i++){
					int[] aTourny = aTournaments.get(i);
					for(int j=0; j< bTournaments.size();j++){
						int[] bTourny = bTournaments.get(j);
						boolean same = false;
						for(int insideA =0; insideA< aTourny.length-1; insideA++){
							for(int insideB = 0 ; insideB < bTourny.length-1; insideB++){
								if(aTourny[insideA]==bTourny[insideB]|| bTourny[insideB]==aTeam|| aTourny[insideA]==bTeam){
									same = true;
									break;
								}
							}
							if(same==true){
								break;
							}
							}
						if(same==false){
							tournyCount[aTeam][0]= aTeam;
							tournyCount[aTeam][1]=tournyCount[aTeam][1]+(aTourny[3]*bTourny[3]);
							int[] tournments = new int[aTourny.length + bTourny.length+1];
							System.arraycopy(aTourny, 0,tournments, 0, aTourny.length);
							System.arraycopy(bTourny, 0, tournments, aTourny.length, bTourny.length);
							System.arraycopy(tournyCount[aTeam][1]+(aTourny[3]*bTourny[3]), 0, tournments, bTourny.length,1);
							ArrayList<int[]> list = eightTeam.get(aTeam);
							list.add(tournments);
							eightTeam.put((Integer)(aTeam),list);
							
						}
						
						}
					
					}
				}
			}
		}
		
	}
	
	public Map<Integer, ArrayList<int[]>> getEightTournys(){
		tournyWork();
		System.out.println(eightTeam.get(1));
		return eightTeam;
	}
	
	public int[][] getEightCounts(){
		tournyWork();
		return tournyCount;
	}
	
	public int[][] getRankings(){
		int[][] tournamentCounts = getEightCounts();
		Arrays.sort(tournamentCounts, Comparator.comparingInt(arr -> arr[1]));
		return tournamentCounts;

	}
}
