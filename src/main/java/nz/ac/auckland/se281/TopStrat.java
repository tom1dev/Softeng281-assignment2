package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Collections;

public class TopStrat implements AiStratigy {

  private int finger;
  private int sum;
  private int avgPersonFinger;
  private Person player;

  // sets the player used in calculations
  public TopStrat(Person player) {
    this.player = player;
  }

  // calculates the ammount of fingers the ai outputs
  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(1, 5);
    return finger;
  }

  @Override
  public int getSum() {
    // sets the person fingers array to the arraylist of fingers in player dataset
    ArrayList<Integer> personFingers = player.getPlayerFingerPicks();

    // finds the median player fingers then calculates the sum
    avgPersonFinger = getMedianPersonFingers(personFingers);
    sum = avgPersonFinger + finger;
    return sum;
  }

  public int getMedianPersonFingers(ArrayList<Integer> personFingers) {
    // creates a 2d array list so store the designated finger and their freqeuncy.
    ArrayList<ArrayList<Integer>> frequency = new ArrayList<ArrayList<Integer>>();
    int highestFrequency = 0;

    // appends freqency of a finger and finger amount into an arrayList, and finds the highest
    // frequency
    for (int a = 1; a < 6; a += 1) {
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(a);
      temp.add(Collections.frequency(personFingers, a));
      frequency.add(temp);

      if (highestFrequency <= frequency.get(a - 1).get(1)) {
        highestFrequency = frequency.get(a - 1).get(1);
      }
    }

    // find which finger has highest frequency
    for (int i = 0; i < frequency.size(); i += 1) {
      if (frequency.get(i).get(1) == highestFrequency) {
        return frequency.get(i).get(0);
      }
    }

    return -1;
  }
}
