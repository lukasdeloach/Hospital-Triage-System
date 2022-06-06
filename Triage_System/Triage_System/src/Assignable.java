/**
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 *
 * Interface Assignable is used by the subclasses of Staff Doctor and
 * Nurse.
 */
public interface Assignable {
    /**
     * Public abstract method named assign.
     */
    public abstract void assign(Patient patient);

}