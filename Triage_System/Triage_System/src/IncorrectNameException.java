/**
 * Custom IncorrectNameException class.
 * 
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
public class IncorrectNameException extends Exception {
    // instance variable message
    private String message;

    /**
     * Public IncorrectNameException.
     * 
     * @param errorMessage
     */
    public IncorrectNameException(String errorMessage) {
        super(errorMessage);

    }
}