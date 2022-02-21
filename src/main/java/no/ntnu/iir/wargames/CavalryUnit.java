package no.ntnu.iir.wargames;

/**
 * A close-ranged unit with bonus attack on it's first attack.
 */
public class CavalryUnit extends Unit {
  private boolean hasAttacked;

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   * @param attack Attack value
   * @param armor  Resistance to attacks
   */
  protected CavalryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
    this.hasAttacked = false;
  }

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   */
  protected CavalryUnit(String name, int health) {
    super(name, health, 20, 12);
    this.hasAttacked = false;
  }

  /**
   * Returns the bonus attack, unit starts with a higher bonus attack on
   * it's first attack.
   *
   * @return The bonus attack
   */
  public int getAttackBonus() {
    int firstAttackBonus = 4;
    if (this.hasAttacked) {
      firstAttackBonus = 0;
    }
    this.hasAttacked = true;
    return 2 + firstAttackBonus;
  }

  public int getResistBonus() {
    return 1;
  }
}
