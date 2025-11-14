public class LargestSubaArrysWithSumK{
  public static void main(String[] args) {
    int[] arr={9,4,20,3,10,5};
    int n = arr.length;
    int k = 33;
    int count=0;
    for(int i=0;i<n;i++){
      int sum =0;         //Brute force approach
      for(int j=i;j<n;j++){
        sum = sum + arr[j];
        if(sum == k){
          count++;
        }
      }
    }
    System.out.println(count);
  }
}

