import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		Student st=new Student(549,"Mohan Krishna",new Date(),78.75);
		Student stud=new Student(549,"Mohan Krishna Reddy",new Date(),78.75);
		StudentGroup sg=new StudentGroup(2);
		sg.addFirst(st);
		sg.addLast(stud);
		Student st1=sg.getStudent(1);
		Student st2=sg.getStudent(0);
		System.out.println(st2.getFullName());
		System.out.println(st1.getFullName());
		Student[] list=sg.getStudents();
		System.out.println(list[0].getFullName());
		sg.remove(0);
		
	}

}
