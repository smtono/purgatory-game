package purgatory.inventory;

import java.util.Arrays;
import java.util.List;

public class ItemUtil {
    /**
     *
     * @param itemName
     * @return
     */
    public static Item findItemOfName(String itemName) {
        List<Item> items = Arrays.asList(Item.values().clone());

        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return Item.NONE;
    }
}
