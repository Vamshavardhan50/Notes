class main{
  public static void main(String[] args) {
    String num =Integer.toString(34,6);
    int num2 = Integer.parseInt(num);
    int sum = 0;
    while(num2!=0){
        int rem = num2%10;
        sum+=rem;
        num2/=10;
    }
    System.out.println(sum);
  }
}