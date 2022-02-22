package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RangedUnitTest {

  @Test
  public void testCreationOfUnitWithGoodParameters(){
    RangedUnit rangedUnit = new RangedUnit("John", 40);
    assertEquals("John", rangedUnit.getName());
    assertEquals(40, rangedUnit.getHealth());
  }
}
