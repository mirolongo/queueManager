package longo;

import java.util.Scanner;
public class App {
	static String invalidNameErrorMessage = " is an invalid person name. Skipping this person";
	static String invalidCommandErrorMessage = "Invalid Command, Try again";
	static String[] queue = {"-","-","-","-","-","-","-","-"};
	static String checkout = "CHECKOUT <-";
	static String enterCommand = "Enter a Command:";
	static String fullQueue1 = "Could not add ";
	static String fullQueue2 = " to queue because the queue is full.";
	static String quitMessage = "Exiting.";
	static String separator = "----------------------------";
	
    enum Command {
        PUT, // should do something
        RESET, // should do something else
        PROCESS, // should do a third thing
        QUIT // should do nothing
    }

	public static void main(String[] args) {
		showHeader();
		Scanner scanner = new Scanner(System.in);
		String commandLine = scanner.nextLine();
		

	}
	private static void showHeader() {
		System.out.print(checkout);
		for (int i =0; i<queue.length;i++) {
			System.out.print("|" + queue[i]);
		}
		System.out.print("|");
		System.out.println();
		System.out.println(separator);
		System.out.println(enterCommand);
		System.out.print("> ");
	}
	/**
	 * Validates person
	 * @param person person have to be max 10 character and contains only small case letters
	 * @return True if valid false otherwise
	 */
	public static boolean nameIsValid(String person) {
		
		return true;
	}

	/**
	 * Reset Queue
	 */
	public static void reset() {
	}

	/**
	 * Put a person on the Queue
	 */
	public static void put(String person) {
	}
	
	
	

	/**
	 * Help the next client
	 */
	public static void process() {
	}

	/**
	 * Exit application
	 */
	public static void quit() {
		System.out.println(quitMessage);
		System.exit(0);
	}
}
