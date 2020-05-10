package amazon;

class BTreeNode {

	int t; // min degree
	int keys[]; // list of keys at this node
	int nodeCount; // number of node
	BTreeNode childs[]; // list of child
	Boolean isLeaf; // current node is leaf or not

	BTreeNode(int t, Boolean isLeaf) {
		this.t = t;
		this.nodeCount = 0;
		this.keys = new int[2 * t - 1];
		this.childs = new BTreeNode[2 * t];
		this.isLeaf = isLeaf;
	}

	public void insertNonFull(int key) {

	}

	public void splitChild(int i, BTreeNode y) {

		BTreeNode z = new BTreeNode(y.t, y.isLeaf);
		z.nodeCount=t-1;
		for(int j=0; j<t-1; j++) 
			z.keys[j]=y.keys[j+t];
		
		if(y.isLeaf==false) 
			for(int j=0; j<t; j++) 
				z.childs[j]=y.childs[j+t];
			
		y.nodeCount=t-1;
		
		
		
	}

	public void traverse() {

	}

	public BTreeNode search(int key) {

		return null;
	}

}

public class BTree {
	BTreeNode root;
	int t;

	BTree(int t) {
		this.t = t;
		this.root = null;
	}

	void traverse() {
		if (root != null) root.traverse();
	}


	BTreeNode search(int k) {
		
		return (root == null) ? null : root.search(k);
	
	}

	void insert(int k) {
		
		if(root==null) {
			root= new BTreeNode(this.t, true);
			root.nodeCount=1;
			root.keys[0]=k;
		}else {
			if(root.nodeCount==2*t-1) {
				BTreeNode node = new BTreeNode(t, false);
				node.childs[0]=root;
				
				node.splitChild(0, root);
				
				int i=0;
				if(node.keys[0]<k)
					i++;
				
				node.childs[i].insertNonFull(k);
				root=node;
				
			}else {
				root.insertNonFull(k);				
			}
		}
		
		
	}

	public static void main(String args[]) {

		BTree tree = new BTree(3);
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);

		tree.traverse();
		
		tree.search(40);
		
	}
}
