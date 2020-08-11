package purgatory.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    Author: Shannon Thornton

    Purpose: To declare different "entity (heroes/enemies/and eventually party members) in one place, since they
    all use similar methods. This is to reduce the amount of redundant / similar code in my files.
    More files =/= more complexity.
 */
public enum EntityType {
    WARRIOR("warrior", true),
    MAGE("mage",true),
    SLIME("slime",false);

    private boolean isHero;
    private String typeName;

    EntityType(String typeName, boolean isHero) {
        this.typeName = typeName;
        this.isHero = isHero;
    }

    public String getHeroTypeName() { return typeName; }

    public boolean isHero() { return isHero; }

    public static Iterator<EntityType> getHeroes(){
        List<EntityType> heroes = new ArrayList<>();
        for (EntityType entity : EntityType.values()) {
            if(entity.isHero)heroes.add(entity);
        }
        return heroes.iterator();
    }

    @Override
    public String toString() {
        return typeName;
    }


   // public static EntityType getRandom(){ return (Math.round(Math.random()) == 1) ? HERO : ENEMY; }
}