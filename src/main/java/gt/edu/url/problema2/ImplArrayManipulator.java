package gt.edu.url.problema2;



public class ImplArrayManipulator implements  ArrayManipulator<Integer>   {
	int cont=0;
   int n=0;
	@Override
	public int subsets(List<Integer> lista) {
		
		n=lista.size()-1;
		   if( n == 1 ){
		    	 for (int i=0;i<n;i++){
		    		 System.out.print(lista.get(i));
		    	        cont++;
		    	        }
		    	

		    }else{
		        for (int i=0;i<n-1;i++){
		        	subsets( lista);
		            if (lista.size()%2==0){
		                swap(lista,n,n-1);
		            } else{
		                swap(lista,0, n-1);
		            }
		        }
		        subsets(lista);
              
		    }
		return cont;
	}



	@Override
public void swap(List<Integer> lista, int posFirst, int posSecond){
    int tmp = lista.get(posFirst);
    lista.set(posFirst, lista.get(posSecond));
   lista.set(posSecond, tmp) ;
}
}




