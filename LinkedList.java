public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private int size;
	private final int defaultSize = 10;

	public LinkedList(){
		this.head = null;
		this.size = 0;
	}

	public class Node<T>{

		T data;
		public Node<T> next;

		public Node(T item){
			this.data = item;
			this.next = null;
		}
	}


	public void add(T item){
		if (head == null){
			Node<T> head = new Node(item);
		} else{
			Node<T> prev = head;
			//gets you to last item on the list
			while(prev.next != null){
				prev = prev.next;
			}
			Node<T> current = new Node(item);
			prev.next = current;
		}
		size ++;
	}



	public void add(int pos, T item){
		if (pos == 0){
			Node<T> current = new Node(item);
			current.next = head;
			head = current;
		} else{
			Node<T> current = new Node(item);
			//gets you to last item on the list
			Node prev = head;
			for(int i = 0; i < pos - 1; i ++){
				prev = prev.next;
			}
			current.next = prev.next;
			prev.next = current;
		}
		size ++;
	}



	public T get(int pos){
		Node<T> prev = head;
		for(int i = 0; i < pos - 1; i ++){
			prev = prev.next;
		}
		return prev.data;
	}



	public T remove(int pos){
		if(pos == 0){
			Node<T> temp = head;
			head = head.next;
			-- size;
			return temp.data;
		} else{
			Node<T> prev = head;
			for(int i = 0; i < pos - 1; i ++){
				prev = prev.next;
			}
			Node<T> temp = prev.next;
			prev.next = temp.next;
			-- size;
			return temp.data;
		}
	}



	public int size(){
		return size;
	}

}