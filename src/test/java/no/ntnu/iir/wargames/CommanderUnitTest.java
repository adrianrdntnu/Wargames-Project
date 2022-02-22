package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommanderUnitTest {

  @Test
  public void testCreationOfUnitWithGoodParameters(){
    CommanderUnit commanderUnit = new CommanderUnit("John", 40);
    assertEquals("John", commanderUnit.getName());
    assertEquals(40, commanderUnit.getHealth());
  }
}
