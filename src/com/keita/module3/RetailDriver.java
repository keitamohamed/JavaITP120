package com.module3;

import com.module3.blueprint.RetailItem;

import java.util.ArrayList;
import java.util.List;

public class RetailDriver {

    public static void main(String[] args) {

        List<RetailItem> list = new ArrayList<>();

        list.add(new RetailItem("Jacket", 12, 59.95));
        list.add(new RetailItem("Designer Jeans", 40, 34.95));
        list.add(new RetailItem("Shirt", 20, 24.95));

        RetailItem r1 = new RetailItem("Jacket", 12, 59.95);
        RetailItem r2 = new RetailItem("Designer Jeans", 40, 34.95);
        RetailItem r3 = new RetailItem("Shirt", 20, 24.95);

        list.forEach(r -> System.out.println(r.toString()));
        System.out.println("\nWithout using ArrayList\n" +
                "--------------------------------------------");
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());
    }
}
