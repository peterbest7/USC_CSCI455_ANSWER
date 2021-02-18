package CSCI455.pa1;



import javax.swing.*;
import java.awt.*;

public class CoinSimComponent extends JComponent {
    private int sumUpCoin;
    private int sumDownCoin;
    private int sumEachCoin ;
    private int trialsNum;
    private int heightComponent;
    private int widthComponent;
    private int rateOfHeads;
    private int rateOfTails;
    private int rateOfEach;
    private final int BUFFER = 30;
    private final int WIDTH = 60;
    private double percent;
    private int  height1;
    private int  height2;
    private int  height3;
    public void paintComponent(Graphics g) {
        Graphics2D g2  =(Graphics2D) g;
        heightComponent = getHeight();
        widthComponent = getWidth();
        rateOfHeads = (int)Math.round(((sumUpCoin*1.0)/trialsNum)*100);
        rateOfTails = (int)Math.round(((sumDownCoin*1.0)/trialsNum)*100);
        rateOfEach = (int)Math.round(((sumEachCoin*1.0)/trialsNum)*100);
        percent = 100.0/(heightComponent-(2*BUFFER));
        height1 = (int)(rateOfHeads/percent);
        height2 = (int)(rateOfEach/percent);
        height3 = (int) (rateOfTails/percent);
        Bar bar1 = new Bar(heightComponent-BUFFER,1*widthComponent/4-WIDTH/2,WIDTH,rateOfHeads,percent,Color.RED,"Two Heads: "+sumUpCoin+"("+rateOfHeads+"%)");
        Bar bar2 = new Bar(heightComponent-BUFFER,2*widthComponent/4-WIDTH/2,WIDTH,rateOfEach,percent,Color.GREEN,"A Head and a Tail: "+sumEachCoin+"("+rateOfEach+"%)");
        Bar bar3 = new Bar(heightComponent-BUFFER,3*widthComponent/4-WIDTH/2,WIDTH,rateOfTails,percent,Color.BLUE,"Two Heads: "+sumDownCoin+"("+rateOfTails+"%)");
        bar1.draw(g2);
        bar2.draw(g2);
        bar3.draw(g2);
    }

    public  void runTrials(int numTrials){
        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        coinTossSimulator.run(numTrials);
        trialsNum = coinTossSimulator.getNumTrials();
        sumUpCoin = coinTossSimulator.getTwoHeads();
        sumDownCoin = coinTossSimulator.getTwoTails();
        sumEachCoin = coinTossSimulator.getHeadTails();
    }
}
