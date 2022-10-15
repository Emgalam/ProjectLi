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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
	
	private String studentid;
	private String username;
	private String password;
	
	Student(){
		studentid="";
		username="";
		password="";
	}
	Student(String id,String a,String b){
		studentid=id;
		username=a;
		password=b;
	}
	public void InitializeStudent(String id,String a,String b)
	{
		studentid=id;
		username=a;
		password=b;
	}
	public void DisplayDetails()
	{
		System.out.println("The student id is: " + studentid);
		System.out.println("The student username is: " + username);
		System.out.println("The student password is: " + password);
	}
	public void setstudentidid(String a)
	{
		studentid=a;
	}
	public void setusername(String a)
	{
		username=a;
	}
	public void setpassword(String a)
	{
		password=a;
	}
	public String getstudentid()
	{
		return studentid;
	}
	public String getusername()
	{
		return username;
	}
	public String getpassword()
	{
		return password;
	}
	public void RegisterStudent(String id,String username2,String password2) 
	{
		try {
			FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Students.txt",true);
			myWriter.write(id + "," + username2 + "," + password2 + "\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void DeleteStudent(String tempid) throws IOException {
		ArrayList<Student> alist=new ArrayList<Student>();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Students.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Student temp=new Student();
			temp.setstudentidid(str[0]);
			temp.setusername(str[1]);
			temp.setpassword(str[2]);
			alist.add(temp);
		}
		reader.close();
		FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Students.txt");
		for(int i=0;i<alist.size();i++) {
			if(!(alist.get(i).getstudentid().equals(tempid))) {
				myWriter.write(alist.get(i).getstudentid()+","+alist.get(i).getusername()+","+alist.get(i).getpassword()+"\n");
			}
		}
		myWriter.close();
	}
	public boolean ReserveBook(String bookid) throws IOException {
		ArrayList<Book> alist=new ArrayList<Book>();
		boolean retVal=false;
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Book temp=new Book();
			temp.setBookId(str[0]);
			temp.setTitle(str[1]);
			temp.setPublisher(str[2]);
			temp.setStatus(Boolean.parseBoolean(str[3]));
			alist.add(temp);
		}
		reader.close();
		FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
		for(int i=0;i<alist.size();i++) {
			if(!(alist.get(i).getBookId().equals(bookid))) {
				myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+alist.get(i).isStatus()+"\n");
			}
			else if((alist.get(i).getBookId().equals(bookid)) && !alist.get(i).isStatus()) {
				myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+"true"+"\n");
				System.out.println("Book Reserved");
				retVal = true;
			}
			else if((alist.get(i).getBookId().equals(bookid)) && alist.get(i).isStatus()) {
				myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+alist.get(i).isStatus()+"\n");
				System.out.println("Book already reserved");
				retVal = false;
			}
			
		}
		myWriter.close();
		return retVal;
	}
	public boolean ReturnBook(String bookid) throws IOException {
		boolean retval=false;
		ArrayList<Book> alist=new ArrayList<Book>();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Book temp=new Book();
			temp.setBookId(str[0]);
			temp.setTitle(str[1]);
			temp.setPublisher(str[2]);
			temp.setStatus(Boolean.parseBoolean(str[3]));
			alist.add(temp);
		}
		reader.close();
		FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
		for(int i=0;i<alist.size();i++) {
			if(!(alist.get(i).getBookId().equals(bookid))) {
				myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+alist.get(i).isStatus()+"\n");
			}
			else if((alist.get(i).getBookId().equals(bookid)) && alist.get(i).isStatus()) {
				myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+"false"+"\n");
				System.out.println("Book Returned");
				retval= true;
			}
			else if((alist.get(i).getBookId().equals(bookid)) && !alist.get(i).isStatus()) {
				myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+alist.get(i).isStatus()+"\n");
				//AlertMsg.mainmsg("Already Returned", "Incorrect Action");
				retval= false;
			}
		}
		myWriter.close();
		return retval;
	}
	boolean authenticate(String n,String p) throws IOException {
		ArrayList<Student> alist=new ArrayList<Student>();
		File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Students.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			String str[]=currentLine.split(",");
			Student temp=new Student();
			temp.setstudentidid(str[0]);
			temp.setusername(str[1]);
			temp.setpassword(str[2]);
			alist.add(temp);
		}
		for(int i=0;i<alist.size();i++) {
			if(alist.get(i).getstudentid().equals(n)&&alist.get(i).getpassword().equals(p)) {
				return true;
			}
		}
		return false;
		
	}
}
