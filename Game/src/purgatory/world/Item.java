package purgatory.WorldBuild;
/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file is the super class for Items, all items inherit traits listed here.
 * 
 * ideas: store item collection in a binary tree? or maybe a hash table
 * 
 */

public abstract class Item 
{
	// different stats
	// hp, mp, strength, accuracy bonus, magic
	protected int hp, mp, accBonus, strength, magic;
	
	// default constructor
	public Item()
	{
		
		
	}
	
	// overloaded constructor
	public Item(int hp, int mp, int accBonus, int strength, int magic) 
	{
		this.hp = hp;
		this.mp = mp;
		this.accBonus = accBonus;
		this.strength = strength;
		this.magic = magic;
	}
	
	// get methods
	public int getHP() 
	{
		return this.hp;
	}
	
	public int getMP() 
	{
		return this.mp;
	}
	
	public int getAccBonus() 
	{
		return this.accBonus;
	}
	
	public int getStrenth() 
	{
		return this.strength;
	}
	
	public int getMagic() 
	{
		return this.magic;
	}
	
	// set methods
	public void setHP(int hp) 
	{
		this.hp = hp;
	}
	
	public void setMP(int mp) 
	{
		this.mp = mp;
	}
	
	public void setAccBonus(int accBonus) 
	{
		this.accBonus = accBonus;
	}
	
	public void setStrength(int strength) 
	{
		this.strength = strength;
	}
	
	public void setMagic(int magic) 
	{
		this.magic = magic;
	}
	
	// methods
	
	/*
	 * public void consume
	 * consumes given item argument
	 * items stored into an (array? tree? map)
	 * searches through container, finds item, then sets stats to hero accordingly.
	 */
	public void consume(String item) 
	{
		
		
	}
	

}
