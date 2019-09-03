/**
 * Main class for game of Oh Hell.  Helps keep track of multiple people's scores.
 * @author kevin
 *
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		PointKeeper[] players = start(console);
		playRound(console, players);
		while(yesTo(console, "Keep playing?")) {
			playRound(console, players);
		}
	}
	
	public static PointKeeper[] start(Scanner console) {
		System.out.println("Welcome to the game of Oh Hell.");
		PointKeeper[] result = new PointKeeper[nextInt(console, "How many players?")];
		for (int i = 0; i < result.length; i++) {
			System.out.print("Name of player " + (i + 1) + "?");
			result[i] = new PointKeeper(console.nextLine().trim());
		}
		return result;
	}
	
	public static void playRound(Scanner console, PointKeeper[] players) {
		guesses(console, players);
		checkResults(console, players);
		reportScores(players);
	}
	
	public static void guesses(Scanner console, PointKeeper[] players) {
		for (int i = 0; i < players.length; i++) {
			players[i].guess(nextInt(console, players[i].getName() + ", what are you betting this round?"));
		}
	}
	
	
	public static void checkResults(Scanner console, PointKeeper[] players) {
		for (int i = 0; i < players.length; i++) {
			players[i].setScore(nextInt(console, "How many tricks did " + players[i].getName() + " get?"));
		}
	}
	
	public static void reportScores(PointKeeper[] players) {
		System.out.println("Here are the current scores:");
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName() + " got " + players[i].getScore());
		}
	}
	
	public static int nextInt(Scanner console, String question) {
		System.out.print(question);
		while (!console.hasNextInt()) {
			console.nextLine();
			System.out.println("Please respond with a number.");
			System.out.print(question);
		}
		int result = console.nextInt();
		console.nextLine();
		return result;	//watch out for errors here
	}
	
	public static boolean yesTo(Scanner console, String question) {
		System.out.print(question + "(y/n)");
		String answer = console.nextLine().toLowerCase().trim();
		while (!answer.equals("y") && !answer.equals("n")) {
			System.out.print("Please answer y or n");
			System.out.print(question + "(y/n)");
			answer = console.nextLine().toLowerCase().trim();
		}
		return answer.equals("y");
	}
}
