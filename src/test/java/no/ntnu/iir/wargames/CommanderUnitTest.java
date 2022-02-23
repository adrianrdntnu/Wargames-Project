package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommanderUnitTest {

  @Test
  public void testCreationOfUnitWithValidParameters(){
    CommanderUnit commanderUnit = new CommanderUnit("John", 40);
    assertEquals("John", commanderUnit.getName());
    assertEquals(40, commanderUnit.getHealth());
  }

  @Test
  public void testCreationOfUnitWithInvalidParameters(){
    try {
      CommanderUnit commanderUnit = new CommanderUnit("", 40);
    } catch (IllegalArgumentException iae){
      assertTrue(true);
    }
  }
}
