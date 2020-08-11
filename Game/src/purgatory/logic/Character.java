package purgatory.logic;
/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file is the super class for all character types, hero and enemy.
 * This is the super class to all character types.
 * Each character has set attributes hp, mp, xp, acc, eva, level, damage, strength, magic;
 * 
 * Encapsulation :
 * These can be accessed / mutated here using get / set methods.
 * 
 * TODO:
 * Generalize characters more? 
 * More abstract methods, perhaps?
 */
@SuppressWarnings("DanglingJavadoc")
public abstract class Character {
	/***************************************************************************************************************************************************************************************/

	//							CLASS VARIABLES

	/***************************************************************************************************************************************************************************************/
	protected int hp, mp, xp, acc, eva, level, damage, strength, magic;
	protected String name;
	protected enum HeroType {WARRIOR, MAGE,}
	protected enum EnemyType {FIRE, ICE, EARTH, WIND,}
	/***************************************************************************************************************************************************************************************/

	//							CONSTRUCTORS

	/***************************************************************************************************************************************************************************************/
	// default constructor
	public Character() {

	}
	/***************************************************************************************************************************************************************************************/

	//							ABSTRACT METHODS

	/***************************************************************************************************************************************************************************************/
	public abstract int attack();
	/***************************************************************************************************************************************************************************************/

	//							ACCESSORS

	/***************************************************************************************************************************************************************************************/
	public String getName() {
		return name;
	}
	public int getHP()  {
		return hp;
	}
	public int getMP() {
		return mp;
	}	
	public int getXP() {
		return xp;
	}	
	public int getACC() {
		return acc;
	}	
	public int getEVA() {
		return eva;
	} 	
	public int getLevel() {
		return level;
	}
	public int getDamage() {
		return damage;
	}
	public int getStrength() {
		return strength;
	}
	public int getMagic() {
		return magic;
	}
	public String getInfo() {
		return getName() + "\n" + getLevel() + "\n" + getHP();
	};
	/***************************************************************************************************************************************************************************************/

	//							MUTATORS

	/***************************************************************************************************************************************************************************************/
	public void setName(String newName) {
		name = newName;
	}
	public void setHP(int newHP) {
		hp = newHP;
	}
	public void setMP(int newMP) {
		mp = newMP;	
	}	
	public void setXP(int newXP) {
		xp = newXP;
	}	
	public void setACC(int newACC) {
		acc = newACC;
	}	
	public void setEVA(int newEVA) {
		eva = newEVA;
	}
	public void setLevel(int newLevel) {
		level = newLevel;
	}
	public void setDamage(int newDamage) {
		damage = newDamage;
	}
	public void setStrength(int newStrength) {
		strength = newStrength;
	}
	public void setMagic(int newMagic) {
		magic = newMagic;
	}
}