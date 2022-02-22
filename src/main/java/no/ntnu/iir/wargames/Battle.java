package no.ntnu.iir.wargames;

/**
 * A simulator that sets up a fight between two armies.
 *
 * @author Adrian R. Dahl
 * @version 22.02.2022
 */
public class Battle {
  Army armyOne;
  Army armyTwo;


  /**
   * Creates a battle.
   *
   * @param armyOne First army to fight
   * @param armyTwo Second army to fight
   */
  public Battle(Army armyOne, Army armyTwo) {
    this.armyOne = armyOne;
    this.armyTwo = armyTwo;
  }

  /**
   * Simulates a fight between the two armies
   * and returns the winner.
   *
   * @return The army that won
   */
  public Army simulate() {
    boolean fighting = true;
    int counter = 0;
    while (fighting) {
      //Each army attack the other army every other loop
      if (counter % 2 == 0) { //armyOne attacks armyTwo
        Unit attacker = armyOne.getRandom();
        Unit defender = armyTwo.getRandom();
        attacker.attack(defender);
        if (defender.getHealth() <= 0) {
          armyTwo.remove(defender);
        }
      } else { //armyTwo attacks armyOne
        Unit attacker = armyTwo.getRandom();
        Unit defender = armyOne.getRandom();
        attacker.attack(defender);
        if (defender.getHealth() <= 0) {
          armyOne.remove(defender);
        }
      }
      counter++;

      //Stops while loop if one of the armies have no more units
      if (!armyOne.hasUnits() || !armyTwo.hasUnits()) {
        fighting = false;
      }
    }
    //Checks which army has units left and is the winner
    Army winningArmy;
    if (armyOne.hasUnits()) {
      winningArmy = armyOne;
    } else {
      winningArmy = armyTwo;
    }
    return winningArmy;
  }

  /**
   * Returns a string representation of the battle.
   *
   * @return a string representation of the battle
   */
  @Override
  public String toString() {
    return "Battle{"
        + "armyOne=" + armyOne
        + ", armyTwo=" + armyTwo
        + '}';
  }
}
