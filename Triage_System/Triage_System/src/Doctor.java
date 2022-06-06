/**
 * The Doctor class is a subclass of Staff.
 * 
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */

public class Doctor extends Staff implements Assignable {

    /** 
     * Constructor of the Doctor Class
     * Call to the Superclass Staff
     * 
     * 
     * @param firstName
     * @param middleName
     * @param surname
     * @param birthDate
     * @param gender
     */
        public Doctor(String firstName, String middleName, String surname, String birthDate, String gender) {
            super(firstName, middleName, surname, birthDate, gender);
        }
    /**
     * Implements the assign method from the Assignable Interface, this allows a Doctor to have a Patient
     */
        @Override
        public void assign(Patient patient) {
    
            Doctor d = Queue.doctorList.get(0);
            Queue.assignedMap.put(d, patient);
            try {
                Queue.doctorList.remove(0);
            } catch (Exception e) {
                // TODO: handle exception
            }
            Queue.doctorList.add(d);
            Queue.patientList.remove(patient);
        }
    
    }
    