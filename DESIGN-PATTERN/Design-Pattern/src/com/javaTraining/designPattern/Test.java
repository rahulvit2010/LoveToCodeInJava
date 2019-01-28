package com.javaTraining.designPattern;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int coveredElem=0;
        int elem=0;
        int A=3;
        ArrayList<ArrayList<Integer>> sprialMat= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp ;
        for(int i=0;i<A;i++)
        {
        	 temp= new ArrayList<Integer>();
        	for(int j=0;j<A;j++)
        	{
        		temp.add(0);
        	}
        
         sprialMat.add(temp);
        }
       System.out.println(sprialMat);
        
        
        int T=0,B=A-1,L=0,R=A-1;
        while(T<=B && L<=R)
        {
            if(coveredElem==0)
            {
                for(int i=L;i<=R;i++)
                {
                elem=elem+1;
                 sprialMat.get(T).set(i,elem);
                }
                T++;
            }
            else if(coveredElem==1)
            {
             
               for(int i=T;i<=B;i++)
               {
                   elem=elem+1;
                   System.out.println("sprial matrix current situation");
                   System.out.println(sprialMat.get(i));
                sprialMat.get(i).set(R,elem) ;
               }
               R--;
            }
            else if(coveredElem==2)
            {
               
               for(int i=R;i>=L;i--)
               {
                   elem=elem+1;
                   sprialMat.get(B).set(i,elem) ;
                   
               }
                B--;
            }
            else if(coveredElem==3)
            {
               
               for(int i=B;i>=T;i--)
               {
                   elem=elem+1;
                   sprialMat.get(i).set(L,elem);
                   
               }
                L++;
            }
            
            coveredElem=(coveredElem+1)%4;
        }
        
        System.out.println(sprialMat);


	}

}
