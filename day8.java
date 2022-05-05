problem 1: You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

		record(order_id): adds the order_id to the log
		get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
		You should be as efficient with time and space as possible.

Solution:
		import java.util.*;

		public class MyClass {
		    
		    static List<Integer> log = new ArrayList<>();
		    
		    public static void main(String args[]) {
		      Scanner sc = new Scanner(System.in);
		      while(true) {
			  System.out.println("Enter your choice\n1.add order id\n2.get last ith id\n3.End\n");
			  int choice = sc.nextInt();
			  if (choice == 1) {
			      System.out.println("Enter the order id");
			      int order_id = sc.nextInt();
			      record(order_id);
			  }
			  else if (choice == 2) {
			      System.out.println("Enter the value of i i.e., the last ith element you want to get where i < "+(log.size()+1));
			      int i = sc.nextInt();
			      System.out.println("The last "+i+"th order is "+get(i)+"\n");
			  }
			  else
			    break;
		      }
		    }
		    
		    public static void record(int order_id) {
			log.add(order_id);
			System.out.println("order id has been added successfully\n");
		    }
		    
		    public static int get(int i) {
			return log.get(log.size()-i);
		    }
		}
