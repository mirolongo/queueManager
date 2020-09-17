package longo;
import java.util.Scanner;
import longo.App.Command;
public class App {
	static String invalidNameErrorMessage = " is an invalid person name. Skipping this person";
	static String invalidCommandErrorMessage = "Invalid Command, Try again";
	static String[] queue = new String[8]; //{"-","-","-","-","-","-","-","-"};
	static String checkout = "CHECKOUT <-";
	static String enterCommand = "Enter a Command:";
	static String fullQueue1 = "Could not add ";
	static String fullQueue2 = " to queue because the queue is full.";
	static String quitMessage = "Exiting.";
	static String separator = "----------------------------";
	static String person = null;	
    enum Command {
        PUT, 		// insert new client in the queue
        RESET, 		// reset the queue
        PROCESS, 	// See the queue and help the first person in the queue
        QUIT 		// Exit from the program
    }
    public static Command enterCommand() {
		return null; 	
    }
	public static void main(String[] args) {
		showHeader();
		Scanner scanner = new Scanner(System.in);
		String commandLine = scanner.nextLine();
		Command com = enterCommand();
			switch (com) {
				case PUT:
					put(commandLine);
				case RESET:
					reset();
				case PROCESS:
					process();
				case QUIT:
					quit();
			}
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
		String[] shareString = enterCommand.split(" ");
		for (String s : shareString){
			if (s.equals(("put")||("reset")||("process")||("quit")){
				enterCommand = s;
			}
			if (s.length() < 11){
				System.out.println(invalidNameErrorMessage);
				return enterCommand() != null;
			}
			if (s.toUpperCase() != null){
				System.out.println(invalidNameErrorMessage);
			}
			else{
			return true;
			}		
		}
		return true;
	}
	/**
	 * Reset Queue
	 */
	public static void reset() {
		for (int i = 0; i<8; i++){
			queue[i] = "-";
		}
		}
	/**
	 * Confirm number of the persons on the queue
	 */
	public static void fullArray() {
		for (int i = 0; i<8; i++){
			if (queue[i].equals("-")){
				queue[i] = person;
			}
			else{
			System.out.println(fullQueue1 + person + fullQueue2);
		}
		}
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