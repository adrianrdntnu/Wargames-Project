package no.ntnu.iir.wargames;

/**
 * A well-balanced unit good at close-ranged combat.
 */
public class InfantryUnit extends Unit {
  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   * @param attack Attack value
   * @param armor  Resistance to attacks
   */
  protected InfantryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   */
  protected InfantryUnit(String name, int health) {
    super(name, health, 15, 10);
  }

  public int getAttackBonus() {
    return 2;
  }

  public int getResistBonus() {
    return 1;
  }
}
