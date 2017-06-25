/*
This is the client class that utilizes the Stats object. This class is used to
make statistics calculations from the Stats object. Mainly used to find the 
correlation and to show all work associated with finding r. 
*/

import java.util.*;

public class StatClient {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Queue<Double> q1 = new LinkedList<Double>();
      Queue<Double> q2 = new LinkedList<Double>();
      System.out.print("How many pairs of items? ");
      int n = console.nextInt();
      System.out.println("Filling First List: ");
      fillQueue(q1, console, n);
      System.out.println("Filling Second List: ");
      fillQueue(q2, console, n);
      Stats calculate = new Stats();
      
      calculate.correlation(q1, q2);
   }
   
   // post: fills a queue based on user input. Puts  n number of
   //       doubles in the given queue q based on user input gathered
   //       by the given Scanner console.
   private static void fillQueue(Queue<Double> q, Scanner console, int n) {
      for (int i = 0; i < n; i++) {
         System.out.print("Enter Number: ");
         double thing = console.nextDouble();
         q.add(thing);
      }
   }   
}