package longo;
import java.util.Scanner;
public class App {
	// Declaration of variables
	static String invalidNameErrorMessage = " is an invalid person name. Skipping this person";
	static String invalidCommandErrorMessage = "Invalid Command, Try again";
	static String[] queue = { "-", "-", "-", "-", "-", "-", "-", "-" };
	static String checkout = "CHECKOUT <-";
	static String enterCommand = "Enter a Command:";
	static String fullQueue1 = "Could not add ";
	static String fullQueue2 = " to queue because the queue is full.";
	static String quitMessage = "Exiting.";
	static String separator = "----------------------------";
	public enum Command {
		PUT, // insert new client in the queue
		RESET, // reset the queue
		PROCESS, // See the queue and help the first person in the queue
		QUIT, // Exit from the program
		INVALID; // Invalid Command
	}
	public static void main(String[] args) {
		Command command = Command.INVALID;
		while (command != Command.QUIT) {
			showHeader();
			Scanner scanner = new Scanner(System.in);
			String commandLine = scanner.nextLine();
			command = readCommand(commandLine);
			switch (command) {
			case INVALID:
				System.out.println(invalidCommandErrorMessage);
				showHeader();
				break;
			case PUT:
				String[] names = extractNames(commandLine);
				for (int i = 0; i < names.length; i++) {
					put(names[i]);
				}
				break;
			case QUIT:
				quit();
				break;
			case RESET:
				reset();
				break;
			case PROCESS:
				process();
				break;
			}
		}
	}
	private static String[] extractNames(String commandLine) {
		String[] shareString = commandLine.split(" ");
		String validNames = "";
		for (int i = 1; i < shareString.length; i++) {
			if (shareString[i].isEmpty()) {
				continue;
			}
			if (nameIsValid(shareString[i])) {
				validNames = validNames + shareString[i] + ",";
			}
		}
		String[] names = validNames.split(",");
		return names;
	}
	private static Command readCommand(String commandLine) {
		Command parsedCommand = Command.INVALID;
		String[] shareString = commandLine.split(" ");
		String command = shareString[0];
		if (command.equals("put")) {
			parsedCommand = Command.PUT;
		}
		if (command.equals("reset")) {
			parsedCommand = Command.RESET;
		}
		if (command.equals("process")) {
			parsedCommand = Command.PROCESS;
		}
		if (command.equals("quit")) {
			parsedCommand = Command.QUIT;
		}
		return parsedCommand;
	}
	//Show the header of application
	private static void showHeader() {
		System.out.print(checkout);
		for (int i = 0; i < queue.length; i++) {
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
	 * 
	 * @param person person have to be max 10 character and contains only small case
	 *               letters
	 * @return True if valid false otherwise
	 */
	public static boolean nameIsValid(String name) {
		// checks if there is an input command in the string
		// check if name has a maximum of 10 characters
		if (name.length() > 10) {
			System.out.println(name + invalidNameErrorMessage);
			return false;
		}
		// check if there are no uppercase characters in the string
		for (int i = 0; i < name.length(); i++) {
			char current = name.charAt(i);
			char currentUpperCase = Character.toUpperCase(current);
			if (current == currentUpperCase) {
				System.out.println(name + invalidNameErrorMessage);
				return false;
			}
		}
		return true;
	}

	/**
	 * Reset Queue
	 */
	public static void reset() {
		queue = new String[] { "-", "-", "-", "-", "-", "-", "-", "-" };
	}

	/**
	 * Confirm number of the persons on the queue
	 */
	public static int findFreeSlotOnQueue() {
		for (int i = 0; i < queue.length; i++) {
			if (queue[i].equals("-")) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Put a person on the Queue
	 */
	public static void put(String name) {
		if (name.isEmpty()) {
			return;
		}
		int freeSlot = findFreeSlotOnQueue();
		if (freeSlot > -1) {
			queue[freeSlot] = name;
		} else {
			System.out.println(fullQueue1 + name + fullQueue2);
		}
	}

	/**
	 * Help the next client
	 */
	public static void process() {
		String[] newQueue = new String[] { "-", "-", "-", "-", "-", "-", "-", "-" };
		for (int i = 1; i < queue.length; i++) {
			newQueue[i - 1] = queue[i];
		}
		queue = newQueue;
	}

	/**
	 * Exit application
	 */
	public static void quit() {
		System.out.println(quitMessage);
		System.exit(0);
	}
}