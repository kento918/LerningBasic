package SingleLinkedList;

public class SingleLinkedListNodes<E> {
	Node<E> head;
	
	public SingleLinkedListNodes(E[] arr) {
		if(arr== null) this.head = null;
		
		this.head = new Node<E>(arr[0]);
		Node<E> temp = this.head;
		for(int i = 1; i < arr.length;i++) {
			temp.next = new Node<E>(arr[i]);
			temp = temp.next; 
		}
	}
	
	public Node<E> at(int num){
		Node<E> ite = this.head;
		int i = 0;
		while(i < num) {
			if(ite == null) return null;
			ite = ite.next;
			i++;
		}
		return ite;
	}
	
	public void peekAt(int num) {
		Node<E> temp = at(num);
		System.out.println(temp.getData());
	}
	
	public void addNodeAt(int num , E data) {
		Node<E> ite = this.head;
		for(int i = 0; i < num-1 ; i++) ite = ite.next;
		Node<E> temp = ite.next;
		ite.next = new Node<E>(data);
		ite.next.next = temp;
	}
	
	public void deleteAt(int num) {
		if(num == 0) this.head = this.head.next;
		else{
			Node<E> ite = this.head;
			for(int i = 0; i < num-1 ; i++ ) ite = ite.next;
			ite.next = ite.next.next;
		}
	}
	
	public String toString() {
		Node<E> ite = this.head;
		String totalString = "[";
		while(ite != null) {
			totalString += ite.getData() + " , ";
			ite = ite.next;
		}
		
		return totalString.substring(0,totalString.length()-3) + "]";
	}
}
