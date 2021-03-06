package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CavalryUnitTest {

  @Test
  public void testCreationOfUnitWithValidParameters(){
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    assertEquals("John", cavalryUnit.getName());
    assertEquals(40, cavalryUnit.getHealth());
  }

  @Test
  public void testCreationOfUnitWithInvalidParameters(){
    try {
      CavalryUnit cavalryUnit = new CavalryUnit("", 40);
    } catch (IllegalArgumentException iae){
      assertTrue(true);
    }
  }

  @Test
  public void testCavalryUnitBonusResistance(){
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    assertEquals(1, cavalryUnit.getResistBonus());
  }

  @Test
  public void testCavalryUnitBonusAttack(){
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    assertEquals(6, cavalryUnit.getAttackBonus());
    assertEquals(2, cavalryUnit.getAttackBonus());
    assertEquals(2, cavalryUnit.getAttackBonus());
  }
}
