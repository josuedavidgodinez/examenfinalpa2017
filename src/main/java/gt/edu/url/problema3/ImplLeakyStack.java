package gt.edu.url.problema3;


public class ImplLeakyStack<E> implements LeakyStack<E> {

	
	private static final Exception IllegalArgumentException = null;

	CircularLinkedList<E>lista =new CircularLinkedList<E>();
	
int capacity=0;
	
	public ImplLeakyStack(int savecapacity){
		
		this.capacity=savecapacity;
		
	}

	@Override
	public int size() {
		return lista.size();
	}

	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	

	@Override
	public E saveHistory(E e) {
		if(lista.size()<capacity) {
		lista.addFirst(e);
		}else {
			
			for(int i=0;i<capacity;i++) {
				lista.rotate();			
				
			}
			lista.removeFirst();
			lista.addFirst(e);
		}
		return e;
	}

	@Override
	public E actual() {
		return lista.first();
	}

	@Override
	public E undo() 
	{
		 E elemento= lista.removeFirst();
		 if(elemento==null) {
			 throw new IllegalArgumentException("Historial sin elementos");
			 
		 }else {
			 
			 return elemento;
			 
		 }
	}

}
