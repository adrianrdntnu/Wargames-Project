package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InfantryUnitTest {

  @Test
  public void testCreationOfUnitWithValidParameters(){
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    assertEquals("John", infantryUnit.getName());
    assertEquals(40, infantryUnit.getHealth());
  }

  @Test
  public void testCreationOfUnitWithInvalidParameters(){
    try {
      InfantryUnit infantryUnit = new InfantryUnit("", 40);
    } catch (IllegalArgumentException iae){
      assertTrue(true);
    }
  }

  @Test
  public void testInfantryUnitBonusResistance(){
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    assertEquals(1, infantryUnit.getResistBonus());
  }

  @Test
  public void testInfantryUnitBonusAttack(){
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    assertEquals(2, infantryUnit.getAttackBonus());
  }
}
