/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Ayoka
 */
public class BST {
    /**
     * 
     */
    private BSTNode root;
    
    
    public static void main(String [] args){
     
    }
    public BST(){
        this.root = null;
    }
    
    /**
     * 
     * @return 
     */
    public BSTNode getRoot(){
        return root;
    } 
    
    
    public void insert(int id, Object element) {
        BSTNode n = new BSTNode(id, element);
        
        if(root == null) {
            root = n;
            return;
        }
        
        BSTNode current = root;
        BSTNode temp;
        
        
        
        
        while(true) {
            temp = current;
            
            if(id < current.getID()) {
                current = current.getLeftChild();
                
                if(current == null) {
                    temp.setLeftChild(n);
                }
            } else if (id > current.getID()){
                current = current.getRightChild();
                
                if(current == null) {
                    temp.setRightChild(n);
                }
            }
        }
    }
    
    //method to find if an id number is in the tree
    public boolean find(int id) {
        BSTNode current = root;
        Boolean found = false;
        while(current != null) {
            
            if(current.getID() == id) {
                found = true;
            } else if(current.getID() < id) {
                current = current.getRightChild();
            } else if(current.getID() > id) {
                current = current.getLeftChild();
            }
        }
        
        return found;
    }
    
  
   
    public boolean isEmpty()
     {
         return root == null;
     }
    public void delete(int id)
     {
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (find(id) == false)
             System.out.println("Sorry "+ id +" is not present");
         else
         {
             root = delete(root, id);
             System.out.println(id+ " deleted from the tree");
         }
     }
     private BSTNode delete(BSTNode root, int k)
     {
         BSTNode p, p2, n;
         if (root.getID() == k)
         {
             BSTNode lt, rt;
             lt = root.getLeftChild() ;
             rt = root.getRightChild();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeftChild() != null)
                     p = p.getLeftChild() ;
                 p.setLeftChild(lt);
                 return p2;
             }
         }
         if (k < root.getID())
         {
             n = delete(root.getLeftChild(), k);
             root.setLeftChild(n);
         }
         else
         {
             n = delete(root.getRightChild(), k);
             root.setRightChild(n);             
         }
         return root;
     }





    public BSTNode getSuccessor(BSTNode n) {
        BSTNode successor = null;
        BSTNode successorParent = null;
        BSTNode current = n.getRightChild();
        
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        
        //check if successor has the right child, it cannot have left child for sure
        //if it does have the right child, add it to the left of successorParent.
        if(successor != n.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(n.getRightChild());
        }
        
        return successor;
    }

    
    private BSTNode findMinFromRight(BSTNode node) {
    while(node.left != null){
        node = node.left;
    }
    return node;
}
    
    
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
