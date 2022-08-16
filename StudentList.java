import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals(Constants.showAll)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader reader = read();
			    String names[] = reader.readLine().split(",");
			    for(String name : names) {
					System.out.println(name.trim());
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Constants.loadData);
		}

		else if(args[0].equals(Constants.random)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader reader = read();
		    	String names[] = reader.readLine().split(Constants.comma);
			    Random rand= new Random();
			    int rand_index = rand.nextInt(names.length);
				System.out.println(names[rand_index].trim());
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Constants.loadData);			
		}

		else if(args[0].contains(Constants.plus)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedWriter reader = write();
			    String student = args[0].substring(1);
				Date date = new Date();
	            String dateFormatString = Constants.dateFormate;
				DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
	            String formatDate= dateFormat.format(date);
			    reader.write(Constants.comma + " " + student + Constants.lastupdate + formatDate);
		     	reader.close();
			} catch (Exception e) {
				System.out.println(e);
			}
							
			System.out.println(Constants.loadData);	
		}
		else if(args[0].contains(Constants.question)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader reader = read();
			    String names[] = reader.readLine().split(Constants.comma);
			    int countName=0;
		     	String student = args[0].substring(1);
			    for(int idx = 0; idx<names.length ; idx++) {
					if(names[idx].trim().equals(student)) {
					countName++;
					}
				}
				if(countName == 0) {
					System.out.println("Name not found!");
				}
				else {
					System.out.println(countName + " name found!");
				}
				reader.close();

			
			  } catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Constants.loadData);				
		}
		else if(args[0].contains(Constants.cnt)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedReader reader = read();
			    String names[] = reader.readLine().split(Constants.comma);
			    System.out.println(names.length + Constants.wordFound);
				reader.close();

			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(Constants.loadData);				
		}


	}

	public static BufferedReader read() throws FileNotFoundException {

		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(Constants.studentList)));
		
		
		return bufferedReader;


	}


	public static BufferedWriter write() throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(Constants.studentList, true));
		
		
		return bufferedWriter;


	}
}


