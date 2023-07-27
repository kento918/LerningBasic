package javaGoldPractis;

class MainInner {

	String item;

	static class Inner {
		static MainInner.Inner2 inner = new MainInner().new Inner2(0);

		public static MainInner.Inner2 makeLinkedList(int[] a) {
			MainInner.Inner2 ite = inner;
			for (int num : a) {
				ite.next = new MainInner().new Inner2(num);
				ite = ite.next;
			}
			return inner.next;
		}
	}

	public class Inner2 {
		private int data;
		private Inner2 next;

		Inner2(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void mainInner() {
		MainInner.Inner head = new MainInner.Inner();
		int[] a = { 1, 2, 3 };
		MainInner.Inner2 newhead = Inner.makeLinkedList(a);
		MainInner.Inner2 iterator = newhead;
		while (iterator != null) {
			System.out.println(iterator.data);
			iterator = iterator.next;
		}
		// System.out.println(head);
	}
}

public class innerClassrenshuu {
	public static void main(String[] args) {
		MainInner.mainInner();
	}
}