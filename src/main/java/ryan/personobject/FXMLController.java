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
    private ListView lstPeople;
    @FXML
    private Label lblBox;

    ArrayList<person> people = new ArrayList();
    
    void error(String text){
        /* Error alert method. */
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(text);
            alert.showAndWait();
    }

    void listUpdate() {
        //Updates the listBox 
        lstPeople.getItems().clear();  //clears the list each time so it can be reset from the arrayList
        for (int i = 0; i < people.size(); i++) {
            lstPeople.getItems().add("Name: " + people.get(i).getName());
        }
    }

    @FXML
    void btnAdd(ActionEvent event) {
        /* Adds a person to the ArrayList. */
        try {
            if ((Integer.parseInt(txtAge.getText())<=0)||(Integer.parseInt(txtHeight.getText())<=0)||(Integer.parseInt(txtWeight.getText())<=0)){
               error("Age, Height and Weight cannot be 0 or less."); 
            }
            else{
            people.add(new person(txtName.getText(), Integer.parseInt(txtAge.getText()), Double.parseDouble(txtHeight.getText()), Double.parseDouble(txtWeight.getText()), txtJob.getText()));
            listUpdate();
            }
        } catch (Exception ex) {
            error("One or more text fields are invalid. Ensure all text fields are filled in, Age is an Integer and Height and Weight are both numbers.");
        }
    }
    

    
    @FXML
    void btnChangeAge(ActionEvent event) {
        /* Changes the age of the selected person. */
        try{
        if (Integer.parseInt(txtAge.getText())<=0){
               error("Age cannot be 0 or less."); 
            }
        else{
            int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
            people.get(selectedIndex).setAge(Integer.parseInt(txtAge.getText()));
            listUpdate();
        }
        }
        catch(Exception ex){
            error("Please select a person and/or ensure a valid age is inputted.");
        }
    }

    @FXML
    void btnChangeHeight(ActionEvent event) {
        /* Changes the height of the selected person. */
        try{
        if (Double.parseDouble(txtHeight.getText())<=0){
               error("Height cannot be 0 or less."); 
            }
        else{
            int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
            people.get(selectedIndex).setHeight(Double.parseDouble(txtHeight.getText()));
            listUpdate();
        }
        }
        catch(Exception ex){
            error("Please select a person and/or ensure a valid height number is inputted.");
        }
    }

    @FXML
    void btnChangeJob(ActionEvent event) {
        /* Changes the job of the selected person. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        people.get(selectedIndex).setJob(txtJob.getText());
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person and/or enter a job into the text field.");
        }
    }

    @FXML
    void btnChangeName(ActionEvent event) {
        /* Changes the name of the selected person. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        people.get(selectedIndex).setName(txtName.getText());
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person and/or enter a name.");
        }
    }

    @FXML
    void btnChangeWeight(ActionEvent event) {
        /* Changes the weight of the selected person. */
        try{
        if (Double.parseDouble(txtWeight.getText())<=0){
               error("Weight cannot be 0 or less."); 
            }
        else{
            int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
            people.get(selectedIndex).setWeight(Double.parseDouble(txtWeight.getText()));
            listUpdate();
        }
        }
        catch(Exception ex){
            error("Please select a person and/or ensure a valid weight number is inputted.");
        }
    }

    @FXML
    void btnClear(ActionEvent event) {
        /* Removes the selected person from the list. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        people.remove(selectedIndex);
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person from the list.");
        }
    }

    @FXML
    void btnClearAll(ActionEvent event) {
        /* Clears the people list. */
        people.clear();
        listUpdate();
    }
    
    @FXML
    void btnShowAge(ActionEvent event) {
        /* Shows the age of the selected person. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        lblBox.setText("" + people.get(selectedIndex).getAge());
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person from the list.");
        }
    }

    @FXML
    void btnShowHeight(ActionEvent event) {
        /* Shows the height of the selected person. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        lblBox.setText("" + people.get(selectedIndex).getHeight());
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person from the list.");
        }
    }

    @FXML
    void btnShowJob(ActionEvent event) {
        /* Shows the job of the selected person. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        lblBox.setText("" + people.get(selectedIndex).getJob());
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person from the list.");
        }
    }   

    @FXML
    void btnShowWeight(ActionEvent event) {
        /* Shows the weight of the selected person. */
        try{
        int selectedIndex = lstPeople.getSelectionModel().getSelectedIndex();  //gets the select spot from the listBox
        lblBox.setText("" + people.get(selectedIndex).getWeight());
        listUpdate();
        }
        catch(Exception ex){
            error("Please select a person from the list.");
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
