package Game.Hero;

import java.util.Scanner;

/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file is to further define the Mage Hero type.
 * 
 * Things to implement:
 * Attack style (spellcasting)
 * Move set
 * 
 */
public class Mage extends Hero 
{
	Scanner scnr = new Scanner(System.in);
	int userInput = 0; // captures userInput
	
	// mage archetype will use spellcasting
	public void heroAttack() 
	{
		
		
	} // end heroAttack
	
	public int moveSet()
	{
		System.out.print("\nQuick, hero! What will you do? "
				+ "\n1\tIce"
				+ "\n2\tFire"
				+ "\n3\t???");
		
		do 
		{
			userInput = scnr.nextInt();
			
			if (userInput <= 0 || userInput > 3)
			{
				System.out.println("\nPlease enter either 1, 2, or 3.");
				userInput = 0;
			}
		} while (userInput == 0);
		
		return userInput;
	}
	
} // end Mage class
