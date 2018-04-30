package Main;

import java.io.IOException;

import Data.WinMatrix;
import Tournys.EightTeam;
import Tournys.FourTeam;

public class Main {
	
	public static void main(String[] args) throws IOException {
		double total =0;
		long startTime = System.nanoTime();
		WinMatrix matrix = new WinMatrix();
		int[][] winMatrix = matrix.getWinMatrix();
		FourTeam fourTeam = new FourTeam();
		int[][] rankings = fourTeam.getRankings(winMatrix);
		//EightTeam eightTeam = new EightTeam(winMatrix);
		//int[][] rankings = eightTeam.getRankings();
		//eightTeam.getEightTournys();
		
		int j =1;
		for(int i=rankings.length-1; i>=0; i--){
				System.out.println(j + ". "+rankings[i][0] + " " + rankings[i][1]);
				total = total + rankings[i][1];
				j++;
		}
		long endTime = System.nanoTime();

		long duration = (endTime - startTime)/60000000; 
		System.out.println(duration);
		System.out.println(total);
//		for(int i =0; i < winMatrix.length; i ++){
//			System.out.println("");
//			for(int j =0; j < winMatrix.length; j ++){
//				System.out.print(winMatrix[i][j]);
//		}
//		
//	}
	}
}
	