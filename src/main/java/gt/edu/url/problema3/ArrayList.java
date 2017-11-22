package gt.edu.url.problema3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author godin
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E>{

	
/**
 * 	
 * @author godin
 *
 */
private class ArrayIterator implements Iterator<E>{
		
		private int j = 0; 
		boolean removable = false; // can remove be called at this time?

		@Override
		/**
		 * retorna si la lista tiene siguiente
		 */
		public boolean hasNext() {
			return j < size;
		}

		@Override
		/**
		 * Busca el elemento siguiente de cierto dato si no tiene retorna null
		 */
		public E next() throws NoSuchElementException {
			if (j == size) throw new NoSuchElementException("No next element");
			removable = true;
			return data[j++];
		}
		
		/**
		 * remueve todos los elementos de la lista
		 */
		public void remove() throws IllegalStateException {
			if (!removable) throw new IllegalStateException("nothing to remove");
				ArrayList.this.remove(j-1);
			j--;
			removable = false;
		}
	}

	
	public static final int CAPACITY = 1;
	private E[] data;
	private int size = 0;
	
	/**
	 * constructor de la lista
	 */
	public ArrayList() {
		this(CAPACITY);
	}
	
	/**
	 * Constructor de la lista por arreglo
	 * @param capacity2
	 */
	public ArrayList(int capacity2) {
		data=(E[]) new Object[capacity2];
	}

	@Override
	/**
	 * devuelve el tamanio de la lista
	 */
	public int size() {
		return size;
	}

	@Override
	/**
	 * Devuelve true si la lista esta vacia de lo contrario devuelve un false
	 */
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	/**
	 * toma un elemento en cierto indice i
	 * @param indice i
	 */
	public E get(int i) {
		checkIndex(i, size);
		return data[i];
	}

	@Override
	/**
	 * establece un valor en cierto indice i
	 *
	 */
	public E set(int i, E e) {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	@Override
	/**
	 * aniade un elemnto en un indice i
	 */
	public void add(int i, E e) {
		checkIndex(i, size + 1);
		if (size == data.length)
			resize(2 * data.length);
		for (int k = size - 1; k >= i; k--)
			data[k + 1] = data[k];
		data[i] = e; 
		size++;
		
	}

	@Override
	/**
	 * remueve un valor en cierto indice i
	 */
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++)
			data[k] = data[k + 1];
		data[size - 1] = null;
		size--;
		return temp;
	}

	/**
	 * evalua si el indice i es valido
	 * @param i
	 * @param n
	 * @throws IndexOutOfBoundsException
	 */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}
	
	/**
	 * redimensiona la lista dependiendo de la capacidad del mismo
	 * @param capacity
	 */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for (int k=0; k < size; k++)
			temp[k] = data[k];
		data = temp;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
