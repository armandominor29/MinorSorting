/**
 * Implements various sorting algorithms.
 *
 * @author (Armando Minor), Acuna, Sedgewick
 * @verison (09-16-16)
 */
import java.util.ArrayList;

public class MinorSorting
{
    /**
     * Entry point for sample output.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        String[] data = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        quicksortmid(data);
        assert isSorted(data); //requires assertions enabled.
        show(data);

        //Q2
        //Create new array called demo
        ArrayList<Comparable> demo=new ArrayList<Comparable>();
        // add elements to the list
        demo.add(32);
        demo.add(2);
        demo.add(3);
        demo.add(352);
        demo.add(872);
        demo.add(7);

        mergeSort(demo);

        System.out.println(mergeSort(demo));

    }

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     *
     */
    private static ArrayList<Comparable> mergeSort(ArrayList<Comparable> l){
        if (l.size()<=1)
            return l;
        else{
            ArrayList<Comparable> a=new ArrayList<Comparable>();
            ArrayList<Comparable> b=new ArrayList<Comparable>();
            for(int i=0;i<l.size()/2;i++)
                a.add(l.get(i));
            for(int i=0;i<l.size()-a.size();i++)
                b.add(l.get(i+a.size()));
            return  merge(mergeSort(a),mergeSort(b));
        }
    }


    /**
     * Merges two sorted subarrays of the specified array.
     *@param a is first list
     *@param b is second list
     */
    @SuppressWarnings("unchecked")
    private static ArrayList<Comparable> merge( ArrayList<Comparable> a,  ArrayList<Comparable> b){
        int aMax=0;
        int bMax=0;

        ArrayList<Comparable> c=new ArrayList();

        while(aMax<a.size() &&bMax<b.size()){
            if (a.get(aMax).compareTo(b.get(bMax))< 0){
                c.add(a.get(aMax));
                aMax++;
            }
            else{
                c.add(b.get(bMax));
                bMax++;
            }
        }
        if (aMax==a.size()){
            for(int x=bMax;x<b.size();x++){
                c.add(b.get(x));
            }
        }
        else if(bMax==b.size()){
            for(int x=aMax;x<a.size();x++){
                c.add(a.get(x));
            }
        }
        return c;
    }

    /**
     * Displays contents of array, space separated.
     * @param data Array to display.
     */
    private static void show(Comparable[] data) {
        for (Comparable a1 : data)
            System.out.print(a1 + " ");

        System.out.println();
    }
    //
    /**
     * Checks if array is in sorted order.
     * @param data Array to be checked.
     * @return Returns true if array is sorted.
     */
    private static boolean isSorted(Comparable[] data) {
        for (int i = 1; i < data.length; i++)
            if (less(data[i], data[i-1]))
                return false;

        return true;
    }

    @SuppressWarnings("unchecked")
    //Method ensures objects are less than each other
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    /*Quick sort method for array
    *@param data is the array to be sorted
    */

    private static <T extends Comparable<T>> void quicksortmid(T[] data) {
        qsort(data, 0, data.length-1);
    }
    /*Quick sort method for array
     *@param data is the array to be sorted
     * @param low is the lowest value of data
     * @param hi is the highest value of data
     */
    private static <T extends Comparable<T>> void qsort(T[] data, int low, int hi) {
        if(low >= hi) return;
        int pi = partition(data, low, hi);
        qsort(data, low, pi-1);
        qsort(data, pi+1, hi);
    }
    /*Partition method finds partition for the array
     *@param data is the array to be sorted
     * @param low is the lowest value of data
     * @param hi is the highest value of data
     */
    private static <T extends Comparable<T>> int partition(T[] data, int low, int hi) {
        int i = low + 1;
        int j = hi;

        while(i <= j) {
            if(data[i].compareTo(data[low]) <= 0) {
                i++;
            }
            else if(data[j].compareTo(data[low]) > 0) {
                j--;
            }
            else if(j < i) {
                break;
            }
            else
                swap(data, i, j);
        }
        swap(data, low, j);
        return j;
    }
    /*swap method enables exchange of paramaters if needed
     *@param data is the array to be sorted
     * @param low is the lowest value of data
     * @param hi is the highest value of data
     */
    private static void swap(Object[] data, int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}