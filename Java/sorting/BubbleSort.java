import java.util.Arrays; 

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr={11, 12, 22, 25, 64};
     int swap = 0;
    for(int i=0;i<arr.length-1;i++){
      for(int j=i+1;j<arr.length;j++){
        if(arr[i]>arr[j]){
          int temp = arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
          swap=1;
        }
      }
      if(swap==0){
        break; // If no swaps were made, the array is sorted
      }
    }

    System.out.println("Sorted array :"+" "+Arrays.toString(arr));
  }
}
