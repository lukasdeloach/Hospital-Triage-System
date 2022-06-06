import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AssignGUI {
    private static Stage mainStage;

    public static void display() {
        mainStage = new Stage();
        BorderPane mainPane = new BorderPane();
        setUpControls(mainPane);

        mainStage.setTitle("Assign Patient Staff");
        mainStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(mainPane);
        mainStage.setScene(scene);
        mainStage.showAndWait();
        System.out.printf("start() called on thread %s%n", Thread.currentThread());
    }

    /**
     * 
     * @param mainPane This creates the main layout of the Assignation GUI for the
     *                 Doctors & Nurses to Patients
     */
    public static void setUpControls(BorderPane mainPane) {

        Label topLabel = new Label("Next Patient in Line:");
        HBox topBox = new HBox();

        topBox.getChildren().add(topLabel);
        topLabel.setPadding(new Insets(20, 20, 20, 20));
        topLabel.setStyle("-fx-background-color: #800000; -fx-text-fill: white; -fx-font-size: 20px;");
        topLabel.setAlignment(Pos.CENTER);
        mainPane.setTop(topBox);

        Doctor d = Queue.doctorList.get(0);
        Nurse n = Queue.nurseList.get(0);
        Patient p = Queue.patientList.get(0);
        Label prompt = new Label("Patient: " + Queue.patientList.get(0).stringPatient());
        Label secondPrompt = new Label(" Seeing Dr. " + d.getFirstName() + " " + d.getSurname());
        Label thirdPrompt = new Label(" Seeing Nurse " + n.getFirstName() + " " + n.getSurname());
        secondPrompt.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");
        thirdPrompt.setStyle("-fx-text-fill: black; -fx-font-size: 16px;");

        prompt.setFont(new Font("Arial", 15));
        prompt.setAlignment(Pos.CENTER);

        secondPrompt.setFont(new Font("Arial", 15));
        secondPrompt.setAlignment(Pos.CENTER);

        Button btn1 = new Button();
        btn1.setText("Assign");
        btn1.setAlignment(Pos.BASELINE_CENTER);


        btn1.setPadding(new Insets(15, 15, 15, 15));
        btn1.setAlignment(Pos.BASELINE_LEFT);
        btn1.setFont(new Font("Arial", 20));
        btn1.setStyle("-fx-background-color: #00FF00;");
        btn1.setOnAction(e -> {
            n.assign(p);
            d.assign(p);
            Room.roomList.remove(Room.roomList.size()-1);
            mainStage.close();
            if (!Queue.patientList.isEmpty()) {
                Queue.printMaxThread();
                Queue.printMinThread();
            }
        });
        
        VBox v = new VBox(25);
        v.getChildren().addAll(prompt, secondPrompt, thirdPrompt, btn1);
        v.setAlignment(Pos.CENTER);
        

        mainPane.setCenter(v);

    }
}