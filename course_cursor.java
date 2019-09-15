
import java.util.Iterator;
public class course_cursor implements Iterator<CourseGrade_>{
	Position_<courseinfo> obj;
	public course_cursor(Position_<courseinfo> Obj) {
		this.obj=Obj;
	}
	public boolean hasNext() {
		if(obj.after()!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public CourseGrade_ next(){
		if(obj.after()!=null) {
			CourseGrade_ temp=obj.value();
			obj=obj.after();
			return temp;
		}
		else {
			return obj.value();
		}
		
	}
}
