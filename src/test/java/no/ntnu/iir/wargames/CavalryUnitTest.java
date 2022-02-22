package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CavalryUnitTest {

  @Test
  public void testCreationOfUnitWithGoodParameters(){
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    assertEquals("John", cavalryUnit.getName());
    assertEquals(40, cavalryUnit.getHealth());
  }

  @Test
  public void testCavalryUnitBonusAttack(){
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    assertEquals(6, cavalryUnit.getAttackBonus());
    assertEquals(2, cavalryUnit.getAttackBonus());
    assertEquals(2, cavalryUnit.getAttackBonus());
  }
}
