package weapon;

/**
 * This interface defines the framework that all Weapon object should follow.
 * 
 * This interface models the Weapons used by ZombieHunters.
 * 
 * @author Mac Clevinger
 *
 */

public interface Weapon {

//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests an identifier for this Weapon object.
	 * 
	 * @return - Returns a String object representing this Weapon object.
	 */
	
	public abstract String getWeaponIdentity();
	
	/**
	 * Getter method that requests whether the provided Weapon is compatible
	 * to the calling Weapon object.
	 * 
	 * @param variant - Weapon object to be compared to the calling Weapon object.
	 * @return - Returns a boolean value representing the result of the comparison; true if they are compatible, false otherwise.
	 */
	
	public boolean compatible(Weapon variant);
	
}
