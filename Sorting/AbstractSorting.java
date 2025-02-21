abstract public class AbstractSorting {
    public static void Sort(Comparable[] a){
        //Sorting algorithm
    }
    protected boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            if(!less(a[i], a[i++])){
                return false;
            }
        }
        return true;
    }
}
