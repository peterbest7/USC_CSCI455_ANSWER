package CSCI455.lab5.pa2;

import java.util.ArrayList;
import java.util.Scanner;

public class BookshelfKeeperProg{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Bookshelf bookshelf1;
        BookshelfKeeper bookshelfKeeper =null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter initial arrangement of books followed by newline: ");
        String str = "";
        boolean flag = true;
        try {
            str = scanner.nextLine();
            String str2=str.trim();
            String str3= str2.replaceAll(" {2,}", " ");
            String strs[] = str3.split("\\s");
            int[] array = new int[strs.length];
            for (int i = 0; i < strs.length; ++i) {
                array[i] = Integer.parseInt(strs[i]);
                if(array[i]<=0){
                    flag=false;
                }
            }
            for (int i : array) {
                list.add(i);
            }
        } catch (Exception e) { }
        try{
            bookshelf1 = new Bookshelf(list);
            bookshelfKeeper = new BookshelfKeeper(bookshelf1);
            if(flag){
                System.out.println(bookshelfKeeper.toString());
                System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
            }
        }catch (Error error){ }
        finally {
            while (scanner.hasNext()) {
                str = scanner.nextLine();
                String str2=str.trim();

                    str2=str2.replace("\t","");
                    String str3= str2.replaceAll(" {2,}", " ");

                    String[]strs1 = str3.split("\\s");


                String str_1;
                String str_2;
                if (strs1.length <= 1) {
                    str_1 = "";
                    str_2 = "";
                } else {
                    str_1 = strs1[0];
                    str_2 = strs1[1];
                }
                if (str_1.equals("put")) {
                    int input = Integer.parseInt(str_2);
                    try {
                        bookshelfKeeper.putHeight(input);
                        System.out.println(bookshelfKeeper.toString());
                    } catch (Error error) { }
                }
                else if (str_1.equals("pick")) {
                    try {
                        bookshelfKeeper.pickPos(Integer.parseInt(str_2));
                        System.out.println(bookshelfKeeper.toString());
                    } catch (Error error) { }
                }
               else if (str.equals("end")) {
                    System.out.println("Exiting Program.");
                    break;
                }
               else {
                    System.out.println("ERROR: Operation should be either pick or put.");
                }
            }
        }
    }
}
