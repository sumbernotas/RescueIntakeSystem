package animals;

public class Dog extends RescueAnimal {
    
    // dog specific instance variable
    private String breed;
    
    // default constructor
    public Dog() {
        super();
        setAnimalType("Dog");
    }

    // constructor with validation
    public Dog(String name, String breed, String gender, String ageStr,
               String weightStr, String acquisitionDateStr, String acquisitionCountry,
               String trainingStatusStr, boolean reserved, String inServiceCountry) {
        
        super();
        setAnimalType("Dog");
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
    }

    ///////
    /// getters and setters
    ///////
    
    public String getBreed() {return breed;}
    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be blank");
        }

        this.breed = breed.trim();
    }
    
    // gets detailed information about dog
    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== DOG DETAILS ===\n");
        info.append(toString()).append("\n");
        info.append("Acquisition Date: ").append(getAcquisitionDate()).append("\n");
        info.append("Acquisition Country: ").append(getAcquisitionCountry()).append("\n");
        info.append("In-Service Country: ").append(getInServiceCountry()).append("\n");
        info.append("Available for Service: ").append(isAvailable() ? "Yes" : "No").append("\n");
        
        return info.toString();
    }

    // parses age from string validation
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

    // parses weight from string validation
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
    
    @Override
    public String toString() {
        return String.format("%s, Breed: %s", super.toString(), breed);
    }
}