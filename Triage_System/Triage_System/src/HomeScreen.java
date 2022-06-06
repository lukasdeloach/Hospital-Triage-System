import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class HomeScreen extends Application {
 static Logger logger = Logger.getLogger("hello");
    public static void launch(String[] args) {
     threadLogger("In Welcome");
     Application.launch(args);
   }
 
   @Override
   public void init() {
     threadLogger("In init");
   }
  
   @Override
   public void start(Stage mainStage) {
     threadLogger("In start");
     BorderPane mainPane = new BorderPane();     // make layout to hold controls
     mainPane.setStyle("-fx-background-image: url('https://cdn1.vectorstock.com/i/1000x1000/35/80/hospital-room-cartoon-doctor-and-patient-vector-26873580.jpg'); -f-background-repeat: no-repeat; -f-background-size: 400 400; -fxbackground-position: center center;");
     setupControls(mainPane);                    // initialize and place controls
     Scene scene = new Scene(mainPane);          // Setup the main scene
     setStage(mainStage, scene);                 // Finalize and show the stage 
   }
  
   @Override
   public void stop() {
     threadLogger("In stop");
   }
  
   private void setStage(Stage mainStage, Scene scene) {
     mainStage.setWidth(1000);
     mainStage.setHeight(1000);
     mainStage.setTitle("Welcome Screen");
     mainStage.setScene(scene);
     mainStage.show();    
 }
 
 private void setupControls(BorderPane mainPane) {
 
       Label welcomeLabel = new Label("Hospital Check-In");
       HBox welcomeBox = new HBox();
 
       welcomeBox.getChildren().add(welcomeLabel);
       welcomeLabel.setFont(new Font("Gothom", 55));
       welcomeLabel.setTextFill(Color.IVORY);
       welcomeLabel.setPadding(new Insets(10));
       welcomeBox.setStyle("-fx-background-color: #800000;");
       welcomeBox.setAlignment(Pos.CENTER);

       Label blank = new Label();
       HBox blankBox = new HBox();
       blankBox.getChildren().add(blank);
       blank.setFont(new Font("Gothom", 20));
       blank.setTextFill(Color.IVORY);
       blank.setPadding(new Insets(10));
       blankBox.setStyle("-fx-background-color: #800000;");
       blankBox.setAlignment(Pos.CENTER);
 
       Button btn1 = new Button();
       //Button btn2 = new Button();
       Button btn3 = new Button();
       Button btn4 = new Button();
       Button btn6 = new Button();
       btn1.setFont(Font.font ("Gothom", 30));
       btn1.setStyle("-fx-background-color: #00ff00; -fx-background-radius: 15px;");
       //  btn1.setStyle("-fx-font-size: 2em; ");
       btn1.setText("Admit Patient");
       btn1.setPadding(new Insets(25));
       btn1.setAlignment(Pos.CENTER);
      
       /*btn2.setFont(Font.font ("Gothom", 30));
       btn2.setText("Assign");
       btn2.setStyle("-fx-background-color: silver");
       btn2.setAlignment(Pos.CENTER);
       btn2.setPadding(new Insets(25));*/
      
       btn3.setFont(Font.font ("Gothom", 30));
       btn3.setText("Queue List");
       btn3.setStyle("-fx-background-radius:15px;");
       btn3.setPadding(new Insets(25));
       btn3.setOnAction(e -> System.out.println(((Button) e.getTarget()).getText()));
       btn3.setAlignment(Pos.CENTER);

       btn4.setFont(Font.font("Gothom",30));
       btn4.setText("Assign");
       btn4.setStyle("-fx-background-radius:15px;");
       btn4.setPadding(new Insets(25));
       btn4.setOnAction(e-> System.out.println(((Button)e.getTarget()).getText()));
       btn4.setAlignment(Pos.CENTER);

       btn6.setFont(Font.font("Gothom",25));
       btn6.setText("Staff Available");
       btn6.setStyle("-fx-background-radius:15px;");
       btn6.setPadding(new Insets(25));

 
       VBox centerBox = new VBox(50);
       centerBox.setPadding(new Insets(10,10,10,-300));
       centerBox.getChildren().addAll(btn1,btn3,btn4, btn6);
       centerBox.setAlignment(Pos.CENTER);
 
       VBox rightBox = new VBox(10);
       rightBox.setPadding(new Insets(0, 0, 0, 0));
 
       long staffCount = Queue.staffList.stream().count();
       Label totalStaff = new Label("Active Staff: " + staffCount);
       Label totalPatients = new Label("Total Patients: " + Queue.getTotalPatients());
       Label totalRooms = new Label("Total Rooms: " + Room.getTotalRooms());
 
       btn1.setOnAction(e -> {
         ForumGUI.display();
         totalPatients.setText("Total Patients: " + Queue.getTotalPatients());
       });
 
       btn3.setOnAction(e -> {
         System.out.println(Queue.patientList.stream().count());
         QueueGUI.display();
       });

       Alert fail= new Alert(AlertType.ERROR);
       
       btn4.setOnAction(e->{
         if(Queue.patientList.size()>0)
         {
            AssignGUI.display();
            totalPatients.setText("Total Patients: " + Queue.getTotalPatients());
            totalRooms.setText("Total Rooms: " + Room.getTotalRooms());
         }
         else{
           fail.setContentText("No Patients");
           fail.showAndWait();
         }
       });
       
        btn6.setOnAction(e->{ 
         System.out.println(Queue.staffList.stream().count());
         StaffListGUI.display();  
       });
       
      
       totalStaff.setFont(new Font("Gothom", 25));
       totalPatients.setFont(new Font("Gothom", 25));
       totalRooms.setFont(new Font("Gothom", 25));
       totalStaff.setTextFill(Color.IVORY);
       totalPatients.setTextFill(Color.IVORY);
       totalRooms.setTextFill(Color.IVORY);
 
       rightBox.getChildren().addAll(totalPatients, totalStaff, totalRooms);
      
       // Now add to border
       mainPane.setTop(welcomeBox);
       mainPane.setCenter(centerBox);
       mainPane.setLeft(rightBox);
       mainPane.setBottom(blankBox);
         //cheap way to get space
 }
 
 private static void threadLogger(String checkpoint) {
       logger.log(Level.INFO, checkpoint + ": " + Thread.currentThread().getName()
       + "  " + Thread.currentThread() + System.lineSeparator()); 
   }
}
