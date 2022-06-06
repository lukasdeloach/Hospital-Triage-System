import java.time.LocalDate;
import java.time.Period;


/**
 * A class representing a Person.
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
public abstract class Person {
    // instance variable firstName;
    private String firstName;
    // instance variable middleName;
    private String middleName;
    // instance variable surname;
    private String surname;
    // instance variable birthDate;
    private String birthDate;
    // instance variable gender;
    private String gender;
    // instance variable streetAddress;
    private String streetAddress;
    // instance variable phoneNumber;
    private int phoneNumber;
    // instance variable age;
    private int age;

    /**
     * Costructor of the Person class.
     * 
     * @param firstName
     * @param middleName
     * @param surname
     * @param birthDate
     * @param gender
     */
    public Person(String firstName, String surname, String gender, String birthDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = 0;
        this.gender = gender;
        this.streetAddress = setAdress();
        this.birthDate = birthDate;
    }

    /**
     * Public mutator method, setAdress, that sets the address.
     */
    private String setAdress() {
        return null;
    }

    /**
     * Public getter method, getFirstName, of return type String that returns
     * the staff firstName.
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Public mutator method, setFirstName, that sets the instance variable
     * firstName to
     * the passed String.
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Public getter method, getMiddleName, of return type String that returns
     * the staff middleName.
     * 
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Public mutator method, setMiddleName, that sets the instance variable
     * middleName to
     * the passed String.
     * 
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Public getter method, getSurname, of return type String that returns
     * the surname.
     * 
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Public mutator method, setSurname, that sets the instance variable surname to
     * the passed String.
     * 
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Public getter method, getAge, of return type int that returns
     * the  age.
     * 
     * @return surname
     */
    public int getAge() {
        return age;
    }

    /**
     * Public getter method, setAge, of return type int that returns
     * the age.
     * 
     * @return Period.between(date, today).getYears()
     */
    public int setAge() {
        LocalDate today = LocalDate.now();
        int month = Integer.parseInt(birthDate.substring(0, 2));
        int day = Integer.parseInt(birthDate.substring(3, 5));
        int year = Integer.parseInt(birthDate.substring(6, 10));
        LocalDate date = LocalDate.of(year, month, day);
        return Period.between(date, today).getYears();
    }

    /**
     * Public getter method, getBirthDate, of return type int that returns
     * the birthDate.
     * 
     * @return birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Public mutator method, setBirthDate, that sets the instance variable
     * birthDate to
     * the passed String.
     * 
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Public getter method, getGender, of return type String that returns
     * the  gender.
     * 
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Public mutator method, setGender, that sets the instance variable gender to
     * the passed String.
     * 
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Public getter method, getStreetAddress, of return type String that returns
     * the  streetAddress.
     * 
     * @return streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Public mutator method, setStreetAddress, that sets the instance variable
     * homeAddress to
     * the passed String.
     * 
     * @param homeAddress
     */
    public void setStreetAddress(String homeAddress) {
        this.streetAddress = homeAddress;
    }

    /**
     * Public getter method, getPhoneNumber, of return type String that returns
     * the  phoneNumber.
     * 
     * @return phoneNumber
     * 
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Public mutator method, setPhoneNumber, that sets the instance variable
     * phoneNumber to
     * the passed int.
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /* SHOW METHOD FOR DEBUGGING PURPOSE */

    public void displayPerson() {
        System.out.println("Firstname: " + this.getFirstName());
        System.out.println("Surname: " + this.getSurname());
        System.out.println("Gender: " + this.getGender());
    }

}