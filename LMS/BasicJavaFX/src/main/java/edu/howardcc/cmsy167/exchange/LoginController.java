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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private TextField Username;

    @FXML
    private PasswordField password;

    @FXML
    void adminSignIn(MouseEvent event) throws IOException {
    	if(Username.getText().toString().isEmpty()||password.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("Field Empty", "Fill Fields");
    	}
    	else {
    		Admin a1=new Admin();
    		boolean status=a1.loginSuccess(Username.getText().toString(), password.getText().toString());
    		if(status) {
    		Parent root=FXMLLoader.load(getClass().getResource("/fxml/ActualAdmin.fxml"));
    		//Scene scene=new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    		}
    		else {
    			AlertMsg.mainmsg("Login Failed", "Try again");
    		}
    	}
    }

    @FXML
    void login(MouseEvent event) throws IOException {
    	if(Username.getText().toString().isEmpty()||password.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("Field Empty", "Fill Fields");
    	}
    	else {
    		boolean student=false;
    		boolean staff=false;
    		Student s=new Student();
    		Staff x=new Staff();
    		staff=x.authenticate(Username.getText().toString(), password.getText().toString());
    		student=s.authenticate(Username.getText().toString(), password.getText().toString());
    		if(staff){
    			Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
				//Scene scene=new Scene(root);
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
    		}
    		if(student){

    			Parent root=FXMLLoader.load(getClass().getResource("/fxml/StudentLogin.fxml"));
				//Scene scene=new Scene(root);
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
    		}
    		if(student==false&& staff==false) {
    			AlertMsg.mainmsg("Login Failed", "Try again");
    		}
    		
    	}
    }
}
    
