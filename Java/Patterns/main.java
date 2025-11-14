// patterns ---> Nested loops 

// 1. for the outer loop ,count the no of lines 
// 2. for the inner loop,focus on the columns and connect with rows somehow
// 3. print them, inside the inner loop 
// 4. observer symmetry [Optional]
 
// * * * *
// * * * *
// * * * *  👉  Pattern 1
// * * * *

// class main{
//   public static void main(String[] args) {
//     for(int i=0;i<4;i++){
//       for(int j=0;j<4;j++){
//         System.out.print("* ");
//       }
//       System.out.println("");
//     }
//   }
// }


// * 
// * * 
// * * *  👉  Pattern 3
// * * * *


// class main{
//   public static void main(String[] args) {
//     for(int i=0;i<4;i++){
//       for(int j=0;j<=i;j++){
//         System.out.print("* ");
//       }
//       System.out.println("");
//     }
//   }
// }


// 1 
// 1 2 
// 1 2 3  👉  Pattern 4
// 1 2 3 4


// class main{
//   public static void main(String[] args) {
//     for(int i=0;i<4;i++){
//       for(int j=0;j<=i;j++){
//         System.out.print((j+1) + " ");
//       }
//       System.out.println("");
//     }
//   }
// }

// 1 
// 2 2
// 3 3 3  👉  Pattern 5
// 4 4 4 4


// class main{
//   public static void main(String[] args) {
//     for(int i=0;i<4;i++){
//       for(int j=0;j<=i;j++){
//         System.out.print((i+1) + " ");
//       }
//       System.out.println("");
//     }
//   }
// }


// * * * *
// * * *  👉  Pattern 6
// * * 
// * 

// class main{
//     public static void main(String[] args) {
//       for(int i=0;i<4;i++){
//         for(int j=0;j<4-i+1;j++){
//           System.out.print("* ");
//         }
//         System.out.println("");
//       }
//     }
//   }


// 1 2 3 4
// 1 2 3  👉  Pattern 7
// 1 2 
// 1

// class main{
//     public static void main(String[] args) {
//       for(int i=0;i<5;i++){
//         for(int j=0;j<5-i;j++){
//           System.out.print((j+1)+" ");
//         }
//         System.out.println("");
//       }
//     }
//   }


//      *         [space,star,space]
//    * * *  👉  Pattern 8
//  * * * * *
// * * * * * *  

   
// class main{
//     public static void main(String[] args) {
//       for(int i=0;i<5;i++){
//        //space 
//        for(int j=0;j<=5-i-1;j++){
//         System.out.print(" ");
//        }

//        //star
//        for(int j=0;j<2*i-1;j++){
//         System.out.print("*");
//        }


//        //space 
//        for(int j=0;j<5-i-1;j++){
//         System.out.print(" ");
//        }

//         System.out.println("");
//       }
//     }
//   }



// * * * * * *  
//  * * * * *
//    * * *  👉  Pattern 9
//      *         [space,star,space]

   
// class main{
//   public static void main(String[] args) {
//       for(int i=0;i<5;i++){
//          //space 
//         for(int j=0;j<=5-i-1;j++){
//             System.out.print(" ");
//         }
//             //star
//         for(int j=0;j<2*i-1;j++){
//           System.out.print("*");
//         }
//            System.out.println("");
//       }

//       for(int i=0;i<5;i++){
//        //space 
//        for(int j=0;j<i;j++){
//         System.out.print(" ");
//        }
//        //star
//        for(int j=0;j<((2*5)-(2*i+1));j++){
//         System.out.print("*");
//        }
//         System.out.println("");

//       }
//     }
//   }


// * 
// * *
// * * *
// * * * *
// * * * * *
// * * * * * *    👉 pattern 10 
// * * * * *
// * * * *
// * * *
// * *
// *


// class main{
//   public static void main(String[] args) {
//     for(int i=0;i<6;i++){
//       for(int j=0;j<i;j++){
//         System.out.print("* ");
//       }
//       System.out.println();
//     }

//     for(int i=0;i<6;i++){
//         for(int j=0;j<6-i+1;j++){
//            System.out.print("* ");
//         }
//       System.out.println("");
    
//     }
//   }
// }


// 1 
// 0 1
// 1 0 1  👉 pattern 11
// 0 1 0 1
// 1 0 1 0 1



// class main{
//   public static void main(String[] args) {

//     int start =1;
//     for(int i=0;i<5;i++){
//       if(i%2==0){
//         start =1 ;
//       }
//       else{
//         start=0;
//       }
//       for(int j=0;j<=i;j++){
//         System.out.print(start + " ");
//         start=1-start;
//       }

//         System.out.println();
//     }
//   }
// }



// 1      1
// 12    21
// 123  321    👉 pattern 12
// 12344321


// class main{
//   public static void main(String[] args) {
    
//     int n =5;
//     int space = 2*(n-1);
//     for(int i=0;i<n;i++){
//       //numbers
//       for(int j =1;j<=i;j++){
//         System.out.print(j);
//       }
//       //space
//       for(int j=1;j<=space;j++){
//         System.out.print(" ");
//       }

//       //number
//       for(int j=i;j>=1;j--){
//         System.out.print(j);
//       }
//       System.out.println();
//       space-=2;

//     }
//   }
// }

// A 
// A B
// A B C   👉 pattern 13
// A B C D
// A B C D E


// class main {
//   public static void main(String[] args) {
//     for(int i=0;i<6;i++){
//         char c=65;
//       for(int j=0;j<i;j++){
//         System.out.print(c +" ");
//         c=(char) (c+1);
//       }
//       System.out.println();
//     }
//   }
// }



// A B C D E 
// A B C D
// A B C      👉 pattern 14
// A B
// A

// class main {
//   public static void main(String[] args) {
//     for(int i=0;i<6;i++){
//         char c=65;
//       for(int j=0;j<6-i-1;j++){
//         System.out.print(c +" ");
//         c=(char) (c+1);
//       }
//       System.out.println();
//     }
//   }
// }


// A 
// B B
// C C C     👉 pattern 15
// D D D D


// class main{
//   public static void main(String[] args) {
//     char c = 64;
//     for(int i=0;i<5;i++){
//       for (int j =0;j<i;j++){
//         System.out.print(c+" ");
//       }
//       c = ((char)(c+1));
//       System.out.println();
    
//     }
//   }
// }


//     A    
//    ABA
//   ABCBA      pattern 👉 16
//  ABCDCBA
// ABCDEDCBA

// class main{
//       public static void main(String[] args) {
//         for(int i=0;i<5;i++){
//          //space 
//          for(int j=0;j<=5-i-1;j++){
//           System.out.print(" ");
//          }
  
//          //star
//          char c = 'A';
//          int breakpoint = (2*i+1)/2;
//          for(int j=1;j<=2*i+1;j++){
//           System.out.print(c);
//           if(j<=breakpoint){
//             c++;
//           }
//           else{
//             c--;
//           }
//          }
  
  
//          //space 
//          for(int j=0;j<5-i-1;j++){
//           System.out.print(" ");
//          }
  
//           System.out.println("");
//         }
//       }
//     }

 