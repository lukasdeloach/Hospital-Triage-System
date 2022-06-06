
public class App {
    public static void main(String[] args) throws Exception {

        makeRooms();
        makeStaff();
        HomeScreen.launch(args);
        Serial.serialize();
        Queue.printMaxThread();
        Queue.printMinThread();

    }

    private static void makeRooms() {
        for(int i = 0; i < 100; i++)
        {
            Room.roomList.add(i);
        }
    }

    private static void makeStaff() {
        Queue.addD(new Doctor("Lukas", "J", "DeLoach", "", "M"));
        Queue.addD(new Doctor("James", "J", "Smith", "", "M"));
        Queue.addD(new Doctor("Iker", "I", "M", "", "M"));
        Queue.addN(new Nurse("Cole", "", "Hughes", "", "F"));
        Queue.addN(new Nurse("Kat", "", "S", "", "F"));
        Queue.staffList.add(new NurseAid("Neiloy", "", "H", "", "M"));
        Queue.staffList.add(new NurseAid("Eliabeth", "", "D", "", "M"));
        Queue.staffList.add(new NurseAid("Lily", "", "D", "", "M"));
        Queue.staffList.add(new NurseAid("Adrianna", "D", "H", "", "M"));
        Queue.staffList.add(new NurseAid("Skylar", "", "B", "", "M"));
        Queue.addD(new Doctor("Jamie", "J", "Smith", "", "M"));
        Queue.addD(new Doctor("Morgan", "J", "DeLL", "", "M"));
        Queue.addN(new Nurse("Jimmy", "", "Ngyuen", "", "F"));
        Queue.addN(new Nurse("Leo", "", "Di", "", "F"));
        Queue.addN(new Nurse("Neil", "", "Palk", "", "F"));
        Queue.addN(new Nurse("Kat", "", "I", "", "F"));
        Queue.addN(new Nurse("Emma", "", "Smith", "", "F"));
        Queue.addN(new Nurse("Kat", "", "Smith", "", "F"));
    } 
   
}


