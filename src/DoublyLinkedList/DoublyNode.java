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

class Main {
	public static void main(String[] args) {
		DoublyNode<Integer> nodes = new DoublyNode<Integer>(
				new Integer[] { 1, 2, 3, 4, 5, 6, 76, 8, 31, 32, 5, 4323, });

		DoublyNode<Integer> iterator = nodes;

		while (iterator.next != null) {
			System.out.print(iterator.data + " , ");
			iterator = iterator.next;
		}

		System.out.println(iterator.data);
		System.out.println();

		while (iterator != null) {
			System.out.print(iterator.data + " , ");
			iterator = iterator.prev;
		}

	}

}
