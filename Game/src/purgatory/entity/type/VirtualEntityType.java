package purgatory.entity.type;

import purgatory.weapon.WeaponType;

import java.util.List;

/**
 * VirtualEntityType is an attempt to implement a "Virtual Field Pattern" in the EntityType enums hierarchy.
 * <p>
 * Each EntityType enum implements these similar methods, so the idea is to implement this interface
 * and return an anonymous class that has these methods already implemented.
 *
 * This is my attempt in getting around the inability for enums to extend abstract classes.
 */
public interface VirtualEntityType extends EntityType {
    EntityType getEntityType();

    @Override
    default String getTypeName() { return getEntityType().getTypeName(); }

    @Override
    default String getDescription() { return getEntityType().getDescription(); }

    @Override
    default CharacterType getCharacterType() { return getEntityType().getCharacterType(); }

    @Override
    default List<WeaponType> getWeaponTypes() { return getEntityType().getWeaponTypes(); }
}
