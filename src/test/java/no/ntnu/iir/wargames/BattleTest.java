package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BattleTest {

  @Test
  public void testSimulation(){
    Army armyOne = new Army("Army1");
    Army armyTwo = new Army("Army2");
    InfantryUnit infantryUnit1 = new InfantryUnit("John", 40);
    armyOne.add(infantryUnit1);
    InfantryUnit infantryUnit2 = new InfantryUnit("John2", 1);
    armyTwo.add(infantryUnit2);
    Battle battle = new Battle(armyOne, armyTwo);
    assertEquals(armyOne, battle.simulate());
  }

  //TODO: pretty sure this test can be better, and should have a negative test too (?)

}
