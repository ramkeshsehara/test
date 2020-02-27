package testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Value {
	int min, max;
}

public class Tree {
	
	private Node createTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		return root;
	}
	
	private void printInorder(Node root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}

	private void printLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		if (root != null) {
			q.add(root);
			while (!q.isEmpty()) {
				int count = q.size();
				while (count > 0) {
					Node temp = q.poll();
					System.out.print(temp.data + " ");
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
					count--;
				}
				System.out.println("\n");

			}
		}
	}
	
	private void leftView(Node root) {
        if(root!=null) {
         leftViewUtil(root,0);
        }		
	}
	
	static int maxLevel = -1; 
	private void leftViewUtil(Node root, int level) {
		if(root!=null) {
			if(maxLevel<level) {
				System.out.println(" Data: "+root.data + " level:" + level + " maxLevel: "+ maxLevel);
				maxLevel=level;
			}
			leftViewUtil(root.left,level+1);
			leftViewUtil(root.right,level+1);
		}
	}

	private void rightView(Node root) {
	
		rightViewUtil(root,0);
	}

	private void rightViewUtil(Node root, int level) {
		if(root!=null) {
			if(maxLevel<level) {
				System.out.println(" Data: "+root.data + " level:" + level + " maxLevel: "+ maxLevel);
				maxLevel=level;
			}
			if(root.right!=null) rightViewUtil(root.right,level+1);
			if(root.left!=null) rightViewUtil(root.left,level+1);
		}
		
	}

	private void topView(Node root) {
		topViewUtil(root,0);
	}
	
    Map map = new HashMap<>();
	private void topViewUtil(Node root, int level) {
		if(root!=null) {		
			if(!map.containsKey(level)) {
				System.out.println(root.data);
				map.put(level,"");
			}
			topViewUtil(root.left, level-1);
			topViewUtil(root.right, level+1);
		}
	}

	private void boundry(Node root) {
		if(root!=null) {
			System.out.println(root.data);
			modifiedLeftView(root.left);
			leafNode(root.left);
			leafNode(root.right);
			modifiedRightView(root.right);	
		}
	}

	private void modifiedRightView(Node root) {
		
		//if(root)
	}

	private void modifiedLeftView(Node root) {
		
		
	}

	private void leafNode(Node root) {
     
		if(root!=null) {
		    if(root.left==null && root.right==null) {
		    	System.out.println(root.data);
		    }
		    
		    leafNode(root.left);
		    leafNode(root.right);
		}
	}

	private void insertNode(Node root, int element) {
	
		if(root==null) return;
		Node e = new Node(element);
		Queue<Node> q = new LinkedList<Node>();
		boolean insertDone=false;
		q.add(root);
		
		while(!q.isEmpty()) {
			
			int count= q.size();
			while(count>0) {
				Node current= q.poll();
				if(current.left==null && !insertDone) {
					current.left=e;
					insertDone=true;
				}
				else if(current.left!=null) {
					q.add(current.left);
				}
				
				if(current.right==null && !insertDone) {
					current.right=e;
					insertDone=true;
				}
				else if(current.right!=null){
					q.add(current.right);
				}
				count--;
			}
		}
		
	}
	
	private void deleteNode(Node root, int e) {
		
		Node right =findDeepestRightNode(root);
		replaceWithRightNode(root,right,e);
		deleteLeafNode(root,e);
		
	}
	
	private void deleteLeafNode(Node root, int e) {
		if(null!=root) {
			
			if(root.left!=null && root.left.data==e) {
				root.left=null;
			}
			if(root.right!=null && root.right.data==e) {
				root.right=null;
			}
			
			if(root.left!=null)deleteLeafNode(root.left, e);
			if(root.right!=null)deleteLeafNode(root.right, e);
			
			
		}
		
	}

	private void replaceWithRightNode(Node root, Node right, int e) {
       
		if(null!=root) {
			if(root.data==e)
				{
				  root.data=right.data;
				  right.data=e;
				}
			replaceWithRightNode(root.left,right,e);
			replaceWithRightNode(root.right,right,e);
		}
	}

	private Node findDeepestRightNode(Node root) {
	
		if(root!=null) {
			if(root.right!=null) 
				return findDeepestRightNode(root.right);
			else if (root.left!=null) 
				return findDeepestRightNode(root.left);
			return root;
			
		}
		return null;
	}


	public static void main(String args[]) {
		Tree t = new Tree();
		Node root = t.createTree();
		
		String str="00101";
		//System.out.println(minFlip(str));
		
		System.out.println(0%2);
		
		Deque<Integer> dq= new LinkedList<Integer>();
		
	    
		//t.printInorder(root);
		//t.printLevelOrder(root);
		//t.leftView(root);
		//t.rightView(root);
		//t.topView(root);
		//t.boundry(root);
        //t.insertNode(root,5);
		//t.deleteNode(root,1);
		//t.printLevelOrder(root);
		
		//t.printInorderWithoutRecursion(root);
		//t.printInorder(root);
		
	}

	private static int minFlip(String str) {

		int flipCount=0;
		int len=str.length();
		char prev = 0;
		if(len==0) return 0;
		if(len>1) {
			if(str.charAt(0)=='1') flipCount++;
			prev=str.charAt(0);
		}
		
		for(int i=1; i<str.length(); i++) {
    		if(str.charAt(i)!=prev) {
				flipCount++;
			}
    		prev=str.charAt(i);
		}
		return flipCount;

	}

	private void printInorderWithoutRecursion(Node root) {
		
	}

	


	
}
