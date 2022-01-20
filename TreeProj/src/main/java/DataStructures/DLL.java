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
public class DLL {

    private DNode header, trailer;
    
    
    public void swap(int i, int j){
        DNode curr = header.getNext();
        DNode curr2 = header.getNext();
        int c=0;

        //stores value at first index into temp
        while(c != i){
            curr = curr.getNext();       
            c++;      
        }
        System.out.println(curr.getElement());
        c=0;
        
        //stores value at second index into temp
        while(c != j){
            curr2 = curr2.getNext();
            
            c++;
        }

        DNode tmp1 =curr.getPrev() ;
        DNode tmp2 =curr.getNext() ;    
        
        
        DNode tmp3 =curr2.getPrev() ;
        DNode tmp4 =curr2.getNext() ;  
        
        
        curr.setNext(tmp4);
        curr.setPrev(tmp3);
        
        curr2.setNext(tmp2);
        curr2.setPrev(tmp1);
        
        tmp1.setNext(curr2);
        tmp3.setNext(curr);
        tmp2.setPrev(curr2);
        tmp4.setPrev(curr);
    }
    
    
    
    public void concat(DLL L, DLL M){
       
        
        DNode cur = L.trailer.getPrev();
        DNode cur2 = M.header.getNext();
        cur.setNext(cur2);
        M.trailer.getPrev().setNext(L.trailer);
       
        
    }
    
    public DLL() {
        header = new DNode(-1,null, null, null);
        trailer = new DNode(-1,null, header, null);
        header.setNext(trailer);
    }

    public DNode getHeader() {
        return this.header;
    }

    public DNode getTrailer() {
        return this.trailer;
    }

    public void setHeader(DNode header) {
        this.header = header;
    }

    public void setTrailer(DNode trailer) {
        this.trailer = trailer;
    }
    
    public void addFirst(DNode n) {
        DNode temp = header.getNext();
        header.setNext(n);
        temp.setPrev(n);
        n.setPrev(header);
        n.setNext(temp);
        
    }
    
    public void print() {
        DNode current = header.getNext();
        while (current != trailer) {
            System.out.println(current.getElement() + " ");
            current = current.getNext();
        }
        
    }
    
    public void addLast(DNode n) {
        DNode temp = trailer.getPrev();
        trailer.setPrev(n);
        temp.setNext(n);
        n.setPrev(temp);
        n.setNext(trailer);
        
    }

    public void remove(int id) {
       DNode a;
       DNode b;
        if(find(id)){
            
            DNode current = header.getNext();
            DNode temp;
            while (current.getID() != id) {

                    current = current.getNext();



            }    
            
            a = current.getPrev();
            b = current.getNext();
            a.setNext(b);
            b.setPrev(a);
            current.setNext(null);
            current.setPrev(null);
            
        }
        
   
        
    }

    public void reverse() {
        
        DNode move = trailer.getPrev();
        DNode current = header.getNext();
        DNode temp = header.getNext();
        DNode temp2 = trailer.getPrev().getPrev();
        
        header.setNext(move);
        move.setPrev(header);
        move.setNext(temp);
        temp.setPrev(move);
        temp2.setNext(trailer);
        
        trailer.setPrev(temp2);
        
        while (trailer.getPrev() != temp) {
            
            temp2 = trailer.getPrev().getPrev();
            move = trailer.getPrev();
            current = temp.getPrev();
            current.setNext(move);
            move.setPrev(current);
            move.setNext(temp);
            temp.setPrev(move);
            temp2.setNext(trailer);
            trailer.setPrev(temp2);
            
        }
        
    }

    public boolean find(int id) {
        DNode current = header.getNext();
        while (current != trailer) {
            if(current.getID()==id){
                return true;
            }
            else{
                current = current.getNext();
            }
            
            
        }    
        return false;
    
    }
    
}
