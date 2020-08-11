package purgatory.Hero;

import java.util.Scanner;
/*
 * Author: Shannon Thornton
 * 
 * Purpose: This file is to further define the Warrior Hero type.
 * 
 * Things to implement:
 * Attack style (melee)
 * Move set
 * 
 */
public class Warrior extends Hero 
{
	Scanner scnr = new Scanner(System.in);
	int userInput = 0; // captures userInput
	

	// warrior archetype will use melee
	public void heroAttack() 
	{
		userInput = moveSet();
		
		// different things will happen when a number is returned
		switch (userInput)
		{
			case 1:
			{
				System.out.println();
			}
			case 2:
			{
				
			}
			case 3:
			{
				
			}
		}
		
	} // end heroAttack
	
	public int moveSet()
	{	
		System.out.print(
				"\nQuick, hero! What will you do? "
				+ " "
				+ warriorMoves[1]
				+ " "
				+ warriorMoves[2]
				+ " "
				+ warriorMoves[3]
						);
		
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
	} // end moveSet()
	
} // end Warrior class
