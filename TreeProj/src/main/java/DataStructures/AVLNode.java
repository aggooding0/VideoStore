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
public class AVLNode {
   private int id;
    private Object element;
    private AVLNode left;
    private AVLNode right;
    private int height;
    
   
    public AVLNode(int num, Object obj) {
        id = num;
        element = obj;
        left = null;
        right = null;
        height = 1;
    }


    public int getId() {
        return id;
    }
    

    public void setId(int num) {
        id = num;
    }

  
    public Object getElement() {
        return element;
    }
    
 
    public void setElement(Object obj) {
        element = obj;
    }

    public AVLNode getLeftChild() {
        return (AVLNode) left;
    }


    public AVLNode getRightChild() {
        return (AVLNode) right;
    }

    public void setLeftChild(AVLNode n) {
        left = n;
    }
    

    public void setRightChild(AVLNode n) {
        right = n;
    }
    

    public int getHeight() {
        return height;
    }
    

    public void setHeight(int num) {
        height = num;
    }
     
}
