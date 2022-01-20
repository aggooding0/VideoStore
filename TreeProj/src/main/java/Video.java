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
public class Video {
    private String title;
    private String id;


    public Video(String title, String id){
        this.id = id;
        this.title = title;
          
    }

    
    public String getTitle(){
        return this.title;
    }
    public String getID(){
        return this.id;
    }
    public String toString(){
        
        String print = "Video title: "+ title+" Video ID "+id;
        return print;
    }
}
