package animals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bird extends RescueAnimal {
    
    // Bird-specific instance variables
    private String species;
    private double wingspan;        // wingspan in inches
    private boolean canFly;         
    private String beakType;        // curved, straight, hooked, etc.
    private boolean isMigratory;    
    
    
    private static final Set<String> VALID_BEAK_TYPES = new HashSet<>(Arrays.asList(
        "straight", "curved", "hooked", "pointed", "flat", "conical"
    ));
    
    // default constructor
    public Bird() {
        super();
        setAnimalType("Bird");
        this.canFly = true;         // Default to flight capable
        this.isMigratory = false;   // Default to non-migratory
        this.beakType = "straight"; // Default beak type
    }
    
    // constructor with validation
    public Bird(String name, String species, String gender, String ageStr,
                String weightStr, String acquisitionDateStr, String acquisitionCountry,
                String trainingStatusStr, boolean reserved, String inServiceCountry,
                String wingspanStr, String canFlyStr, String beakType, String isMigratoryStr) {
        
        super();
        setAnimalType("Bird");
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(parseAge(ageStr));
        setWeight(parseWeight(weightStr));
        setAcquisitionDate(parseDate(acquisitionDateStr));
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(TrainingStatus.fromString(trainingStatusStr));
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setWingspan(parseDouble(wingspanStr, "wingspan"));
        setCanFly(parseBoolean(canFlyStr, "flight capability"));
        setBeakType(beakType);
        setMigratory(parseBoolean(isMigratoryStr, "migratory status"));
    }
    
    /////
    /// getters and setters
    /////
     
    public String getSpecies() {return species;}
    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be blank");
        }
        
        this.species = species.trim();
    }
    
    public double getWingspan() {return wingspan;}
    public void setWingspan(double wingspan) {
        if (wingspan <= 0) {
            throw new IllegalArgumentException("Wingspan must be positive");
        }
        this.wingspan = wingspan;
    }
    
    public boolean canFly() {return canFly;}
    public void setCanFly(boolean canFly) {this.canFly = canFly;}
    
    public String getBeakType() {return beakType;}
    public void setBeakType(String beakType) {
        if (beakType == null || beakType.trim().isEmpty()) {
            throw new IllegalArgumentException("Beak type cannot be blank");
        }
        
        String normalizedType = beakType.trim().toLowerCase();
        if (!VALID_BEAK_TYPES.contains(normalizedType)) {
            throw new IllegalArgumentException("Invalid beak type. Valid types: " + VALID_BEAK_TYPES);
        }
        
        this.beakType = normalizedType;
    }
    
    public boolean isMigratory() {return isMigratory;}
    public void setMigratory(boolean migratory) {this.isMigratory = migratory;}

    
    // determines wing size category based on wingspan inches
    public String getSizeCategory() {
        if (wingspan < 12) {
            return "small";
        } else if (wingspan < 24) {
            return "medium";
        } else if (wingspan < 48) {
            return "large";
        } else {
            return "extra large";
        }
    }

    // gets detailed information about bird
     public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== BIRD DETAILS ===\n");
        info.append(toString()).append("\n");
        info.append("Migratory: ").append(isMigratory ? "Yes" : "No").append("\n");
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
    
    private static double parseDouble(String valueStr, String fieldName) {
        try {
            double value = Double.parseDouble(valueStr.trim());
            if (value <= 0) {
                throw new IllegalArgumentException(fieldName + " must be positive");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid " + fieldName + " format: " + valueStr);
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
        return String.format("%s, Species: %s, Wingspan: %.1f\", Can Fly: %s, Beak: %s",
                        super.toString(), species, wingspan, canFly ? "Yes" : "No", beakType);
    }
}