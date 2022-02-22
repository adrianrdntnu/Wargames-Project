package no.ntnu.iir.wargames;

/**
 * A unit good at ranged attacks.
 *
 * @author Adrian R. Dahl
 * @version 21.02.2022
 */
public class RangedUnit extends Unit {
  private int timesAttacked;

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   * @param attack Attack value
   * @param armor  Resistance to attacks
   */
  protected RangedUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
    this.timesAttacked = 0;
  }

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   */
  protected RangedUnit(String name, int health) {
    super(name, health, 15, 8);
    this.timesAttacked = 0;
  }

  public int getAttackBonus() {
    return 3;
  }

  /**
   * Returns the bonus resistance, unit starts with higher resistance
   * the first few attacks.
   *
   * @return The bonus resistance
   */
  public int getResistBonus() {
    int bonusResist;
    bonusResist = (2 - this.timesAttacked) * 2;
    if (bonusResist <= 0) {
      bonusResist = 0;
    }
    this.timesAttacked++;
    return 2 + bonusResist;
  }
}
