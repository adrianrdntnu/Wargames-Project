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
}
