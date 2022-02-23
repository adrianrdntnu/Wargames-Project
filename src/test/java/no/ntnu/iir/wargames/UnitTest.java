package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTest {

  @Test
  public void testCreationOfUnitWithValidParameters(){
    DummyUnit dummyUnit = new DummyUnit("John", 40, 4, 4);
    assertEquals("John", dummyUnit.getName());
    assertEquals(40, dummyUnit.getHealth());
    assertEquals(4, dummyUnit.getAttack());
    assertEquals(4, dummyUnit.getArmor());
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
  public void testCavalryUnitBonusAttack(){
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    assertEquals(6, cavalryUnit.getAttackBonus());
    assertEquals(2, cavalryUnit.getAttackBonus());
    assertEquals(2, cavalryUnit.getAttackBonus());
  }
}
