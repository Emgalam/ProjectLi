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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Admin {
	private String UserName;
	private String Password;
	public void AddStaff(String username,String Pass,String CNIC,String fname,String lname) throws IOException {
		FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Staff.txt",true);
		myWriter.write(username + "," + Pass + "," + CNIC + "," + fname+","+lname +"\n");
		myWriter.close();
		
	}
	boolean loginSuccess(String n,String p) throws IOException{
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\AdminData.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		String toCheck=n+","+p;
		while((currentLine = reader.readLine()) != null) {

			System.out.println("currentline"+currentLine);
			if(toCheck.equals(currentLine)) {
				System.out.println("currentline");
				return true;
			}
		}
		return false;
	}
	boolean changePsuc(String prev,String newp) throws IOException {
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\AdminData.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine,uname;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			if(prev.equals(str[1])) {
				uname=str[0];
				String newpf=uname+","+newp;
				FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\AdminData.txt");
				myWriter.write(newpf);
				myWriter.close();
				return true;
		}
		}
		return false;
			
	}
	public void deleteStaff(String iddel) throws IOException {
		ArrayList<Staff> alist=new ArrayList<Staff>();
		//Staff temp=new Staff();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Staff.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine,uname;
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
			if(!alist.get(i).CNIC.equals(iddel)) {
				FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Staff.txt");
				myWriter.write(alist.get(i).username+","+alist.get(i).password+","+alist.get(i).CNIC+alist.get(i).firsrname+","+alist.get(i).lastname+"\n");
			}
		}
	}

}
