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
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class studentprofController implements Initializable{
	private Scene scene;
	@SuppressWarnings("unused")
	private Parent root;
	private Stage stage;
    @FXML
    private TableColumn<Book, String> BookID;

    @FXML
    private TableColumn<Book, String> BookName;

    @FXML
    private TableView<Book> BooksTable;

    @FXML
    private TableColumn<Book, String> PublishedBy;

    @FXML
    private TextField Searchbar;

    @FXML
    private TableColumn<Book, Boolean> Status;
    
    ObservableList<Book> oblist=FXCollections.observableArrayList();
	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
		 
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
		
		
	 }

    @FXML
    void Reserve(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/ReserveBook.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void returnbook(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/ReturnBook.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void tomain(MouseEvent event) throws IOException {
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		//Scene scene=new Scene(root);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void viewBook(MouseEvent event) throws IOException {
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