package purgatory.entity;

/*
    Author: Shannon Thornton

    Purpose: To keep all possible moves that the hero can use (depending on their type) in one file, along
    with keeping track of base damage, whether it is AOE or not, etc.

    Move types will be dependent on their hero counterparts, for now I will work on Warrior and Mage moves.
    Warrior:
    can use "SLASH" moves or "BLUDGEON" etc..
    Somehow come up with a way to keep certain moves associated to different weapons and levels.

    Mage:
    can use "WAND" or "STAFF" spells, wand will be hit one target, staff will be hit all

    How accuracy can work:
    Take hero's current accuracy (in entity constructor)
    multiply that by 200,
    then take the weapon's accuracy and multiply by that
    take whatever percent over 100 it gets and use that for critical
    critical can be calculated by taking whatever percentage it is after the above calulations and adding that percent
    of damage on top of the base damage.

    Attributes of a move:
    name,
    base damage,
    accuracy,
    magic or strength,

 */
public enum HeroMoves {

}
