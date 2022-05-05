
   import java.lang.*;
     import java.util.*;

	class MultiThreading extends Thread {

		Map<String, Integer> items = new HashMap<String, Integer>();
		MultiThreading(Map<String, Integer> items) {
			this.items = items;
		}
		
		public void run() {
			try { 
				Scanner sc = new Scanner(System.in);
				System.out.println("Current Thread id:            "+Thread.currentThread().getId());
				System.out.println("Availabe Items ");
				if(showItems()) {
					System.out.println("Enter the item you want to buy");
					String item = sc.nextLine();
					buy(item);
					System.out.println(item+" has been ordered");	
				}	
				else
				  	System.out.println("Sorry!!! currently no items available");	
					
			}
			catch(Exception e) {
				System.out.println("Exception is caught "+e);
			}
		}
		
		public boolean showItems() {
			int totalNumberofItems = 0;
			for(Map.Entry<String, Integer> item : items.entrySet()) {
				String itemName = item.getKey();
				int itemCount = item.getValue();
				totalNumberofItems += itemCount;
				if(itemCount > 0)
					System.out.println("Item: "+itemName+" Available: "+itemCount);
				else
					items.remove(itemName);	
			}
			
			return totalNumberofItems != 0? true : false;		
		}
		
		public void buy(String item) {
			items.replace(item, items.get(item)-1);
		}
		
	}
	
	//This is a MultiThreadingDemo class that creates thread objects for the above created thread class and starts running it.
	import java.util.*;
	class MultiThreadingDemo {
		public static void main(String []args) {
			Scanner sc = new Scanner(System.in);
			
			Map<String, Integer> items = new HashMap<>();
			items.put("realme 8i", 5);
			items.put("Macbook Air M1", 10);
			items.put("Duroflex mattress", 12);
			items.put("kurtha", 50);
			items.put("Michael Kors Watch", 3);
			
			System.out.println("Enter the number of threads you want to create");
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				MultiThreading thread = new MultiThreading(items);
				thread.start();
			}
		}
	}
		
2. Implement multithreading by implementing runnable interface

Program :
	// This is an abstract class named Shopping which contains items to purchase
	import java.util.*;
	abstract class Shopping {
		
		HashMap<String, Integer> items;
		Shopping(HashMap<String, Integer> items) {
			this.items = items;
		}
		
		public boolean showItems() {
			int totalNumberofItems = 0;
			for(Map.Entry<String, Integer> item : items.entrySet()) {
				String itemName = item.getKey();
				int itemCount = item.getValue();
				totalNumberofItems += itemCount;
				if(itemCount > 0)
					System.out.println("Item: "+itemName+" Available: "+itemCount);
				else
					items.remove(itemName);	
			}
			
			return totalNumberofItems != 0? true : false;		
		}
		
		abstract public void buy(String item);
	}
	
	// This is a MultiThreadByRunnable class that extends Shopping and implements runnable interface
	import java.lang.*;
	import java.util.*;

	class MultiThreadByRunnable extends Shopping implements Runnable{

		MultiThreadByRunnable(HashMap<String, Integer> items) {
			super(items);
		}
		
		public void run() {
			try { 
				Scanner sc = new Scanner(System.in);
				System.out.println("Current Thread id: "+Thread.currentThread().getId());
				System.out.println("Availabe Items");
				if(showItems()) {
					System.out.println("Enter the item you want to buy");
					String item = sc.nextLine();
					buy(item);
					System.out.println(item+" has been ordered");	
				}	
				else
				  	System.out.println("Sorry!!! currently no items available");		
			}
			catch(Exception e) {
				System.out.println("Exception is caught "+e);
			}
		}
		
		public void buy(String item) {
			items.replace(item, items.get(item)-1);
		}
		
	}
	
	//This is a MultiThreadByRunnableDemo class That creates objects for the above class and will be passed to the Thread class thereby the thread objects are created and run.
	import java.util.*;
	class MultiThreadByRunnableDemo {

		public static void main(String []args) {
		
			Scanner sc = new Scanner(System.in);
			
			HashMap<String, Integer> items = new HashMap<>();
			items.put("realme 8i", 5);
			items.put("Macbook Air M1", 10);
			items.put("Duroflex mattress", 12);
			items.put("kurtha", 50);
			items.put("Michael Kors Watch", 3);
			
			System.out.println("Enter the number of threads you want to create");
			int n = sc.nextInt();
			
			for(int i = 0; i < n; i++) {
				Thread thread = new Thread( new MultiThreadByRunnable(items));
				thread.start();
			}
			
		}
		
	}
			

