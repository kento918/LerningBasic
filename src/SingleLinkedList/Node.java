package SingleLinkedList;

public class Node<E>{
	private int data;
	Node<E> next;
	public Node(int data) {
		this.setData(data);
		this.next = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}