package com.epam.rd.java.basic.practice6.part3;


import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final int capacity;
    private int carsParked = 0;
    List<Boolean> list = new ArrayList<>();
     public Parking(int capacity) {
        this.capacity = capacity;
        for (int i = 0;i<capacity;i++)
        {
            list.add(false);
        }
    }

    public boolean arrive(int k) {
         if(k>=capacity)
            throw new IllegalArgumentException();
         if (carsParked>capacity)
            return false;
         if(!list.get(k)) {
             list.set(k, true);
             carsParked++;
             return true;
         }
        for(;k<capacity;k++)
        {
            if(!list.get(k))
            {
                list.set(k,true);
                carsParked++;
                return true;
            }
        }
        for (int i = 0; i<k;i++) {
            if (!list.get(i))
            {
                list.set(i,true);
                carsParked++;
                return true;
            }
        }
        return false;
    }
    
    public boolean depart(int k) {
         if(capacity<=k)
             throw new IllegalArgumentException();
         if(list.get(k)) {
             list.set(k, false);
              return true;
         }
        return false;
    }
    
    public void print() {
        for (Boolean b:list) {
            if(b) {
                System.out.print(1);
            }
            else {
                System.out.print(0);
            }
        }
    }
}
