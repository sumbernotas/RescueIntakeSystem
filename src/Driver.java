import animals.*;
import datastructures.*;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static AnimalTreeManager treeManager = new AnimalTreeManager();
    

    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        
        System.out.println("=== WELCOME TO THE ENHANCED RESCUE ANIMAL SYSTEM ===");
        System.out.println("Supports Dogs, Monkeys, Cats, and Birds!");

        treeManager.initializeWithSampleData();
        System.out.println(treeManager.getPerformanceInfo());
        
        // Main application loop
        while (!userInput.equals("q")) {
            displayMenu();
            userInput = scanner.nextLine().trim().toLowerCase();
            
            switch (userInput) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    intakeNewCat(scanner);
                    break;
                case "4":
                    intakeNewBird(scanner);
                    break;
                case "5":
                    reserveAnimal(scanner);
                    break;
                case "6":
                    printAnimals("dog");
                    break;
                case "7":
                    printAnimals("monkey");
                    break;
                case "8":
                    printAnimals("cat");
                    break;
                case "9":
                    printAnimals("bird");
                    break;
                case "10":
                    printAnimals("available");
                    break;
                case "11":
                    searchAnimals(scanner);
                    break;
                case "12":
                    printSystemStatistics();
                    break;
                case "13":
                    searchByName(scanner);
                    break;
                    
                case "q":
                    System.out.println("Thank you for using the Rescue Animal System!");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a valid option.");
            }
        }
        
        scanner.close();
    }
    
    // displays main menu
    public static void displayMenu() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\t\tRESCUE ANIMAL SYSTEM MENU");
        System.out.println("=".repeat(70));
        System.out.println("INTAKE OPTIONS:");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Intake a new cat");
        System.out.println("[4] Intake a new bird");
        System.out.println("\nMANAGEMENT OPTIONS:");
        System.out.println("[5] Reserve an animal");
        System.out.println("\nVIEW OPTIONS:");
        System.out.println("[6] Print all dogs");
        System.out.println("[7] Print all monkeys");
        System.out.println("[8] Print all cats");
        System.out.println("[9] Print all birds");
        System.out.println("[10] Print all available animals");
        System.out.println("\nSEARCH OPTIONS:");
        System.out.println("[11] Multi-criteria search");
        System.out.println("[12] System statistics & tree analysis");
        System.out.println("[13] Name search");
        System.out.println("\n[q] Quit application");
        System.out.println("=".repeat(70));
        System.out.print("Enter your choice: ");
    }
    
    // dog intake with updated validation
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("\n=== DOG INTAKE ===");
        
        try {
            System.out.print("Dog's name: ");
            String name = scanner.nextLine().trim();
            
            // duplicate check
            if (treeManager.animalNameExists(name)) {
                System.out.println("A dog with this name already exists in our system");
                return;
            }
            
            System.out.print("Breed: ");
            String breed = scanner.nextLine().trim();
            
            System.out.print("Gender (male/female/unknown): ");
            String gender = scanner.nextLine().trim();
            
            System.out.print("Age (years): ");
            String age = scanner.nextLine().trim();
            
            System.out.print("Weight (pounds): ");
            String weight = scanner.nextLine().trim();
            
            System.out.print("Acquisition date (MM-dd-yyyy): ");
            String acquisitionDate = scanner.nextLine().trim();
            
            System.out.print("Acquisition country: ");
            String acquisitionCountry = scanner.nextLine().trim();
            
            System.out.print("Training status (intake/Phase I/Phase II/Phase III/in service): ");
            String trainingStatus = scanner.nextLine().trim();
            
            System.out.print("Reserved (true/false): ");
            boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("true");
            
            System.out.print("In-service country: ");
            String inServiceCountry = scanner.nextLine().trim();
            
            Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                               acquisitionCountry, trainingStatus, reserved, inServiceCountry);
            
            // insertion into binary search tree
            if (treeManager.addDog(newDog)) {
                System.out.println("Successfully added new dog: " + name);
            } else {
                System.out.println("Failed to add dog. Name may already exist.");
            }
            
        } catch (Exception e) {
            System.out.println("Error adding dog: " + e.getMessage());
        }
    }
    
    // monkey intake with updated validation
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("\n=== MONKEY INTAKE ===");
        
        try {
            System.out.print("Monkey's name: ");
            String name = scanner.nextLine().trim();
            
            // duplicate check
            if (treeManager.animalNameExists(name)) {
                System.out.println("A monkey with this name already exists in our system.");
                return;
            }
            
            System.out.print("Gender (male/female/unknown): ");
            String gender = scanner.nextLine().trim();
            
            System.out.print("Age (years): ");
            String age = scanner.nextLine().trim();
            
            System.out.print("Weight (pounds): ");
            String weight = scanner.nextLine().trim();
            
            System.out.print("Acquisition date (MM-dd-yyyy): ");
            String acquisitionDate = scanner.nextLine().trim();
            
            System.out.print("Acquisition country: ");
            String acquisitionCountry = scanner.nextLine().trim();
            
            System.out.print("Training status (intake/Phase I/Phase II/Phase III/in service): ");
            String trainingStatus = scanner.nextLine().trim();
            
            System.out.print("Reserved (true/false): ");
            boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("true");
            
            System.out.print("In-service country: ");
            String inServiceCountry = scanner.nextLine().trim();
            
            System.out.print("Tail length (inches): ");
            String tailLength = scanner.nextLine().trim();
            
            System.out.print("Height (inches): ");
            String height = scanner.nextLine().trim();
            
            System.out.print("Body length (inches): ");
            String bodyLength = scanner.nextLine().trim();
            
            System.out.print("Species: ");
            String species = scanner.nextLine().trim();
            
            Monkey newMonkey = new Monkey(name, gender, age, weight, acquisitionDate,
                                        acquisitionCountry, trainingStatus, reserved, 
                                        inServiceCountry, tailLength, height, bodyLength, species);
            
            if (treeManager.addMonkey(newMonkey)) {
                System.out.println("Successfully added new monkey: " + name);
            } else {
                System.out.println("Failed to add monkey. Name may already exist.");
            }
            
        } catch (Exception e) {
            System.out.println("Error adding monkey: " + e.getMessage());
        }
    }
    
    // cat intake with updated validation
    public static void intakeNewCat(Scanner scanner) {
        System.out.println("\n=== CAT INTAKE ===");
        
        try {
            System.out.print("Cat's name: ");
            String name = scanner.nextLine().trim();
            
            if (treeManager.animalNameExists(name)) {
                System.out.println("A cat with this name already exists in our system.");
                return;
            }
            
            System.out.print("Breed: ");
            String breed = scanner.nextLine().trim();
            
            System.out.print("Gender (male/female/unknown): ");
            String gender = scanner.nextLine().trim();
            
            System.out.print("Age (years): ");
            String age = scanner.nextLine().trim();
            
            System.out.print("Weight (pounds): ");
            String weight = scanner.nextLine().trim();
            
            System.out.print("Acquisition date (MM-dd-yyyy): ");
            String acquisitionDate = scanner.nextLine().trim();
            
            System.out.print("Acquisition country: ");
            String acquisitionCountry = scanner.nextLine().trim();
            
            System.out.print("Training status (intake/Phase I/Phase II/Phase III/in service): ");
            String trainingStatus = scanner.nextLine().trim();
            
            System.out.print("Reserved (true/false): ");
            boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("true");
            
            System.out.print("In-service country: ");
            String inServiceCountry = scanner.nextLine().trim();
            
            System.out.print("Indoor only (true/false): ");
            String isIndoorOnly = scanner.nextLine().trim();
            
            System.out.print("Declawed (true/false): ");
            String isDeclawed = scanner.nextLine().trim();
            
            System.out.print("Coat length (short/medium/long): ");
            String coatLength = scanner.nextLine().trim();
            
            Cat newCat = new Cat(name, breed, gender, age, weight, acquisitionDate,
                               acquisitionCountry, trainingStatus, reserved, inServiceCountry,
                               isIndoorOnly, isDeclawed, coatLength);
            
            if (treeManager.addCat(newCat)) {
                System.out.println("Successfully added new cat: " + name);
            } else {
                System.out.println("Failed to add cat. Name may already exist.");
            }
            
        } catch (Exception e) {
            System.out.println("Error adding cat: " + e.getMessage());
        }
    }
    
    // bird intake with updated validation
    public static void intakeNewBird(Scanner scanner) {
        System.out.println("\n=== BIRD INTAKE ===");
        
        try {
            System.out.print("Bird's name: ");
            String name = scanner.nextLine().trim();
            
            if (treeManager.animalNameExists(name)) {
                System.out.println("A bird with this name already exists in our system.");
                return;
            }
            
            System.out.print("Species: ");
            String species = scanner.nextLine().trim();
            
            System.out.print("Gender (male/female/unknown): ");
            String gender = scanner.nextLine().trim();
            
            System.out.print("Age (years): ");
            String age = scanner.nextLine().trim();
            
            System.out.print("Weight (pounds): ");
            String weight = scanner.nextLine().trim();
            
            System.out.print("Acquisition date (MM-dd-yyyy): ");
            String acquisitionDate = scanner.nextLine().trim();
            
            System.out.print("Acquisition country: ");
            String acquisitionCountry = scanner.nextLine().trim();
            
            System.out.print("Training status (intake/Phase I/Phase II/Phase III/in service): ");
            String trainingStatus = scanner.nextLine().trim();
            
            System.out.print("Reserved (true/false): ");
            boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("true");
            
            System.out.print("In-service country: ");
            String inServiceCountry = scanner.nextLine().trim();
            
            System.out.print("Wingspan (inches): ");
            String wingspan = scanner.nextLine().trim();
            
            System.out.print("Can fly (true/false): ");
            String canFly = scanner.nextLine().trim();
            
            System.out.print("Beak type (straight/curved/hooked/pointed/flat/conical): ");
            String beakType = scanner.nextLine().trim();
            
            System.out.print("Migratory (true/false): ");
            String isMigratory = scanner.nextLine().trim();
            
            Bird newBird = new Bird(name, species, gender, age, weight, acquisitionDate,
                                  acquisitionCountry, trainingStatus, reserved, inServiceCountry,
                                  wingspan, canFly, beakType, isMigratory);
            
            if (treeManager.addBird(newBird)) {
                System.out.println("Successfully added new bird: " + name);
            } else {
                System.out.println("Failed to add bird. Name may already exist.");
            }
            
        } catch (Exception e) {
            System.out.println("Error adding bird: " + e.getMessage());
        }
    }
    
    // animal reservation with all animal types
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("\n=== RESERVE ANIMAL ===");
        
        System.out.print("Animal type (dog/monkey/cat/bird): ");
        String animalType = scanner.nextLine().trim().toLowerCase();
        
        System.out.print("Service country: ");
        String serviceCountry = scanner.nextLine().trim();
        
        RescueAnimal reservedAnimal = treeManager.reserveAnimal(animalType, serviceCountry);
        
        if (reservedAnimal != null) {
            System.out.println("Successfully reserved " + animalType + ": " + reservedAnimal.getName());
        } else {
            System.out.println("No available " + animalType + " found in " + serviceCountry);
        }
    }
    
    // to print all animals information, sorted
    public static void printAnimals(String listType) {
        System.out.println("\n=== " + listType.toUpperCase() + " LIST ===");
        
        switch (listType.toLowerCase()) {
            case "dog":
                List<? extends RescueAnimal> dogs = treeManager.getAnimalsByType("dog");
                
                if (dogs.isEmpty()) {
                    System.out.println("No dogs in the system.");
                } else {
                    System.out.println("Dogs sorted alphabetically:");
                    for (RescueAnimal dog : dogs) {
                        System.out.println("  " + dog.toString());
                    }
                }

                break;
                
            case "monkey":
                List<? extends RescueAnimal> monkeys = treeManager.getAnimalsByType("monkey");
                
                if (monkeys.isEmpty()) {
                    System.out.println("No monkeys in the system.");
                } else {
                    System.out.println("Monkeys sorted alphabetically:");
                    for (RescueAnimal monkey : monkeys) {
                        System.out.println("  " + monkey.toString());
                    }
                }

                break;
                
            case "cat":
                List<? extends RescueAnimal> cats = treeManager.getAnimalsByType("cat");
                
                if (cats.isEmpty()) {
                    System.out.println("No cats in the system.");
                } else {
                    System.out.println("Cats sorted alphabetically:");
                    for (RescueAnimal cat : cats) {
                        System.out.println("  " + cat.toString());
                    }
                }

                break;
                
            case "bird":
                List<? extends RescueAnimal> birds = treeManager.getAnimalsByType("bird");
                
                if (birds.isEmpty()) {
                    System.out.println("No birds in the system.");
                } else {
                    System.out.println("Birds sorted alphabetically:");
                    for (RescueAnimal bird : birds) {
                        System.out.println("  " + bird.toString());
                    }
                }

                break;
                
            case "available":
                List<RescueAnimal> available = treeManager.getAllAvailableAnimals();
                if (available.isEmpty()) {
                    System.out.println("No animals are currently available for service.");
                } else {
                    System.out.println("🌳 Available Animals (In Service & Not Reserved):");
                    System.out.println("Found using efficient tree traversal across all animal types:");
                    for (RescueAnimal animal : available) {
                        System.out.println("  " + animal.getAnimalType().toUpperCase() + ": " + animal.toString());
                    }
                }
                break;
                
            default:
                System.out.println("Invalid list type.");
        }
    }
    
    // allows for search by specific criteria
    public static void searchAnimals(Scanner scanner) {
        System.out.println("\n=== ENHANCED ANIMAL SEARCH ===");
        System.out.println("1. Search by training status");
        System.out.println("2. Search by country");
        System.out.println("3. Search by age range");
        System.out.print("Select search type: ");
        
        String searchType = scanner.nextLine().trim();
        
        switch (searchType) {
            case "1":
                searchByTrainingStatus(scanner);
                break;
            case "2":
                searchByCountry(scanner);
                break;
            case "3":
                searchByAgeRange(scanner);
                break;
            default:
                System.out.println("Invalid search type.");
        }
    }
    
    // searches animal by name
    private static void searchByName(Scanner scanner) {
        System.out.print("Enter animal name to search: ");
        String name = scanner.nextLine().trim();
        
        long startTime = System.nanoTime();
        RescueAnimal found = treeManager.searchAnimalByName(name);
        long endTime = System.nanoTime();
        
        double searchTimeMs = (endTime - startTime) / 1_000_000.0;
        
        if (found != null) {
            System.out.println("FOUND in " + String.format("%.3f", searchTimeMs) + " milliseconds!");
            System.out.println();
            System.out.println("Animal Details:");
            System.out.println("  " + found.toString());
            
            // Show detailed info if available
            if (found instanceof Dog) {
                System.out.println(((Dog) found).getDetailedInfo());
            } else if (found instanceof Cat) {
                System.out.println(((Cat) found).getDetailedInfo());
            } else if (found instanceof Bird) {
                System.out.println(((Bird) found).getDetailedInfo());
            } else if (found instanceof Monkey) {
                System.out.println(((Monkey) found).getDetailedInfo());
            }
        } else {
            System.out.println("Animal not found");
        }
    }
    
    // searches animal by training status
    private static void searchByTrainingStatus(Scanner scanner) {
        System.out.print("Enter training status (intake/Phase I/Phase II/Phase III/in service/retired): ");
        String status = scanner.nextLine().trim();
        
        try {
            RescueAnimal.TrainingStatus trainingStatus = RescueAnimal.TrainingStatus.fromString(status);
            List<RescueAnimal> results = treeManager.searchByTrainingStatus(trainingStatus);
            
            if (results.isEmpty()) {
                System.out.println("No animals found with training status: " + status);
            } else {
                System.out.println("Found " + results.size() + " animal(s) with training status: " + status);
                for (RescueAnimal animal : results) {
                    System.out.println("  " + animal.getAnimalType().toUpperCase() + ": " + animal.toString());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid training status: " + status);
        }
    }
    
    // searches animal by country
    private static void searchByCountry(Scanner scanner) {
        System.out.print("Enter country: ");
        String country = scanner.nextLine().trim();
        
        List<RescueAnimal> results = treeManager.searchByCountry(country);
        
        if (results.isEmpty()) {
            System.out.println("No animals found from country: " + country);
        } else {
            System.out.println("Found " + results.size() + " animal(s) from " + country + ":");
            for (RescueAnimal animal : results) {
                System.out.println("  " + animal.getAnimalType().toUpperCase() + ": " + animal.toString());
            }
        }
    }
    
    // searches animal by age
    private static void searchByAgeRange(Scanner scanner) {
        try {
            System.out.print("Enter minimum age: ");
            int minAge = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.print("Enter maximum age: ");
            int maxAge = Integer.parseInt(scanner.nextLine().trim());
            
            List<RescueAnimal> results = treeManager.searchByAgeRange(minAge, maxAge);
            
            if (results.isEmpty()) {
                System.out.println("No animals found in age range: " + minAge + " to " + maxAge + " years");
            } else {
                System.out.println("Found " + results.size() + " animal(s) aged " + minAge + " to " + maxAge + " years:");
                for (RescueAnimal animal : results) {
                    System.out.println("  " + animal.getAnimalType().toUpperCase() + ": " + animal.toString());
                }
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format. Please enter valid numbers");
        }
    }

    // prints statistics and information
    public static void printSystemStatistics() {
        System.out.println(treeManager.getSystemStatistics());
    }
}


                
