package longo;
import java.io.Serializable;
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
    public static Command commandLine() {
		return null; 	
    }
	public static void main(String[] args) {
		showHeader();
		Scanner scanner = new Scanner(System.in);
		String commandLine = scanner.nextLine();
		Command com = commandLine;
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
	public static boolean 	nameIsValid(String person) {
		String[] shareString = enterCommand.split(" "); 
		//checks if there is an input command in the string
		for (String s : shareString){
			if (s.equals(("put")||("reset")||("process")||("quit")){
				enterCommand = s;
			}
			//check if you have a maximum of 10 characters per name
			if (s.length() < 11){
				System.out.println(invalidNameErrorMessage);
				return enterCommand() != null;
			}
			//check if there are no uppercase characters in the string
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
	public static void decreaseArray(){
		int i = 0;
		while (queue[i] != "-"){
			queue[i] = queue[i+1];
		}
		String queueDecrease = "-";
		queue[i] = queueDecrease;
	}
	/**
	 * Put a person on the Queue
	 */
	public static void put(){
		nameIsValid(person);
		if ( = true){
			for (int i = 0; queue[i] = "-"; queue[i++]){
				if queue[i] = queue[7]{
					return true;
				}
			}
		}
	}
	/**
	 * Help the next client
	 */
	public static void process() {
		decreaseArray();
		showHeader();
	}
	/**
	 * Exit application
	 */
	public static void quit() {
		System.out.println(quitMessage);
		System.exit(0);
	}
}