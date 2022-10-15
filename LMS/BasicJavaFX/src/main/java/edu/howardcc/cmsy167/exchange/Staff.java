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
import java.util.ArrayList;

public class Staff {
	String username;
	String firsrname;
	String lastname;
	String CNIC;
	String password;
	
	public boolean authenticate(String n, String p) throws IOException {
		ArrayList<Staff> alist=new ArrayList<Staff>();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Staff.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Staff temp=new Staff();
			temp.username=str[0];
			temp.password=str[1];
			temp.CNIC=str[2];
			temp.firsrname=str[3];
			temp.lastname=str[4];
			alist.add(temp);
		}
		for(int i=0;i<alist.size();i++) {
			if(alist.get(i).username.equals(n)&&alist.get(i).password.equals(p)) {
				return true;
			}
		}
		return false;
	}
}
