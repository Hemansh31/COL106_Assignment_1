import java.util.Iterator;

public interface Entity_ {
	public String name();                 
	   public Iterator<Student_> studentList();        // Returns all students of this entity
}
class hostel implements Entity_{
	private String nameofhostel;
	int countstudents=0;
	private linkedlist<student> studentlist=new linkedlist<student>();
	public hostel(String hostelname) {
		this.nameofhostel=hostelname;
	}
	public String name() {
		return nameofhostel;
	}
	public void addstudent(student stu) {
		Position_<student> newstudent=studentlist.add(stu);
		countstudents=countstudents+1;
	}
	public Iterator<Student_> studentList(){
		student_cursor itr=new student_cursor(studentlist.head);
		return itr;
	}
}
class department implements Entity_{
	private String nameofdepartment;
	int countstudents=0;
	private linkedlist<student> studentlist=new linkedlist<student>();
	public department(String departmentname) {
		this.nameofdepartment=departmentname;
	}
	public String name() {
		return nameofdepartment;
	}
	public void addstudent(student stu) {
		Position_<student> newstudent=studentlist.add(stu);
		countstudents=countstudents+1;
	}
	public Iterator<Student_> studentList(){
		student_cursor itr=new student_cursor(studentlist.head);
		return itr;
	}
}
class course implements Entity_{
	private String nameofcourse;
	private String codeofcourse;
	int countstudents=0;
	private linkedlist<student> studentlist=new linkedlist<student>();
	public course(String coursename,String coursecode) {
		this.nameofcourse=coursename;
		this.codeofcourse=coursecode;
	}
	public String name() {
		return nameofcourse;
	}
	public String code() {
		return codeofcourse;
	}
	public void addstudent(student stu) {
		Position_<student> newstudent=studentlist.add(stu);
		countstudents=countstudents+1;
	}
	public Iterator<Student_> studentList(){
		student_cursor itr=new student_cursor(studentlist.head);
		return itr;
	}
}