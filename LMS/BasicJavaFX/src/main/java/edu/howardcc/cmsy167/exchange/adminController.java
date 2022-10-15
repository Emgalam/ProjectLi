/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.howardcc.cmsy167.exchange;

/**
 *
 * @author Acer
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class adminController implements Initializable{
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
	 @FXML
	    private TableView<Book> BooksTable;
	@FXML
    private TableColumn<Book, String> BookID;

    @FXML
    private TableColumn<Book, String> BookName;

    @FXML
    private TableColumn<Book, String> PublishedBy;


    @FXML
    private TableColumn<Book, Boolean> Status;
	 @FXML
	 private TextField Searchbar;
	 ObservableList<Book> oblist=FXCollections.observableArrayList();
	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
		 boolean found=false;
		 BookID.setCellValueFactory(new PropertyValueFactory<Book,String>("bookId"));
		 BookName.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
		 PublishedBy.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
		 Status.setCellValueFactory(new PropertyValueFactory<Book,Boolean>("Status"));
		 oblistget x=new oblistget();
		 try {
			BooksTable.setItems(x.getdata());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 Book books=new Book();
//		
//			try {
//				oblist=books.getOBLIST();
//				found=true;
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		if(found) {
//		 BooksTable.setItems(oblist);
//		}
		
		
	 }
    @FXML
    void AddBook(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/AddBook.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void DeleteBook(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/DeleteBook.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void EditBook(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/EditBook.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Logout(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void RegisterStudent(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/StudentRegister.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void ViewStudents(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/ViewStudents.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void deleteStudent(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/DeleteStudent.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }
    @FXML
    void Find(MouseEvent event) throws IOException {
    	 BookID.setCellValueFactory(new PropertyValueFactory<Book,String>("bookId"));
		 BookName.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
		 PublishedBy.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
		 Status.setCellValueFactory(new PropertyValueFactory<Book,Boolean>("Status"));
		 oblistget x=new oblistget();
		 try {
			BooksTable.setItems(x.getdata(Searchbar.getText().toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Searchbar.getText().toString().isEmpty()) {
			BooksTable.setItems(x.getdata());
		}
    }

}
