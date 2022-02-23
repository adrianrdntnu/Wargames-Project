package no.ntnu.iir.wargames;

public class
DummyUnit extends Unit{

  /**
   * Create a unit.
   *
   * @param name   Name of the unit
   * @param health Health points
   * @param attack Attack value
   * @param armor  Resistance to attacks
   */
  protected DummyUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  @Override
  public int getAttackBonus() {
    return 0;
  }

  @Override
  public int getResistBonus() {
    return 0;
  }
}
