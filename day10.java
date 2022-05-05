Problem : Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

	For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

	In this example, assume nodes with the same value are the exact same node objects.

Solution :
		public class Solution {
		    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			Map<ListNode, Integer> map = new HashMap<>();
			
			//Inserting every node of headA in map
			while(headA != null) {
			    map.put(headA, 1);
			    headA = headA.next;
			}
			
			//Checking if any node of headB exists in map 
			while(headB != null) {
			    if(map.get(headB) != null)
				return headB;
			    headB = headB.next;
			}
			return null;
		    }
		}
