public class CheckSquare {

    public static void main(String args[])
    {
      System.out.println("please enter all the four points");
      Point p1= new Point(20,10);
      Point p2= new Point(10,20);
      Point p3= new Point(20,20);
      Point p4= new Point(10,10);

     System.out.println("below points :");
     System.out.println("Point p1 :"+p1 +"Point p2 :" +p2 +"Point p3 "+p3 +"Point p4 :"+ p4 +" can form a square ====== "+ isSquare(p1,p2,p3,p4)  );
    }
    public static  boolean isSquare(Point p1,Point p2,Point p3,Point p4)
    {
        int d1= findDistance(p1,p2);
        int d2=findDistance(p1,p3);
        int d3=findDistance(p1,p4);
        if(d1==d2 && 2*d1==d3  &&2*d1==findDistance(p2,p3))
        {
            int d= findDistance(p2,p4);
            return(d==d1 &&d1==findDistance(p3,p4));
        }
        if(d2==d3 && 2*d2==d1 &&2*d2==findDistance(p3,p4))
        {
            int d=findDistance(p3,p2);
            return(d==d2 &&d2== findDistance(p4,p2));
        }
        if(d3==d1 && 2*d3==d2 && 2*d3==findDistance(p4,p2))
        {
            int d= findDistance(p4,p3);
            return(d==d3 &&d3==findDistance(p2,p3));
        }
     return false;
    }

    public static  int findDistance(Point p1,Point p2)
    {
        return((p2.getX()-p1.getX()) *(p2.getX()-p1.getX()) +(p2.getY()-p1.getY()) *(p2.getY()-p1.getY()));
    }
}
