package no.ntnu.iir.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * A collection of units that can go to battle.
 *
 * @author Adrian R. Dahl
 * @version 22.02.2022
 */
public class Army {
  private String name;
  private final List<Unit> units;
  private final Random rng = new Random();

  /**
   * Create an army.
   *
   * @param name Name of the army
   */
  public Army(String name) {
    this.name = name;
    this.units = new ArrayList<>();
  }

  /**
   * Creates an army with the list of units.
   *
   * @param name Name of the army
   * @param units List of units
   */
  public Army(String name, List<Unit> units) {
    this.name = name;
    this.units = new ArrayList<>(units);
  }

  /**
   * Returns the name of the army.
   *
   * @return The name of the army
   */
  public String getName() {
    return this.name;
  }

  /**
   * Adds a unit to the army.
   *
   * @param unit Unit to add to the list
   */
  public void add(Unit unit) {
    this.units.add(unit);
  }

  /**
   * Adds a list of units to the army.
   *
   * @param units List of units to add to the army.
   */
  public void addAll(List<Unit> units) {
    this.units.addAll(units);
  }

  /**
   * Removes a unit from the army.
   *
   * @param unit Unit to be removed from the army
   */
  public void remove(Unit unit) {
    this.units.remove(unit);
  }

  /**
   * Returns true if this army has any units.
   *
   * @return True if this army has any units
   */
  public boolean hasUnits() {
    return !units.isEmpty();
  }

  /**
   * Returns a string representation of the army.
   *
   * @return a string representation of the army
   */
  @Override
  public String toString() {
    return "Army{"
        + "name='" + name + '\''
        + ", units=" + units
        + '}';
  }

  /**
   * Compares the specified army with this army, if they have the same size,
   * units, and the units are in the same order, this returns true.
   *
   * @param o The army to compare to
   * @return True if the armies are the same
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Army army = (Army) o;
    return Objects.equals(name, army.name) && Objects.equals(units, army.units);
  }

  /**
   * Returns the hash code value of this army.
   *
   * @return The hash code value of the army
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, units);
  }

  /**
   * Returns a random unit in this army.
   *
   * @return A random unit in this army
   */
  public Unit getRandom() {
    int maxUnits = this.units.size();
    int randomNumber = rng.nextInt(maxUnits);
    return this.units.get(randomNumber);
  }

  /**
   * Returns a list of all infantry units in the army.
   *
   * @return the list of infantry units
   */
  public List<Unit> getInfantryUnits() {
    return units.stream()
        .filter(InfantryUnit.class::isInstance)
        .toList();
  }

  /**
   * Returns a list of all cavalry units in the army.
   *
   * @return the list of cavalry units
   */
  public List<Unit> getCavalryUnits() {
    return units.stream()
        .filter(unit -> unit instanceof CavalryUnit && !(unit instanceof CommanderUnit))
        .toList();
  }

  /**
   * Returns a list of all ranged units in the army.
   *
   * @return the list of ranged units
   */
  public List<Unit> getRangedUnits() {
    return units.stream()
        .filter(RangedUnit.class::isInstance)
        .toList();
  }

  /**
   * Returns a list of all commander units in the army.
   *
   * @return the list of commander units
   */
  public List<Unit> getCommanderUnits() {
    return units.stream()
        .filter(CommanderUnit.class::isInstance)
        .toList();
  }
}
