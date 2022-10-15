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

public class editbookController {
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private TextField bookid;

    @FXML
    private TextField bookname;

    @FXML
    private TextField publisher;


    @FXML
    void goBack(MouseEvent event) throws IOException {	
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();

    }

    @FXML
    void update(MouseEvent event) throws IOException {
    	if(!bookid.getText().toString().isEmpty()) {
    		if(bookname.getText().toString().isEmpty()||publisher.getText().toString().isEmpty()) {
    			AlertMsg.mainmsg("Fill fields", "Insufficient Information");
    		}
    		else {
    			Book b1=new Book();
    			b1.EditBook(bookid.getText().toString(), bookname.getText().toString(),publisher.getText().toString(), true);
    			
    			Parent root=FXMLLoader.load(getClass().getResource("/fxml/Staff.fxml"));
    			//Scene scene=new Scene(root);
    			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			scene=new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    			}
    		}
    	}
    }
