import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
     
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int target=sc.nextInt();
    List<Integer> list=new ArrayList<>();
    for(int i=0;i<n;i++){
      list.add(sc.nextInt());
     }
     System.out.println(findTarget(list,target,n));
    }
 public static boolean findTarget(List<Integer> list,int target,int n){
    HashSet<Integer> hs=new HashSet<>();
    for(int i=0;i<n;i++)
     {
      if(hs.contains(target-list.get(i)))
           return true;
      else
         hs.add(list.get(i));
     }
      return false;
  }
 }
