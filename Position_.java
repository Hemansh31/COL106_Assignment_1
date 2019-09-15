
public interface Position_<T>{
	 public T value();          // Return value at position
	   public Position_<T> after();// Returns the position after this position in its list
}
class Node<T> implements Position_<T> {
	public T obj;
	Node<T> next;
	public Node(T obj){
		this.obj=obj;
		next=null;
	}
	public T value() {
		return obj;
	}
	public Position_<T> after(){
		if(next==null) {
			return null;
		}
		else {
		return next;
		}
	}
}