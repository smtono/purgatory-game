package purgatory.inventory;

/**
 *
 */
public enum Item {
    NONE("null", "", null, 0),

    // HEALING
    BANDAGE("Bandage", "Provides 10 HP", ItemType.HEAL, 10),
    OINTMENT("Ointment", "Provides 50 HP", ItemType.HEAL, 50),
    MEDICINE("Medicine", "Provides 100 HP", ItemType.HEAL, 100),
    VULNERARY("Vulnerary", "Provides 200 HP", ItemType.HEAL, 200),
    PRAYER("Prayer", "Provides 500 HP", ItemType.HEAL, 500),

    // MANA
    DRINK("Energy Drink", "Provides 10 MP", ItemType.MANA, 10),
    COFFEE("Coffee", "Provides 25 MP", ItemType.MANA, 25),
    SWEETS("Sweets", "Provides 50 MP", ItemType.MANA, 50),
    ORANGE("Orange Juice", "Provides 80 MP", ItemType.MANA, 80),
    KISS("Kiss", "Provides 100 MP", ItemType.MANA, 100),

    // BUFF
    SHIELD("Shield", "Provide 80% more defense", ItemType.BUFF, 80),

    // DEBUFF

    
    // ATTACKS
    
    ;

    // ATTRIBUTES
    String name;
    String description;
    ItemType itemType;
    int result;

    // CONSTRUCTOR
    Item(String name, String description, ItemType itemType, int result) {
        this.name = name;
        this.description = description;
        this.itemType = itemType;
        this.result = result;
    }

    // ACCESSORS
    public String getName() { return name; }
    public String getDescription() { return description; }
    public ItemType getItemType() { return itemType; }
    public int getResult() { return result; }

    @Override
    public String toString() { return name; }
}
