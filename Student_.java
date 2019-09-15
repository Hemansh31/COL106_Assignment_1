import java.util.Iterator;

public interface Student_ {
	 public String name();               	// Returns student's name
	 public String entryNo();            	// Returns student's entry number
	 public String hostel();             	// Returns student's hostel name
	 public String department();         	// Returns student's department name
	 public String completedCredits();   	
	 public String cgpa();   		
	  public Iterator<CourseGrade_> courseList();
}
class student implements Student_{
	private String Name;
	private String Entryno;
	private String Hostel;
	private String Dep;
	private linkedlist<courseinfo> courselist=new linkedlist<courseinfo>();
	int countcourses=0;
	int completedcredits=0;
	int cumulativetotal=0;
	int completedcourses=0;
	public student(String name,String entno,String hostel,String dep) {
		Name=name;
		Entryno=entno;
		Hostel=hostel;
		Dep=dep;
	}
	public String name() {
		return Name; 
	}
	public String entryNo() {
		return Entryno; 
	}
	public String hostel() {
		return Hostel; 
	}
	public String department() {
		return Dep; 
	}
	public void addcourse(courseinfo course) {
		Position_<courseinfo> newcourse=courselist.add(course);
		GradeInfo_ finalgrade=course.grade();
		gradeinfo whatgrade=(gradeinfo) finalgrade;
		int addition=GradeInfo_.gradepoint(whatgrade.sgrade);
		if(addition!=0) {
		completedcredits=completedcredits+3;
		cumulativetotal=cumulativetotal+(3*addition);
		completedcourses=completedcourses+1;
		}
		countcourses=countcourses+1;
	}
	public String completedCredits() {
		String str=Integer.toString(completedcredits);
		return str;
	}
	public String cgpa() {
		float cg=((float)cumulativetotal/(float)completedcredits);
		return String.format("%.2f", cg);
	}
	public Iterator<CourseGrade_> courseList(){
		course_cursor itr=new course_cursor(courselist.head);
		return itr;
	}
}