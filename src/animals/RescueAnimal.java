package animals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public abstract class RescueAnimal implements Comparable<RescueAnimal> {
    // static counter for generating IDs
    private static int nextID = 1;

    // core instance variable declarations
    private final int animalID;
    private String name;
    private String animalType;
    private String gender;
    private int age;
    private double weight;
    private LocalDate acquisitionDate;
    private String acquisitionCountry;
    private TrainingStatus trainingStatus;
    private boolean reserved;
    private String inServiceCountry;

    // enum for training status to ensure valid values
    public enum TrainingStatus {
        INTAKE("intake"),
        PHASE_I("Phase I"),
        PHASE_II("Phase II"),
        PHASE_III("Phase III"),
        IN_SERVICE("in service"),
        RETIRED("retired");

        private final String displayName;

        TrainingStatus(String displayName) {this.displayName = displayName;}
        public String getDisplayName() {return displayName;}

        public static TrainingStatus fromString(String status) {
            for (TrainingStatus ts : TrainingStatus.values()) {
                if (ts.displayName.equalsIgnoreCase(status)) {
                    return ts;
                }
            }
            throw new IllegalArgumentException("Invalid training status " + status);
        }
    }

    // default constructor
    public RescueAnimal() {
        this.animalID = nextID++;
        this.acquisitionDate = LocalDate.now();
        this.trainingStatus = TrainingStatus.INTAKE;
        this.reserved = false;
    }

    // constructor with validation
    public RescueAnimal(String name, String animalType, String gender, int age, 
                       double weight, LocalDate acquisitionDate, String acquisitionCountry,
                       TrainingStatus trainingStatus, boolean reserved, String inServiceCountry) {

        this();
        setName(name);
        setAnimalType(animalType);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionCountry(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    //////
    /// getters and setters
    //////
    
    public int getAnimalID() {return animalID;}
    
    public String getName() {return name;}
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name.trim();
    }

    public String getAnimalType() {return animalType;}
    public void setAnimalType(String animalType) {
        if (animalType == null || animalType.trim().isEmpty()) {
            throw new IllegalArgumentException("Animal type cannot be blank");
        }
        this.animalType = animalType.trim();
    }

    public String getGender() {return gender;}
    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be blank");
        }

        String normalizedGender = gender.trim().toLowerCase();

        if (!normalizedGender.equals("male") && !normalizedGender.equals("female") 
            && !normalizedGender.equals("unknown")) {
            throw new IllegalArgumentException("Gender must be 'male', 'female', or 'unknown'");
        }
        this.gender = normalizedGender;
    }

    public int getAge() {return age;}
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public double getWeight() {return weight;}
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    public LocalDate getAcquisitionDate() {return acquisitionDate;}
    public void setAcquisitionDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Acquisition date cannot be null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Acquisition date cannot be in the future");
        }
        this.acquisitionDate = date;
    }

    public String getAcquisitionCountry() {return acquisitionCountry;}
    public void setAcquisitionCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Acquisition country cannot be blank");
        }
        this.acquisitionCountry = country.trim();
    }

    public TrainingStatus getTrainingStatus() {return trainingStatus;}
    public void setTrainingStatus(TrainingStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Training status cannot be null");
        }
        this.trainingStatus = status;
    }

    public boolean isReserved() {return reserved;}
    public void setReserved(boolean reserved) {this.reserved = reserved;}

    public String getInServiceCountry() {return inServiceCountry;}
    public void setInServiceCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("In-service country cannot be blank");
        }
        this.inServiceCountry = country.trim();
    }

    public boolean isAvailable() {
        return trainingStatus == TrainingStatus.IN_SERVICE && !reserved;
    }

    // parses date from string
    public static LocalDate parseDate(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use MM-dd-yyyy format", e);
        }
    }

    // formats the date for output
    public String formattedAcquisitionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return acquisitionDate.format(formatter);
    }

    // allows for sorting animals by name
    @Override
    public int compareTo(RescueAnimal other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}