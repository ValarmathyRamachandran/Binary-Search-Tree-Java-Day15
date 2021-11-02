package com.bridgelabzBinary;
public class BinaryTree {
    public static boolean flag = false;  
	public static Node root; 
		public BinaryTree(){  
        root = null;  
		}  

    //insert() will add new node to the binary search tree  
    public void insert(Node root2, int data) {  
        //Create a new node  
        Node newNode = new Node(data);  

        //Check whether tree is empty  
        if(root == null){  
            root = newNode;  
            return;  
          }  
        else {  
            //current node point to root of the tree  
            Node current = root, parent = null;  

            while(true) {  
                //parent keep track of the parent node of current node.  
                parent = current;  

                //If data is less than current's data, node will be inserted to the left of tree  
                if(data < current.data) {  
                    current = current.left;  
                    if(current == null) {  
                        parent.left = newNode;  
                        return;  
                    }  
                }  
                //If data is greater than current's data, node will be inserted to the right of tree  
                else {  
                    current = current.right;  
                    if(current == null) {  
                        parent.right = newNode;  
                        return;  
                    }  
                }  
            }  
        }  
    }  

    //minNode() will find out the minimum node  
    public Node minNode(Node root) {  
        if (root.left != null)  
            return minNode(root.left);  
        else  
            return root;  
    }  
   
    //inorder() will perform inorder traversal on binary search tree  
    public void inorderTraversal(Node node) {  

        //Check whether tree is empty  
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
         }  
        else {  

            if(node.left!= null)  
                inorderTraversal(node.left);  
            System.out.print(node.data + " ");  
            if(node.right!= null)  
                inorderTraversal(node.right);  

        }  
    } 
    
  //searchNode() will search for the particular node in the binary tree  
    public void searchNode(Node temp, int value){  
      //Check whether tree is empty  
      if(root == null){  
        System.out.println("Tree is empty");  
      }  
      else{  
        //If value is found in the given binary tree then, set the flag to true  
        if(temp.data == value){  
          flag = true;  
             return;  
        }  
        //Search in left subtree  
        if(flag == false && temp.left != null){  
           searchNode(temp.left, value);  
        }  
        //Search in right subtree  
        if(flag == false && temp.right != null){  
           searchNode(temp.right, value);  
        }  
      }  
    }  
    public static void main(String[] args) {  

        BinaryTree bt = new BinaryTree(); 
        Node root = new Node(56);
        //Add nodes to the binary tree 
        System.out.println("***********Binary Search Tree************");
        System.out.println("      Building tree with root value " + "'"  + root.data + "'"  );
       
        bt.insert(root,56);  
        bt.insert(root,30);  
        bt.insert(root,70);   
        bt.insert(root,22); 
        bt.insert(root,40);
        bt.insert(root,60);
        bt.insert(root,95); 
        bt.insert(root,11); 
        bt.insert(root,3); 
        bt.insert(root,16);
        bt.insert(root,65);
        bt.insert(root,63);
        bt.insert(root,67);
        
        System.out.println("------Binary search tree after insertion--------");  
        //Displays the binary tree  
        bt.inorderTraversal(bt.root);  
        int val = 63;
      //Search for node 5 in the binary tree  
        bt.searchNode(bt.root, val);  
        System.out.println("\n ---------------------------------------------");
	     if(flag)  
	       System.out.println("Element " +val + " is present in the binary tree");  
	     else  
	       System.out.println("Element"  +val + " is not present in the binary tree");  
	   }  
 }  