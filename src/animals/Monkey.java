package animals;

public class Monkey extends RescueAnimal {

    // monkey specific instance variables
    private String species;
    private double tailLength;
    private double height;
    private double bodyLength;

    // default constructor
    public Monkey() {
        super();
        setAnimalType("Monkey");
    }

    // constructor with validation
    public Monkey(String name, String gender, String ageStr, String weightStr,
                  String acquisitionDateStr, String acquisitionCountry,
                  String trainingStatusStr, boolean reserved, String inServiceCountry,
                  String tailLengthStr, String heightStr, String bodyLengthStr, String species) {
        
        super();
        setAnimalType("Monkey");
        setName(name);
        setGender(gender);
        setAge(parseAge(ageStr));
        setWeight(parseWeight(weightStr));
        setAcquisitionDate(parseDate(acquisitionDateStr));
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(TrainingStatus.fromString(trainingStatusStr));
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(parseDouble(tailLengthStr, "tail length"));
        setHeight(parseDouble(heightStr, "height"));
        setBodyLength(parseDouble(bodyLengthStr, "body length"));
        setSpecies(species);
    }

    //////
    /// getters and setters
    //////
    
    public String getSpecies() {return species;}
    public void setSpecies (String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be blank");
        }
        
        this.species = species.trim();
    }

    public double getTailLength() {return tailLength;}
    public void setTailLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Tail length must be greater than 0");
        }

        this.tailLength = length;
    }

    public double getHeight() {return height;}
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

        this.height = height;
    }

    public double getBodyLength() {return bodyLength;}
    public void setBodyLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Body length must be greater than 0");
        }
        this.bodyLength = length;
    }

    // gets detailed information about monkey
    public String getDetailedInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== MONKEY DETAILS ===\n");
        info.append(toString()).append("\n");
        info.append("Acquisition Date: ").append(getAcquisitionDate()).append("\n");
        info.append("Acquisition Country: ").append(getAcquisitionCountry()).append("\n");
        info.append("In-Service Country: ").append(getInServiceCountry()).append("\n");
        info.append("Available for Service: ").append(isAvailable() ? "Yes" : "No").append("\n");
        info.append("Total Body Size: ").append(String.format("%.1f\" (H) x %.1f\" (L)", height, bodyLength));
        
        return info.toString();
    }

    // parses age from string
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

    // parses weight from string
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

    // parses double from string
    private static double parseDouble(String valueStr, String fieldName) {
        try {
            double value = Double.parseDouble(valueStr.trim());
            if (value < 0) {
                throw new IllegalArgumentException(fieldName + " cannot be negative");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid " + fieldName + " format: " + valueStr);
        }
    }
}