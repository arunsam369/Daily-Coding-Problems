Problem 1: cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
	   For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
		Given this implementation of cons:
			def cons(a, b):
			    def pair(f):
				return f(a, b)
			    return pair
		Implement car and cdr.
	
Solution :
	class Pair<U, V> {

		 U x;
		 V y;

		Pair(U x, V y) {
			this.x = x;
			this.y = y;
		}	
	}
	
	class RetrievePair<U, V> {

		U car(Pair<U, V> p) {
			return p.x;
		}

		V cdr(Pair<U, V> p) {
			return p.y;
		}
	}
	
	class PairDemo{
		public static void main(String[] args) {

			//Instantiating the object pair1
			Pair<Object, Object> pair1 = new Pair<Object, Object>(2,3.456);

			//Instantiating the object pair2
			Pair<Object, Object> pair2 = new Pair<Object, Object>("3983", 56787.82398);

			//Instantiating the object RetrievePair class object
			RetrievePair<Object, Object> data = new RetrievePair<Object, Object>();

			System.out.println("The first element of pair2 is "+data.car(pair2));
			System.out.println("The second element of pair2 is "+data.cdr(pair2));

		}
	}
	
Problem 2: Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded. 
	   For example, the message '111' would give 3, since it could be decoded as
           'aaa', 'ka', and 'ak'. You can assume that the messages are decodable. For example, '001' is not allowed.

Solution :
	class Solution {
	    public int numDecodings(String s) {
		
		if(s.length() == 0 || s.charAt(0) == '0')
		    return 0;
		if(s.length() == 1)
		    return 1;
		int dp[] = new int[s.length()+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 1; i < s.length(); i++) {
		    
		    int singleDigit = s.charAt(i) - '0';
		    int doubleDigit = (s.charAt(i-1) - '0')*10 + singleDigit;
		    
		    if(singleDigit > 0)
		        dp[i+1] += dp[i];
		    if(doubleDigit >= 10 && doubleDigit <= 26)
		        dp[i+1] += dp[i-1];
		}
		
		return dp[s.length()];
	    }
	    
	}
			
			
			
			
			
			
		
		
		
		
		
		
		
