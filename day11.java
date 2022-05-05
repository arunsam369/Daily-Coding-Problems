Problem 1: Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

		For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
		
Solution: 
		public class Solution {
		    public int solve(ArrayList<ArrayList<Integer>> A) {
			int rooms = 0;
			int n = A.size();
			
			Collections.sort(A,(x,y) -> {
			    return x.get(0) - y.get(0);
			});
			
			PriorityQueue<Integer> pque = new PriorityQueue<>();

			for(int i = 0; i < n; i++) {
			    while(pque.size() > 0 && pque.peek() <= A.get(i).get(0)) 
				    pque.poll();

			    pque.add(A.get(i).get(1));

			    rooms = Math.max(rooms, pque.size());
			}
			return rooms;
		    }
		}
