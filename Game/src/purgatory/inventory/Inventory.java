package purgatory.inventory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    // ATTRIBUTES
    private HashMap<Item, Integer> items;

    // CONSTRUCTOR
    public Inventory(HashMap<Item, Integer> items) {
        this.items = items;
    }

    // ACCESSORS
    public HashMap<Item, Integer> getItems() { return items; }

    // MUTATORS
    public void setItems(HashMap<Item, Integer> items) { this.items = items; }

    // HELPER METHODS

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();

        items.forEach((item, number) -> {
            itemNames.add(item + " (" + number + ")");
        });

        return itemNames;
    }

    /** Adds the given amount of items to the inventory  */
    public void addItem(String itemName, int amount) {
        Item item = ItemUtil.findItemOfName(itemName);
        if (items.containsKey(item)) {
            items.replace(item, amount);
        }
        else {
            items.put(item, amount);
        }
    }

    /** Deletes the given amount of items from the inventory */
    public void deleteItem(String itemName, int amount) {
        Item item = ItemUtil.findItemOfName(itemName);

        if ((amount > items.get(item) || !items.containsKey(item))) {
            JOptionPane.showMessageDialog(null, "I don't think you can do that.");
        }
        else {
            items.replace(item, items.get(item) - amount);
        }
    }
}
