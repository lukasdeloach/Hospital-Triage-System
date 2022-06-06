import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.*;

public class Serial implements Serializable {
    
public static void serialize() throws IOException{
    File f = new File("serial.ser");
    Patient p = Queue.patientList.get(Queue.patientList.size()-1);
    try { 
        FileOutputStream fileO = new FileOutputStream(f);
        ObjectOutputStream out = new ObjectOutputStream(fileO);
        out.writeObject(p);
        out.close();
        System.out.println("Object has been serialized");}

        catch(IOException e)
        {
            System.out.println("Boo");
        }

    try
    {   
        // Reading the object from a file
            FileInputStream fileI = new FileInputStream(f);
            try (ObjectInputStream in = new ObjectInputStream(fileI)) {
                // Method for deserialization of object
                p = (Patient)in.readObject();
            }
              
            System.out.println("Object has been deserialized ");
            System.out.println("a = " + p);
        }
          
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    
    }
    
}