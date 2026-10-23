package stack;

import net.datastructures.ArrayStack;
import net.datastructures.Stack;
import net.datastructures.*;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> st = new LinkedStack<String>();
		st.push("Juan");
		st.push("Pablo");
		st.push("Ana");
		
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
		
	}

}
