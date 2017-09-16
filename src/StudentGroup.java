import java.util.Date;

import org.apache.commons.lang.ArrayUtils;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {
	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		try {
			return students;
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
			
		}
		return null;

	}

	@Override
	public void setStudents(Student[] students) {
		try {
			this.students=students;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int index)
	{
	try {
		return students[index];	
	}
	catch(IllegalArgumentException e)
	{
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public void setStudent(Student student, int index)
	{
		try {
			students[index]=student;
		}
		catch(IllegalArgumentException e)
		{
		e.printStackTrace();	
		}
	}

	@Override
	public void addFirst(Student student)
	{
		try {
			students[0]=student;
		}
		catch(IllegalArgumentException e)
		{
			
		}
	}

	@Override
	public void addLast(Student student) {
		try {
			students[students.length-1]=student;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void add(Student student, int index) {
		try {
			students[index]=student;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int index) {
		try {
			students=(Student[])ArrayUtils.remove(students, index);
			
		}catch(IllegalArgumentException e)
		{
			System.out.println("Student not exist");
		}
		
	}
	@Override
	public void remove(Student student) {
		try {
			students=(Student[])ArrayUtils.removeElement(students, student);
			
		}catch(IllegalArgumentException e)
		{
			System.out.println("Student not exist");
		}
		
	}

	@Override
	public void removeFromIndex(int index) {
		try {
			for(int i=index-1;i<students.length-1;i++)
			{
				students=(Student[])ArrayUtils.remove(students,i);
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeFromElement(Student student) {
		try {
			int pos=0;
			for(int i=0;i<students.length-1;i++)
			{
				if(student.equals(students[i]))
				{
					pos=i;
				}
			}
			for(int i=pos;i<students.length-1;i++)
			{
				ArrayUtils.removeElement(students,students[i]);
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeToIndex(int index) {
		try {
			for(int i=0;i<index;i++)
			{
				students=(Student[])ArrayUtils.remove(students,i);
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeToElement(Student student) {
		try {
		for(int i=0;i<students.length-1;i++)
		{
			if(students[i].equals(student))
			{
				break;
			}
			else
			{
				students=(Student[])ArrayUtils.removeElement(students,students[i]);
			}
		}
	}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void bubbleSort() {
		Student temp;
		for(int i=0;i<students.length-1;i++)
		{
			for(int j=0;j<students.length-1;j++)
			{
				if(students[i].getAvgMark()>=students[j].getAvgMark())
				{
					temp=students[i];
					students[i]=students[j];
					students[j]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		try {
			int j=0;
			Student ResultedStudents[]=new Student[students.length];
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].getBirthDate().equals(date))
				{
					ResultedStudents[j++]=students[i];
				}
			}
			return ResultedStudents;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		try {
			int j=0;
			Student ResultedStudents[]=new Student[students.length];
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].getBirthDate().after(firstDate)&&students[i].getBirthDate().before(lastDate))
				{
					ResultedStudents[j++]=students[i];
				}
			}
			return ResultedStudents;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		int year=students[indexOfStudent].getBirthDate().getYear();
		int cyear=new Date().getYear();
		return cyear-year;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
       try {
    	   int pos=0;
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].equals(student))
				{
					pos=i;
					break;
				}
			}
			return students[pos++];
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
