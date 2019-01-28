package java8Dev;

public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("++++++++++++++++++++++++++++++");
		System.out.println(" with out lambda");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("running threads");
				
			}
		}).start();

		
		
		System.out.println("+++++++++++++++++++++++++++++++++");
		System.out.println("with lambda");
		
		new Thread(()->System.out.println("running threads")).start();
	}

}
