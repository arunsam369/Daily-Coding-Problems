Problem 1 : A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

		Given the root to a binary tree, count the number of unival subtrees.

		For example, the following tree has 5 unival subtrees:

		   0
		  / \
		 1   0
		    / \
		   1   0
		  / \
		 1   1

Solution :
	class Solution {
	    public int numDecodings(String s) {
		
		if(s.length() == 0 || s.charAt(0) == '0')
		    return 0; /*If the first char is 0 then we can't decode as there isn't an alphabet with value 0 and 
		    			for length 0 no of ways is 0 as we can't decode an empty string.*/
		    
		if(s.length() == 1)
		    return 1; //The no of ways a single char is decoded is 1.
		
		int dp[] = new int[s.length()+1];
		dp[1] = 1; //At index 1 it is the no of ways that single char is decoded which is 1 way.
		dp[0] = 1; //This is previous no of ways for 1st char which is itself 1.
		
		for(int i = 1; i < s.length(); i++) {
		    
		    int singleDigit = s.charAt(i) - '0'; // Considering the message where the current current alphabet encoded between 1 to 9 
		    int doubleDigit = (s.charAt(i-1) - '0')*10 + singleDigit; /*Considering the message where the current alphabet encoded between 
										10 to 26 */
		    
		    if(singleDigit > 0)
			dp[i+1] += dp[i]; /* As it is between 1 to 9 we can just add the current alphabet to the previous message. So, no of ways 
						will be the same as before*/
		    if(doubleDigit >= 10 && doubleDigit <= 26)
			dp[i+1] += dp[i-1]; /* As it is between 10 to 26 we can just add the current alphabet to the previous message where the 
						previous message is before i-1th char. So add that count to current index.*/
		}
		
		return dp[s.length()];
	    }
	    
	}
