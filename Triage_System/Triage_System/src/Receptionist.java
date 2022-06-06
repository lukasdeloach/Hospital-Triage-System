/**
 * The Receptionist class is a subclass of Staff.
 * 
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
public class Receptionist extends Staff {

    /**
     * Costructor of the Receptionist class.
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
    public Receptionist(String firstName, String middleName, String surname,
            String birthDate, String gender, String homeAddress, int phoneNumber, int staffId, String staffUsername,
            String staffPassword, boolean staffAdmin) {
        super(firstName, middleName, surname, birthDate, gender);
        // TODO Auto-generated constructor stub
    }

}