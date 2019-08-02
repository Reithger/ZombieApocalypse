package zombie;

import horde.symbol.FactionSymbol;
import pronoun.GenderPronoun;
import weapon.Weapon;
import horde.Horde;
import pronoun.Feminine;

/**
 * This abstract class defines the framework that all HuntableZombie objects must follow.
 * 
 * This class models generic Zombies that can be hunted by ZombieHunters.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class HuntableZombie {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** int value representing the ID associated to this HuntableZombie object*/
	protected int uniqueID;
	/** int value representing the number of limbs on the Zombie modeled by this HuntableZombie object*/
	protected int limbCount;
	/** String object representing the name of this HuntableZombie*/
	protected String zombieName;
	/** Horde object representing the horde to which this HuntableZombie belongs*/
	protected Horde socialCircle;
	/** FactionSymbol object representing the type of HuntableZombie that this is*/
	protected FactionSymbol factionID;
	/** GenderPronoun object representing the used gender pronouns of this HuntableZombie*/
	protected GenderPronoun pronouns;
	
//---  Operations   ---------------------------------------------------------------------------
	
	/**
	 * This method subscribes this HuntableZombie to the provided Horde object.
	 * 
	 * @param newHorde - Horde object to which this HuntableZombie will subscribe.
	 */
	
	public void joinHorde(Horde newHorde) {
		setHorde(newHorde);
		if(newHorde != null)
			newHorde.employZombie(this);
	}
	
	/**
	 * This method unsubscribes this HuntableZombie from its currently associated Horde object.
	 * 
	 */
	
	public void leaveHorde() {
		socialCircle.removeZombie(this);
		setHorde(null);
	}

	/**
	 * This method notifies the HuntableZombie to update its parameters according to
	 * the information in its associated Horde object.
	 * 
	 */
	
	public void notifyNewFactionSymbol() {
		factionID = socialCircle.getFactionSymbol();
	}
	
//---  Setter Methods   -----------------------------------------------------------------------
	
	/**
	 * Setter method that assigns a specified ID number to the HuntableZombie object.
	 * 
	 * @param id - int value representing the ID number to assign to this HuntableZombie.
	 */
	
	public void setZombieID(int id){
		uniqueID = id;
	}

	/**
	 * Setter method that assigns specified zombieName to the HuntableZombie object.
	 * 
	 * @param zombieName - String object representing the new ZombieName to be assigned.
	 */
	
	public void setZombieName(String zombieNameIn){
		zombieName = zombieNameIn;
	}

	/**
	 * Setter method that assigns the number of limbs to the HuntableZombie object, throws an
	 * IllegalArgumentException if a number less than 0 or more than 4 is attempted to be assigned.
	 * 
	 * @param limbs - int value describing the number of limbs of this HuntableZombie object.
	 */
	
	public void setLimbCount(int limbs){
		if(limbs < 0 || limbs > 4){
			throw new IllegalArgumentException();
		}
		limbCount = limbs;
	}

	/**
	 * Setter method to change the Horde associated to this HuntableZombie.
	 * 
	 * @param hordeStatus - Horde object representing the new Horde to which this HuntableZombie belongs.
	 */
	
	public void setHorde(Horde socialite){
		socialCircle = socialite;
	}

	/**
	 * Setter method to assign a new Faction to this HuntableZombie, changing its vulnerability.
	 * 
	 * @param symbol - FactionSymbol object representing the new Faction to which this HuntableZombie belongs.
	 */
	
	public void setFactionSymbol(FactionSymbol symbol) {
		factionID = symbol;
	}
	
	/**
	 * Setter method that assigns a new set of used pronouns to this HuntableZombie.
	 * 
	 * So the zombie can be trans.
	 * 
	 * @param newPronouns - GenderPronoun object representing the new used pronouns of this HuntableZombie.
	 */
	
	public void applyPronouns(GenderPronoun newPronouns) {
		if(newPronouns == null) 
			pronouns = new Feminine();
		else
			pronouns = newPronouns;
	}
	
//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that retrieves a zombie's ID Number.
	 * 
	 * @return - Returns the HuntableZombie's ID number
	 */
	
	public int getZombieID(){
		return uniqueID;
	}

	/**
	 * Getter method that retrieves a HuntableZombie's name.
	 * 
	 * @return - Returns the HuntableZombie's name.
	 */

	public String getZombieName(){
		return zombieName;
	}

	/**
	 * Getter method that retrieves the limb count of this HuntableZombie.
	 * 
	 * @return - Returns an int value representing the number of limbs on the zombie modeled by this HuntableZombie.
	 */
	
	public int getLimbCount(){
		return limbCount;
	}

	/**
	 * Getter method that requests the Horde to which this HuntableZombie belongs.
	 * 
	 * @return - Returns a Horde object representing the Horde to which this HuntableZombie belongs.
	 */
	
	public Horde getHorde(){
		return socialCircle;
	}
	
	/**
	 * Getter method that requests the FactionSymbol object associated to this HuntableZombie.
	 * 
	 * @return - Returns the FactionSymbol object representing the type of HuntableZombie this is.
	 */
	
	public FactionSymbol getFactionSymbol() {
		return factionID;
	}
	
	/**
	 * Getter method that request the GenderPronoun object used by this HuntableZombie.
	 * 
	 * @return - Returns the GenderPronoun object that this HuntableZombie object uses.
	 */
	
	public GenderPronoun getPronouns() {
		return pronouns;
	}
	
	/**
	 * Getter method that requests the Weapon to which this HuntableZombie is vulnerable.
	 * 
	 * @return - Returns the Weapon object that this HuntableZombie object is vulnerable to.
	 */
	
	public Weapon accessWeakness() {
		return factionID.getCulturalWeakness();
	}
	
}
