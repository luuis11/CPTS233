/**
 * * Name: Yi Chou
 * CptS 233: microAssignment #1
 * Date: 09/02/2020
 * gitRepo url:https://github.com/luuis11/CPTS233.git
 */

public class MA2 {
// Java program to illustrate the sum of two numbers 

// A BTree 
class Btree { 
	public BTreeNode root; // Pointer to root node 
	public int t; // Minimum degree 

	// Constructor (Initializes tree as empty) 
	Btree(int t) { 
		this.root = null; 
		this.t = t; 
	} 

	// function to traverse the tree 
	public void traverse() { 
		if (this.root != null) 
			this.root.traverse(); 
		System.out.println(); 
	} 

	// function to search a key in this tree 
	public BTreeNode search(int k) { 
		if (this.root == null) 
			return null; 
		else
			return this.root.search(k); 
    } 
    public void insert(int k){
        if(root == null){
            root = new BTreeNode(t, true);
            root.keys[1] = k;
            root.n = 1;
        }else{
            //if root is full
            if(root.n == 2*t-1){
                BTreeNode s = new BTreeNode(t, false);
                s.C[0] = root;
                s.splitChild(0, root);
                root = s;
            }else{
                root.insertNonFull(k);
            }
        }
    }
  
} 


// A BTree node 
class BTreeNode { 
	int[] keys; // An array of keys 
	int t; // Minimum degree (defines the range for number of keys) 
	BTreeNode[] C; // An array of child pointers 
	int n; // Current number of keys 
	boolean leaf; // Is true when node is leaf. Otherwise false 

	// Constructor 
	BTreeNode(int t, boolean leaf) { 
		this.t = t; 
		this.leaf = leaf; 
		this.keys = new int[2 * t - 1]; 
		this.C = new BTreeNode[2 * t]; 
		this.n = 0; 
	} 

	// A function to traverse all nodes in a subtree rooted with this node 
	public void traverse() { 

		// There are n keys and n+1 children, travers through n keys 
		// and first n children 
		int i = 0; 
		for (i = 0; i < this.n; i++) { 

			// If this is not leaf, then before printing key[i], 
			// traverse the subtree rooted with child C[i]. 
			if (this.leaf == false) { 
				C[i].traverse(); 
			} 
			System.out.print(keys[i] + " "); 
		} 

		// Print the subtree rooted with last child 
		if (leaf == false) 
			C[i].traverse(); 
	} 
    // A utility function to insert a new key in the subtree rooted with 
    // this node. The assumption is, the node must be non-full when this 
    // function is called 
    public void insertNonFull(int k){
        int i = n-1;
        if(leaf==true){
            while(i>=0 && keys[i]>k){
                keys[i+1]=keys[i];
                i--;
            }
            keys[i+1]=k;
            n=n+1;
        }else{
            while(i>=0 && keys[i]>k)
                i--;
            if(C[i+1].n == 2*t-1){
                splitChild(i+1, C[i+1]);

                if(keys[i+1]<k){
                    i++;
                }
            }
            C[i+1].insertNonFull(k);
        }
    }
  
    // A utility function to split the child y of this node. i is index of y in 
    // child array C[].  The Child y must be full when this function is called 
    public void splitChild(int i, BTreeNode y){
        BTreeNode newNode = new BTreeNode(y.t, y.leaf);
        newNode.n = t-1;
        //moving keys to the new node
        for(int j=0;j<t-1;j++){
            newNode.keys[j] = y.keys[j+t];
        }
        //adding children to new node
        if(y.leaf == false){
            for(int j=0;j<t;j++){
                newNode.C[j]=y.C[j+t];
            }
          }

        y.n = t-1;

        for(int j=n;j>=i+1;j--)
            C[j+1] = C[j];
        C[i+1] = newNode;
        
        for(int j=n-1;j>=i;j--)
            keys[j+1] = keys[j];
        keys[i] = y.keys[t-1];

        n = n+1;
    }

	// A function to search a key in the subtree rooted with this node. 
	BTreeNode search(BTreeNode root,int k) { // returns NULL if k is not present. 
        int i=0;
        while(i<root.n && k>root.keys[i]){
            i++;
        }
        if(i<=root.n && k == root.keys[i]){
            return root;
        }
        if(root.leaf){
            return null;
        }
        else{
            return search(root.getChild(i), k);
        }
    } 
    BTreeNode getChild(int index){
        if(index>=C.length){
            return null;
        }
        return C[index];
    }
        
}