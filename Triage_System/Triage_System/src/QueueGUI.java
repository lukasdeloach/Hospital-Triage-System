
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QueueGUI {

    private static Stage mainStage;

    public static void display() {
        mainStage = new Stage();
        BorderPane mainPane = new BorderPane();
        setUpControls(mainPane);

        mainStage.setTitle("Patient Queue");
        mainStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(mainPane);
        mainStage.setScene(scene);
        mainStage.showAndWait();
        System.out.printf("start() called on thread %s%n", Thread.currentThread());
    }

/**
 * 
 * @param mainPane This creates the main layout of the Assignation GUI for the QueueGUI
 */
    private static void setUpControls(BorderPane mainPane) {
        ObservableList<Patient> data = FXCollections.observableArrayList();
        data.clear();

        Label label = new Label("Triage and Acuity Scale");
        label.setFont(new Font("Gothom", 25));

        Label levelOneText = new Label("Level I - Resuscitation");
        levelOneText.setFont(new Font("Gothom", 20));
        levelOneText.setTextFill(Color.BLACK);
        HBox levelOne = new HBox();
        levelOne.getChildren().addAll(levelOneText);
        levelOne.setStyle("-fx-background-color: #BF40BF;");

        Label levelTwoText = new Label("Level II - Emergent");
        levelTwoText.setFont(new Font("Gothom", 20));
        levelTwoText.setTextFill(Color.BLACK);
        HBox levelTwo = new HBox();
        levelTwo.getChildren().addAll(levelTwoText);
        levelTwo.setStyle("-fx-background-color: #FF0000;");

        Label levelThreeText = new Label("Level III - Urgent");
        levelThreeText.setFont(new Font("Gothom", 20));
        levelThreeText.setTextFill(Color.BLACK);
        HBox levelThree = new HBox();
        levelThree.getChildren().addAll(levelThreeText);
        levelThree.setStyle("-fx-background-color: #FFFF00;");

        Label levelFourText = new Label("Level IV - Less Urgent");
        levelFourText.setFont(new Font("Gothom", 20));
        levelFourText.setTextFill(Color.BLACK);
        HBox levelFour = new HBox();
        levelFour.getChildren().addAll(levelFourText);
        levelFour.setStyle("-fx-background-color: #00FF00;");

        Label levelFiveText = new Label("Level V - Non-Urgent");
        levelFiveText.setFont(new Font("Gothom", 20));
        levelFiveText.setTextFill(Color.BLACK);
        HBox levelFive = new HBox();
        levelFive.getChildren().addAll(levelFiveText);
        levelFive.setStyle("-fx-background-color: #FFFFF0;");

        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, levelOne, levelTwo, levelThree, levelFour, levelFive);

        TableView<Patient> patients = new TableView<Patient>();

        // Setup the table columns
        TableColumn<Patient, String> colName = new TableColumn<Patient, String>("Patient First Name");
        colName.setMinWidth(140);
        colName.setCellValueFactory(
                new PropertyValueFactory<Patient, String>("firstName"));

        TableColumn<Patient, String> colLast = new TableColumn<Patient, String>("Patient Last Name");
        colLast.setMinWidth(140);

        colLast.setCellValueFactory(
                new PropertyValueFactory<Patient, String>("surname"));

        for (int i = 0; i < Queue.patientList.size(); i++) {
            patients.setRowFactory(patient -> new TableRow<Patient>() {
                @Override
                protected void updateItem(Patient p, boolean empty) {
                    super.updateItem(p, empty);
                    if (p == null)
                        setStyle("");
                    else if (p.getSeverityScore() <= 1)
                        setStyle("-fx-background-color: #FFFFF0;");
                    else if (p.getSeverityScore() >= 2 && p.getSeverityScore() < 3)
                        setStyle("-fx-background-color: #00FF00;");
                    else if (p.getSeverityScore() >= 3 && p.getSeverityScore() < 7)
                        setStyle("-fx-background-color: #FFFF00;");
                    else if (p.getSeverityScore() >= 7 && p.getSeverityScore() < 15)
                        setStyle("-fx-background-color: #FF0000;");
                    else {
                        setStyle("-fx-background-color: #BF40BF;");
                    }
                }
            });
        }

        patients.getColumns().addAll(Arrays.asList(colName, colLast));

        mainPane.setCenter(vbox);
        mainPane.setBottom(patients);

        if (!Queue.patientList.isEmpty()) {
            data.addAll(Queue.patientList);
            patients.setItems(data);
        }
    }
}
