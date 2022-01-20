

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ayoka
 */
import DataStructures.*;
public class Customer {
    
    
    private String name;
    private String id;
    SLL rentVideoSLL = new SLL();
    DLL rentVideoDLL = new DLL();
    BST rentVideoBST = new BST();
    AVL rentVideoAVL = new AVL();
    
    
    
    public Customer(String name, String id){
        this.name = name;
        this.id = id;
        
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return this.id;
    }
    public Object getRentVideo(){
        String s = VideoStore.getType();
        
        if( s.equals("SLL")){
            return rentVideoSLL;
        }
        else if( s.equals("DLL")){
           return rentVideoDLL;

        }
        else if( s.equals("BST")){
            return rentVideoBST;
        }
        else{
            return rentVideoAVL;
        }
    }
    
    public void setRentVideo(Video e){
        String s = VideoStore.getType();
        if( s.equals("SLL") ){
            Node a = new Node(Integer.parseInt(e.getID()),new Video(e.getID(),e.getTitle()), null);
            
            rentVideoSLL.add(a);
        }
        else if( s.equals("DLL")){
            DNode d = new DNode(Integer.parseInt(e.getID()),new Video(e.getID(),e.getTitle()), null,null);
            rentVideoDLL = new DLL();
            rentVideoDLL.addLast(d);
        }
        else if( s.equals("BST")){
            BSTNode b = new BSTNode(new Video(e.getID(),e.getTitle()));
            rentVideoBST = new BST();
            rentVideoBST.insert(b.getID(), e);
        }/*
         else if( v.getType().equals("AVL")){
            AVLNode aa = new AVLNode(e);
            rentVideoBST = new BST();
            rentVideoBST.insert(-1, e);
        }*/
        
    }
    
    
    public void removeRentVideo(int vid){
        String s = VideoStore.getType();
        if( s.equals("SLL") ){
            rentVideoSLL.removeElement(vid);
        }
        else if( s.equals("DLL")){
           rentVideoDLL.remove(vid);
        }
        else if( s.equals("BST")){
            rentVideoBST.delete(vid);
        }/*
         else if( v.getType().equals("AVL")){
            
        }*/
    }
    
    public boolean custHasVideo(int id){
        String s = VideoStore.getType();
    
         if( s.equals("SLL") ){
           return rentVideoSLL.find(id);
        }
        else if( s.equals("DLL")){
           return rentVideoDLL.find(id);
        }
        else if( s.equals("BST")){
            return rentVideoBST.find(id);
        }
        else{
            return false;
        }
    }
    
    
    
    public void printVideos(){
        
    }
    
    
    public String toString(){
       return "ID: " + id + ", Name: " + name; 
    }
    
    
    
}
    
   