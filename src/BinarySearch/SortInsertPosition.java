package BinarySearch;

public class SortInsertPosition {
    public static int searchInsert(int[] A, int B) {
        return searchIndex(A, B, 0, A.length-1,-1);
    }

    public static int searchIndex(int[] A, int B, int low, int high,int floor){
        if(low>high){
            return low;
        }
        int mid = (low+high)/2;
        if(A[mid] == B){
            return mid;
        }
        if(A[mid]>B){
            return searchIndex(A,B,low,mid-1,floor);
        }else{
            return searchIndex(A,B,mid+1,high,floor);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7};
        System.out.println(searchInsert(arr,9));
    }
}
