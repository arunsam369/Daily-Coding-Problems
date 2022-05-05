Problem 1: Given a string you need to print the size of the longest possible substring that has exactly K unique characters.
		 If there is no possible substring then print -1.
Solution :
		class Solution {
		    public int longestkSubstr(String s, int k) {
			// code here
			
			int p1 = 0, p2 = 0;
			
			int maxLength = -1;
			
			int count[] = new int[26];
			
			while(p2 < s.length()) {
			    
			    count[s.charAt(p2)-'a']++;
			    
			    int unique = 0;
			    
			    for(int j = 0; j < 26; j++) {
				
				if(count[j] != 0)
				    unique++;
			    }
			    
			    if(unique == k)
				maxLength = Math.max(maxLength, p2-p1+1);
				
			    else if(unique > k) {
				
				while(p1 < p2) {
				    
				    unique = 0;
				    
				    count[s.charAt(p1++)-'a']--;
				    
				    for(int j = 0; j < 26; j++) {
				        
				        if(count[j] != 0)
				            unique++;
				    }
				    
				    if(unique == k)
				        break;
				}
			    }
			    
			    p2++;
			}
			return maxLength;
		    }
		}
