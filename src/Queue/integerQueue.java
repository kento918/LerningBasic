package Queue;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	
}

public class integerQueue {
	Node head;
	public integerQueue(Node head) {
		this.head = head;
	}
	
	public void add(int num) {
		Node n = new Node(num);
		Node head = this.head;
		while(head.next != null) {
			head = head.next;
		}
		head.next = n;
	}
	
	public Node pull() {
		
		Node temp = this.head;
		this.head = this.head.next;
		return temp;
	}
	
	public Node peek() {
		return this.head;
		
	}
	
	public void printNodes() {
		Node head = this.head;
		String line = "";
		while(head != null) {
			line += head.data + " , ";
			head = head.next;
		}
		System.out.println(line);
	}
	
	
}

class main{
	public static void main(String[] args) {
		integerQueue q = new integerQueue(new Node(1));
		q.add(2);
		q.add(100);
		
		q.printNodes();
	}
}
