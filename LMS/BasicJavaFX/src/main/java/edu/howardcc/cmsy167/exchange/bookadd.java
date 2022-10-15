/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.howardcc.cmsy167.exchange;

/**
 *
 * @author Acer
 */
import java.io.FileWriter;
import java.io.IOException;

public class bookadd {
	public void AddBook(String id,String b,String c,boolean d) throws IOException
	{
			FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt",true);
			myWriter.write(id + "," + b + "," + c + "," +","+d +"\n");
			myWriter.close();

	}
}

