package serialization_deserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeSer {

	public static void main(String[] args) throws Throwable, IOException {
		
		Student  s1 = new Student();
		
		s1.studentRollNo = 5;
		s1.StudentName = "Ravi";
		
		String fileName = "C:\\Users\\SUBHADEEP MALLICK\\git\\API_RestAssured\\RestAssured\\Utility.txt";
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos))
		{
			oos.writeObject(s1);
			
			System.out.println("Object saved in the file");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis))
		{
			Student read = (Student)ois.readObject();
			
			System.out.println(s1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
