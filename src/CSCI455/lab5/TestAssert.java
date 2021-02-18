package CSCI455.lab5;

import java.util.ArrayList;
import java.util.List;

public class TestAssert {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList();
        arrayList2.add(1);
        arrayList1.add(-1);
        Bookshelf bookshelf1 = new Bookshelf(arrayList1);
        System.out.println(bookshelf1.toString());
        Bookshelf bookshelf2 = new Bookshelf(arrayList2);
        System.out.println(bookshelf2.toString());
        bookshelf1.addFront(-6);
    }
}
