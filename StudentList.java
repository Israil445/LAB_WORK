import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			    String allStudent = reader.readLine();
			    String names[] = allStudent.split(",");
			    for(String name : names) {
					System.out.println(name.trim());
				}

			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");
		}

		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			    String allStudent = reader.readLine();
		    	System.out.println(allStudent);
		    	String names[] = allStudent.split(",");
			    Random rand= new Random();
			    int rand_index = rand.nextInt(4);
				System.out.println(names[rand_index].trim());
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");			
		}

		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter reader = new BufferedWriter(new FileWriter("students.txt", true));
			    String student = args[0].substring(1);
				Date date = new Date();
	            String dateFormatString = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
	            String formatDate= dateFormat.format(date);
			    reader.write(", "+student+"\nList last updated on "+formatDate);
		     	reader.close();
			} catch (Exception e){
				System.out.println(e);
			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			    String allStudents = reader.readLine();
			    String names[] = allStudents.split(",");
			    boolean done = false;
		     	String student = args[0].substring(1);
			    for(int idx = 0; idx<names.length && !done; idx++) {
					if(names[idx].equals(student)) {
					System.out.println("We found it!");
					done=true;
					}
				}
			  } catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
		     	String students = reader.readLine();
			    char names[] = students.toCharArray();
			    boolean in_word = false;
			    int count=0;
			    for(char name:names) {
					if(name ==' ')
					{
					if (!in_word) {
						count++;
						in_word =true;
					}

					else {
						in_word=false;
				    	}
			    	}
		    	}
			    System.out.println(count +" word(s) found " + names.length);
			} catch (Exception e){
				System.out.println(e);
			}
			System.out.println("Data Loaded.");				
		}
	}
}