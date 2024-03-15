/*
RugbyTeamApp.java
@author Artem Rubin
13th Nov 23
*/


import java.util.Scanner; // Importing Scanner package


public class RugbyTeamApp { // Main Class
    public static void main(String[] args) { //Main Method


        Scanner scanner = new Scanner(System.in); // Creating an object - scanner
        int arraySize; // Declaring the variable - arraySize
        int menuChoice; // Declaring the variable - menuChoice



        RugbyTeam[] teams; // Declarating variable "teams". It be used to reference an array of RugbyTeam objects.

        RugbyTeam lastEnteredTeam = null; // Declaring and initializing a single reference to a RugbyTeam object, will be used later to show last team entered by the user

        int totalPoints = 0;
        int teamsCount = 0;

        // Prompt the user to define the number of teams
        System.out.print("Hi There, please enter the number of teams you would like to provide information for: ");
        arraySize = scanner.nextInt(); // Assigning an value to "arraySize", this value was entered by the user using scanner
        teams = new RugbyTeam[arraySize]; // Array initialization. An actual array created in memory

        // Loop for the menu
        do {
            // Displaying the application menu
            System.out.println("\nApplication Menu - Rugby Team Tournament ");
            System.out.println("\n1 - Enter the details of an item");
            System.out.println("2 - Display the details of the last entered item");
            System.out.println("3 - Display the team with the highest points scored");
            System.out.println("4 - Display the team with the lowest points scored");
            System.out.println("5 - Display the average points of all the teams");
            System.out.println("6 - Exit application");
            System.out.print("\nEnter your choice: ");
            menuChoice = scanner.nextInt(); // user input

            // Switch Statement, every case is representing the one menu item
            switch (menuChoice) {
                case 1:
                    // Entering details of a rugby team
                    if (teamsCount < arraySize) {
                        System.out.print("Enter Points Scored (From 3 to 97): ");
                        int points = scanner.nextInt();
                        System.out.print("Enter Games Played (From 1 to 15): ");
                        int games = scanner.nextInt();
                        System.out.print("Enter Tries Scored (From 4 to 99): ");
                        int tries = scanner.nextInt();
                        System.out.print("Enter Team Rank (From 1 to 20): ");
                        int rank = scanner.nextInt();

                        // Validation of users input
                        if (points >= 3 && points <= 97 && games >= 1 && games <= 15 && tries >= 4 && tries <= 99 && rank >= 1 && rank <= 20) {
                            RugbyTeam team = new RugbyTeam(points, games, tries, rank); // Creating a new RugbyTeam object with the entered data
                            teams[teamsCount++] = team; // newly created "team" object will be stored in the array with "teamscount+1" index number, "teamscount" variable increases by 1
                            lastEnteredTeam = team; // lastEnteredTeam variable is updated to reference newly created "team" object
                            totalPoints += points; // total points calculated
                        } else {
                            System.out.println("\nInvalid input. Please enter values from the range.");
                        }
                    } else {
                        System.out.println("\nImportant: Maximum number of teams reached. Choose a different option");
                    } // closing if (teamsCount < arraySize) statement
                    break;
                case 2:
                    // Display the last entered team
                    if (lastEnteredTeam != null) {
					            lastEnteredTeam.displayTeamDetails(); //  calling on displayTeamDetails() method of the lastEnteredTeam object to display last entered team data
					        } else {
					            System.out.println("No team data entered yet.");
					        }
                        break;
                case 3:
                    // Displaying the team with the highest points scored
                    displayTeamWithExtremeScore(teams, true); // calling a method named "displayTeamWithExtremeScore". "Teams" is an array of RugbyTeam object,
                    // "true" indicates that method will find and display the team with the lowest points scored instead
                    break;
                case 4:
                    // Display the team with the lowest points scored
                    displayTeamWithExtremeScore(teams, false); // calling a method named "displayTeamWithExtremeScore". "Teams" is an array of RugbyTeam object,
                    // false indicates that method will find and display the team with the lowest points scored instead
                    break;
                case 5:
                    // Display the average points of all teams
                    if (teamsCount > 0) {
                        System.out.println("Average Points Scored: " + ((double) totalPoints / teamsCount));
                    } else {
                        System.out.println("No teams to calculate average.");
                    }
                    break;
                case 6:
                    // Exit the application
                    System.out.println("\nExiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (menuChoice != 6);

        scanner.close(); // closing  an object scanner
    }



    // Method to display the team with the highest or lowest points scored
     private static void displayTeamWithExtremeScore(RugbyTeam[] teams, boolean highest) {
	        if (teams[0] == null) {
	            System.out.println("No teams have been entered.");
	            return;
	        }
RugbyTeam extremeTeam = teams[0]; // Assume the first team has the extreme score.

//  For-Each Loop. Looping through each team in the array. Syntax : for (type variableName : arrayName)
for (RugbyTeam team : teams) {
    // Skiping this iteration if the team is null.
    if (team == null) {
        continue;
    }

    // Check if we're looking for the highest scoring team. Syntax: if(condition){}
    if (highest) {
        // If the current team's score is higher than the extreme team's score
        if (team.getPointsScored() > extremeTeam.getPointsScored()) {
            // Updating the extreme team to this current team.
            extremeTeam = team;
        }
    }
    // Otherwise, we're looking for the lowest scoring team.
    else {
        // If the current team's score is lower than the extreme team's score.
        if (team.getPointsScored() < extremeTeam.getPointsScored()) {
            // Updating the extreme team to this current team.
            extremeTeam = team;
        }
    }
}
	 //  For-each going through each RugbyTeam object within the teams array.
    for (RugbyTeam team : teams) {
        // First, checking if the current team is not null to avoid any errors.
        if (team != null) {
        // Checking if we're looking for the highest score and if the current team's score is higher than the extreme team's score.
          if (highest && team.getPointsScored() > extremeTeam.getPointsScored()) {
            extremeTeam = team;
          }
        // Looking for the lowest. Checking  if the current team's score is lower than the extreme team's score.
        else if (!highest && team.getPointsScored() < extremeTeam.getPointsScored()) {
            extremeTeam = team;
         }
        }
      }
	        // Checking if the 'highest' variable is true
			if (highest) {
			    // If 'highest' is true, printing "Highest Points Scored Team:"
			    System.out.println("Highest Points Scored Team:");
			} else {
			    // If 'highest' is false, printing "Lowest Points Scored Team:"
			    System.out.println("Lowest Points Scored Team:");
			}
            extremeTeam.displayTeamDetails(); // Calling the method 'displayTeamDetails' on the object 'extremeTeam'
    }
}
