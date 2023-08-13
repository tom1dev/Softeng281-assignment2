package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Person {
  private String name;
  private ArrayList<Integer> sums;
  private ArrayList<Integer> fingers;

  // initialises fields used
  public Person(String name) {
    this.sums = new ArrayList<Integer>();
    this.fingers = new ArrayList<Integer>();
    this.name = name;
  }

  public Integer[] getPlayerChoices() {
    // initalises variables for the loop
    boolean incorrentNumbers = true;
    boolean isNotNumber = true;
    Integer[] personChoices = new Integer[2];

    // if the current input is not a number or isn't in the correct range of numbers it countinues
    // looping
    while (incorrentNumbers || isNotNumber) {

      // resets variables in loop
      int personFingerTemp = -1;
      int personSumTemp = -1;
      String personFingerTempStr;
      String personSumTempStr;

      // gets input and splits it if it can be otherwise it pruduces variables that will loop again
      String input = Utils.scanner.nextLine();

      if (input.contains(" ")) {
        String[] inputSplit = input.split(" ", 2);

        personFingerTempStr = inputSplit[0];
        personSumTempStr = inputSplit[1];
      } else {
        personFingerTempStr = "";
        personSumTempStr = "";
      }

      // checks if inputs are integers
      if (Utils.isInteger(personFingerTempStr) && Utils.isInteger(personSumTempStr)) {
        isNotNumber = false;
        personFingerTemp = Integer.parseInt(personFingerTempStr);
        personSumTemp = Integer.parseInt(personSumTempStr);
      }

      // checks if inputs are in valid range if they are integers
      if ((personFingerTemp > 0 && personFingerTemp < 6)
          && (personSumTemp > 0 && personSumTemp < 11)) {
        incorrentNumbers = false;
        personChoices[0] = personFingerTemp;
        personChoices[1] = personSumTemp;
      }

      // prints error message if either condition is not met
      if (incorrentNumbers || isNotNumber) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    return personChoices;
  }

  // adds the current rounds player inputs into their respective array lists
  public void setRndInputs(int finger, int sum) {

    fingers.add(finger);
    sums.add(sum);
  }

  // returns the fingers arrayList
  public ArrayList<Integer> getPlayerFingerPicks() {
    return fingers;
  }

  // clears the values in the arrayLists
  public void clear() {
    sums.clear();
    fingers.clear();
  }

  // outputs the persons name
  public String getName() {
    return name;
  }
}
