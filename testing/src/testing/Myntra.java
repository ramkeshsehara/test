package testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ListNode {
	int data;
	ListNode next;

	ListNode(int data) {
		this.data = data;
		next = null;
	}
}



public class Myntra {

	public static void main(String[] args) {

		Date date;
	    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

	    Calendar c1 = Calendar.getInstance();
	    
	    String res=null;
	    res = df.format(new Date());

	  ExecutorService es = Executors.newCachedThreadPool();
	  
	  for(int i=0; i<10; i++) {
		  es.submit(new Runnable() {
				@Override
				public void run() {
					int count=0;
					for(int j=0; j<900000000; j++) {
						count++;
					}
					System.out.println(Thread.currentThread().getName() + " = "+ count);
				}
			}); 
	  }
	  
	  
	  new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Testing1 ");
				System.out.println(Thread.currentThread().getName());
			}
		}).start(); 
	  
	  System.out.println("heslogaa ");
	    
	}

	Node head = null, prev = null;

	public void childrenSumProperty(Node root) {

		if (root == null || (root.left == null && root.right == null))
			return;

		childrenSumProperty(root.left);
		childrenSumProperty(root.right);
		int left = 0, right = 0;
		if (root.left != null)
			left = root.left.data;
		if (root.right != null)
			right = root.right.data;

		if (root.data < (left + right))
			root.data = left + right;
		else
			increment(root.left, root.data - (left + right));

	}

	public void increment(Node root, int diff) {
		if (root.left != null) {

			root.data = root.data + diff;
			increment(root.left, diff);
		} else if (root.right != null) {

			root.data = root.data + diff;
			increment(root.right, diff);
		}

	}

	public Boolean isCousin(Node root, Node a, Node b) {

		if (root == null)
			return false;

		return (level(root, a, 1) == level(root, b, 1)) && (!isSibling(root, a, b));
	}

	public int level(Node root, Node a, int l) {

		if (root == null)
			return 0;

		if (root == a)
			return l;

		int leftL = level(root.left, a, l + 1);
		int rightL = level(root.right, a, l + 1);

		return leftL == 0 ? rightL : leftL;
	}

	public Boolean isSibling(Node root, Node a, Node b) {

		if (root == null)
			return false;
		if ((root.left == a && root.right == b) || (root.left == b && root.right == a))
			return true;

		return (isSibling(root.left, a, b) || isSibling(root.right, a, b));
	}

	Boolean foundA = false, foundB = false;

	public Node LCA(Node root, Node a, Node b) {

		if (root == null)
			return null;

		Node temp = null;

		if (root == a) {
			foundA = true;
			temp = root;
		} else if (root == b) {
			foundB = true;
			temp = root;
		}

		Node left = LCA(root.left, a, b);
		Node right = LCA(root.right, a, b);

		if (temp != null)
			return temp;

		if (left != null && right != null)
			return root;

		return left == null ? right : left;

	}

	int maxLevel = -1;

	public void leftView(Node root, int l) {

		if (root == null)
			return;

		if (maxLevel < l) {
			System.out.println(root.data);
			maxLevel = l;
		}
		leftView(root.left, l + 1);
		leftView(root.right, l + 1);
	}

	// List1: 5->6->3 // represents number 365
	// List2: 8->4->2 // represents number 248

	public ListNode addTwoNumber(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		int carry = 0;

		ListNode result = null, prev = null, current = null;
		while (l1 != null || l2 != null) {

			int sum= (l1== null ? 0 : l1.data) + (l2 == null ? 0 : l2.data) + carry;

			carry=sum/10;
			sum=sum%10;
			current = new ListNode(sum);
			if (result == null)
				result = current;
			else
				prev.next = current;
			
			prev=current;
			
			if(l1!=null)
				l1=l1.next;
			if(l2!=null)
				l2=l2.next;

		}

		if (carry != 0) {
			current = new ListNode(carry);
			prev.next = current;
		}

		return result;

	}
	

   class Height{
	   int height;
   }
   
   public int diameter(Node root, Height h) {
		
		if(root==null) {
			h.height=0;
			return 0;
		}
		Height hl = new Height();
		Height hr = new Height();
				
		int lDiameter = diameter(root.left,hl);
		int rDiameter = diameter(root.right, hr);
		
		h.height=1+Math.max(hl.height, hr.height);
	
		return Math.max(hl.height+hr.height+1, Math.max(lDiameter, rDiameter));
	}
	
   class Pair{
	   int x,y;
	   Pair(int x,  int y){
		   this.x=x;
		   this.y=y;
	   }
   }
   
   public int rotOranges(int mat[][]) {
	   
	   if(mat==null) return 0;
	   int r=mat.length;
	   int c=mat[0].length;
	   
	   Queue<Pair> q = new java.util.LinkedList<Pair>();
	   
	   for(int i=0; i<r; i++) {
		   for(int j=0; j<c; j++) {
			   if(mat[i][j]==2) {
				   Pair p = new Pair(i,j);
				   q.add(p);
			   }
		   }
	   }
	   
	   q.add(null);
	   
	   int result=0;
	   while(!q.isEmpty()) {
		
		   while(q.peek()!=null) {
			   
			   Pair temp = q.peek();
			   
			   if(isValid(temp.x+1, temp.y) && mat[temp.x+1][temp.y]==1) {
				   mat[temp.x+1][temp.y]=2;
				   q.add(new Pair(temp.x+1,temp.y));
			   }
			   
			   if(isValid(temp.x-1, temp.y) && mat[temp.x-1][temp.y]==1) {
				   mat[temp.x-1][temp.y]=2;
				   q.add(new Pair(temp.x-1,temp.y));
			   }
			   
			   if(isValid(temp.x, temp.y+1) && mat[temp.x][temp.y+1]==1) {
				   mat[temp.x][temp.y+1]=2;
				   q.add(new Pair(temp.x,temp.y+1));
			   }
			   
			   if(isValid(temp.x, temp.y-1) && mat[temp.x][temp.y-1]==1) {
				   mat[temp.x][temp.y-1]=2;
				   q.add(new Pair(temp.x,temp.y-1));
			   }
			   q.remove();
		   }
		   
		  q.remove();
		  
		  if(!q.isEmpty()) {
			  result++;
			  q.add(null);
		  }
	   }
	   
	   return result;
	   
   }
   
   public Boolean isValid(int i, int j) {
	   return true;
   }
	
  
   public Boolean isBST(Node root) {
	
	   return isBSTUtil(root,Integer.MAX_VALUE, Integer.MIN_VALUE);
	   
   }
   
   public Boolean isBSTUtil(Node root, int max, int min) {
   
	   if(root==null) return true;
	   
	   if(root.data< min || root.data >max)
	         return false;
	   
       return isBSTUtil(root.left, root.data-1, min)&&isBSTUtil(root.right, max, root.data);
   }
   
 
   public void heapify(int arr[], int n, int i) {
	   
	   int largest=i;
	   int left = 2*i+1;
	   int right =2*i+2;
	   
	   if(left<n && arr[left] > arr[largest]) {
		   largest=left;
	   }
	   
	   if(right<n && arr[right]> arr[largest]) {
		   largest=right;
	   }
	   
	   
	   if(largest!=i) {
		   int temp=arr[i];
		   arr[i]=arr[largest];
		   arr[largest]=temp;
		   heapify(arr, n, largest);   
	   }
   }
   
   public void binaryHeap() {
	   
	   int arr[]= {1,2,3,4,5};
	   int n=arr.length;
	   
	   for(int i=((n/2) -1); i>=0; i--) {
		   heapify(arr, n, i);
	   }
   }


   
   
   
}
