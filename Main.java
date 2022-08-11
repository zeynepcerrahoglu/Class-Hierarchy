package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Object> l1 = new ArrayList<>();
        l1.add("251333333");
        ArrayList<Object> l2 = new ArrayList<>();
        l2.add("4646464646");
        CustomerInfo c1 = new CustomerInfo("irem", "Çorum", l1);
        CustomerInfo c2 = new CustomerInfo("Irmak", "ankara", l2);
        CustomerInfo c3 = new CustomerInfo("Ahmet", "izmir", l2);

        DoublyLinkedList list = new DoublyLinkedList();
        list.ekleme(c1);
        list.ekleme(c2);
        list.ekleme(c3);

        list.kisiSilme("Ahmet");
        list.alfabetikSiraylaYazdirma();



    }
}
