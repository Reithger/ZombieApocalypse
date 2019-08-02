package hunterguild.career;

import weapon.Weapon;

/**
 * This abstract class describes the framework that all Career-type classes should follow.
 * 
 * This class models Careers that ZombieHunters can have, describing their weapon of choice.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class Career {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** Weapon instance variable designating the preferred Weapon of this Career object*/
	protected Weapon preferredWeapon;

//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests the Weapon associated to this Career.
	 * 
	 * @return - Returns a Weapon object representing the Weapon associated to this Career.
	 */
	
	public Weapon getPreferredWeapon() {
		return preferredWeapon;
	}

	/**
	 * Getter method that requests whether two Careers are compatible by requesting
	 * whether their two Weapons are compatible to one another.
	 * 
	 * @param other - Career object being compared to the calling Career object.
	 * @return - Returns a boolean value representing the result of the objects' being compared.
	 */
	
	public boolean compatible(Career other) {
		return(getPreferredWeapon().compatible(other.getPreferredWeapon()));
	}
	
//---  Setter Methods   -----------------------------------------------------------------------
	
	/**
	 * Setter method that assigns a new Weapon as that associated to this Career.
	 * 
	 * @param newWeapon - Weapon object representing the new Weapon associated to this Career.
	 */
	
	protected void assignPreferredWeapon(Weapon newWeapon) {
		preferredWeapon = newWeapon;
	}
	
}
