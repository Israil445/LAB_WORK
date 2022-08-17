import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println(Constants.usage);
			return;

		}
	    else if(args[0].equals(Constants.showAll)) {

			System.out.println(Constants.loadingData);			
			String names[] = fileToStringArray(Constants.studentList);
			for(String name : names) {
					System.out.println(name.trim());
				}
			System.out.println(Constants.loadData);
		}

		else if(args[0].equals(Constants.random)) {
			System.out.println(Constants.loadingData);			
		    String names[] = fileToStringArray(Constants.studentList);
			Random rand = new Random();
			System.out.println(names[rand.nextInt(names.length)].trim());
			System.out.println(Constants.loadData);			
		}

		else if(args[0].contains(Constants.plus)) {
			System.out.println(Constants.loadingData);			
			try {
				BufferedWriter writer = writeToFile(Constants.studentList); 
			    String student = args[0].substring(1);
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat(Constants.dateFormate);
	            String formatDate= dateFormat.format(date);
			    writer.write(Constants.comma + " " + student + Constants.lastupdate + formatDate);
		     	writer.close();
			} catch (Exception e) {
				System.out.println(e);
			}
							
			System.out.println(Constants.loadData);	
		}
		else if(args[0].contains(Constants.question)) {
			System.out.println(Constants.loadingData);			
			String names[] = fileToStringArray(Constants.studentList);
			int countName=0;
		    String student = args[0].substring(1);
			    for(int idx = 0; idx<names.length ; idx++) {
					if(names[idx].trim().equals(student)) {
					countName=countName + 1;
					}
				}
				if(countName == 0) {
					System.out.println(Constants.nameNotFound);
				}
				else {
					System.out.println(countName + " data " + Constants.namefound);
				}
			System.out.println(Constants.loadData);				
		}
		else if(args[0].contains(Constants.cnt)) {
			System.out.println(Constants.loadingData);			
			String names[] = fileToStringArray(Constants.studentList);
			System.out.println(names.length + Constants.wordFound);
			System.out.println(Constants.loadData);				
		} else {

			System.out.println(Constants.invalidArg); // No arguments matches
			System.out.println(Constants.usage);

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

	public static String[] fileToStringArray(String fileName) {
		try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(fileName)));
			String stringName[] = bufferedReader.readLine().split(Constants.comma);
			bufferedReader.close();
			return stringName;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static BufferedWriter writeToFile(String fileName) throws IOException {  // returns a buffered file writer
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(fileName, true));
		return bufferedWriter;
	}


	}





