import java.util.Iterator;
public interface LinkedList_ <T>{
	public Position_<T> add(T e);              // Add element e to this list, returns it position in the list
	public Iterator<Position_<T>>  positions();// Returns an iterator for all positions in the list
	public int  count();
}

class linkedlist<T> implements LinkedList_<T>{
	Node<T> head=null;
	Node<T> tail=null;
	int cnt=0;
	/*public linkedlist(T obj){
		Node<T> temp=new Node<T>(obj);
		head=temp;
		tail=temp;
		cnt=cnt+1;
	}*/
	public Position_<T> add(T e){
		if(head==null) {
			Node<T> temp=new Node<T>(e);
			head=temp;
			tail=temp;
			cnt=cnt+1;
			return temp;
		}
		else {
		Node<T> temp=new Node<T>(e);
		Node<T> last=this.tail;
		last.next=temp;
		tail=temp;
		cnt=cnt+1;
		return temp;
		}
	}
	public int count() {
		return cnt;
	}
	public Iterator<Position_<T>>  positions(){
		cursor<T> itr=new cursor<T>(head);
		return itr;
	}
}