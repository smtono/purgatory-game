package Game.Logic;
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
public abstract class Character {
	/***************************************************************************************************************************************************************************************/

	//							CLASS VARIABLES

	/***************************************************************************************************************************************************************************************/
	protected int hp, mp, xp, acc, eva, level, damage, strength, magic;
	protected String name;
	protected enum EnemyType {FIRE, ICE, EARTH, WIND,};
	protected enum HeroType {WARRIOR, MAGE,};
	/***************************************************************************************************************************************************************************************/

	//							CONSTRUCTORS

	/***************************************************************************************************************************************************************************************/
	// default constructor
	public Character() {

	}
	// parametized
	public Character(String name, int hp, int mp, int xp, int acc, int eva, int level) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.xp = xp;
		this.acc = acc;
		this.eva = eva;
		this.level = level;
	} // end overloaded constructor
	/***************************************************************************************************************************************************************************************/

	//							ABSTRACT METHODS

	/***************************************************************************************************************************************************************************************/
	public abstract void attack();
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