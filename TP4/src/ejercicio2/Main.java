package ejercicio2;

public class Main {
	public static void main(String[] args) {
		int[] sizes = new int[] {50000, 100000, 200000, 400000, 800000};
		long start, time;
		for (int size : sizes) {
		start = System.currentTimeMillis();
		quickSort(createRandomArray(size));
		time = System.currentTimeMillis() - start;
		System.out.println("Size:" + size +  " Time:" + time + "ms");
		}
		}
	
		public static int[] createRandomArray(int size) {
		int[] ret = new int[size];
		for (int i=0; i<size; i++) {
			ret[i] = (int)(Math.random() * 100);
		}
		return ret;
		}

		public static void quickSort(int array[]) {
			quickSort(array, 0, array.length - 1);             
		}


		public static void quickSort(int array[], int start, int end){
		        int i = start;                          
		        int k = end;                            

		        if( end - start < 1) //si hay menos de dos elementos no hago nada
		        	return;
		        
		        int pivot = array[start];       //Pivot es el primer elemento

		         while (k > i)                   
		                {
		                     while (array[i] <= pivot && i <= end && k > i)  
		                           i++;                                    
		                     while (array[k] > pivot && k >= start && k >= i) 
		                           k--;                                        
		                     if (k > i)                                       
		                           swap(array, i, k);                      
		                }
		         
		                swap(array, start, k);          
		                                                 
		                quickSort(array, start, k - 1); 
		                quickSort(array, k + 1, end);   
		   }
		        
		

		public static void swap(int array[], int index1, int index2) 
		
		{
			int temp = array[index1];           
			array[index1] = array[index2];      
			array[index2] = temp;               
		}


}

