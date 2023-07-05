package SingleLinkedList;
class Node<E>{
	int data;
	Node<E> next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class singleLinkedListNodes<E> {
	Node<E> head;
	public singleLinkedListNodes(int[] arr) {
		this.head = new Node<>(arr[0]);
		Node<E> temp = this.head;
		for(int i = 1; i < arr.length;i++) {
			temp.next = new Node<>(arr[i]);
			temp = temp.next; 
		}
	}
	public void printNodes() {
		Node<E> head = this.head;
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
