package serialize_deserialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeSer {

	public static void main(String[] args) {
		
		Student student = new Student("Alice",21,"Computer Science");
		
		try(FileOutputStream fos = new FileOutputStream("Student.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos))
			{
				oos.writeObject(student);
				
				System.out.println("Student object has been serialized to student.ser");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			try(FileInputStream fis = new FileInputStream("Student.ser");
					ObjectInputStream ois = new ObjectInputStream(fis))
			{
				Student read = (Student)ois.readObject();
				
				System.out.println("Student object has been de-serialized to student.ser");
				
				read.display();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
