//Anthony Licea
import java.io.*;
import java.util.*;
public class LinkedLists<e>{
	Node head; // 
	int track;
	LinkedList list;
public class Node{
	 e data; // data being inserted
	Node next; // "pointer" to next Node
	
	//Node constructors
	Node(){
		data = null;
		next = null;
	}
	Node(e d){
		data = d; 
		next = null;
	}
}


public void insert(e data) {
	Node nNode = new Node(data);
	//nNode.next = null; // make null because it goes @ the end
	if(head == null) {
		head = nNode;
		track++;
	}
	else {
		Node lastn = head;
		while(lastn.next!= null) {
			lastn = lastn.next;
		}
		lastn.next = nNode;
		track++; //increment tracker
	}

	}
public void insert( e data, int b) { // inserting @ specific location
		Node insert = new Node(data); // node to be inserted
		
		Node last = head;
		if(last == null) {
			head = insert;
			
		}
		 // while the we have something to point to...
			
			for (int i =0; i< b-1; i++) { // loop through the list until we are at our desired position
				last = last.next;
			
			
		}
		insert.next = last.next; // new node being inserted points to whatever was being pointed to at its new position
		last.next = insert; // make sure a node points to our new item being inserted
		track++; // increment tracker
		

}
public e get(int pos) {
	Node og = head;
	for(int i=0; i<pos; i++) {
		
		head = head.next;
	}
	e tbr = head.data;
	head = og; //resetting the head
	return tbr;
}

public e remove (int pos) {
	Node og = head; // storing our head
	if(pos == 0) {
		og = head.next; //
	}
	for(int i=0; i<pos-1; i++) {
		
			head = head.next;
		}
	e tobereturned = head.next.data; // int value being removed
	head.next = head.next.next; // setting the pointer for the current value to the Node that was being pointed to by deleted node
	head = og; // resetting the head
	track--;// decrement tracker
	return tobereturned;


}

	public Node reverse(Node n) {
		Node prev = null; // prev
		 // next
		Node next = null; // current
		Node current = head;
		while (current != null) {
			next = current.next; 
			current.next = prev;
			prev = current;
			current = next;
		}
		n = prev;
		return n;
	}

public static void main(String[] args) { 
	LinkedLists<Integer> list = new LinkedLists();
	LinkedLists.Node n = list.new Node(3);
	LinkedLists.Node m = list.new Node(4);
	LinkedLists.Node k = list.new Node(5);
	LinkedLists.Node o = list.new Node(8);
	list.insert((Integer) n.data); //adds item to list
	list.insert((Integer) m.data); //adds item to list
	list.insert((Integer) k.data); //adds item to list
	list.insert((Integer) o.data, 1); //places 8 at index 1
	int gp = list.get(1); //get function
	System.out.println("item at index 1");
	System.out.println(gp); // prints item at index 1
	System.out.println("prints full list");
	for(int i=0; i<list.track; i++) { // loop to get whole list
		 int r = list.get(i);
		 System.out.println(r);
	}
	
	list.remove(0);// removes 3
	list.remove(1);// removes 5
	list.insert(7); //adds 7
	System.out.println("list after deleting");
	
	for(int i=0; i<list.track; i++) {
		int r = list.get(i);
		System.out.println(r);
	}
	list.head=list.head;
	LinkedLists.Node g = list.reverse(list.head);
	System.out.println("reversed list");
	while(g != null) {
		System.out.println(g.data);
		g = g.next;
}

}
}
