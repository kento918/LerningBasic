package SingleLinkedList;

public class useSingleLinkedListArgo<E> {
	private SingleLinkedListNodes<E> root;

	public useSingleLinkedListArgo(E[] a) {
		this.setRoot(new SingleLinkedListNodes<E>(a));
	}
	
	public useSingleLinkedListArgo(){
		this.setRoot(null);
	}

	public SingleLinkedListNodes<E> getRoot() {
		return root;
	}

	public void setRoot(SingleLinkedListNodes<E> root) {
		this.root = root;
	}
	
	public void printRoot() {
		SingleLinkedListNodes<E> iterator = getRoot();
		System.out.println(iterator.toString());
	}
	
	public SingleLinkedListNodes<Integer> mergeTwoSortedLinkedLists(SingleLinkedListNodes<Integer> a , SingleLinkedListNodes<Integer> b){
		if(a.head.getData() == null) return b;
		
		if(b.head.getData() == null) return a;
		SingleLinkedListNodes<Integer> mergeNode = new SingleLinkedListNodes<Integer>(0);
		Node<Integer> head = mergeNode.head;
		SingleLinkedListNodes<Integer> iterator = new SingleLinkedListNodes<>();
		iterator = mergeNode;
		
		while(a.head != null && b.head != null) {
			if(a != null && b != null && a.head.getData() > b.head.getData()) { 
				iterator.addLast(b.head.getData());
				b.head = b.head.next;
			}
			else if(a != null && b != null && a.head.getData() < b.head.getData()){
				iterator.addLast(a.head.getData());
				a.head = a.head.next;
			}
			iterator.head = iterator.head.next;
		}
		
		if(a != null) iterator.head.next = a.head;
		if(b != null) iterator.head.next = b.head;
		mergeNode.head = head.next;
		
		return mergeNode;
	}
	
	public static void test() {
		
	}
	
}
