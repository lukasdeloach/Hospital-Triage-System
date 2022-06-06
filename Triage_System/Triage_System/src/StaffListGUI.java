import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StaffListGUI
 {

    private static Stage mainStage;
	public static void display() {
		mainStage = new Stage();
		BorderPane mainPane = new BorderPane();
		setUpControls(mainPane);

		mainStage.setTitle("Staff Available");
		mainStage.initModality(Modality.APPLICATION_MODAL);
		Scene scene = new Scene(mainPane);
		mainStage.setScene(scene);
		mainStage.showAndWait();
		System.out.printf("start() called on thread %s%n", Thread.currentThread());	
        //mainStage.onCloseRequestProperty().addListener(e -> Patient.clearList());	
	}
/**
 * 
 * @param mainPane This creates the main layout of the Assignation GUI for the StaffListGUI
 */
    private static void setUpControls(BorderPane mainPane)
    {
        ObservableList<Staff> data = FXCollections.observableArrayList();
        data.clear();

        TableView<Staff> staff = new TableView<Staff>();    
		// Setup the table columns
		TableColumn<Staff, String> coldName = 
				new TableColumn<Staff, String>("First Name");
		coldName.setMinWidth(140);
		coldName.setCellValueFactory(
				new PropertyValueFactory<Staff, String>("firstName")); 
                
        TableColumn<Staff, String> coldLast = 
				new TableColumn<Staff, String>("Last Name");
		coldLast.setMinWidth(140);
		coldLast.setCellValueFactory(
				new PropertyValueFactory<Staff, String>("surname")); 

		TableColumn<Staff, String> colTitle = 
				new TableColumn<Staff, String>("Staff Title");
		colTitle.setMinWidth(140);
		colTitle.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getClass().getSimpleName()));

		staff.getColumns().addAll(Arrays.asList(colTitle, coldName, coldLast));
        mainPane.setCenter(staff);

        if(!Queue.staffList.isEmpty())
       {
         	data.addAll(Queue.staffList);
            staff.setItems(data);
        }
    }

}

