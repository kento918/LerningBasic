package SingleLinkedList;

public class useSingleLinkedListArgo<E> {
	private singleLinkedListNodes<E> root;

	public useSingleLinkedListArgo(E[] a) {
		this.setRoot(new singleLinkedListNodes<E>(a));
	}

	public useSingleLinkedListArgo() {
		this.setRoot(null);
	}

	public singleLinkedListNodes<E> getRoot() {
		return root;
	}

	public void setRoot(singleLinkedListNodes<E> root) {
		this.root = root;
	}

	public void printRoot() {
		singleLinkedListNodes<E> iterator = getRoot();
		System.out.println(iterator.toString());
	}

	public singleLinkedListNodes<Integer> mergeTwoSortedLinkedLists(singleLinkedListNodes<Integer> a,
			singleLinkedListNodes<Integer> b) {
		if (a.head.getData() == null)
			return b;

		if (b.head.getData() == null)
			return a;
		singleLinkedListNodes<Integer> mergeNode = new singleLinkedListNodes<Integer>(0);
		Node<Integer> head = mergeNode.head;
		singleLinkedListNodes<Integer> iterator = new singleLinkedListNodes<>();
		iterator = mergeNode;

		while (a.head != null && b.head != null) {
			if (a != null && b != null && a.head.getData() > b.head.getData()) {
				iterator.addLast(b.head.getData());
				b.head = b.head.next;
			} else if (a != null && b != null && a.head.getData() < b.head.getData()) {
				iterator.addLast(a.head.getData());
				a.head = a.head.next;
			}
			iterator.head = iterator.head.next;
		}

		if (a != null)
			iterator.head.next = a.head;
		if (b != null)
			iterator.head.next = b.head;
		mergeNode.head = head.next;

		return mergeNode;
	}
}
