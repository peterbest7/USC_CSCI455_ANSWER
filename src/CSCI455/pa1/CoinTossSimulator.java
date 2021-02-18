package CSCI455.pa1;
import java.util.Random;

/**
 * class CoinTossSimulator
 *
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 *
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants,
 * and private methods to the class.  You will also be completing the
 * implementation of the methods given.
 *
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 *
 */
public class CoinTossSimulator {
    private int sumUp ;
    private int sumDown ;
    private int sumEach ;
    private int trials ;
    Coin coin;
    Coin coin2;
    private class Coin{
        private Random generator;
        private int sides;
        public  Coin(int s){
            sides = s;
            generator = new Random();
        }
        public int cast(){
            return 0 + generator.nextInt(sides);
        }
    }

    /**
     Creates a coin toss simulator with no trials done yet.
     */
    public CoinTossSimulator() {
        sumUp=0;
        sumDown=0;
        sumEach=0;
        trials=0;
        coin = new Coin(2);
        coin2 = new Coin(2);

    }
    /**
     Runs the simulation for numTrials more trials. Multiple calls to this method
     without a reset() between them *add* these trials to the current simulation.

     @param numTrials  number of trials to for simulation; must be >= 1
     */
    public void run(int numTrials) {

        trials += numTrials;
        for(int i = 0; i< numTrials;++i){

            int n1 = coin.cast();
            int n2 = coin2.cast();
            if(n1 + n2 == 1){
                sumEach++;
            }
            else if(n1 == 1 && n2 == 1){
                sumUp++;
            }
            else if(n2 == 0 && n1 == 0){
                sumDown++;
            }
        }
    }
    /**
     Get number of trials performed since last reset.
     */
    public int getNumTrials() {
        return getTwoHeads() + getTwoTails() + getHeadTails();
        // DUMMY CODE TO GET IT TO COMPILE
    }
    /**
     Get number of trials that came up two heads since last reset.
     */
    public int getTwoHeads() {
        return sumUp; // DUMMY CODE TO GET IT TO COMPILE
    }
    /**
     Get number of trials that came up two tails since last reset.
     */
    public int getTwoTails() {
        return sumDown; // DUMMY CODE TO GET IT TO COMPILE
    }
    /**
     Get number of trials that came up one head and one tail since last reset.
     */
    public int getHeadTails() {
        return sumEach; // DUMMY CODE TO GET IT TO COMPILE
    }
    /**
     Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {
        trials = 0;
        sumDown = 0;
        sumUp = 0;
        sumEach = 0;
    }

    public static void main(String[] args) {
        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        coinTossSimulator.run(2147483647);
        System.out.println(coinTossSimulator.getTwoTails());
    }
}

