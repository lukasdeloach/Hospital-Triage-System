import java.util.ArrayList;
import java.util.HashMap;
/**
 * A class representing Symptoms.
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
public class Symptoms {
 
    public static HashMap<String, Integer> symptoms = new HashMap<>();
    private static HashMap<String, Integer> patientSymptoms;
    private int symptomValue;

    public Symptoms()
    {
        patientSymptoms = new HashMap<>();
    }

  /**   
   * Adds each symptom into a HashMap named symptoms, of our choice with it's deserved value. 
   * 
   */
    public static void addSymptom()
    {
        //symptoms.put(symptom, value);
        symptoms.put("Head injury", 3);
        symptoms.put("Difficulty breathing / speaking", 3);
        symptoms.put("OD/poisoning", 4);
        symptoms.put("Heart attack symptoms", 4);
        symptoms.put("No pulse", 15);
        symptoms.put("Chest pain", 3);
        symptoms.put("Impaled", 15);
        symptoms.put("Stroke-like symptoms", 4);
        symptoms.put("Uncontrolled bleeding", 15);
        symptoms.put("Unconsciousness", 4);
        symptoms.put("Limb Injury ", 4);
        symptoms.put("Seizure", 4);
        symptoms.put("Eye injury", 4);
        symptoms.put("Abdominal pain", 3);
        symptoms.put("Severe bites & stings", 4);
        symptoms.put("Burns", 4);
        symptoms.put("Pregnancy", 4);
        symptoms.put("Severe pain", 4);
        symptoms.put("Persistent vomiting", 4);
        symptoms.put("Suicidal thughts", 4);
        symptoms.put("Dizziness", 3);
        symptoms.put("Coughing blood", 3);
        symptoms.put("Confusion ", 3);
        symptoms.put("Severe headache", 3);
        symptoms.put("Dehydration", 3);
        symptoms.put("Weakness", 3);
        symptoms.put("Nausea", 2);
        symptoms.put("Cuts/wounds & minor bleeding", 2);
        symptoms.put("Swelling", 2);
        symptoms.put("Vomiting ", 2);
        symptoms.put("Sudden rash", 2);
        symptoms.put("Diarrhea", 2);
        symptoms.put("Fever ", 1);
        symptoms.put("Flu-like symptoms", 1);
        symptoms.put("Back pain", 1);
        symptoms.put("Ear pain", 1);
        symptoms.put("Infection", 1);
        symptoms.put("Orifice obstruction", 1);
        symptoms.put("Urinary problems/pain", 1);
    }

    /**
     * Static method that returns type ArrayList<String> called symtpomList
     * Calls the add symptom method which loads in all the symptoms. 
     * Then creates a new list to hold String symtpoms
     * Iterates through that list and adds the symptom names
     * @return symptomList
     */
     public static ArrayList<String> symptomList()
    {
        addSymptom();
        ArrayList<String> symptomList = new ArrayList<>();
        symptoms.forEach((key, value) -> symptomList.add(key));
        return symptomList;
    }

    /**
   * Gets the total value score of each symptom and adds it to a local variable 
   * totalValue. Then returns that value
   * @return totalValue
   */
    public int getTotalValueScore()
    {
        int totalValue = 0;
        for(Integer value: symptoms.values())
        {
            totalValue += value;
        }
        return totalValue;
    }


    /** 
     * Returns the symptom int value
     * @return symptomValue
     */
    public int getSymptomValue()
    {
        return symptomValue;
    }
    /**
     * Sets the symptom int value
     * @param value
     */
    public void setSymptomValue(int value)
    {
        this.symptomValue = value;
    }
  
/**
 * Public static method, getSymptomScore. 
 * @param symptom This takes in the symptom as a string and returns the value of the symptoms.
 * @return the score of the String of symptoms
 */
    public static int getSymptomScore(String symptom)
    {
        return symptoms.get(symptom).intValue();
    }
   
 }