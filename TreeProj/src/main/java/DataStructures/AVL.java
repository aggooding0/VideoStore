/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author ayoka
 */
public class AVL {
    private AVLNode root;
    
	
    public AVLNode getRoot() {
        return root;
    }
    
    
    public void setRoot(AVLNode n) {
        root = n;
    }
    
    
    public boolean find(int id) {
        AVLNode current = root;
        
        while(current != null) {
            if(current.getId() == id) {
                return true;
            } else if(current.getId() > id) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        
        return false;
    }
    
    
    public Object getElement(int id) {
        AVLNode current = root;
        
        while(current != null) {
            if(current.getId() == id) {
                return current.getElement();
            } else if(current.getId() > id) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        
        return null;
    }
    
   
   
    public void print(AVLNode n) {
        if(n != null) {
            print(n.getLeftChild());
            System.out.print(n.getElement() + "\n");
            print(n.getRightChild());
        }
    }

    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
