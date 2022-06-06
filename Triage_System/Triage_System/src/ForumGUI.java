import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * @author Emma Zimmerman
 * @author Kat Saburova
 * @author Lukas DeLoach
 * @author Neiloy Hossain
 * @author Iker Martinez
 * @version 14.0
 */

/**
 * Demonstration of various controls
 */

public class ForumGUI {

    private static Stage mainStage;

    public static void display() {
        mainStage = new Stage();
        BorderPane mainPane = new BorderPane();
        setupControls(mainPane);

        mainStage.setTitle("Welcome Screen");
        mainStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(mainPane);
        mainStage.setScene(scene);
        mainStage.showAndWait();
        System.out.printf("start() called on thread %s%n", Thread.currentThread());
    }

    private static TreeView<String> treeView2;
/**
 *  Creates the main window for the Patient forum which takes in various functions, such as name, address, and symptoms
 * @param mainPane
 */
    private static void setupControls(BorderPane mainPane) {

        Label topLabel = new Label("Patient Information Forum");
        HBox topBox = new HBox();
        /**
         * This creates the top part of the GUI, it positions it along with alignment and padding 
         */
        topBox.getChildren().add(topLabel);
        topLabel.setFont(new Font("Arial", 25));
        topLabel.setPadding(new Insets(10));
        topLabel.setAlignment(Pos.CENTER);
        mainPane.setTop(topBox);

        VBox patientInfo = new VBox(15);
        /**
         * This creates the two Labels for the Name of the Patient, that being the first and last name
         */
        Label namePrompt = new Label("Patient Name");
        TextField textFieldFirstName = new TextField();
        textFieldFirstName.setPromptText("First Name");
        TextField textFieldLastName = new TextField();
        textFieldLastName.setPromptText("Last Name");

        /**
         * This creates a Check Box if the incoming Patient is urgent, when checked, the symptoms of the patient is multiplied by 2 which allows
         * the patient to go to the top of the Queue List
         */
        CheckBox check = new CheckBox("Urgent Patient");
        
        /**
         *  Creates where the position of the name and the urgent check box should be placed in the forum
         */
        HBox nameBox = new HBox(25);
        nameBox.getChildren().addAll(textFieldFirstName, textFieldLastName, check);

        /**
         * Creates various radio buttons which hold the Patient's sex
         */
        Label patientSexPrompt = new Label(("Patient Sex"));
        RadioButton rButtonMale = new RadioButton("M");
        RadioButton rButtonFemale = new RadioButton("F");
        RadioButton rButtonOther = new RadioButton("Other");

        /**
         *  Creates text field which holdsthe value of string of the patient's birthdate
         */
        Label patientDateOfBirth = new Label("Date of Birth");
        TextField textFieldDateOfBirth = new TextField();
        textFieldDateOfBirth.setPromptText("MM/DD/YYYY");
        textFieldDateOfBirth.setMaxWidth(100);

        /**
         * Creates a toggle group for the thre radio buttons which contain the sex of the patient
         * 
         */
        ToggleGroup radioButtonGroupSex = new ToggleGroup();
        rButtonMale.setToggleGroup(radioButtonGroupSex);
        rButtonFemale.setToggleGroup(radioButtonGroupSex);
        rButtonOther.setToggleGroup(radioButtonGroupSex);
        rButtonOther.setSelected(true);
        rButtonMale.pressedProperty();
        rButtonFemale.pressedProperty();
        rButtonOther.pressedProperty();

        /**
         * adds the toggle group into the main window of the forum
         */
        HBox patientSexBox = new HBox(20);
        patientSexBox.getChildren().addAll(rButtonMale, rButtonFemale, rButtonOther);

        /**
         * creates more textfields containing the strings for the patient's address
         */
        Label patientAddress = new Label("Patient's Address");
        TextField streetTxt = new TextField();
        streetTxt.setPromptText("Street Address");
        TextField cityTxt = new TextField();
        cityTxt.setPromptText("City");

        /**
         * creates a text field which can enter strings for the patient's zip code and country
         */
        TextField zipCodeTxt = new TextField();
        zipCodeTxt.setPromptText("Postal/Zip Code");
        TextField countryTxt = new TextField();
        countryTxt.setPromptText("Country");

        /**
         *  adds both of the textfields (address and city) into the main window of the forum gui
         */
        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(patientAddress, streetTxt);

        /**
         *  adds the city textfield and the drop down for the states which the user can pick from
         */
        HBox hbox2 = new HBox();
        hbox2.setPadding(new Insets(0, 0, 0, 25));
        hbox2.getChildren().addAll(cityTxt, setStates());

        /**
         * creates the location for the zip code and the country of the patient
         * 
         */
        HBox hbox3 = new HBox();
        hbox3.setPadding(new Insets(0, 0, 0, 25));
        hbox3.getChildren().addAll(zipCodeTxt, countryTxt);

        /**
         * creates the main button which the forum is dependent on
         */
        Button btn1 = new Button();
        btn1.setText("Admit Patient");
        btn1.setPadding(new Insets(25));
        btn1.setAlignment(Pos.CENTER);

        /**
         *  Creates a label and the choice box for the insurance of the patient, and then chooses the location to where these two
         * components can be placed in the window
         */
        Label insuranceLabel = new Label("Patient's Insurance:");
        insuranceLabel.setPadding(new Insets(2, 2, 2, 2));
        ChoiceBox<String> insurance = new ChoiceBox<String>();
        insurance.getItems().addAll("Cigna", "Well Care", "Care Plus", "Magellan Health", "United Health One",
                "Aetna", "Horizon: Blue Cross Blue Shield", "Medicare", "Medicade", "No Insurance Given");
        insurance.setValue("Please Choose Insurance Company");
        HBox hbox4 = new HBox(insuranceLabel, insurance);

        /**
         *  adds all of the controls for the patient into one window, depending on where the 
         */
        patientInfo.getChildren().addAll(namePrompt, nameBox, patientSexPrompt,
                patientSexBox, patientDateOfBirth, textFieldDateOfBirth, hbox1, hbox2, hbox3, hbox4);
        
        /**
         * This creates the tree in which the patient's symptoms are stored and the patient can select multiple symptoms
         */
        treeView2 = new TreeView<String>();
        treeView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        buildTree(treeView2);

        /**
         * This button has great functionality but is very delicate. Starting off, the patient is admitted into a queue list which is determined
         * by the severity of each patient. The window is unable to close if the user has entered nothing for the required text fields.
         * That being the first name, last name, address, and birthday. After the user enters the valid values for the patient,
         * the patient's information is then printed out into a txt file for the user to read.
         */
        btn1.setOnAction(e -> {
        

            Alert fail = new Alert(AlertType.ERROR);
                String textName = textFieldFirstName.getPromptText();
                String textLast = textFieldLastName.getPromptText();
                String streetext = streetTxt.getPromptText();
                String birthdate = textFieldDateOfBirth.getPromptText();
                String gender = ((RadioButton) radioButtonGroupSex.getSelectedToggle()).getText();

                String birthDateRegex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";

                if (textFieldFirstName.getText().trim().isEmpty() | textFieldLastName.getText().trim().isEmpty()
                        | streetTxt.getText().trim().isEmpty() | !textFieldDateOfBirth.getText().matches(birthDateRegex)){
                    fail.setHeaderText("Failure");
                    if (textFieldFirstName.getText().trim().isEmpty()) {
                        fail.setContentText("Please Enter Valid " + textName);
                        Logging.log(Level.WARNING, "User entered Invalid First Name");
                    } else if (textFieldLastName.getText().trim().isEmpty()) {
                        fail.setContentText("Please Enter Valid " + textLast);
                        Logging.log(Level.WARNING, "User entered Invalid Last Name");
                    } 
                    else if(!textFieldDateOfBirth.getText().matches(birthDateRegex))
                    {
                        fail.setContentText("Please Enter Valid " + birthdate);
                        Logging.log(Level.WARNING, "User entered Invalid Birthdate");
                     }

                    else {
                        fail.setContentText("Please Enter Valid " + streetext);
                    }
                    fail.showAndWait();
                }
                // System.err.println("User put invalid " + textName);}

                /**
                 * After the user enters valid fields for the strings, it then places the patients into a queue list based on severity score
                 * with the patient's symptoms added up
                 */
                else {

                    ArrayList<String> items = new ArrayList<>();
                    treeView2.getSelectionModel().getSelectedItems().forEach(item -> items.add(item.getValue()));
                    String birthDate = textFieldDateOfBirth.getText();

                    int score = 0;
                    for (String symptom : items) {
                        if (Symptoms.symptomList().contains(symptom)) {
                            score += Symptoms.getSymptomScore(symptom);
                        }
                        if (check.isSelected()) {
                            score *= 2;
                        }
                    }


                    Queue.patientList.add(Patient.makePatient(textFieldFirstName.getText(),
                            textFieldLastName.getText(), gender,
                            birthDate, items, score));
                            
                    
                    try {
                        try (BufferedWriter writer = new BufferedWriter(
                            (new FileWriter(textFieldFirstName.getText() + textFieldLastName.getText() + ".txt")))) {
                        try {
                            writer.write("\n" + Queue.patientList.get(Queue.patientList.size()-1).getPatientInfo() + "\n"+
                                "\n" + streetTxt.getText() + "\n" + cityTxt.getText() + "\n" + zipCodeTxt.getText() + "\n"
                                + countryTxt.getText() + "\n " +
                                insurance.getValue() + "\n Symptoms: " + Queue.patientList.get(Queue.patientList.size()-1).getSymptoms());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    
                    try (BufferedReader myReader = new BufferedReader(
                        new FileReader(textFieldFirstName.getText() + textFieldLastName.getText() + ".txt"))) {
                        String line = "";

                        while ((line = myReader.readLine()) != null) {
                            System.out.println(line);
                        }
                        myReader.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("File does not exist");
                        ex.printStackTrace();
                    } catch (IOException exc) {
                        exc.printStackTrace();}
                        mainStage.close();
                        Queue.sort();
                        Logging.log(Level.INFO, "Patient has been admitted");}
                    catch (Exception IncorrectNameException) {

                    }

                }
            });

        /**
         * 
         */
        mainPane.setBottom(btn1);
        mainPane.setLeft(patientInfo);
        mainPane.setRight(treeView2);
    }
    /**
     * this creates the tree view for the symptoms and adds them to the window for th patient forum
     * @param treeView
     */

    private static void buildTree(TreeView<String> treeView) {

        ArrayList<String> symptoms = Symptoms.symptomList();

        TreeItem<String> rootItem = new TreeItem<String>("Select Patient's Symptoms:");
        rootItem.setExpanded(true);

        symptoms.forEach(symptom -> {
            TreeItem<String> symptomItem = new TreeItem<String>(symptom);
            rootItem.getChildren().add(symptomItem);
        });

        treeView.setRoot(rootItem); 

    }
    /**
     * this create a choice box for the 50 states which a patient can choose from 
     * @return
     */
    private static HBox setStates() {
        ChoiceBox<String> states = new ChoiceBox<String>();
        states.getItems().addAll("Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California",
                "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii",
                "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts",
                "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska",
                "Nevada",
                "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
                "Northern Mariana Islands",
                "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina",
                "South Dakota",
                "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington",
                "West Virginia",
                "Wisconsin", "Wyoming");
        states.setValue("State");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(states);
        return hbox;
    }

}