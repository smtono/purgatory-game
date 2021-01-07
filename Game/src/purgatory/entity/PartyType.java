package purgatory.entity;

import purgatory.weapon.WeaponType;

import java.util.List;

public enum PartyType implements VirtualEntityType {
    ;

    //ATTRIBUTES
    private final EntityType entityType;

    // CONSTRUCTOR
    PartyType(String typeName, String description, CharacterType type, List<WeaponType> weaponTypeTypes) {
        this.entityType = EntityType.of(typeName, description, type, weaponTypeTypes);
    }

    @Override
    public EntityType getEntityType() { return entityType; }

    @Override
    public String toString() { return getEntityType().getTypeName(); }
}
