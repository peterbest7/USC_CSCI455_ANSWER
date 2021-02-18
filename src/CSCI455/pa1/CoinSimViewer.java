package CSCI455.pa1;

import javax.swing.*;

import java.util.Scanner;

public class CoinSimViewer {
    public static void main(String[] args) {
        System.out.print("Enter number of trials: ");
        Scanner in = new Scanner(System.in);
        int trails = in.nextInt();
        while(trails<=0){
            System.out.println("ERROR: Number entered must be greater than 0.");
            System.out.print("Please enter the correct number of trails: ");
            trails =in.nextInt();
        }
        JFrame frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Trials Coins");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CoinSimComponent component = new CoinSimComponent();
        component.runTrials(trails);
        frame.add(component);
        frame.setVisible(true);
    }
}
