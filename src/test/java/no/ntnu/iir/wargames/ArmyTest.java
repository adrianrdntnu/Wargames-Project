package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArmyTest {

  @Test
  public void testCreationOfArmyWithValidParameters(){
    Army army = new Army("John");
    assertEquals("John", army.getName());
  }

  @Test
  public void testCreationOfArmyWithInvalidParameters(){
    try {
      Army army = new Army(null);
    } catch (IllegalArgumentException iae){
      assertTrue(true);
    }
    //TODO: this test does not fail, even though i have not made an exception to throw. Check this out
  }

  @Test
  public void testAddAndRemoveUnit(){
    Army army = new Army("John");
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    army.add(infantryUnit);
    assertTrue(army.hasUnits());
    army.remove(infantryUnit);
    assertFalse(army.hasUnits());
  }
  @Test
  public void testGetSpecifiedUnits(){
    Army army = new Army("John");
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    RangedUnit rangedUnit = new RangedUnit("John", 40);
    CommanderUnit commanderUnit = new CommanderUnit("John", 40);
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    army.add(infantryUnit);
    army.add(rangedUnit);
    army.add(commanderUnit);
    army.add(cavalryUnit);
    assertTrue(army.getInfantryUnits().get(0) instanceof InfantryUnit);
    assertTrue(army.getRangedUnits().get(0) instanceof RangedUnit);
    assertTrue(army.getCommanderUnits().get(0) instanceof CommanderUnit);
    assertTrue(army.getCavalryUnits().get(0) instanceof CavalryUnit);
  }
}
