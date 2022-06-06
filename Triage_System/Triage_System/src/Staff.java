import java.util.ArrayList;

/**
 * The Staff class is a subclass of Person.
 * 
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */

public class Staff extends Person {

    protected static ArrayList<Staff> staffList = new ArrayList<>();
    // instance variable staffId
    private int staffId;
    // instance variable staffUsername
    private String staffUsername;
    // instance variable staffPassword
    private String staffPassword;
    // instance variable staffAdmin
    private boolean staffAdmin;

    /**
     * Costructor of the Staff class.
     * Call to the superclass Person.
     * 
     * @param firstName
     * @param middleName
     * @param surname
     * @param birthDate
     * @param gender
     */
    public Staff(String firstName, String middleName, String surname, String birthDate, String gender) {
        super(firstName, surname, gender, birthDate);
    }

    /**
     * Public static getter method, getTotalStaff, of return type int that returns
     * the total staff.
     * 
     * @return staffList.size()
     */
    public static int getTotalStaff() {
        return staffList.size();
    }

    /**
     * Public getter method, getStaffId, of return type int that returns the staff
     * Id.
     * 
     * @return staffId
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * Public mutator method, setStaffId, that sets the instance variable staffId to
     * the passed String.
     * 
     * @param staffId
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    /**
     * Public getter method, getStaffUsername, of return type String that returns
     * the staff username.
     * 
     * @return staffUsername
     */
    public String getStaffUsername() {
        return staffUsername;
    }

    /**
     * Public mutator method, setStaffUsername, that sets the instance variable
     * staffusername to the passed String.
     * 
     * @param staff_username
     */
    public void setStaffUsername(String staff_username) {
        this.staffUsername = staff_username;
    }

    /**
     * Public getter method, getStaff_password, of return type String that returns
     * the staff password.
     * 
     * @return staffPassword
     */
    public String getStaff_password() {
        return staffPassword;
    }

    /**
     * Public mutator method, setStaff_password, that sets the instance variable
     * staffpassword to the passed String.
     * 
     * @param staff_password
     */
    public void setStaff_password(String staff_password) {
        this.staffPassword = staff_password;
    }

    /**
     * Public getter method, isStaff_admin, of return type boolean that returns if
     * the staff was admin.
     * 
     * @return staffAdmin
     */
    public boolean isStaff_admin() {
        return staffAdmin;
    }

    /**
     * Public mutator method, setStaff_admin, that sets the instance variable
     * staff_admin to the passed boolean.
     * 
     * @param staff_admin
     */
    public void setStaff_admin(boolean staff_admin) {
        this.staffAdmin = staff_admin;
    }

    // DEBUGGING PURPOSE ONLY
    public void displayPerson() {
        super.displayPerson();
        System.out.println("ID: " + this.getStaffId());
        System.out.println("Username: " + this.getStaffUsername());
        System.out.println("Password: " + this.getStaff_password());
        System.out.println("IsAdmin: " + this.isStaff_admin());
    }
}