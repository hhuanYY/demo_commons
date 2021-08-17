package other.秋招.剑指offer;

public class g_基于快速排序的寻找第K大数 {
    public static void main(String[] args) {
        int[] arr = {5111,611,21,31111,81};
        int n = 5;
        int K = 3;
        //System.err.println(findK(arr,n,K));

        System.err.println(findKth(arr,n,K));
    }

    public static int findKth(int[] a, int n, int K) {
        // write code here
        // 思路：在快排基础上改变为从大到小排序
        return find(a,0,n-1,K);
    }

    private static int find(int[] a,int low,int high,int K){
        int part = getIndex(a,low,high);
        if(K == (part - low + 1)) return a[part];
        else if(K > (part - low + 1)) return find(a,part+1,high,K-(part-low+1));
        else return find(a,low,part-1,K);
    }

    private static int getIndex(int[] a,int low,int high){
        int tmp = a[low];
        if(low < high){
            while(low < high && a[high] <= tmp) high--;
            a[low] = a[high];
            while(low < high && a[low] >= tmp) low++;
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }
}
