package com.rahul.problems.findNearestSmallNumber;

import java.util.Stack;

public class NearestSmallNUmber {
   public static void main(String args[])
   {
       int [] store= {1,10,40,3,7,4} ;

       Stack<Integer> stack= new Stack<Integer>();

       printSmallNumber(store,stack);

   }

   public static void printSmallNumber(int [] arr,Stack<Integer> stack)
   {
       for(int i=0;i<arr.length;i++)
       {
           while(!stack.empty() && stack.peek()>arr[i])
           {
               stack.pop();
           }
           if(stack.isEmpty())
           {
              stack.push(arr[i]);
              System.out.println("small number for "+ arr[i]  + " is "+"_");
           }

           System.out.println("small number for "+ arr[i]  + " is "+stack.peek());
           stack.push(arr[i]);
       }

   }
}
