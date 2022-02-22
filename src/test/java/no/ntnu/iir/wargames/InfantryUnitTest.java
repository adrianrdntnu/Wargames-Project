package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InfantryUnitTest {

  @Test
  public void testCreationOfUnitWithGoodParameters(){
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    assertEquals("John", infantryUnit.getName());
    assertEquals(40, infantryUnit.getHealth());
  }
}
