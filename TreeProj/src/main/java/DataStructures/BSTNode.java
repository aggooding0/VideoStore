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
public class BSTNode {
    public Object element;
    public int id;
    public BSTNode left;
    public BSTNode right;
    
    /**
     * 
     * @param id
     * @param d 
     */
    public BSTNode(){
        this.element = null;
        left = null;
        right = null;
    }
    public BSTNode( Object d){
        this.element = d;
        left = null;
        right = null;
    }
    
    public BSTNode(int id, Object e){
        this.element = e;
        this.id = id;
        left = null;
        right = null;
    }
    public int getID(){
        return id;
    }
    public void setId(int num) {
        id = num;
    }
    public void setElement(Object obj) {
        element = obj;
    }
     public Object getElement() {
        return element;
    }
    public BSTNode getLeftChild() {
        return left;
    }
    public  BSTNode getRightChild() {
        return right;
    }
    public void setLeftChild(BSTNode n) {
        this.left = n;
    }
    
    //set the right child of the node
    public void setRightChild(BSTNode n) {
        this.right = n;
    }

    
    public void clear(){
        this.element = null;
    }
   
}
