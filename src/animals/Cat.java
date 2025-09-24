package animals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cat extends RescueAnimal {
    
    // Cat-specific instance variables
    private String breed;
    private boolean isIndoorOnly;
    private boolean isDeclawed;
    private String coatLength; // short, medium, long
    
    
    private static final Set<String> VALID_COAT_LENGTHS = new HashSet<>(Arrays.asList(
        "short", "medium", "long"
    ));
    
    // default constructor
    public Cat() {
        super();
        setAnimalType("Cat");
        this.isIndoorOnly = true; // Default to indoor for safety
        this.isDeclawed = false;  // Default to not declawed
        this.coatLength = "short"; // Default coat length
    }
    
    // constructor with validation
    public Cat(String name, String breed, String gender, String ageStr,
               String weightStr, String acquisitionDateStr, String acquisitionCountry,
               String trainingStatusStr, boolean reserved, String inServiceCountry,
               String isIndoorOnlyStr, String isDeclawedStr, String coatLength) {
        
        super();
        setAnimalType("Cat");
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(parseAge(ageStr));
        setWeight(parseWeight(weightStr));
        setAcquisitionDate(parseDate(acquisitionDateStr));
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(TrainingStatus.fromString(trainingStatusStr));
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setIndoorOnly(parseBoolean(isIndoorOnlyStr, "indoor only"));
        setDeclawed(parseBoolean(isDeclawedStr, "declawed"));
        setCoatLength(coatLength);
    }
    
    //////
    /// getters and setters
    //////
    

    public String getBreed() {return breed;}
    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be blank");
        }
        
        this.breed = breed.trim();
    }
    
    public boolean isIndoorOnly() {return isIndoorOnly;}
    public void setIndoorOnly(boolean indoorOnly) {this.isIndoorOnly = indoorOnly;}
    
    public boolean isDeclawed() {return isDeclawed;}
    public void setDeclawed(boolean declawed) {this.isDeclawed = declawed;}
    
    public String getCoatLength() {return coatLength;}
    public void setCoatLength(String coatLength) {
        
        if (coatLength == null || coatLength.trim().isEmpty()) {
            throw new IllegalArgumentException("Coat length cannot be null or empty");
        }
        
        String normalizedLength = coatLength.trim().toLowerCase();

        if (!VALID_COAT_LENGTHS.contains(normalizedLength)) {
            throw new IllegalArgumentException("Invalid coat length. Valid options: " + VALID_COAT_LENGTHS);
        }
        
        this.coatLength = normalizedLength;
    }

    // get detailed information about cat
    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== CAT DETAILS ===\n");
        info.append(toString()).append("\n");
        info.append("Acquisition Date: ").append(getAcquisitionDate()).append("\n");
        info.append("Acquisition Country: ").append(getAcquisitionCountry()).append("\n");
        info.append("In-Service Country: ").append(getInServiceCountry()).append("\n");
        info.append("Available for Service: ").append(isAvailable() ? "Yes" : "No");
        
        return info.toString();
    }
    
    // Utility methods
    private static int parseAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr.trim());
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            return age;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid age format: " + ageStr);
        }
    }
    
    private static double parseWeight(String weightStr) {
        try {
            double weight = Double.parseDouble(weightStr.trim());
            if (weight <= 0) {
                throw new IllegalArgumentException("Weight must be positive");
            }
            return weight;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid weight format: " + weightStr);
        }
    }
    
    private static boolean parseBoolean(String boolStr, String fieldName) {
        if (boolStr == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
        
        String normalized = boolStr.trim().toLowerCase();

        if ("true".equals(normalized) || "yes".equals(normalized) || "1".equals(normalized)) {
            return true;
        } else if ("false".equals(normalized) || "no".equals(normalized) || "0".equals(normalized)) {
            return false;
        } else {
            throw new IllegalArgumentException("Invalid " + fieldName + " format: " + boolStr + 
                                             ". Use true/false, yes/no, or 1/0");
        }
    }

    @Override
    public String toString() {
        return String.format("%s, Breed: %s, Coat: %s, Indoor Only: %s, Declawed: %s",
                        super.toString(), breed, coatLength, 
                        isIndoorOnly ? "Yes" : "No", isDeclawed ? "Yes" : "No");
    }
}