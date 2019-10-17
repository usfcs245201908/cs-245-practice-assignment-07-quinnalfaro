public class ArrayList<T> implements List<T>{
	T[] a;
	int size;

	public ArrayList(){
		this.a = (T[]) new Object[10];
		this.size = 0;
	}

	public void add(T item){
		if(size == a.length){
			growArray();
		}
		a[size ++] = item;
	}

	public void add(int pos, T item){
		if(size == a.length){
			growArray();
		}
		for(int i = size; i >= pos; i --){
			a[i] = a[i - 1];
		}
		a[pos] = item;
		size ++;
	}

	public T get(int pos){
		return a[pos];
	}

	public T remove(int pos){
		T temp = a[pos];
		for (int i = pos; i < size - 1; i ++){
			a[i] = a[i + 1];
		}
		--size;
		return temp;
	}

	public int size(){
		return size;
	}

	public void growArray(){
		T[] newArray = (T[]) new Object[a.length * 2];
		for(int i = 0; i < a.length; i++){
			newArray[i] = a[i];
		}
		a = newArray;
	}
}