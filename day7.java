Problem 2 : The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

		Hint: The basic equation of a circle is x2 + y2 = r2.
Solution :
		import java.util.*;
		public class MyClass {
		    public static void main(String args[]) {
		    
		      int interval = 3;
		      int circlePoints = 0;
		      int squarePoints = 0;
		      double pi = 0;
		      
		      for(int i = 0; i < interval*interval; i++) {
			  
			  double x = Math.random();
			  double y = Math.random();
			  
			  if(x*x + y*y <= 1) 
			      circlePoints++;
			  squarePoints++;
			  
			  pi = (double)(4*circlePoints)/squarePoints;
		      }
		      
		      System.out.println(pi);
		    }
		}	
	
Problem 3 : Implementation of synchronized concurrent threading.

Solution :
	//This is a Mart class where each thread tries to make a purchase in synchronized manner.
	import java.util.*;
	class Mart {
		
		HashMap<String, Integer> items;
		Mart(HashMap<String, Integer> items) {
			this.items = items;
		}
		
		Scanner sc = new Scanner(System.in);
		
		public  synchronized void checkItems(String thread) {
		
			System.out.println("Executing :"+thread);
			
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
			
			if(totalNumberofItems > 0) {
			
				System.out.println("Enter the item to buy");
				String item = sc.nextLine();
				buy(item);
			}
			else
				System.out.println("No items available");
				
			System.out.println(thread+" completed\n");		
		}
		
		public void buy(String item) {
		
			if(items.get(item) == null)
				System.out.println("Item is not available");
			else { 
			
				items.put(item, items.get(item)-1);
				System.out.println(item+" has been purchased");
			}
		}
	} 	
	
	//This is a thread class to which a mart object is passed when a thread is created to make a purchase in Mart
	class concurrentThreading implements Runnable{
		
		Mart mart;
		String thread;
		
		concurrentThreading(Mart mart, String thread) {
			this.mart = mart;
			this.thread = thread;
		}
		
		public void run() {
				mart.checkItems(thread);		
		}
	}
	
	/*This is concurrentThreadingDemo class where multiple threads are created which are runnable 
	  objects and these will be passed to execute method of ExecutorService that 
	  will execute all the threads*/
	import java.util.concurrent.Executors;
	import java.util.concurrent.ExecutorService;
	import java.util.*;

	class concurrentThreadingDemo {

		public static void main(String[] args) {
			
			
			HashMap<String, Integer> items = new HashMap<>();
			items.put("realme 8i", 5);
			items.put("Macbook Air M1", 10);
			items.put("Duroflex mattress", 12);
			items.put("kurtha", 50);
			items.put("Michael Kors Watch", 3);
			
			Mart mart = new Mart(items);
			
			Runnable thread1 = new concurrentThreading(mart, "thread1");
			Runnable thread2 = new concurrentThreading(mart, "thread2");
			Runnable thread3 = new concurrentThreading(mart, "thread3");
			Runnable thread4 = new concurrentThreading(mart, "thread4");
			Runnable thread5 = new concurrentThreading(mart, "thread5");
			
			ExecutorService pool = Executors.newFixedThreadPool(3);
			
			pool.execute(thread1);
			pool.execute(thread2);
			pool.execute(thread3);
			pool.execute(thread4);
			pool.execute(thread5);
			
			pool.shutdown();
		}
	}	
