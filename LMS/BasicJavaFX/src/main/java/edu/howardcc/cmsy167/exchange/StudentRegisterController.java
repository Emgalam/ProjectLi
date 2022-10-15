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

public class StudentRegisterController {

	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private PasswordField password;

    @FXML
    private TextField stID;

    @FXML
    private TextField uname;

    @FXML
    void gotoStaffpage(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void signup(ActionEvent event) throws IOException {
    	if(password.getText().toString().isEmpty()||uname.getText().toString().isEmpty()||stID.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("Fill All blanks", "Error");
    	}
    	else {
    		Student st=new Student();
    		st.RegisterStudent(stID.getText().toString(),uname.getText().toString(), password.getText().toString());
    		Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
    		//Scene scene=new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    }

}
