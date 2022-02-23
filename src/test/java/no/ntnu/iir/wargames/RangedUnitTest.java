package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RangedUnitTest {

  @Test
  public void testCreationOfUnitWithValidParameters(){
    RangedUnit rangedUnit = new RangedUnit("John", 40);
    assertEquals("John", rangedUnit.getName());
    assertEquals(40, rangedUnit.getHealth());
  }

  @Test
  public void testCreationOfUnitWithInvalidParameters(){
    try {
      RangedUnit rangedUnit = new RangedUnit("", 40);
    } catch (IllegalArgumentException iae){
      assertTrue(true);
    }
  }

  @Test
  public void testRangedUnitBonusResistance(){
    RangedUnit rangedUnit = new RangedUnit("John", 40);
    assertEquals(6, rangedUnit.getResistBonus());
    assertEquals(4, rangedUnit.getResistBonus());
    assertEquals(2, rangedUnit.getResistBonus());
    assertEquals(2, rangedUnit.getResistBonus());
  }

  @Test
  public void testRangedUnitBonusAttack(){
    RangedUnit rangedUnit = new RangedUnit("John", 40);
    assertEquals(3, rangedUnit.getAttackBonus());
  }
}
