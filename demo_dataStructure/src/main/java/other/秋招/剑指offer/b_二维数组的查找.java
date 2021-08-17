package other.秋招.剑指offer;

public class b_二维数组的查找 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,8},{4,6,25,8}};
        int target = 250;
        System.err.println(searchArr(arr,target));
    }

    private static boolean searchArr(int[][] arr,int target) {
        if (arr == null || arr.length == 0 || arr[0].length ==0)
            return  false;
        int row = arr.length, col = arr[0].length;
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (arr[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
