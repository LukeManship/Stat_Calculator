/*
The Stats class is used to calculate various statistics based on given inputs.
A client would use this class to find correlation, mean, or standard deviations, while
showing all work associated with each calculation.
*/

import java.util.*;

public class Stats {  

   // pre: both queues q1 and q2 are assumed to have at least one element
   // post: calculates and returns the correlation as a double based on this correlation formula:
   //       (1 / n - 1) * sigma(((xi - xbar)/sdx) * ((yi - ybar)/sdy)). This shows all
   //       work so that client can follow the calculations.
   public double correlation(Queue<Double> q1, Queue<Double> q2) {
      double mean1 = mean(q1);
      double mean2 = mean(q2);
      double sd1 = standardDeviation(q1);
      double sd2 = standardDeviation(q2);
      
      int size1 = q1.size();
      double sum = 0;
      String toPrint = "";
      for (int i = 0; i < size1; i++) {
         double num1 = q1.remove();
         double num2 = q2.remove();
         toPrint += "((" + num1 + " - " + mean1 + ") / " + sd1 + ") * ((" + num2 + " - " + mean2 + ") / " + sd2 + ")  +  ";
         double diff1 = (num1 - mean1) / sd1;
         double diff2 = (num2 - mean2) / sd2;
         sum += diff1 * diff2;
         q1.add(num1);
         q2.add(num2);
      }
      toPrint = toPrint.substring(0, toPrint.length() - 3);
      System.out.println(toPrint);
      System.out.println("Rest of Calculation: " + sum + " * (1 / " + (size1 - 1) + ")");
      double r = sum / (size1 - 1);
      System.out.println("r  =  " + r);
      return r;
   }
   
   // pre: given queue q is assumed to have at least one element
   // post: calculates the standard deviation and returns it as a double based
   //       on this formula: root((1/n-1)sigma((xi - xbar)^2))). Shows all work
   //       involved in calculation.
   public double standardDeviation(Queue<Double> q) {
      double mean = mean(q);
      double df = q.size() - 1;
      double minusSum = 0;
      int size = q.size();
      String toPrint = "";
      for (int i = 0; i < size; i++) {
         double num = q.remove();
         toPrint += "(" + num + " - " + mean + ")^2  +  ";
         double diff = num - mean;
         minusSum += diff * diff;
         q.add(num);
      }
      toPrint = toPrint.substring(0, toPrint.length() - 3);
      System.out.println(toPrint);
      double variance = minusSum / df;
      System.out.println("Variance: " + minusSum + " * (1 / " + (size - 1) + ")  =  " + variance);
      double sd = Math.sqrt(variance);
      System.out.println("Standard Deviation: root(" + variance + ")  =  " + sd);
      return sd;
   }
   
   // pre: given queue q is assumed to have at least one element.
   // post: calculates the mean based on the elements in the given queue
   //       q and returns it as a double.
   public double mean(Queue<Double> q) {
      double sum = 0;
      System.out.print("Numbers: ");
      int size = q.size();
      for (int i = 0; i < size; i++) {
         double num = q.remove();
         System.out.print(num + " ");
         sum += num;
         q.add(num);
      }
      System.out.println();
      double mean = sum / size;
      System.out.println("Mean: " + mean);
      return mean;
   }
}