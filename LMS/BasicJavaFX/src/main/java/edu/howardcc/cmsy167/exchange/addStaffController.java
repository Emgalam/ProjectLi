/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.howardcc.cmsy167.exchange;

/**
 *
 * @author Acer
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class addStaffController {
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private TextField cnic;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private PasswordField password;

    @FXML
    private Button toLogin;

    @FXML
    private TextField uname;

    @FXML
    void signup(ActionEvent event) throws IOException {
    	if(cnic.getText().toString().isEmpty()||fname.getText().toString().isEmpty()||lname.toString().isEmpty()||uname.getText().toString().isEmpty()||password.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("Insufficient Information", "Fill All fields");
    	}
    	else {
    		Admin a = new Admin();
    		a.AddStaff(uname.getText().toString(), password.getText().toString(), cnic.getText().toString(),fname.getText().toString(),lname.getText().toString());
    		Parent root=FXMLLoader.load(getClass().getResource("/fxml/ActualAdmin.fxml"));
    		//Scene scene=new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    }
    @FXML
    void goBack(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/ActualAdmin.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}
