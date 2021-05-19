package purgatory.inventory;

import java.util.Arrays;
import java.util.List;

public class ItemUtil {
    /** Finds an item by name and returns it */
    public static Item findItemOfName(String itemName) {
        Item[] items = Item.values().clone();

        for (Item item : items) {
            if (item.getName().toLowerCase().equals(itemName)) {
                return item;
            }
        }
        return Item.NONE;
    }
}
