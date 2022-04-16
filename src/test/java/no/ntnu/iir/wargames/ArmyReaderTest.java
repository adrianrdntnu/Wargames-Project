package no.ntnu.iir.wargames;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArmyReaderTest {

  @Test
  public void testReadAndWriteToFile(){
    Army army = new Army("John");
    InfantryUnit infantryUnit = new InfantryUnit("John", 40);
    RangedUnit rangedUnit = new RangedUnit("John", 40);
    CommanderUnit commanderUnit = new CommanderUnit("John", 40);
    CavalryUnit cavalryUnit = new CavalryUnit("John", 40);
    army.add(infantryUnit);
    army.add(rangedUnit);
    army.add(commanderUnit);
    army.add(cavalryUnit);

    ArmyReader reader = new ArmyReader();
    reader.writeArmy(army, "testArmy.csv");
    Army army2 = reader.readArmy("testArmy.csv");
    assertEquals("John", army2.getName());
    assertEquals(40, army2.getInfantryUnits().get(0).getHealth());
  }
}
