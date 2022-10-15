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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class oblistget {
	ObservableList<Book> getdata() throws IOException{
		ObservableList<Book> x=FXCollections.observableArrayList();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Book temp=new Book(str[0],str[1],str[2],Boolean.parseBoolean(str[3]));
			//temp.setBookId(str[0]);
			//temp.setTitle(str[1]);
			//temp.setPublisher(str[2]);
			//temp.setStatus(Boolean.parseBoolean(str[3]));
			x.add(temp);
		}
		return x;
	}
	ObservableList<Book> getdata(String n) throws IOException{
		ObservableList<Book> x=FXCollections.observableArrayList();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Book temp=new Book(str[0],str[1],str[2],Boolean.parseBoolean(str[3]));
			//temp.setBookId(str[0]);
			//temp.setTitle(str[1]);
			//temp.setPublisher(str[2]);
			//temp.setStatus(Boolean.parseBoolean(str[3]));
			if(temp.getBookId().equalsIgnoreCase(n)||temp.getTitle().equalsIgnoreCase(n)||temp.getPublisher().equalsIgnoreCase(n)) {
				x.add(temp);
			}
		}
		return x;
	}
}

