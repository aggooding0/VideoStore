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
public class Node{
    private Object element;
    private Node next;
    private int ID;
    public Node(int ID, Object element, Node next){
        this.element = element;
        this.next = next;
        this.ID = ID;
    }
    
    public Object getElement(){
        return element;
    }
    public Node getNext(){
        return next;
    }
    public void setElement(Object element){
        this.element = element;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public int getID(){
        return this.ID;
    }
}
