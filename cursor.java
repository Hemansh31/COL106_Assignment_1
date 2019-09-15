import java.util.Iterator;
public class cursor<T> implements Iterator<Position_<T>>{
	Position_<T> obj;
	public cursor(Node<T> obj) {
		this.obj=obj;
	}
	public boolean hasNext() {
		if(obj.after()!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public Position_<T> next(){
		if(obj.after()!=null) {
			Position_<T> temp=obj;
			obj=obj.after();
			return temp;
		}
		else {
			return obj;
		}
		
	}
}
