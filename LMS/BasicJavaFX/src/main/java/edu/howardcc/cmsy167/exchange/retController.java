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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class retController {
	private Stage stage;
	private Scene scene;
    @FXML
    private TextField Bookid;

    @FXML
    void returnBook(MouseEvent event) throws IOException {
    	if(Bookid.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("Not Possible Enter an ID", "Fatal Error");
    	}
    	else {
    		Student s1=new Student();
    		boolean m=s1.ReturnBook(Bookid.getText().toString());
    		if(m) {
    			AlertMsg.mainmsg("Book returned", "Return Successful");
    		}
    		else {
    			AlertMsg.mainmsg("Book already returned", "Invalid Action");
    		}
    		Parent root=FXMLLoader.load(getClass().getResource("/fxml/StudentLogin.fxml"));
    		//Scene scene=new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    }

    @FXML
    void studentprof(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/StudentLogin.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}

