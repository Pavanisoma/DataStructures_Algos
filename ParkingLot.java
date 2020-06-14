
import java.io.*;
import java.util.*;

import jdk.internal.util.xml.impl.Pair;

// "static void main" must be defined in a public class.
public class Main {
  public static class parkingspace{
     int floor;
     int slot;
     parkingspace(int floor,int slot){
         this.floor=floor;
         this.slot=slot;
     }
 }  
    int floorcapacity;
    int slotcapacity;
    
    PriorityQueue<parkingspace> queue;
    
    public void parkinglotdesign(int floorcapacity,int slotcapacity){
        this.floorcapacity=floorcapacity;
        this.slotcapacity=slotcapacity;
        
       queue=new PriorityQueue<>((floorcapacity*slotcapacity),new Comparator<parkingspace>(){
        @Override
        public int compare(parkingspace a,parkingspace b){
            if(a.floor ==b.floor){
                return a.slot-b.slot;
            }
            else{
               return a.floor - b.floor;
            }
        }
    }
    ); 
    }

   public parkingspace park(){
       parkingspace currentslot=queue.poll();
       if(currentslot == null){
           throw new IllegalStateException("Parking Lot is full");
       }
       return currentslot;
   }
    public void unpark(int floor,int slot){
        parkingspace vehicle=new parkingspace(floor,slot);
        queue.add(vehicle);
    }
    
    public String status(){
        return "Available: "+queue.size();
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main v=new Main(4,3);
        parkingspace user1;
        user1 = v.park();
        v.status();
         } 
}