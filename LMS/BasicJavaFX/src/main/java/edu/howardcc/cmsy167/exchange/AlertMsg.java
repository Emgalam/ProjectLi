/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.howardcc.cmsy167.exchange;

/**
 *
 * @author Acer
 */
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertMsg {
	public static void mainmsg(String msg,String title) {
		Stage Alertbox=new Stage();
		Alertbox.initModality(Modality.APPLICATION_MODAL);
		Alertbox.setTitle(title);
		Alertbox.setMinWidth(270);
		Alertbox.setMinHeight(180);
		Label label=new Label();
		label.setText(msg);
		label.setStyle("-fx-text-fill: red");
		Button close=new Button("OK!");
		close.setOnAction(e->Alertbox.close());
		
		VBox layout=new VBox();
		layout.getChildren().addAll(label,close);
		layout.setAlignment(Pos.CENTER);
		Scene sAB=new Scene(layout);
		Alertbox.setScene(sAB);
		Alertbox.show();
	}
}

