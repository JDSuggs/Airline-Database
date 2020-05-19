package airlineDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Menu {

	// Display main menu and prompt user for selection
	protected static void mainMenu() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n" + "\n" + "\t" + 
			"MAIN MENU" + "\n" + 
			"(1) Customer Functions" + "\n" + 
			"(2) Reporting Functions" + "\n" + 
			"(3) Administrative Functions" + "\n" + 
			"(4) Quit" + "\n" + "\n" + "Selection:  ");
		// Find out what was selected, if valid, go to next menu, else, display menu again
		try {
			int selection = Integer.parseInt(br.readLine());
			if (selection == 1) {
				customerFunctionsMenu();
			} else if (selection == 2) {
				reportingFunctionsMenu();
			} else if (selection == 3) {
				administrativeFunctionsMenu();
			} else if (selection == 4) {
				System.out.println("Quitting program...");
			} else {
				System.out.println("Invalid Entry");
				mainMenu();
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("Invalid Entry");
			mainMenu();
		}
	}
	
	// Display main menu1 and prompt user for selection - different because of view
	protected static void mainMenu1() throws IOException, SQLException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\n" + "\n" + "\t" + 
				"MAIN MENU" + "\n" + 
				"(1) Customer Functions" + "\n" + 
				"(2) Reporting Functions" + "\n" +
				"(3) Quit" + "\n" + "\n" + "Selection:  ");
			// Find out what was selected, if valid, go to next menu, else, display menu again
			try {
				int selection = Integer.parseInt(br.readLine());
				if (selection == 1) {
					customerFunctionsMenu();
				} else if (selection == 2) {
					reportingFunctionsMenu();
				} else if (selection == 3) {
					System.out.println("Quitting program...");
				} else {
					System.out.println("Invalid Entry");
					mainMenu1();
				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Invalid Entry");
				mainMenu1();
			}
		}

	// Display customer functions menu and prompt user for selection
	protected static void customerFunctionsMenu() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n" + "\n" + "\t" + 
			"CUSTOMER FUNCTIONS MENU" + "\n" + 
			"(1) Make a reservation" + "\n" + 
			"(2) Cancel a reservation" + "\n" + 
			"(3) Confirm a reservation" + "\n" + 
			"(4) Print trip itinerary" + "\n" + 
			"(5) Locate fare" + "\n" + 
			"(6) Find cheap flight" + "\n" + 
			"(7) Quit" + "\n" + "\n" + "Selection:  ");
		// Find out what was selected, if valid, perform request, else, display menu again
		try {
			int selection = Integer.parseInt(br.readLine());
			if (selection == 1) {
				Statements.createReservation(Database.conn);
			} else if (selection == 2) {
				Statements.cancelReservation(Database.conn);
			} else if (selection == 3) {
				Statements.callConfirmReservation();
			} else if (selection == 4) {
				Statements.printTripItinerary(Database.conn);
			} else if (selection == 5) {
				Statements.locateFare(Database.conn);
			} else if (selection == 6) {
				Statements.cheapFlight(Database.conn);
			} else if (selection == 7) {
				System.out.println("Quitting program...");
			} else {
				System.out.println("Invalid Entry");
				customerFunctionsMenu();
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("Invalid Entry");
			customerFunctionsMenu();
		}
	}

	// Display reporting functions menu and prompt user for selection
	protected static void reportingFunctionsMenu() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n" + "\n" + "\t" + 
			"REPORTING FUNCTIONS MENU" + "\n" + 
			"(1) Print flight roster" + "\n" + 
			"(2) Print flight schedule" + "\n" + 
			"(3) Print flight performance report" + "\n" +
			"(4) Print flight history" + "\n" +
			"(5) Quit" + "\n" + "\n" + "Selection:  ");
		// Find out what was selected, if valid, perform request, else, display menu again
		try {
			int selection = Integer.parseInt(br.readLine());
			if (selection == 1) {
				Statements.flightroster(Database.conn);
			} else if (selection == 2) {
				Statements.flightschedule(Database.conn);
			} else if (selection == 3) {
				Statements.performanceReport(Database.conn);
			} else if (selection == 4) {
				Statements.flightHistory(Database.conn);
			} else if (selection == 5) {
				System.out.println("Quitting program...");
			} else {
				System.out.println("Invalid Entry");
				reportingFunctionsMenu();
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("Invalid Entry");
			reportingFunctionsMenu();
		}
	}

	// Display administrative functions menu and prompt user for selection
	protected static void administrativeFunctionsMenu() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\n" + "\n" + "\t" + 
			"ADMINSISTRATIVE FUNCTIONS MENU" + "\n" + 
			"(1) Add/drop flight" + "\n" + 
			"(2) Add airport" + "\n" + 
			"(3) Update fares" + "\n" + 
			"(4) Create leg instance" + "\n" + 
			"(5) Update leg instance" + "\n" + 
			"(6) Quit" + "\n" + "\n" + "Selection:  ");
		// Find out what was selected, if valid, perform request, else, display menu again
		try {
			int selection = Integer.parseInt(br.readLine());
			if (selection == 1) {
				Statements.addDropFlight(Database.conn);
			} else if (selection == 2) {
				Statements.addAirport(Database.conn);
			} else if (selection == 3) {
				Statements.updatefares(Database.conn);
			} else if (selection == 4) {
				Statements.addLegInstance(Database.conn);
			} else if (selection == 5) {
				Statements.updateLegInstance(Database.conn);
			} else if (selection == 6) {
				System.out.println("Quitting program...");
			} else {
				System.out.println("Invalid Entry");
				administrativeFunctionsMenu();
			}
		} catch (IllegalArgumentException iae) {
			System.out.println("Invalid Entry");
			administrativeFunctionsMenu();
		}
	}
}
