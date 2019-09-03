/**
 * Keeps track of points for a single player.
 * @author kevin
 *
 */


import java.util.*;

public class PointKeeper {
	private String name;
	private ArrayList<Integer> history;
	private int score;
	private int guess;
	
	public PointKeeper(String name) {
		this.name = name;
		history = new ArrayList<Integer>();
		score = 0;
	}
	
	public void guess(int num) {
		guess = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setScore(int tricksWon) {
		int currentScore;
		if (tricksWon == guess) {
			if (guess == 0) {
				currentScore = 10;
			}else {
				currentScore = 10 * tricksWon;
			}
		}else if (tricksWon < guess) {
			currentScore = tricksWon;
		}else {
			currentScore = -1 * tricksWon;
		}
		score += currentScore;
		history.add(currentScore);
	}
	
	public int getScore() {
		return score;
	}
}
