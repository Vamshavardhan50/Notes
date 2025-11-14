import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RightRotByKplaces{
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7};
    int n = arr.length;
    List<Integer> temp = new ArrayList<>();
    int k = 3; 
    //temp will hold the last k elements
    for(int i =n-k;i<n;i++){
      temp.add(arr[i]);
    }
    
    System.out.println(temp);
    //Shift the elements of arr to the right by k places
    for(int i=n-k-1;i>=0;i--){
      arr[i+k] = arr[i];
    }

    //Push back the elements from temp to arr
      
    System.out.println(Arrays.toString(arr));
  }
}