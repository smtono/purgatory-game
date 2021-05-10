package purgatory.inventory;

public enum Item {
    // HEALING
    BANDAGE("Bandage", "Provides 10 HP", ItemType.HEAL, 10),
    OINTMENT("Ointment", "Provides 50 HP", ItemType.HEAL, 50),
    MEDICINE("Medicine", "Provides 100 HP", ItemType.HEAL, 100),
    HERBS("Herbs", "Provides 200 HP", ItemType.HEAL, 200),
    PRAYER("Prayer", "Provides 500 HP", ItemType.HEAL, 500),

    // MANA
    DRINK("Energy Drink", "Provides 5 MP", ItemType.MANA, 5),

    // BUFF

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
}
