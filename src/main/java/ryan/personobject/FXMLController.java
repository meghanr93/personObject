package ryan.personobject;

/*
Meghan Ryan
12/2/2021
This program a client program is required to be made that interacts with a person object.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtHeight;
    @FXML
    private TextField txtWeight;
    @FXML
    private TextField txtJob;

    @FXML
    private ListView<?> lstPeople;

    ArrayList people = new ArrayList();

    void listUpdate() {
        //Updates the listBox 
        lstPeople.getItems().clear();  //clears the list each time so it can be reset from the arrayList
        for (int i = 0; i < people.size(); i++) {
            lstPeople.getItems().add("Name: " + people.get(i).getName());
        }
    }

    @FXML
    void btnAdd(ActionEvent event) {
        try {
            people.add(new person(txtName.getText(), Integer.parseInt(txtAge.getText()), Integer.parseInt(txtHeight.getText()), txtJob.getText(), Integer.parseInt(txtWeight.getText())));
            listUpdate();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("One or more text fields are invalid. Ensure all text fields are filled in, Age is an Integer and Height and Weight are both numbers.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    double buttonSetHeight = 0;
    double buttonSetWidth = 0;

    @FXML
    void btnHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        Button button = (Button) event.getSource();
        buttonSetHeight = button.getPrefHeight();
        buttonSetWidth = button.getPrefWidth();
        button.setPrefHeight(buttonSetHeight * 1.1);
        button.setPrefWidth(buttonSetWidth * 1.1);
        button.setTranslateX((buttonSetWidth - buttonSetWidth * 1.1) / 2);
        button.setTranslateY((buttonSetHeight - buttonSetHeight * 1.1) / 2);
        button.toFront();
    }

    @FXML
    void btnUnhover(MouseEvent event) {
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(buttonSetHeight);
        button.setPrefWidth(buttonSetWidth);
        button.setTranslateX(0);
        button.setTranslateY(0);
        button.toBack();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
