package no.ntnu.iir.wargames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads and writes an army to and from file in csv format.
 */
public class ArmyReader {

  public ArmyReader() {

  }

  /**
   * Read an Army from file.
   *
   * @return The Army.
   */
  public Army readArmy(String filename) {

    Charset charset = Charset.forName("US-ASCII");
    Path path = Paths.get(filename);

    Army army = null;

    try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
      String armyName = reader.readLine();
      army = new Army(armyName);
      String[] unit;
      String line = reader.readLine();


      while (line != null) {
        unit = line.split(",");
        String unitType = unit[0];
        String unitName = unit[1];
        int unitHealth = Integer.parseInt(unit[2]);
        switch (unitType) {
          case "CavalryUnit":
            army.add(new CavalryUnit(unitName, unitHealth));
            break;

          case "CommanderUnit":
            army.add(new CommanderUnit(unitName, unitHealth));
            break;

          case "InfantryUnit":
            army.add(new InfantryUnit(unitName, unitHealth));
            break;

          case "RangedUnit":
            army.add(new RangedUnit(unitName, unitHealth));
            break;

          //TODO: Default: throw exception?
        }
        line = reader.readLine();
      }
    } catch (FileNotFoundException e) {
      System.err.println("Unable to open " + filename);
    } catch (IOException e) {
      System.err.println("A problem was encountered reading "
          + filename);
    }
    return army;
  }

  /**
   * Writes an army to file in csv format.
   *
   * @param army The army to write to file
   * @param filename Name of the file to write to
   */
  public void writeArmy(Army army, String filename) {
    if (army != null) {
      Charset charset = Charset.forName("US-ASCII");
      Path path = Paths.get(filename);

      try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
        writer.write(army.getName());
        writer.write('\n');
        List<Unit> units = new ArrayList<>();
        units = army.getUnits();

        for (Unit unit : units) {
          writer.write(unit.getClass().getSimpleName());
          writer.write(',');
          writer.write(unit.getName());
          writer.write(',');
          writer.write("" + unit.getHealth());
          writer.write('\n');
        }
      } catch (IOException e) {
        System.out.println("Problem writing file: " + filename
            + " in writeList");
      }
    } else {
      System.out.println("Null army passed to writeList.");
    }
  }
}
