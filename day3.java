Problem 1:  Given a list of numbers and a number k,return whether any two numbers from the list add up to k

Solution :
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
		
		int num[] = new int[nums.length];
		for(int i = 0; i < nums.length; i++) 
		    num[i] = nums[i];
		
		int pairInSortedArray[] = new int[2];
		
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length; i++) {
		    
		    int index = checkForPair(nums, 0, nums.length-1, target-nums[i]);
		    
		    if(index != -1) {
		        pairInSortedArray[0] = i;
		        pairInSortedArray[1] = index;
		        break;
		    }
		}
		
		int pair[] = new int[2];
		int index = 0;
		
		for(int i = 0; i < num.length; i++) {
		    
		    if(num[i] == nums[pairInSortedArray[0]])
		        pair[index++] = i;
		    else if(num[i] == nums[pairInSortedArray[1]])
		        pair[index++] = i;
		}
		
		return pair;
	    }
	    
	    public int checkForPair(int[] nums, int low, int high, int k) {
		
		
		while(low <= high) {
		    
		    int mid = (low+high)/2;
		    
		    if(nums[mid] < k)
		        low = mid+1;
		    
		    else if(nums[mid] > k)
		        high = mid-1;
		    
		    else
		        return mid;
		}
		
		return -1;
	    }
	}


Problem 2:  Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

Solution :
	//deserialization is a partialised solution
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialization(TreeNode root, String serialized) {
		
		serialized = String.valueOf(root.val);
		
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		que.add(null);
		
		while(que.size() > 0) {
		    
		    while(que.peek() != null) {
		        
		        TreeNode node = que.poll();
		        TreeNode leftNode = node.left;
		        TreeNode rightNode = node.right;
		        String left = "";
		        String right = "";
		        
		        if(leftNode != null)
		            left = String.valueOf(leftNode.val);
		        else
		            left = "null";
		        
		        if(rightNode != null)
		            right = String.valueOf(rightNode.val);
		        else
		            right = "null";
		        
		        serialized += " "+left+" "+right;
		        
		        if(leftNode != null)
		            que.add(node.left);
		        
		        if(rightNode != null)
		            que.add(node.right);
		    }
		    
		    que.poll();
		    
		    if(que.size() > 0) 
		        que.add(null);
		}
		
		return serialized;    
	    }
	    public String serialize(TreeNode root) {
		
		if(root == null)
		    return "";
		
		String serialized = serialization(root, "");
		
		while(serialized.length() > 0) {
		    
		    if(serialized.charAt(serialized.length()-1) == 'l')
		        serialized = serialized.substring(0, serialized.length()-5);
		    else
		        break;
		}
		
		return serialized;
	    }
	    
	    public List<Integer> stringToArray(List<Integer> dataList, String data) {
		
		String val = "";
		
		for(int i = 0; i < data.length(); i++) {
		    
		    if(data.charAt(i) != ' ')
		        val += data.charAt(i);
		    else {
		        
		        if(!val.equals("null")) 
		            dataList.add(Integer.parseInt(val));
		        else 
		            dataList.add(null);
		        
		        val = "";
		    }
		}
		
		dataList.add(Integer.parseInt(val));
		
		return dataList;
	    }
	    public TreeNode deserialization(List<Integer> dataList, int size) {
		
		TreeNode deserialized = new TreeNode(dataList.get(0));
		
		Queue<TreeNode> que = new LinkedList<>();
		que.add(deserialized);
		que.add(null);
		
		for(int i = 0; i < size; i++) {
		    
		    if(dataList.get(i) != null) {
		        
		        TreeNode node = que.poll();
		        
		        if(node != null) {
		            
		            if(2*i+1 < size) {
		                
		                if(dataList.get(2*i+1) != null) {
		                    
		                    node.left = new TreeNode(dataList.get(2*i+1));
		                    que.add(node.left);
		                }
		                
		            }
		            
		            if(2*i+2 < size) {
		                
		                if(dataList.get(2*i+2) != null) {
		                    
		                    node.right = new TreeNode(dataList.get(2*i+2));
		                    que.add(node.right);
		                }
		                
		            }
		        }
		    }
		}
		return deserialized;
	    }
	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
		
		if(data.equals(""))
		    return null;
		
		List<Integer> dataList = new ArrayList<>();
		
		dataList = stringToArray(dataList, data);
		
		return deserialization(dataList, dataList.size());
	    }
	}
