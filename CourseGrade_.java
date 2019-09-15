
public interface CourseGrade_ {
	 public String coursetitle();   	 // Returns course title 
	   public String coursenum();   	 // Returns course code, e.g., COL106 
	   public GradeInfo_ grade();   	 // Returns student's letter grade
}
class courseinfo implements CourseGrade_{
	String coursettle;
	String coursen;
	gradeinfo Grade;
	public courseinfo(String title,String num,gradeinfo sgrades) {
		coursettle=title;
		coursen=num;
		Grade=sgrades;
	}
	public String coursetitle() {
		return coursettle;
	}
	public String coursenum() {
		return coursen;
	}
	public GradeInfo_ grade() {
		return Grade;
	}
}