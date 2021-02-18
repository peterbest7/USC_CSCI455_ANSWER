package CSCI455.pa1;

import java.util.Scanner;

public class CoinTossSimulatorTester {
    public static void main(String[] args) {
        int sum = 0;
        boolean flag = true;
        int enterNum;
        String reset;
        String exit;
        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        System.out.println("After constructor: ");
        System.out.println("Number of trials [exp:0]: " + coinTossSimulator.getNumTrials() );
        System.out.println("Two-head tosses: " +coinTossSimulator.getTwoHeads());
        System.out.println("Two-tail tosses: "+coinTossSimulator.getTwoTails());
        System.out.println("One-head one-tail tosses: " +coinTossSimulator.getHeadTails());
        if(coinTossSimulator.getNumTrials()==0){
            flag =true;
        }
        else{
            flag =false;
        }
        System.out.println("Tosses add up correctly? " + flag);
        System.out.println("===================================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of trials: ");
        enterNum = scanner.nextInt();
        while (enterNum>0){
            System.out.println("After run: "+enterNum);
            coinTossSimulator.run(enterNum);
            sum +=  enterNum;
            System.out.println("Number of trials [exp: "+sum+"]:"  + coinTossSimulator.getNumTrials() );
            System.out.println("Two-head tosses: " +coinTossSimulator.getTwoHeads());
            System.out.println("Two-tail tosses: "+coinTossSimulator.getTwoTails());
            System.out.println("One-head one-tail tosses: " +coinTossSimulator.getHeadTails());
            if(coinTossSimulator.getNumTrials()==sum){
                flag =true;
            }
            else{
                flag =false;
            }
            System.out.println("Tosses add up correctly? " + flag);
            System.out.println("===================================================");
            System.out.print("Whether you want to exit: Y/N ");
            exit =scanner.next();
            if(exit.equals("Y")){
                System.out.println("Exit");
                break;
            }
            System.out.print("Whether you want to reset: Y/N ");
            reset = scanner.next();
            if(reset.equals("Y")){
                coinTossSimulator.reset();
                sum=0;
                System.out.println("After reset: ");
                System.out.println("Number of trials [exp:0]: " + coinTossSimulator.getNumTrials() );
                System.out.println("Two-head tosses: " +coinTossSimulator.getTwoHeads());
                System.out.println("Two-tail tosses: "+coinTossSimulator.getTwoTails());
                System.out.println("One-head one-tail tosses: " +coinTossSimulator.getHeadTails());
                if(coinTossSimulator.getNumTrials()==0){
                    flag =true;
                }
                else{
                    flag =false;
                }
                System.out.println("Tosses add up correctly? " + flag);
                System.out.println("===================================================");
            }
            System.out.print("Enter number of trials: ");
            enterNum = scanner.nextInt();

        }



    }

}
