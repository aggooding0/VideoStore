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
import java.util.Scanner;
public class VideoStore {
    
    
    private static String type;
    private static SLL videoInStoreSLL;
    private static SLL  customerSLL;
    private static DLL videoInStoreDLL;
    private static DLL  customerDLL;
    private static BST videoInStoreBST;
    private static BST  customerBST;
    private static AVL videoInStoreAVL;
    private static AVL  customerAVL;
    private static int videoID = 0;
    private static int customerID = 0;
    
    public static void main(String[] args){
        
        
        String Menu = ("1: To add a video\n2: To delete a video\n3: To add "
                + "a customer\n4: To delete a customer\n5: To check if a "
                + "particular video is in store\n6: To check out a video\n7: "
                + "To check in a video\n8: To print all customers\n9: To print "
                + "all videos\n10: To print in store videos\n11: To print "
                + "all rent videos\n12: To print the videos rent by a customer"
                + "\n13: To exit");
        System.out.println(Menu); 
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the Type"); 
        type  = reader.next();
        
        if(type.equals("SLL")){
              videoInStoreSLL  = new SLL();
              customerSLL  = new SLL();
        }
        else if(type.equals("DLL")){
            videoInStoreDLL  = new DLL();
            customerDLL  = new DLL();
        }
        else if(type.equals("BST")){
            videoInStoreBST  = new BST();
            customerBST  = new BST();
        }
        else if(type.equals("AVL")){
            videoInStoreAVL  = new AVL();
            customerAVL  = new AVL();
        }
        
        
        
        int numVideosInStore = 0;
        int numCustomers = 0;
        int numTransactions = 0;
       
        /*
         if(args.length == 4) {
            numVideosInStore = Integer.parseInt(args[1]);
            numCustomers = Integer.parseInt(args[2]);
            numTransactions = Integer.parseInt(args[3]);
        }else{
            int S = reader.nextInt();
        String response="";
        */
        System.out.println("Please enter the number"); 
        int S = reader.nextInt();
        
        Scanner info = new Scanner(System.in);
        String response;
        while(S != 13){
       
        switch(S) {

            case 1:
               
                System.out.println("Please enter the title of the video");
                response = info.nextLine().trim();
                setVideoInStore(response,Integer.toString(videoID++));
                System.out.println(Menu);
                S = reader.nextInt();
                break;

            case 2:
                System.out.println("Which video do you wish to delete?");
                response = info.nextLine().trim();
                removeVideo(response);
                System.out.println(Menu);
                S = reader.nextInt();
                break;

            case 3:
                System.out.println("Please enter the name of the customer");
                response = info.nextLine().trim();
                setCustomer(response,Integer.toString(customerID++) );
                System.out.println(Menu);
                S = reader.nextInt();
                
                break;

            case 4:
                System.out.println("Which customer do you wish to delete?(id)");
                response = info.nextLine().trim();
                removeCustomer(response);
                System.out.println(Menu);
                S = reader.nextInt();
               
                
                break;

            case 5:
                System.out.println("Which video do you want to check if in store(ID)");
                response = reader.next().trim();
                
                if(check(Integer.parseInt(response))==false){
                    System.out.println("Sorry, "+ response+" is currently not in store.");
                }else{
                    System.out.println(check(Integer.parseInt(response)));
                }
                
                System.out.println(Menu);
                S = reader.nextInt();
                
                
                break;

            case 6:
                //To check out a video
                
                System.out.println("Please enter the Customer ID");
                int cid = reader.nextInt();
                
                System.out.println("Please enter the Video ID");
                int vid = reader.nextInt();
                checkOut(cid, vid);
                
                System.out.println(Menu);
                S = reader.nextInt();
                break;

            case 7:
                //To check in a video
                
                System.out.println("Please enter the Video ID");
                int vid2 = reader.nextInt();
                checkIn(vid2);
                
                
                System.out.println(Menu);
                S = reader.nextInt();
                break;

            case 8:
                //To print all customers
                
                printAllCustomers();
                
                System.out.println(Menu);
                S = reader.nextInt();
               
                break;

            case 9:
               
               //To print all videos 
                printAllVideos();
                
                System.out.println(Menu);
                S = reader.nextInt();
                break;
                
                
            case 10:
                //To print in store videos
                //videoInStore.print();
                printInStoreVideos();
                System.out.println(Menu);
                S = reader.nextInt();
                break;
            case 11:
               //To print all rent videos
                printAllRentVideos();
                System.out.println(Menu);
                S = reader.nextInt();
                break;
            case 12:
               //To print the videos rented by customer
                
                printVideosRentByACustomer();
                System.out.println(Menu);
                S = reader.nextInt();
                break;
            case 13:
               System.out.println("Goodbye");
                break;

                
            default:
                break;
        }
        } 
   
             
         }
        
        
       
    
    private static void removeCustomer(String id){
        if(type.equals("SLL")){
           customerSLL.removeElement(Integer.parseInt(id));
        }
        else if(type.equals("DLL")){
           
           customerDLL.remove(Integer.parseInt(id));
        }
        else if(type.equals("BST")){
            
            return;
        }
        else if(type.equals("AVL")){
            return;
        }
    }
       
    public static String getType(){
        return type;
    }
    
    private static void setVideoInStore(String s, String id){
       if(type.equals("SLL")){
           Node n = new Node(Integer.parseInt(id),new Video(s, id),null); 
           videoInStoreSLL.add(n);
        }
        else if(type.equals("DLL")){
           DNode n = new DNode(Integer.parseInt(id),new Video(s, id),null, null); 
           videoInStoreDLL.addLast(n);
           
        }
        else if(type.equals("BST")){
            BSTNode n = new BSTNode(Integer.parseInt(id), new Video(id,s));
            videoInStoreBST.insert(Integer.parseInt(id), n);
            
        }
        /*else if(type.equals("AVL")){
           AVLNode n = new AVLNode(Integer.parseInt(s), new Video(id,s));
           videoInStoreAVL.insert()
        }*/
    }
    private static void setCustomer(String s,String id) {
        if(type.equals("SLL")){
           Node n = new Node(Integer.parseInt(id),new Customer(s, id),null); 
           n.getElement();
           customerSLL.add(n);
        }
        else if(type.equals("DLL")){
           DNode n = new DNode(Integer.parseInt(id), new Customer(s, id),null, null); 
           customerDLL.addLast(n);
           
        }
        else if(type.equals("BST")){
            BSTNode b = new BSTNode( new Customer(s, id)); 
           
            return;
        }
        else if(type.equals("AVL")){
            return;
        }
    }
    
    private static void printAllCustomers(){
        if(type.equals("SLL")){
           customerSLL.print();
        }
        else if(type.equals("DLL")){
           
           customerDLL.print();
        }
        else if(type.equals("BST")){
            customerBST.print();
            
        }
        else if(type.equals("AVL")){
            customerAVL.print();
        }
    }
    private static void printAllVideos(){
        if(type.equals("SLL")){
           videoInStoreSLL.print();
        }
        else if(type.equals("DLL")){
           
           videoInStoreDLL.print();
        }
        else if(type.equals("BST")){
            videoInStoreBST.print();
            
        }
        else if(type.equals("AVL")){
            videoInStoreAVL.print();
        }
    }
    private static void printAllRentVideos(){
        
    }
    private static void printVideosRentByACustomer(){
        
    }
    private static void removeVideo(String s){
        if(type.equals("SLL")){
           // Object current = videoInStoreSLL.getHead().getElement().getID();

           videoInStoreSLL.removeElement(Integer.parseInt(s));
        }
        else if(type.equals("DLL")){
           videoInStoreDLL.remove(Integer.parseInt(s));
           
        }
        else if(type.equals("BST")){
            
            return;
        }
        else if(type.equals("AVL")){
            return;
        }
    }

    private static void checkOut(int cid, int vid) {
        
        if(type.equals("SLL")){
           
           
         // Video v = removeVideo();
        }
        else if(type.equals("DLL")){
           customerDLL.remove(vid);
           
        }
        else if(type.equals("BST")){
            
            return;
        }
        else if(type.equals("AVL")){
            return;
        }
        
       
    }

    private static void checkIn(int vid2) {
        
        
        if(type.equals("SLL")){
           // Object current = videoInStoreSLL.getHead().getElement().getID();

           
        }
        else if(type.equals("DLL")){
           
           
        }
        else if(type.equals("BST")){
            
            return;
        }
        else if(type.equals("AVL")){
            return;
        }
       
    }
    private static void printInStoreVideos() {
        if(type.equals("SLL")){
           videoInStoreSLL.print();
        }
        else if(type.equals("DLL")){
           
           videoInStoreDLL.print();
        }
        else if(type.equals("BST")){
            videoInStoreBST.print();
            
        }
        else if(type.equals("AVL")){
            videoInStoreAVL.print();
        }
    }

    private static boolean check(int id) {
       if(type.equals("SLL")){
           return videoInStoreSLL.find(id);
        }
        else if(type.equals("DLL")){
           
          return videoInStoreDLL.find(id);
        }
        else if(type.equals("BST")){
            return videoInStoreBST.find(id);
            
        }
        else{
          return videoInStoreAVL.find(id);
        }
    }
   
    
}



