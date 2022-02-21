package no.ntnu.iir.wargames;

/**
 * A stronger version of CavalryUnit.
 */
public class CommanderUnit extends CavalryUnit {
  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   * @param attack Attack value
   * @param armor  Resistance to attacks
   */
  protected CommanderUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   */
  protected CommanderUnit(String name, int health) {
    super(name, health, 25, 15);
  }
}
