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
public class SLL{

    private Node head;

    

    public SLL() {

        head = null;

    }
    public Node getHead(){
        return head;
    }
    public void deleteNth(int n){
        int count= 0;
        Node curr = head;
        
        while(curr != null){
            curr = curr.getNext();
            count++;
        }
        System.out.println(count);if(count == n){
            
         setHead(null); 
         
        }else{
        count = count-n;
        int i = 1;
        Node temp = head;
        while(i != count){
           temp = temp.getNext();
           i++;
        }
        
        temp.setNext(null);
        }
    }
    
    
    public Node findMiddle(){

int n = 0;

Node current = head;

while (current != null){

current = current.getNext();

n++;

}

int mid = n/2;

int i = 0;

Node temp = head;

while(i != mid){

i++;

temp = temp.getNext();

}

return temp;

}

    public void setHead(Node head) {
        this.head = head;

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getElement() + " ");
            current = current.getNext();
        }

    }
    

    public void add(Node n) {
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(n);
        }
        n.setNext(null);
    }

    public Node remove() {

        Node current = head;
        
        if (current == null) {
            head = null;
            return null;
        } else if (current.getNext() == null) {
            head = null;
            return null;
        } else {
            while (current.getNext().getNext() != null) {
           
                current = current.getNext();
            }
            current.setNext(null);
        }

        return current;

    }
    public boolean find(Object e){
        
        boolean isThere = false;
        Node current = head;
        while (current.getElement() != e) {
           
                current = current.getNext();
                
                
        }
        if(current == e){
            isThere = true;
        }
        return isThere;
            
    }
    public void removeElement(int e) {

        Node current = head;
        
        
        if (current.getID() == e && current.getNext()==null) {
            head = null;
            
        } else if(current.getID() == e && current.getNext()!=null){
            head = current.getNext();
        }
        else if(current.getID() != e && current.getNext()==null){
           return;
        }
        
        else{
            while (current.getNext() != null && current.getNext().getID() != e) {
           
                current = current.getNext();
                
                
            }
            if(current.getNext().getID() == e){
                if(current.getNext().getNext()==null){
                    current.setNext(null);
                }else{
                    current.setNext(current.getNext().getNext());
                    //current.getNext().setNext(null);
                }
                
            }
            
        
        }
        
        
        

    }
    

    public void reverse(){
       Node prev = null;
       Node current= head;
       Node next = null;
       
       while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current= next;
            
            
            
       }
       head = prev;
       
       
    }
}
