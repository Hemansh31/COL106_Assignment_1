import java.util.Iterator;
public class student_cursor implements Iterator<Student_> {
	Position_<student> obj;
	public student_cursor(Position_<student> Obj) {
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
	public Student_ next(){
		if(obj.after()!=null) {
			Student_ temp=obj.value();
			obj=obj.after();
			return temp;
		}
		else {
			return obj.value();
		}
		
	}
}
