package no.ntnu.iir.wargames;

/**
 * Super class for all units that battle.
 *
 * @author: Adrian R. Dahl
 * @Version 15.02.2022
 */
public abstract class Unit {
  private String name;
  private int health;
  private int attack;
  private int armor;

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   * @param attack Attack value
   * @param armor  Resistance to attacks
   */
  protected Unit(String name, int health, int attack, int armor) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name cannot be null nor be empty");
    }

    if (health <= 0) {
      throw new IllegalArgumentException("Health cannot be lower or equal 0");
    }

    if (attack < 0) {
      throw new IllegalArgumentException("Negative attack values not allowed");
    }

    if (armor < 0) {
      throw new IllegalArgumentException("Negative armor values not allowed");
    }

    this.name = name;
    this.health = health;
    this.attack = attack;
    this.armor = armor;
  }

  /**
   * Returns the name of the unit.
   *
   * @return The unit's name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the health of the unit.
   *
   * @return the unit's health
   */
  public int getHealth() {
    return this.health;
  }

  /**
   * Returns the attack of the unit.
   *
   * @return the unit's attack
   */
  public int getAttack() {
    return this.attack;
  }

  /**
   * Returns the armor of the unit.
   *
   * @return The unit's armor
   */
  public int getArmor() {
    return this.armor;
  }

  /**
   * Sets the health of the unit.
   *
   * @param health What the unit's health should be set to
   */
  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * Creates a string containing the information of all the unit's fields.
   *
   * @return The string containing the information
   */
  @Override
  public String toString() {
    return "Unit{"
        + "name='" + name + '\''
        + ", health=" + health
        + ", attack=" + attack
        + ", armor=" + armor
        + '}';
  }

  /**
   * Returns the attack bonus of the unit.
   *
   * @return Bonus attack
   */
  public abstract int getAttackBonus();

  /**
   * Returns the resistance bonus of the unit.
   *
   * @return Bonus resistance
   */
  public abstract int getResistBonus();

  /**
   * This unit attacks another unit from the opponent then sets that unit's health
   * to whatever is left after the attack has been calculated.
   *
   * @param opponent The opponent's unit to fight
   */
  public void attack(Unit opponent) throws IllegalArgumentException {
    if (opponent == null) {
      throw new
          IllegalArgumentException("Opponent cannot be null");
    }

    int newHealth = opponent.getHealth() - (this.getAttack() + this.getAttackBonus())
        + (opponent.getArmor() + opponent.getResistBonus());
    opponent.setHealth(newHealth);
  }
}
