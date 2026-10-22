// Importing Scanner class for user input
import java.util.Scanner; 

public class Main { 

    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);

        // Creating Object 1 using Default Constructor
        RentalCar car1 = new RentalCar();

        // Creating Object 2 using Parameterized Constructor
        RentalCar car2 = new RentalCar("C002", "McLaren", "Myvi", "SRG 1010", 150.00, 15000, true);

        int choice = 0;

        // Displaying the main menu title
        System.out.println("==========================================");
        System.out.println("           CAR RENTAL SYSTEM              ");
        System.out.println("==========================================");

        // Looping structure: using while loop to repeat the menu until user enters 6
        while (choice != 6) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. View Car Details");
            System.out.println("2. Rent a Car & Calculate Price");
            System.out.println("3. Return a Car");
            System.out.println("4. Update Car Daily Rate");
            System.out.println("5. Check Car Service Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = input.nextInt();

            // Selection structure: using switch statement for menu selection
            switch (choice) {

                // Operational method to display car information
                case 1:
                    System.out.println("\n--- CAR 1 DETAILS ---");
                    car1.displayCarInfo();
                    System.out.println("\n--- CAR 2 DETAILS ---");
                    car2.displayCarInfo();
                    break;

                // Operational method to rent a car and calculate total cost
                case 2:
                    System.out.print("\nSelect Car to rent (1 for " + car1.getModel() + ", 2 for " + car2.getModel() + "): ");
                    int rentChoice = input.nextInt();

                    RentalCar selectedCar;
                    if (rentChoice == 1) {
                        selectedCar = car1;
                    } else {
                        selectedCar = car2;
                    }

                    // Selection structure: usingif-else to check if the car is available
                    if (selectedCar.getIsAvailable()) {
                        System.out.print("Enter number of days to rent: ");
                        int days = input.nextInt();

                        // Looping structure: usingfor loop to display day by day base rate breakdown
                        System.out.println("\n--- Daily Breakdown ---");
                        for (int day = 1; day <= days; day++) {
                            System.out.println("Day " + day + ": RM " + selectedCar.getDailyRate());
                        }

                        // Operational method to calculate total cost
                        double totalCost = selectedCar.calculateTotalCost(days);

                        // Modify availability attribute using Setter
                        selectedCar.setIsAvailable(false);

                        // Displaying the total cost to pay
                        System.out.println("\n--- TOTAL COST ---");
                        System.out.println("Total Price to Pay: RM " + totalCost);
                        System.out.println("Success! You have rented the " + selectedCar.getBrand() + " " + selectedCar.getModel() + ".");
                    } else {
                        // Displaying message if the car is not available for rent
                        System.out.println("Sorry! That car is currently rented out.");
                    }
                    break;

                // Operational method to return a car and update mileage
                case 3:
                    System.out.print("\nSelect Car to return (1 for " + car1.getModel() + ", 2 for " + car2.getModel() + "): ");
                    int returnChoice = input.nextInt();

                    RentalCar returnCar = (returnChoice == 1) ? car1 : car2;

                    // Selection structure: using if-else to check if the car is currently rented out
                    if (!returnCar.getIsAvailable()) {
                        System.out.print("Enter distance driven (km): ");
                        int drivenKm = input.nextInt();

                        // Manipulating attributes using Getters and Setters
                        int newMileage = returnCar.getMileage() + drivenKm;
                        returnCar.setMileage(newMileage);
                        returnCar.setIsAvailable(true);

                        // Displaying message after returning the car successfully
                        System.out.println("Car returned successfully! Updated Mileage: " + returnCar.getMileage() + " km.");
                    } else {
                        // Displaying message if the car is already available in the garage
                        System.out.println("This car is already available in the garage.");
                    }
                    break;

                // Operational method to update the daily rate of a car
                case 4:
                    System.out.print("\nSelect Car to update rate (1 for " + car1.getModel() + ", 2 for " + car2.getModel() + "): ");
                    int updateChoice = input.nextInt();

                    RentalCar updateCar = (updateChoice == 1) ? car1 : car2;

                    // Update daily rate using Setter method with validation
                    System.out.println("Current Daily Rate: RM " + updateCar.getDailyRate());
                    System.out.print("Enter New Daily Rate: RM ");
                    double newRate = input.nextDouble();

                    // Using Setter to update attribute
                    updateCar.setDailyRate(newRate);
                    System.out.println("Updated Daily Rate: RM " + updateCar.getDailyRate());
                    break;

                // Operational method to check the service status of a car
                case 5:
                    System.out.println("\n--- CHECKING MAINTENANCE STATUS ---");
                    car1.checkServiceStatus();
                    car2.checkServiceStatus();
                    break;
                
                // To exit the program
                case 6:
                    System.out.println("Thank you for using the Car Rental System!");
                    break;
                
                // To handle invalid menu choices
                default:
                    System.out.println("Invalid choice. Please enter 1 to 6.");
            }
        }
        input.close();
    }
}
