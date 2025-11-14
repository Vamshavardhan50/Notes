public class LargestElement {
  public static void main(String[] args) {
    int[] arr={12, 34, 54, 2, 3};
    int largest = arr[0];
    for(int i=1;i<arr.length;i++){
      if(arr[i]>largest){
        largest = arr[i];
      }
    }


    int secondLargest = -1;
    for(int i=0;i<arr.length;i++){
      if(arr[i] > secondLargest && arr[i] !=largest) {
        secondLargest = arr[i];
      }
    }
    System.out.println("Largest element in the array is: " + largest);
    System.out.println("Largest element in the array is: " + secondLargest);
  }
}
