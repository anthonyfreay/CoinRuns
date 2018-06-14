package coinRuns;

import java.util.*;
import java.io.*;

public class CoinRuns {

	public static void main(String[] args) {
		MultiDie die = new MultiDie(2); // two sided die i.e. coin
		final int SIZE = 8; // how many experiments (1, 10, 100, etc.)
		int[] runs = new int[SIZE]; // holds maxRun for each experiment
		int[] maxRolls = new int[SIZE];
		int maxRoll = 1; // starting maxRoll
		int currentRun = 1; // first flip creates current run of 1
		int maxRun = 0; // holds the highest run for experiment
		int lastFace = 0; // holds value of last face
		
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < maxRoll; j++) {
				die.roll();
				int face = die.getFaceValue();
				// compares face to last face, adds to current run if the same
				if(face == lastFace) currentRun++; 
				// if not the same, currentRun is compared to maxRun
				else {
					// maxRun is reassigned if current run is larger
					if(currentRun > maxRun) maxRun = currentRun;
					currentRun = 0;
				}
				// lastFace is assigned to current face
				lastFace = face;
			}
			maxRolls[i] = maxRoll; // stored for printing
			maxRoll = maxRoll*10; // maxRoll incremented by power of 10
			currentRun = 0; // reset to 0 for next experiment
			runs[i] = maxRun; // maxRun stored for each experiment
			maxRun = 0; // reset for next experiment
			lastFace = 0; // reset for next experiment 
		}
		
		for(int i = 0; i < maxRolls.length; i++) {
			System.out.println("Longest run with " + maxRolls[i] + 
					" flip(s) is: "+runs[i]);
		}
		
	}
}


