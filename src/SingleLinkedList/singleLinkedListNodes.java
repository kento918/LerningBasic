package SingleLinkedList;

public class SingleLinkedListNodes<E> {
	Node<E> head;
	
	public SingleLinkedListNodes(int[] arr) {
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
			System.out.println(head.getData());
			head = head.next;
		}
	}
	
	public Node<E> at(int num){
		Node<E> head = this.head;
		int i = 0;
		while(i < num) {
			if(head == null) return null;
			head = head.next;
			i++;
		}
		return head;
	}
}
