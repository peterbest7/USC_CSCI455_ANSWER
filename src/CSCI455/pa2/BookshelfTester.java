package CSCI455.pa2;

import java.util.ArrayList;

public class BookshelfTester {
    public static void main(String[] args) {
        Bookshelf sortBookshelf = new Bookshelf();
        System.out.println(sortBookshelf.toString());
        ArrayList<Integer> arrayList =new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);

        Bookshelf bookshelf = new Bookshelf(arrayList);
        System.out.println(bookshelf.toString());
        bookshelf.addFront(1);
        System.out.println(bookshelf.toString());
        bookshelf.addLast(11);
        System.out.println(bookshelf.toString());
        System.out.println(bookshelf.getHeight(2));
        bookshelf.removeFront();
        System.out.println(bookshelf.toString());
        bookshelf.removeLast();
        System.out.println(bookshelf.toString());
        System.out.println(bookshelf.size());
        boolean flag2 = bookshelf.isSorted();
        System.out.println(flag2);
        System.out.println("=============================================================================");
       sortBookshelf.addFront(1);
        System.out.println(sortBookshelf.toString());
       sortBookshelf.addLast(3);
        System.out.println(sortBookshelf.toString());
       sortBookshelf.addFront(1);
        System.out.println(sortBookshelf.toString());
       sortBookshelf.addLast(4);
        System.out.println(sortBookshelf.toString());
        sortBookshelf.removeLast();
        System.out.println(sortBookshelf.toString());
        sortBookshelf.removeFront();
        System.out.println(sortBookshelf.toString());

        System.out.println( sortBookshelf.getHeight(1));
        System.out.println(sortBookshelf.size());
        boolean flag = sortBookshelf.isSorted();
        System.out.println(flag);


    }
}
