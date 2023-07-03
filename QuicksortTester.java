// Walker
// Reign
// 4144021
// CSC211 2022 Practical 3
// File name

public class QuicksortTester {


    /**
     * Quicksort algorithm (driver)
     */

    public static void quicksort(int[] a)
    {
        quicksort( a, 0, a.length - 1 );
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cut-off.
     */



    public static void quicksort(int[] a, int low, int high)
    {
        if( low + CUTOFF > high )
            insertionSort( a );
        else
        { // Sort low, middle, high
            int middle = ( low + high ) / 2;
            if( Integer.compare(a[middle], a[low]) < 0 )
                swapReferences( a, low, middle );
            if( Integer.compare(a[high], a[low]) < 0 )
                swapReferences( a, low, high );
            if( Integer.compare(a[high], a[middle]) < 0 )
                swapReferences( a, middle, high );

            // Place pivot at position high - 1
            swapReferences( a, middle, high - 1 );
            int pivot = a[ high - 1 ];

            // Begin partitioning
            int i, j;
            for( i = low, j = high - 1; ; )
            {
                while( Integer.compare(a[++i], pivot) < 0 )
                    ;
                while( Integer.compare(pivot, a[--j]) < 0 )
                    ;
                if( i >= j )
                    break;
                swapReferences( a, i, j );
            }

            // Restore pivot
            swapReferences( a, i, high - 1 );

            quicksort( a, low, i - 1 ); // Sort small elements
            quicksort( a, i + 1, high ); // Sort large elements
        }
    }


    // insert code here for question 3
    static int CUTOFF = 10;
    // insert code here for question 4 a)
    public static void insertionSort( int a []){
        for(int p=1; p<a.length; p++){
            int temp = a[p];
            int j = p;

            for(; j>0 && Integer.compare(temp, a[j-1])<0; j--){
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }

    // insert code here for question 4 b)

    public static void swapReferences(int [] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    // insert code here for question 5)
    public static void removeDuplicates(int A []){

        quicksort(A);

        int Final[] = new int[A.length];
        int j =0;
        for(int i = 0; i<A.length-1; i++){
            if (A[i] != A[i + 1]) {
                Final[j] = A[i];
                j++;
            }
        }

        if(A[A.length-2] != A[A.length-1]){
            j++;
        }
        System.out.println(j); //Prints the number of elements in the array after the duplicates have been removed
    }
    // insert code here for question 6)
    public static void main(String args[]){
        int [] b= {1,3,4,1,4,12,4,6,7,1,3,1};
        quicksort(b);
        for(int i =0; i< b.length;i++){
            System.out.print(" "+ b[i]);
        }
        System.out.println(" ");

        removeDuplicates(b);
    }
}
