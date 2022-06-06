
 /**
 * The Nurse class is a subclass of Staff and implements Assignable {

 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
 
public class Nurse extends Staff implements Assignable {
    /**
         * Costructor of the Nurse class.
         * Call to the superclass Staff.
         * 
         * @param firstName
         * @param middleName
         * @param surname
         * @param birthDate
         * @param gender
         * @param homeAddress
         * @param phoneNumber
         * @param staffId
         * @param staffUsername
         * @param staffPassword
         * @param staffAdmin
         */
        public Nurse(String firstName, String middleName, String surname, String birthDate, String gender) {
            super(firstName, middleName, surname, birthDate, gender);
            // TODO Auto-generated constructor stub
        }
    
        @Override
        public void assign(Patient patient) {
            Nurse n = Queue.nurseList.get(0);
            Queue.assignedMap.put(n, patient);
            try {
                Queue.nurseList.remove(0);
            } catch (Exception e) {
                // TODO: handle exception
            }
            Queue.nurseList.add(n);
    
        }
    
    }