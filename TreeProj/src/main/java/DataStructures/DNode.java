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
public class DNode {
    private Object element;
    private DNode prev;
    private DNode next;
    private int ID;
    
    public DNode(int id, Object element, DNode prev, DNode next ){
        this.element= element;
        this.next= next;
        this.prev = prev;
        this.ID = id;
    }
    public Object getElement(){
        return element;
    }
    public DNode getPrev(){
        return prev;
    }
    public DNode getNext(){
        return next;
    }
    public int getID(){
        return ID;
    }
    public void setElement(Object element){
        this.element = element;
    }
    public void setPrev(DNode prev){
        this.prev = prev;
    }
    public void setNext(DNode next){
        this.next = next;
    }     

    
            
}
