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

public class deleteBookController {
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private TextField booktodel;

    @FXML
    void DeleteBook(MouseEvent event) throws IOException {
    	if(booktodel.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("No id entered", "Enter an Id");
    	}
    	else {
    		Book book=new Book();
    		book.DeleteBook(booktodel.getText().toString());
    		Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
    		//Scene scene=new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    }

    @FXML
    void GoBack(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}