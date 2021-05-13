package purgatory.inventory;

import java.util.HashMap;

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
    /** Adds the given amount of items to the inventory  */
    public void addItem(String itemName, int amount) {
        Item item = ItemUtil.findItemOfName(itemName);

       items.replace(item, amount);
    }

    /** Deletes the given amount of items from the inventory */
    public void deleteItem(String itemName, int amount) {
        Item item = ItemUtil.findItemOfName(itemName);

        // TODO: validation check
        items.replace(item, items.get(item) - amount);
    }
}
