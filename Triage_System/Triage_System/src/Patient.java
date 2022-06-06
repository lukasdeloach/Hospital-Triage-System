
import java.io.*;
import java.util.ArrayList;

/**
 * The Patient is a subclass of Person
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
public class Patient extends Person implements Serializable{

    // instance variable age;
    private int age;
    // instance variable admissionDate;
    private String admissionDate;
    // instance variable sicknessHistory;
    private String sicknessHistory;
    // instance variable prescriptions;
    private String prescriptions;
    // instance variable allergies;
    private String allergies;
    // instance variable specialRequests;
    private String specialRequests;
    // instance variable severityScore;
    private int severityScore;
    // instance variable count;
    public static int count = 0;
    // instance variable symptoms;
    private ArrayList<String> symptoms;

    /**
     * Costructor of the Patient class.
     * Call to the superclass Person.
     * Initalizes symptoms and severityScore.
     * 
     * @param firstName
     * @param middleName
     * @param surname
     * @param birthDate
     * @param gender
     * @param symptoms
     */
    public Patient(String firstName, String surname, String gender, String birthDate, ArrayList<String> symptoms,
            int score) {
        super(firstName, surname, gender, birthDate);
        this.symptoms = symptoms;
        severityScore = score;
    }

    /**
     * Public static method, makePatient, careates a Patients, and returns a
     * Patient.
     * 
     * @param firstName
     * @param surname
     * @param birthDate
     * @param gender
     * @param symptoms
     * @param score
     * @return patient
     */
    public static Patient makePatient(String firstName, String surname, String gender, String birthDate,
            ArrayList<String> symptoms, int score) {
        Patient patient = new Patient(firstName, surname, gender, birthDate, symptoms, score);
        return patient;
    }

    /**
     * Public mutator method, getSymptoms, that goes through the systems and prints
     * them.
     * 
     * @return severityScore;
     */
    public String getSymptoms() {
        String symptomsList = "";
        for (String symptom : symptoms) {
            symptomsList += symptom + ", ";
        }
        return symptomsList;
    }


    /**
     * Public getter method, getSymptomScore, of return type String that returns
     * the severityScore.
     * If the Symptoms.symptomList contains the symptom then the severityScore is
     * added.
     * 
     * @return severityScore;
     */
    public int getSymptomScore() {
        for (String symptom : symptoms) {
            if (Symptoms.symptomList().contains(symptom)) {
                severityScore += Symptoms.getSymptomScore(symptom);
            }
        }
        return severityScore;
    }

    /**
     * Public getter method, getSeverityScore, of return type int that returns
     * the severityScore.
     * 
     * @return severityScore;
     */
    public int getSeverityScore() {
        return severityScore;
    }

    /**
     * Public getter method, getAdmissionDate, of return type String that returns
     * the admissionDate;
     * 
     * @return admissionDate;
     */
    public String getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Public mutator method, setAdmissionDate, that sets the instance variable
     * admissionDate to
     * the passed String.
     * 
     * @param admissionDate
     */
    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * Public getter method, getSicknessHistory, of return type String that returns
     * the sicknessHistory.
     * 
     * @return sicknessHistory;
     */
    public String getSicknessHistory() {
        return sicknessHistory;
    }

    /**
     * Public mutator method, setSicknessHistory, that sets the instance variable
     * sicknessHistory to
     * the passed String.
     * 
     * @param sicknessHistory
     */

    public void setSicknessHistory(String sicknessHistory) {
        this.sicknessHistory = sicknessHistory;
    }

    /**
     * Public getter method,getPrescriptions, of return type String that returns
     * the prescriptions.
     * 
     * @return prescriptions
     * 
     */
    public String getPrescriptions() {
        return prescriptions;
    }

    /**
     * Public mutator method, setPrescriptions, that sets the instance variable
     * prescriptions to
     * the passed String.
     * 
     * @param prescriptions
     */
    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    /**
     * Public getter method,getAllergies, of return type String that returns
     * the allergies.
     * 
     * @return allergies
     * 
     */
    public String getAllergies() {
        return allergies;
    }

    /**
     * Public mutator method, setAllergies, that sets the instance variable
     * allergies to
     * the passed String.
     * 
     * @param allergies
     */
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    /**
     * Public getter method, getSpecialRequests, of return type String that returns
     * the specialRequests.
     * 
     * @return specialRequests
     * 
     */
    public String getSpecialRequests() {
        return specialRequests;
    }

    /**
     * Public mutator method, setSpecialRequests, that sets the instance variable
     * specialRequests to
     * the passed String.
     * 
     * @param specialRequests
     */
    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    /**
     * Public getter method, getTrueSeverityScore, of return type int that returns
     * the severityScore.
     * 
     * @return severityScore
     * 
     */
    public int getTrueSeverityScore() {
        return severityScore;
    }

    /**
     * Public mutator method, setSeverityScore, that sets the instance variable
     * score to
     * the passed String.
     * 
     * @param score
     */
    public void setSeverityScore(int score) {
        this.severityScore = score;
    }

    /**
     * Public getter method, stringPatient, of return type String that returns
     * the firstName and Surname.
     * 
     * @return severitythis.getFirstName() + " " + this.getSurname()
     */
    public String stringPatient() {
        return this.getFirstName() + " " + this.getSurname();
    }

    /* FOR DEBUGGING PURPOSE ONLY */
    public void displayPerson() {
        super.displayPerson();
        System.out.println("Age: " + this.setAge());
        System.out.println("Symptoms: ");
        getSymptoms();
    }

    /**
     * Public getter method, getPatientInfo, of return type String that returns
     * the firstName, Surname, gender, and birth date.
     * 
     * @return this.getFirstName() + ", " + this.getSurname()
     *         + ", " + this.getBirthDate() + ", " + this.getGender()
     */
    public String getPatientInfo() {
        return this.getFirstName() + ", " + this.getSurname()
                + ", " + this.getBirthDate() + ", " + this.getGender();

    }
}