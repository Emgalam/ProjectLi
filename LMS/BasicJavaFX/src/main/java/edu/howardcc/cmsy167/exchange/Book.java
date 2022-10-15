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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

	public class Book {

		private String bookId;
		private String title;
		private String publisher;
		private boolean Status;
		
		Book(){
			setBookId("");
			setTitle("");
			setPublisher("");
			setStatus(false);
		}
		Book(String id,String a,String b,boolean c){
			setBookId(id);
			setTitle(a);
			setPublisher(b);
			setStatus(c);
		}
		public void InitializeBook(String id,String a,String b,boolean c){
			setBookId(id);
			setTitle(a);
			setPublisher(b);
			setStatus(c);
		}
		public String getBookId() {
			return bookId;
		}
		public void setBookId(String bookId) {
			this.bookId = bookId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public boolean isStatus() {
			return Status;
		}
		public void setStatus(boolean status) {
			Status = status;
		}
		public void printBookDetails() {
			System.out.println("The book id is: " + bookId);
			System.out.println("The book title is: " + title);
			System.out.println("The book publisher is: " + publisher);
			System.out.println("The book current status is: " + Status);
		}
		public void AddBook(String id,String b,String c,boolean d) throws IOException
		{
				FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt",true);
				myWriter.write(id + "," + b + "," + c + "," +","+d +"\n");
				myWriter.close();

		}
		public void EditBook(String bookid,String newtitle,String newpublisher,boolean newstatus) throws IOException {
			ArrayList<Book> alist=new ArrayList<Book>();
			File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				String str[]=currentLine.split(",");
				Book temp=new Book(str[0],str[1],str[2],Boolean.parseBoolean(str[3]));
				//temp.bookId=str[0];
				//temp.title=str[1];
				//temp.publisher=str[2];
				//temp.Status=Boolean.parseBoolean(str[3]);
				//System.out.println(currentLine);
				alist.add(temp);
			}
			reader.close();
			FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
			for(int i=0;i<alist.size();i++) {
				if(!(alist.get(i).getBookId().equalsIgnoreCase(bookid))) {
					myWriter.write(alist.get(i).getBookId()+","+alist.get(i).getTitle()+","+alist.get(i).getPublisher()+","+alist.get(i).isStatus()+"\n");
				}
				else {
					myWriter.write(bookid+","+newtitle+","+newpublisher+","+newstatus+"\n");				
				}
			}
			myWriter.close();
		}
		public void DeleteBook(String bookid) throws IOException {
			ArrayList<Book> alist=new ArrayList<Book>();
			File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				String str[]=currentLine.split(",");
				Book temp=new Book();
				temp.bookId=str[0];
				temp.title=str[1];
				temp.publisher=str[2];
				temp.Status=Boolean.parseBoolean(str[3]);
				alist.add(temp);
			}
			reader.close();
			FileWriter myWriter = new FileWriter("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
			for(int i=0;i<alist.size();i++) {
				if(!(alist.get(i).bookId.equals(bookid))) {
					myWriter.write(alist.get(i).bookId+","+alist.get(i).title+","+alist.get(i).publisher+","+alist.get(i).Status+"\n");
				}
			}
			myWriter.close();
		}
		ObservableList<Book> getOBLIST() throws IOException{
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
		public static void main(String args[]) throws IOException {
			File inputFile = new File("C:\\Users\\mirza\\OneDrive\\Desktop\\LMS\\Books.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				Book temp=new Book();
				String str[]=currentLine.split(",");
				temp.bookId=str[0];
				temp.title=str[1];
				temp.publisher=str[2];
				temp.Status=Boolean.parseBoolean(str[3]);
				System.out.println(str[0]);
			}
		}
	}