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

public class addBookController {
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private TextField bname;

    @FXML
    private TextField bookid;

    @FXML
    private TextField publisher;

    @FXML
    void addbook(MouseEvent event) throws IOException {
    	
    	
    	
    	if(bname.getText().toString().isEmpty()||bookid.getText().toString().isEmpty()||publisher.getText().toString().isEmpty()) {
    		AlertMsg.mainmsg("Not All fields are Filled", "Fill the Fields");
    	}
    	else {
    		//Book b1=new Book("1","2","3",true);
    		//b1.AddBook(bookid.getText().toString(),bname.getText().toString(), publisher.getText().toString(), true);
    		bookadd b1=new bookadd();
    		b1.AddBook(bookid.getText().toString(),bname.getText().toString(), publisher.getText().toString(),true);
    		Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
    		//Scene scene=new Scene(root);
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene=new Scene(root);
    		stage.setScene(scene);
    		stage.show();
    	}
    }

    @FXML
    void goback(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}
