package datastructures;

import animals.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalTreeManager {
    
    // Binary search trees for each animal type
    private AnimalBinaryTree<Dog> dogTree;
    private AnimalBinaryTree<Monkey> monkeyTree;
    private AnimalBinaryTree<Cat> catTree;
    private AnimalBinaryTree<Bird> birdTree;
    
    // default constructor
    public AnimalTreeManager() {
        this.dogTree = new AnimalBinaryTree<>();
        this.monkeyTree = new AnimalBinaryTree<>();
        this.catTree = new AnimalBinaryTree<>();
        this.birdTree = new AnimalBinaryTree<>();
    }
    
    ////////
    /// insertion methods
    ////////
    
    public boolean addDog(Dog dog) {
        try {
            if (dogTree.search(dog.getName()) != null) {
                return false; // Dog already exists
            }

            dogTree.insert(dog);
            return true;

        } catch (Exception e) {   
            System.out.println("Error adding dog: " + e.getMessage());
            return false;
        }
    }
    
    public boolean addMonkey(Monkey monkey) {
        try {
            if (monkeyTree.search(monkey.getName()) != null) {
                return false; // Monkey already exists
            }

            monkeyTree.insert(monkey);
            return true;

        } catch (Exception e) {
            System.out.println("Error adding monkey: " + e.getMessage());
            return false;
        }
    }
    
    public boolean addCat(Cat cat) {
        try {
            if (catTree.search(cat.getName()) != null) {
                return false; // Cat already exists
            }

            catTree.insert(cat);
            return true;

        } catch (Exception e) {
            System.out.println("Error adding cat: " + e.getMessage());
            return false;
        }
    }
    
    public boolean addBird(Bird bird) {
        try {
            if (birdTree.search(bird.getName()) != null) {
                return false; // Bird already exists
            }

            birdTree.insert(bird);
            return true;

        } catch (Exception e) {
            System.out.println("Error adding bird: " + e.getMessage());
            return false;
        }
    }
    
    ////////
    /// search methods
    ////////
    
    public RescueAnimal searchAnimalByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        
        Dog dog = dogTree.search(name);
        if (dog != null) return dog;
        
        Monkey monkey = monkeyTree.search(name);
        if (monkey != null) return monkey;
        
        Cat cat = catTree.search(name);
        if (cat != null) return cat;
        
        Bird bird = birdTree.search(name);
        if (bird != null) return bird;
        
        return null; // Not found in any tree
    }
    
    // gets animals of specific type
    public List<? extends RescueAnimal> getAnimalsByType(String animalType) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return dogTree.getAllSorted();
            case "monkey":
                return monkeyTree.getAllSorted();
            case "cat":
                return catTree.getAllSorted();
            case "bird":
                return birdTree.getAllSorted();
            default:
                return new ArrayList<>();
        }
    }
    
    public List<RescueAnimal> getAllAvailableAnimals() {
        List<RescueAnimal> available = new ArrayList<>();
        
        available.addAll(dogTree.getAvailableAnimals());
        available.addAll(monkeyTree.getAvailableAnimals());
        available.addAll(catTree.getAvailableAnimals());
        available.addAll(birdTree.getAvailableAnimals());
        
        return available;
    }
    
    // gets animals by training status
    public List<RescueAnimal> searchByTrainingStatus(RescueAnimal.TrainingStatus status) {
        List<RescueAnimal> results = new ArrayList<>();
        
        results.addAll(dogTree.getAnimalsByTrainingStatus(status));
        results.addAll(monkeyTree.getAnimalsByTrainingStatus(status));
        results.addAll(catTree.getAnimalsByTrainingStatus(status));
        results.addAll(birdTree.getAnimalsByTrainingStatus(status));
        
        return results;
    }
    
    public List<RescueAnimal> searchByCountry(String country) {
        List<RescueAnimal> results = new ArrayList<>();
        
        results.addAll(dogTree.getAnimalsByCountry(country));
        results.addAll(monkeyTree.getAnimalsByCountry(country));
        results.addAll(catTree.getAnimalsByCountry(country));
        results.addAll(birdTree.getAnimalsByCountry(country));
        
        return results;
    }
    
    public List<RescueAnimal> searchByAgeRange(int minAge, int maxAge) {
        List<RescueAnimal> results = new ArrayList<>();
        
        results.addAll(dogTree.getAnimalsByAgeRange(minAge, maxAge));
        results.addAll(monkeyTree.getAnimalsByAgeRange(minAge, maxAge));
        results.addAll(catTree.getAnimalsByAgeRange(minAge, maxAge));
        results.addAll(birdTree.getAnimalsByAgeRange(minAge, maxAge));
        
        return results;
    }
    
    ////////
    /// reserve methods
    ////////
    
    public RescueAnimal reserveAnimal(String animalType, String serviceCountry) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return reserveFirstAvailable(dogTree, serviceCountry);
            case "monkey":
                return reserveFirstAvailable(monkeyTree, serviceCountry);
            case "cat":
                return reserveFirstAvailable(catTree, serviceCountry);
            case "bird":
                return reserveFirstAvailable(birdTree, serviceCountry);
            default:
                return null;
        }
    }
    
    // helper to reserve first animal in tree
    private <T extends RescueAnimal> T reserveFirstAvailable(AnimalBinaryTree<T> tree, String serviceCountry) {
        List<T> animals = tree.getAnimalsByCountry(serviceCountry);
        
        for (T animal : animals) {
            if (animal.isAvailable()) {
                animal.setReserved(true);
                return animal;
            }
        }
        
        return null; // No available animals found
    }
    
    ////////
    /// information methods
    ////////

    public String getSystemStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("\n=== SYSTEM STATISTICS ===\n");
        stats.append("Dogs: ").append(dogTree.size()).append(" (Tree Height: ").append(dogTree.getHeight()).append(")\n");
        stats.append("Monkeys: ").append(monkeyTree.size()).append(" (Tree Height: ").append(monkeyTree.getHeight()).append(")\n");
        stats.append("Cats: ").append(catTree.size()).append(" (Tree Height: ").append(catTree.getHeight()).append(")\n");
        stats.append("Birds: ").append(birdTree.size()).append(" (Tree Height: ").append(birdTree.getHeight()).append(")\n");
        stats.append("Total Animals: ").append(getTotalAnimals()).append("\n");
        stats.append("Available for Service: ").append(getAllAvailableAnimals().size()).append("\n");
        
        // Training status breakdown
        stats.append("\nTraining Status Breakdown:\n");
        for (RescueAnimal.TrainingStatus status : RescueAnimal.TrainingStatus.values()) {
            int count = searchByTrainingStatus(status).size();
            stats.append("  ").append(status.getDisplayName()).append(": ").append(count).append("\n");
        }
        
        return stats.toString();
    }
    
    public int getTotalAnimals() {
        return dogTree.size() + monkeyTree.size() + catTree.size() + birdTree.size();
    }

    public boolean animalNameExists(String name) {
        return searchAnimalByName(name) != null;
    }
    
    // gets tree performance info
    public String getPerformanceInfo() {
        StringBuilder info = new StringBuilder();
        info.append("\n=== TREE PERFORMANCE ANALYSIS ===\n");
        info.append("Data Structure: Binary Search Trees\n");
        info.append("Search Complexity: O(log n) average, O(n) worst case\n");
        info.append("Insert Complexity: O(log n) average, O(n) worst case\n");
        info.append("Space Complexity: O(n)\n\n");
        
        info.append("Tree Heights (Lower is Better for Performance):\n");
        info.append("  Dog Tree: ").append(dogTree.getHeight()).append(" levels\n");
        info.append("  Monkey Tree: ").append(monkeyTree.getHeight()).append(" levels\n");
        info.append("  Cat Tree: ").append(catTree.getHeight()).append(" levels\n");
        info.append("  Bird Tree: ").append(birdTree.getHeight()).append(" levels\n");
        
        return info.toString();
    }
    
    // initializes tree with sample info
    public void initializeWithSampleData() {
        try {
            // Add sample dogs
            addDog(new Dog("Simba", "German Shepherd", "male", "1", "25.6", 
                          "05-12-2019", "United States", "intake", false, "United States"));
            addDog(new Dog("Rex", "Great Dane", "male", "3", "35.2", 
                          "02-03-2020", "United States", "Phase I", false, "United States"));
            addDog(new Dog("Luna", "Chihuahua", "female", "4", "8.5", 
                          "12-12-2019", "Canada", "in service", true, "Canada"));
            
            // Add sample monkeys
            addMonkey(new Monkey("Bingo", "male", "3", "40.0", "09-21-2018", 
                               "Australia", "intake", false, "United States", 
                               "2.3", "6.0", "4.2", "Tamarin"));
            addMonkey(new Monkey("Layla", "female", "2", "38.0", "01-15-2018", 
                               "Brazil", "Phase I", true, "United States", 
                               "2.5", "6.3", "4.0", "Capuchin"));
            addMonkey(new Monkey("Banana", "male", "3", "41.0", "10-21-2019", 
                               "Africa", "intake", false, "United States", 
                               "2.0", "5.2", "3.5", "Guenon"));
            
            // Add sample cats
            addCat(new Cat("Whiskers", "Domestic Shorthair", "female", "2", "8.5", 
                          "03-15-2020", "United States", "in service", false, "United States",
                          "true", "false", "short"));
            addCat(new Cat("Shadow", "Persian", "male", "4", "12.3", 
                          "07-22-2019", "Canada", "Phase II", false, "Canada",
                          "true", "false", "long"));
            
            // Add sample birds
            addBird(new Bird("Coopa", "Parrot", "female", "3", "2.1", 
                           "04-10-2020", "Australia", "Phase I", false, "United States",
                           "18.5", "true", "hooked", "false"));
            addBird(new Bird("Marvel", "Falcon", "male", "2", "3.2", 
                           "06-05-2021", "Canada", "in service", false, "Canada",
                           "32.0", "true", "hooked", "true"));
            
            System.out.println("Sample data loaded successfully!");
            System.out.println("Total animals: " + getTotalAnimals());
            
        } catch (Exception e) {
            System.out.println("Error loading sample data: " + e.getMessage());
        }
    }
}