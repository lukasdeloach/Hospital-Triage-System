import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * A class representing a Queuq.
 * 
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */
public class Queue {

    public static ArrayList<Patient> patientList = new ArrayList<>();
    public static ArrayList<Staff> staffList = new ArrayList<>();
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static ArrayList<Nurse> nurseList = new ArrayList<>();
    public static HashMap<Staff, Patient> assignedMap = new HashMap<>();

    /**
     * Costructor of the Queue class.
     * initalizes patient list as an ArrayList
     */
    public Queue() {
        patientList = new ArrayList<>();
    }

    /**
     * Public static sort method.
     * Compares the severityScore of the patients.
     */
    public static void sort() {

        List<Patient> sorted = patientList.stream()
                .sorted(Comparator.comparing(Patient::getSeverityScore)
                        .reversed())
                .filter(p -> p.getSeverityScore() >= 0)
                .collect(Collectors.toList());

        patientList = (ArrayList<Patient>) sorted;
    }

    /**
     * Public static printMprintMaxThreadinThread method.
     * Compares the severityScore of the patients and finds the most severe patient.
     */
    public static void printMaxThread() {
        Patient p = Queue.patientList
                .stream()
                .max(Comparator.comparing(Patient::getSeverityScore))
                .orElseThrow(NoSuchElementException::new);

        Consumer<Patient> consume = c -> System.out.println("Most Severe: " + c.stringPatient());
        Runnable max = () -> {
            consume.accept(p);
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(max);
    }

    /**
     * Public static printMinThread method.
     * Compares the severityScore of the patients and finds the least severe
     * patient.
     */
    public static void printMinThread() {

        Patient p = Queue.patientList
                .stream()
                .min(Comparator.comparing(Patient::getSeverityScore))
                .orElseThrow(NoSuchElementException::new);
        Consumer<Patient> consume = c -> System.out.println("Least Severe: " + c.stringPatient());
        Runnable min = () -> {
            consume.accept(p);
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(min);
    }

    /**
     * Public static method, addD, that adds a doctor to the staff list if it is not
     * already there.
     * 
     * @param d
     */
    public static void addD(Doctor d) {
        if (!staffList.contains(d)) {
            staffList.add(d);
            doctorList.add(d);
        }
    }

    /**
     * Public static method, addN, that adds a nurse to the staff list if it is not
     * already there.
     * 
     * @param n
     */
    public static void addN(Nurse n) {
        if (!staffList.contains(n)) {
            staffList.add(n);
            nurseList.add(n);
        }
    }

    /**
     * Public getter method, getTotalPatients, of return type int that returns
     * the total number of patients.
     * 
     * @return patientList.size()
     */
    public static int getTotalPatients() {
        return patientList.size();
    }

    /**
     * Public getter method, getPatientList, of return type ArrayList<Patient> that
     * returns
     * the list of patients.
     * 
     * @return patientList
     */
    public ArrayList<Patient> getPatientList() {
        return patientList;
    }
}