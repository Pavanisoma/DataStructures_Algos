
import java.io.*;
import java.util.*;

import jdk.internal.util.xml.impl.Pair;

// "static void main" must be defined in a public class.

 class parkingspace{
    int floor;
    int slot;
    parkingspace( int floor,  int slot) {
        this.floor = floor;
        this.slot = slot;
    }
}

public class parkingLot {

    int floorcapacity;
    int slotcapacity;

    PriorityQueue<parkingspace> queue;

    parkingLot(final int floorcapacity, final int slotcapacity) {
        this.floorcapacity = floorcapacity;
        this.slotcapacity = slotcapacity;

        queue = new PriorityQueue<>((floorcapacity * slotcapacity), new Comparator<parkingspace>() {
            @Override
            public int compare(final parkingspace a, final parkingspace b) {
                if (a.floor == b.floor) {
                    return a.slot - b.slot;
                } else {
                    return a.floor - b.floor;
                }
            }
        });

        for (int i = 0; i < floorcapacity; i++) {
            for (int j = 0; j < slotcapacity; j++) {
                queue.add(new parkingspace(i, j));
                System.out.println("i "+i+","+"j "+j);
            }
        }
    }

    public parkingspace park() {
        final parkingspace currentslot = queue.poll();
        if (currentslot == null) {
            System.out.println("check this out");
        }
        return currentslot;
    }

    public void unpark(final int floor, final int slot) {
        final parkingspace vehicle = new parkingspace(floor, slot);
        queue.add(vehicle);
    }

    public String status() {
        return "Available: " + queue.size();
    }

    public static void main(final String[] args) {
        System.out.println("Hello World!");
        parkingLot v = new parkingLot(3, 4);
        parkingspace puser1;
        puser1 = v.park();
        v.status();
         } 
}