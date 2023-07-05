package SingleLinkedList;
class Node<E>{
	int data;
	Node<E> next;
	public Node(int data) {
		this.data = data;
	}
}
public class singleLinkedListNodes<E> {
	Node<E> head;
	public singleLinkedListNodes(int i) {
		this.head = new Node<>(i);
	}
}
