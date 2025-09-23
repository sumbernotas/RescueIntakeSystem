import animals.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    
    // Animal storage lists (will be replaced with binary trees later)
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();
    private static ArrayList<Cat> catList = new ArrayList<>();
    private static ArrayList<Bird> birdList = new ArrayList<>();
    

    public static void main(String[] args) {
        // Initialize with sample data
        initializeDogList();
        initializeMonkeyList();
        initializeCatList();
        initializeBirdList();
        
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        
        System.out.println("=== WELCOME TO THE ENHANCED RESCUE ANIMAL SYSTEM ===");
        System.out.println("Supports Dogs, Monkeys, Cats, and Birds!");
        
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
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\t\tRESCUE ANIMAL SYSTEM MENU");
        System.out.println("=".repeat(60));
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
        System.out.println("[11] Search animals (enhanced)");
        System.out.println("[12] System statistics");
        System.out.println("\n[q] Quit application");
        System.out.println("=".repeat(60));
        System.out.print("Enter your choice: ");
    }
    
    // uses sample data to initialize dog list
    public static void initializeDogList() {
        try {
            Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", 
                              "05-12-2019", "United States", "intake", false, "United States");
            Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", 
                              "02-03-2020", "United States", "Phase I", false, "United States");
            Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "8.5", 
                              "12-12-2019", "Canada", "in service", true, "Canada");
            
            dogList.add(dog1);
            dogList.add(dog2);
            dogList.add(dog3);
            
            System.out.println("Initialized " + dogList.size() + " dogs.");
        } catch (Exception e) {
            System.out.println("Error initializing dogs: " + e.getMessage());
        }
    }
    
    // uses sample data to initialize monkey list
    public static void initializeMonkeyList() {
        try {
            Monkey monkey1 = new Monkey("Bingo", "male", "3", "40.0", "09-21-2018", 
                                       "Australia", "intake", false, "United States", 
                                       "2.3", "6.0", "4.2", "Tamarin");
            Monkey monkey2 = new Monkey("Layla", "female", "2", "38.0", "01-15-2018", 
                                       "Brazil", "Phase I", true, "United States", 
                                       "2.5", "6.3", "4.0", "Capuchin");
            Monkey monkey3 = new Monkey("Nanas", "male", "3", "41.0", "10-21-2019", 
                                       "Africa", "intake", false, "United States", 
                                       "2.0", "5.2", "3.5", "Guenon");
            
            monkeyList.add(monkey1);
            monkeyList.add(monkey2);
            monkeyList.add(monkey3);
            
            System.out.println("Initialized " + monkeyList.size() + " monkeys.");
        } catch (Exception e) {
            System.out.println("Error initializing monkeys: " + e.getMessage());
        }
    }
    
    // uses sample data to initialize cat list
    public static void initializeCatList() {
        try {
            Cat cat1 = new Cat("Whiskers", "Domestic Shorthair", "female", "2", "8.5", 
                              "03-15-2020", "United States", "in service", false, "United States",
                              "true", "false", "short");
            Cat cat2 = new Cat("Shadow", "Persian", "male", "4", "12.3", 
                              "07-22-2019", "Canada", "Phase II", false, "Canada",
                              "true", "false", "long");
            
            catList.add(cat1);
            catList.add(cat2);
            
            System.out.println("Initialized " + catList.size() + " cats.");
        } catch (Exception e) {
            System.out.println("Error initializing cats: " + e.getMessage());
        }
    }
    
    // uses sample data to initialize bird list
    public static void initializeBirdList() {
        try {
            Bird bird1 = new Bird("Phoenix", "Parrot", "female", "3", "2.1", 
                                 "04-10-2020", "Australia", "Phase I", false, "United States",
                                 "18.5", "true", "hooked", "false");
            Bird bird2 = new Bird("Eagle Eye", "Falcon", "male", "2", "3.2", 
                                 "06-05-2021", "Canada", "in service", false, "Canada",
                                 "32.0", "true", "hooked", "true");
            
            birdList.add(bird1);
            birdList.add(bird2);
            
            System.out.println("Initialized " + birdList.size() + " birds.");
        } catch (Exception e) {
            System.out.println("Error initializing birds: " + e.getMessage());
        }
    }
    
    // dog intake with updated validation
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("\n=== DOG INTAKE ===");
        
        try {
            System.out.print("Dog's name: ");
            String name = scanner.nextLine().trim();
            
            // Check for duplicates
            for (Dog dog : dogList) {
                if (dog.getName().equalsIgnoreCase(name)) {
                    System.out.println("A dog with this name already exists in our system.");
                    return;
                }
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
            
            dogList.add(newDog);
            System.out.println("Successfully added new dog: " + name);
            
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
            
            // Check for duplicates
            for (Monkey monkey : monkeyList) {
                if (monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("A monkey with this name already exists in our system.");
                    return;
                }
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
            
            monkeyList.add(newMonkey);
            System.out.println("Successfully added new monkey: " + name);
            
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
            
            // Check for duplicates
            for (Cat cat : catList) {
                if (cat.getName().equalsIgnoreCase(name)) {
                    System.out.println("A cat with this name already exists in our system.");
                    return;
                }
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
            
            catList.add(newCat);
            System.out.println("Successfully added new cat: " + name);
            
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
            
            // Check for duplicates across all birds
            for (Bird bird : birdList) {
                if (bird.getName().equalsIgnoreCase(name)) {
                    System.out.println("A bird with this name already exists in our system.");
                    return;
                }
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
            
            birdList.add(newBird);
            System.out.println("Successfully added new bird: " + name);
            
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
        
        boolean found = false;
        
        switch (animalType) {
            case "dog":
                for (Dog dog : dogList) {
                    if (dog.getInServiceCountry().equalsIgnoreCase(serviceCountry) && !dog.isReserved()) {
                        dog.setReserved(true);
                        System.out.println("Reserved dog: " + dog.getName());
                        found = true;
                        break;
                    }
                }
                break;
            case "monkey":
                for (Monkey monkey : monkeyList) {
                    if (monkey.getInServiceCountry().equalsIgnoreCase(serviceCountry) && !monkey.isReserved()) {
                        monkey.setReserved(true);
                        System.out.println("Reserved monkey: " + monkey.getName());
                        found = true;
                        break;
                    }
                }
                break;
            case "cat":
                for (Cat cat : catList) {
                    if (cat.getInServiceCountry().equalsIgnoreCase(serviceCountry) && !cat.isReserved()) {
                        cat.setReserved(true);
                        System.out.println("Reserved cat: " + cat.getName());
                        found = true;
                        break;
                    }
                }
                break;
            case "bird":
                for (Bird bird : birdList) {
                    if (bird.getInServiceCountry().equalsIgnoreCase(serviceCountry) && !bird.isReserved()) {
                        bird.setReserved(true);
                        System.out.println("Reserved bird: " + bird.getName());
                        found = true;
                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid animal type.");
                return;
        }
        
        if (!found) {
            System.out.println("No available " + animalType + " found in " + serviceCountry);
        }
    }
    
    // to print all animals information
    public static void printAnimals(String listType) {
        System.out.println("\n=== " + listType.toUpperCase() + " LIST ===");
        
        switch (listType.toLowerCase()) {
            case "dog":
                if (dogList.isEmpty()) {
                    System.out.println("No dogs in the system.");
                } else {
                    for (Dog dog : dogList) {
                        System.out.println(dog.toString());
                    }
                }
                break;
                
            case "monkey":
                if (monkeyList.isEmpty()) {
                    System.out.println("No monkeys in the system.");
                } else {
                    for (Monkey monkey : monkeyList) {
                        System.out.println(monkey.toString());
                    }
                }
                break;
                
            case "cat":
                if (catList.isEmpty()) {
                    System.out.println("No cats in the system.");
                } else {
                    for (Cat cat : catList) {
                        System.out.println(cat.toString());
                    }
                }
                break;
                
            case "bird":
                if (birdList.isEmpty()) {
                    System.out.println("No birds in the system.");
                } else {
                    for (Bird bird : birdList) {
                        System.out.println(bird.toString());
                    }
                }
                break;
                
            case "available":
                System.out.println("Available Animals (In Service & Not Reserved):");
                boolean foundAny = false;
                
                for (Dog dog : dogList) {
                    if (dog.isAvailable()) {
                        System.out.println("DOG: " + dog.toString());
                        foundAny = true;
                    }
                }
                
                for (Monkey monkey : monkeyList) {
                    if (monkey.isAvailable()) {
                        System.out.println("MONKEY: " + monkey.toString());
                        foundAny = true;
                    }
                }
                
                for (Cat cat : catList) {
                    if (cat.isAvailable()) {
                        System.out.println("CAT: " + cat.toString());
                        foundAny = true;
                    }
                }
                
                for (Bird bird : birdList) {
                    if (bird.isAvailable()) {
                        System.out.println("BIRD: " + bird.toString());
                        foundAny = true;
                    }
                }
                
                if (!foundAny) {
                    System.out.println("No animals are currently available for service.");
                }
                break;
                
            default:
                System.out.println("Invalid list type.");
        }
    }
    
    // allows for search by specific criteria
    public static void searchAnimals(Scanner scanner) {
        System.out.println("\n=== ENHANCED ANIMAL SEARCH ===");
        System.out.println("1. Search by name");
        System.out.println("2. Search by training status");
        System.out.println("3. Search by country");
        System.out.println("4. Search by age range");
        System.out.print("Select search type: ");
        
        String searchType = scanner.nextLine().trim();
        
        switch (searchType) {
            case "1":
                searchByName(scanner);
                break;
            case "2":
                searchByTrainingStatus(scanner);
                break;
            case "3":
                searchByCountry(scanner);
                break;
            case "4":
                searchByAgeRange(scanner);
                break;
            default:
                System.out.println("Invalid search type.");
        }
    }
    
    // searches animal by name
    private static void searchByName(Scanner scanner) {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;
        
        // Search all animal types
        for (Dog dog : dogList) {
            if (dog.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("DOG FOUND: " + dog.toString());
                found = true;
            }
        }
        
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("MONKEY FOUND: " + monkey.toString());
                found = true;
            }
        }
        
        for (Cat cat : catList) {
            if (cat.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("CAT FOUND: " + cat.toString());
                found = true;
            }
        }
        
        for (Bird bird : birdList) {
            if (bird.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("BIRD FOUND: " + bird.toString());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No animals found with name containing: " + searchName);
        }
    }
    
    // searches animal by training status
    private static void searchByTrainingStatus(Scanner scanner) {
        System.out.print("Enter training status (intake/Phase I/Phase II/Phase III/in service/retired): ");
        String status = scanner.nextLine().trim();
        boolean found = false;
        
        // Search all animal types
        for (Dog dog : dogList) {
            if (dog.getTrainingStatus().getDisplayName().equalsIgnoreCase(status)) {
                System.out.println("DOG: " + dog.toString());
                found = true;
            }
        }
        
        for (Monkey monkey : monkeyList) {
            if (monkey.getTrainingStatus().getDisplayName().equalsIgnoreCase(status)) {
                System.out.println("MONKEY: " + monkey.toString());
                found = true;
            }
        }
        
        for (Cat cat : catList) {
            if (cat.getTrainingStatus().getDisplayName().equalsIgnoreCase(status)) {
                System.out.println("CAT: " + cat.toString());
                found = true;
            }
        }
        
        for (Bird bird : birdList) {
            if (bird.getTrainingStatus().getDisplayName().equalsIgnoreCase(status)) {
                System.out.println("BIRD: " + bird.toString());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No animals found with training status: " + status);
        }
    }
    
    // searches animal by country
    private static void searchByCountry(Scanner scanner) {
        System.out.print("Enter country: ");
        String country = scanner.nextLine().trim();
        boolean found = false;
        
        System.out.println("Animals from " + country + ":");
        
        // Search all animal types
        for (Dog dog : dogList) {
            if (dog.getAcquisitionCountry().equalsIgnoreCase(country) || 
                dog.getInServiceCountry().equalsIgnoreCase(country)) {
                System.out.println("DOG: " + dog.toString());
                found = true;
            }
        }
        
        for (Monkey monkey : monkeyList) {
            if (monkey.getAcquisitionCountry().equalsIgnoreCase(country) || 
                monkey.getInServiceCountry().equalsIgnoreCase(country)) {
                System.out.println("MONKEY: " + monkey.toString());
                found = true;
            }
        }
        
        for (Cat cat : catList) {
            if (cat.getAcquisitionCountry().equalsIgnoreCase(country) || 
                cat.getInServiceCountry().equalsIgnoreCase(country)) {
                System.out.println("CAT: " + cat.toString());
                found = true;
            }
        }
        
        for (Bird bird : birdList) {
            if (bird.getAcquisitionCountry().equalsIgnoreCase(country) || 
                bird.getInServiceCountry().equalsIgnoreCase(country)) {
                System.out.println("BIRD: " + bird.toString());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No animals found from country: " + country);
        }
    }
    
    // searches animal by age
    private static void searchByAgeRange(Scanner scanner) {
        try {
            System.out.print("Enter minimum age: ");
            int minAge = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.print("Enter maximum age: ");
            int maxAge = Integer.parseInt(scanner.nextLine().trim());
            
            boolean found = false;
            
            System.out.println("Animals aged " + minAge + " to " + maxAge + " years:");
            
            // Search all animal types
            for (Dog dog : dogList) {
                if (dog.getAge() >= minAge && dog.getAge() <= maxAge) {
                    System.out.println("DOG: " + dog.toString());
                    found = true;
                }
            }
            
            for (Monkey monkey : monkeyList) {
                if (monkey.getAge() >= minAge && monkey.getAge() <= maxAge) {
                    System.out.println("MONKEY: " + monkey.toString());
                    found = true;
                }
            }
            
            for (Cat cat : catList) {
                if (cat.getAge() >= minAge && cat.getAge() <= maxAge) {
                    System.out.println("CAT: " + cat.toString());
                    found = true;
                }
            }
            
            for (Bird bird : birdList) {
                if (bird.getAge() >= minAge && bird.getAge() <= maxAge) {
                    System.out.println("BIRD: " + bird.toString());
                    found = true;
                }
            }
            
            if (!found) {
                System.out.println("No animals found in age range: " + minAge + " to " + maxAge);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format. Please enter valid numbers.");
        }
    }

    // prints statistics and information
    public static void printSystemStatistics() {
        System.out.println("\n=== SYSTEM STATISTICS ===");
        System.out.println("Dogs: " + dogList.size());
        System.out.println("Monkeys: " + monkeyList.size());
        System.out.println("Cats: " + catList.size());
        System.out.println("Birds: " + birdList.size());
        System.out.println("Total Animals: " + (dogList.size() + monkeyList.size() + catList.size() + birdList.size()));
        
        // Count available animals
        int availableCount = 0;
        for (Dog dog : dogList) {
            if (dog.isAvailable()) availableCount++;
        }
        for (Monkey monkey : monkeyList) {
            if (monkey.isAvailable()) availableCount++;
        }
        for (Cat cat : catList) {
            if (cat.isAvailable()) availableCount++;
        }
        for (Bird bird : birdList) {
            if (bird.isAvailable()) availableCount++;
        }
        
        System.out.println("Available for Service: " + availableCount);
        
        // Training status breakdown
        System.out.println("\nTraining Status Breakdown:");
        for (RescueAnimal.TrainingStatus status : RescueAnimal.TrainingStatus.values()) {
            int count = 0;
            
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus() == status) count++;
            }
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus() == status) count++;
            }
            for (Cat cat : catList) {
                if (cat.getTrainingStatus() == status) count++;
            }
            for (Bird bird : birdList) {
                if (bird.getTrainingStatus() == status) count++;
            }
            
            System.out.println("  " + status.getDisplayName() + ": " + count);
        }
    }
}


                
