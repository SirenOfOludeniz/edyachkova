package ru.job4j.apphf;
import java.util.Iterator;
import java.util.List;

public class FindGuitarTester {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec whatErinLikes = 
      new GuitarSpec(Builder.FENDER, "Stratocastor", 
                     Type.ELECTRIC, Wood.ALDER, Wood.ALDER, 6);
    List matchingGuitars = inventory.search(whatErinLikes);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("Erin, you might like these guitars:");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println("  We have a " +
          spec.getBuilder() + " " + spec.getModel() + " " +
          spec.getType() + " guitar:\n     " +
          spec.getBackWood() + " back and sides,\n     " +
          spec.getTopWood() + " top.\n  You can have it for only $" +
          guitar.getPrice() + "!\n  ----");
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    GuitarSpec guitarSpec = new GuitarSpec(Builder.COLLINGS,
            "CJ", Type.ACOUSTIC,
            Wood.INDIAN_ROSEWOOD, Wood.SITKA, 6);
    inventory.addGuitar("11277", 3999.95, guitarSpec);


    GuitarSpec guitarSpec1 = new GuitarSpec( Builder.FENDER,
            "Stratocastor", Type.ELECTRIC,
            Wood.ALDER, Wood.ALDER, 6);
    inventory.addGuitar("V95693", 1499.95, guitarSpec1);



    GuitarSpec guitarSpec2 = new GuitarSpec(Builder.FENDER,
            "Stratocastor", Type.ELECTRIC,
            Wood.ALDER, Wood.ALDER, 6);
    inventory.addGuitar("V9512", 1549.95, guitarSpec2);
    GuitarSpec guitarSpec3 = new GuitarSpec( Builder.MARTIN,
            "D-18", Type.ACOUSTIC,
            Wood.MAHOGANY, Wood.ADIRONDACK, 12);
    inventory.addGuitar("122784", 5495.95,guitarSpec3);
    GuitarSpec guitarSpec4 = new GuitarSpec( Builder.MARTIN,
            "OM-28", Type.ACOUSTIC,
            Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6);
    inventory.addGuitar("76531", 6295.95,guitarSpec4);
    GuitarSpec guitarSpec5 = new GuitarSpec(Builder.GIBSON,
            "Les Paul", Type.ELECTRIC,
            Wood.MAHOGANY, Wood.MAHOGANY, 6);
    inventory.addGuitar("70108276", 2295.95, guitarSpec5);
    GuitarSpec guitarSpec6 = new GuitarSpec(Builder.GIBSON,
            "SG '61 Reissue", Type.ELECTRIC,
            Wood.MAHOGANY, Wood.MAHOGANY, 6);
    inventory.addGuitar("82765501", 1890.95, guitarSpec6);
    GuitarSpec guitarSpec7 = new GuitarSpec(Builder.MARTIN,
            "D-28", Type.ACOUSTIC,
            Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK, 6);
    inventory.addGuitar("77023", 6275.95, guitarSpec7);
    GuitarSpec guitarSpec8 = new GuitarSpec(Builder.OLSON,
            "SJ", Type.ACOUSTIC,
            Wood.INDIAN_ROSEWOOD, Wood.CEDAR, 6);
    inventory.addGuitar("1092", 12995.95, guitarSpec8);
    GuitarSpec guitarSpec9 = new GuitarSpec( Builder.RYAN,
            "Cathedral", Type.ACOUSTIC,
            Wood.COCOBOLO, Wood.CEDAR, 6);
    inventory.addGuitar("566-62", 8999.95,guitarSpec9);
    GuitarSpec guitarSpec10 = new GuitarSpec(Builder.PRS,
            "Dave Navarro Signature", Type.ELECTRIC,
            Wood.MAHOGANY, Wood.MAPLE, 6);
    inventory.addGuitar("6 29584", 2100.95, guitarSpec10);
  }
}
