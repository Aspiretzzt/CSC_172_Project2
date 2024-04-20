/*
 * Zhongtian Zhai
 * Email: zzhai4@u.rochester.edu
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static CustomHashTable readResponsesFromFile(String filePath)
	{
		CustomHashTable hashTable = new CustomHashTable();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner= new Scanner(line);
					
					int id = lineScanner.nextInt();
					int gender = lineScanner.nextInt();
					int age = lineScanner.nextInt();
					int residence = lineScanner.nextInt();
					int education = lineScanner.nextInt();
					int incomeSource = lineScanner.nextInt();
					int maritalStatus = lineScanner.nextInt();
					int smoker = lineScanner.nextInt();
					int year = lineScanner.nextInt();
					String q9 = lineScanner.next();
					int q10 = lineScanner.nextInt();
					int q11 = lineScanner.nextInt();
					int q12 = lineScanner.nextInt();
					int q13 = lineScanner.nextInt();
					int q14 = lineScanner.nextInt();
					int q15 = lineScanner.nextInt();
					String q16 = lineScanner.next();
					int q17 = lineScanner.nextInt();
					int q18 = lineScanner.nextInt();
					int q19 = lineScanner.nextInt();
					int q20 = lineScanner.nextInt();
					int q21 = lineScanner.nextInt();
					int q22 = lineScanner.nextInt();
					String q23 = lineScanner.next();
					int q24 = lineScanner.nextInt();
					int q25 = lineScanner.nextInt();
					int q26 = lineScanner.nextInt();
					int q27 = lineScanner.nextInt();
					int q28 = lineScanner.nextInt();
					int q29 = lineScanner.nextInt();
					int q30 = lineScanner.nextInt();

					Response response = new Response(id, gender, age, residence, education,
							incomeSource, maritalStatus,smoker, year, q9, q10, q11, 
							q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22, q23, q24,
							q25, q26, q27, q28, q29, q30);
					hashTable.insert(id, response);				
			}
            return hashTable;
        } catch (FileNotFoundException e) {
        	System.out.println("File Not Found.");
            e.printStackTrace();
        }
        return hashTable;
	}
	
	public static void main(String[] args) {
	}

}
