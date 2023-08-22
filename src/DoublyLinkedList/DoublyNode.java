package DoublyLinkedList;

public class DoublyNode<E> {

	E data;
	DoublyNode<E> prev;
	DoublyNode<E> next;

	public DoublyNode(E data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public DoublyNode(E[] datas) {
		DoublyNode<E> first = createNodeFactry(datas);
		if (first != null) {
			this.data = (E) first.data;
			this.next = (DoublyNode<E>) first.next;
			this.prev = null;
		}
	}

	public DoublyNode<E> createNodeFactry(E[] datas) {
		if (datas.length == 0)
			return null;

		DoublyNode<E> first = new DoublyNode<>(datas[0]);
		DoublyNode<E> iterator = first;

		for (int i = 1; i < datas.length; i++) {
			iterator.next = new DoublyNode<E>(datas[i]);
			iterator.next.prev = iterator;
			iterator = iterator.next;
		}

		return first;
	}
}

class DoublyLinkedNodes<E> {
	DoublyNode<E> head;

	public DoublyLinkedNodes(DoublyNode<E> head) {
		this.head = head;
	}

	public DoublyNode<E> at(int num) {
		DoublyNode<E> iterator = this.head;
		for (int i = 1; i < num; i++) iterator = iterator.next;
		return iterator;
	}

	public void deleteAt(int num) {
		DoublyNode<E> iterator = this.head;
		if(num <= 1) {
			iterator = iterator.next; 
			iterator.prev = null;
		}
		
		for (int i = 1; i < (num - 1); i++) iterator = iterator.next;
		
		iterator.next = iterator.next.next;
		iterator.next.prev = iterator;
		
	}
	
	public void printNodes() {
		DoublyNode<E> iterator = this.head;
		while(iterator.next != null) {
			System.out.print(iterator.data + " , ");
			iterator = iterator.next;
		}
		System.out.print(iterator.data);
	}

}

class Main {
	public static void main(String[] args) {
		DoublyNode<Integer> nodes = new DoublyNode<Integer>(
				new Integer[] { 1, 2, 3, 4, 5, 6, 76, 8, 31, 32, 5, 4323, 555});

		DoublyNode<Integer> iterator = nodes;

		while (iterator.next != null) {
			System.out.print(iterator.data + " , ");
			iterator = iterator.next;
		}

		System.out.println(iterator.data);
		System.out.println();

		while (iterator.prev != null) {
			System.out.print(iterator.data + " , ");
			iterator = iterator.prev;
		}
		System.out.println(iterator.data);
		System.out.println();

		DoublyLinkedNodes<Integer> head = new DoublyLinkedNodes<>(iterator);

		System.out.println(head.head.data);
		System.out.println();
		
		head.deleteAt(3);
		
		head.printNodes();

	}

}
