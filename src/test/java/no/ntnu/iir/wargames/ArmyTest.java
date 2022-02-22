package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArmyTest {

  @Test
  public void testCreationOfArmyWithGoodParameters(){
    Army army = new Army("John");
    assertEquals("John", army.getName());
  }

  @Test
  public void testAddAndRemoveUnit(){
    Army army = new Army("John");
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    army.add(infantryUnit);
    assertEquals(true, army.hasUnits());
    army.remove(infantryUnit);
    assertEquals(false, army.hasUnits());
  }

}
