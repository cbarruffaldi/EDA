package mergeSort;

/* Orden Nlog(N) */

public class MergeSort {
	public static void mergeSortGeneric(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];
		mergeSortGeneric(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSortGeneric(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSortGeneric(a, tmp, left, center);
			mergeSortGeneric(a, tmp, center + 1, right);
			mergeGeneric(a, tmp, left, center + 1, right);
		}
	}


    private static void mergeGeneric(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    
}
