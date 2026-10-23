package queue;
import net.datastructures.*;

public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> qu = new LinkedCircularQueue<String>();
	
		System.out.println(qu.isEmpty());
		
		qu.enqueue("Juan");
		qu.enqueue("Ana");
		qu.enqueue("Mariela");
		
		
		System.out.println(qu.dequeue());
		System.out.println(qu.isEmpty());
		
	}

}
