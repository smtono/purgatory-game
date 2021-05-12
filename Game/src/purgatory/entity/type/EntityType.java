package purgatory.entity.type;

import purgatory.weapon.WeaponType;

import java.util.List;

/**
 * EntityType is an enum that lists out different hero/enemy/boss types a unit can be.
 * <p>
 * Each unit type has a different name, description, character type, and weapons that they can use.
 */
public interface EntityType {
   String getTypeName();

   String getDescription();

   CharacterType getCharacterType();

    List<WeaponType> getWeaponTypes();

    static EntityType of(final String typeName,
                         final String description,
                         final CharacterType type,
                         final List<WeaponType> weaponTypeTypes) {
        return new EntityType() {

            @Override
            public String getTypeName() { return typeName; }

            @Override
            public String getDescription() { return description; }

            @Override
            public CharacterType getCharacterType() { return type; }

            @Override
            public List<WeaponType> getWeaponTypes() { return weaponTypeTypes; }
        };
    }
}
