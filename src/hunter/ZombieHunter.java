package hunter;

import weapon.Weapon;
import zombie.HuntableZombie;
import pronoun.GenderPronoun;
import hunterguild.ZombieHunterGuild;
import hunterguild.career.Career;
import pronoun.Feminine;

/**
 * This abstract class defines the framework that all classes which extend ZombieHunter must follow.
 * 
 * This class models a ZombieHunter, that being an object which can belong to a HunterGuild and
 * possess a Career and Weapon that is used to combat zombies.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class ZombieHunter {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** String object representing the name of this ZombieHunter*/
	protected String name;
	/** Career object representing the career to which this ZombieHunter belongs*/
	protected Career career;
	/** GenderPronoun object representing the used pronouns of this ZombieHunter object*/
	protected GenderPronoun pronoun;
	/** Weapon object representing the weapon used by this ZombieHunter object*/
	protected Weapon combatPower;
	/** ZombieHunterGuild object representing the association to which this ZombieHunter belongs*/
	protected ZombieHunterGuild association;
	/** boolean value representing whether or not subscriber updates can change this ZombieHunter's career*/
	protected boolean fixedCareer;
	/** boolean value representing whether or not subscriber updates cna change this ZombieHunter's weapon*/
	protected boolean fixedWeapon;
	
//---  Operations   ---------------------------------------------------------------------------

	/**
	 * This method commands a ZombieHunter to attack the provided HuntableZombie, succeeding if
	 * the vulnerable weapon of the HuntableZombie matches the weapon of the ZombieHunter.
	 * 
	 * @param zomB - HuntableZombie object that is being attacked by this ZombieHunter
	 * @return - Returns a boolean value representing the result of this attack; true if the ZombieHunter won, false otherwise.
	 */
	
	public boolean attackZombie(HuntableZombie zomB) {
		return zomB.accessWeakness().compatible(combatPower);
	}

	/**
	 * This method subscribes the ZombieHunter to the provided ZombieHunterGuild, assigning
	 * it to be a member of that guild.
	 * 
	 * @param zHG - ZombieHunterGuild object representing the new association that this ZombieHunter object belongs to.
	 */
	
	public void joinGuild(ZombieHunterGuild zHG) {
		setGuild(zHG);
		if(zHG != null)
			zHG.employZombieHunter(this);
	}
	
	/**
	 * This method unsubscribes the ZombieHunter from the ZombieHunterGuild associated to it.
	 * 
	 */
	
	public void quitGuild() {
		association.fireZombieHunter(this);
		association = null;
	}
	
	/**
	 * This method reassigns the weapon of this ZombieHunter to the default as implemented by
	 * the class extending the ZombieHunter abstract class.
	 * 
	 */
	
	public abstract void reassignCareerWeapon();

	/**
	 * This method dispermits the ZombieHunter from having their weapon be automatically changed.
	 * 
	 */
	
	public void freezeWeapon() {
		fixedWeapon = true;
	}
	
	/**
	 * This method permits the ZombieHunter to have their weapon be automatically changed.
	 * 
	 */
	
	public void freeWeapon() {
		fixedWeapon = false;
	}
	
	/**
	 * This method dispermits the ZombieHunter from having their career be automatically changed.
	 * 
	 */
	
	public void freezeCareer() {
		fixedCareer = true;
	}
	
	/**
	 * This method permits the ZombieHunter to have their career be automatically changed.
	 * 
	 */
	
	public void freeCareer() {
		fixedCareer = false;
	}

//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests the Weapon associated to this ZombieHunter.
	 * 
	 * @return - Returns a Weapon object representing the weapon used by this ZombieHunter
	 */
	
	public Weapon getHuntingPower() {
		return combatPower;
	}

	/**
	 * Getter method that requests the Career associated to this ZombieHunter.
	 * 
	 * @return - Returns a Career object representing the career associated to this ZombieHunter.
	 */
	
	public Career getHunterType() {
		return career;
	}
	
	/**
	 * Getter method that requests the name of this ZombieHunter.
	 * 
	 * @return - Returns a String object representing the name of this ZombieHunter.
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Getter method that requests the GenderPronoun associated to this ZombieHunter.
	 * 
	 * @return - Returns a GenderPronoun object representing the used gender pronouns of this ZombieHunter.
	 */
	
	public GenderPronoun getPronouns() {
		return pronoun;
	}

	/**
	 * Getter method that requests the ZombieHunterGuild associated to this ZombieHunter.
	 * 
	 * @return - Returns a ZombieHunterGuild object representing the association this ZombieHunter is a part of.
	 */
	
	public ZombieHunterGuild getGuildAssociation() { 
		return association;
	}
	
//---  Setter Methods   -----------------------------------------------------------------------
	
	/**
	 * Setter method that assigns a new String object as the name of this ZombieHunter.
	 * 
	 * @param preferredName - String object representing the new name of this ZombieHunter.
	 */
	
	public void applyNameChange(String preferredName) {
		name = preferredName;
	}

	/**
	 * Setter method that assigns a new Career to this ZombieHunter from the ZombieHunterGuild
	 * that this ZombieHunter is a part of, reassigning the Career of that Guild.
	 * 
	 */
	
	public void notifyNewCareer() {
		if(!fixedCareer)
			chooseCareer(association.getCareer());
		if(!fixedWeapon)
			reassignCareerWeapon();
		
	}
	
	/**
	 * Setter method that assigns a new Career to this ZombieHunter.
	 * 
	 * @param careerChoice - Career object representing the new Career for this ZombieHunter.
	 */
	
	public void chooseCareer(Career careerChoice) {
		career = careerChoice;
	}
	
	/**
	 * Setter method that assigns a new GenderPronoun to this ZombieHunter.
	 * 
	 * @param newPronouns - GenderPronoun object representing the new pronouns used by this ZombieHunter.
	 */
	
	public void applyPronouns(GenderPronoun newPronouns) {
		if(newPronouns == null)
			pronoun = new Feminine();
		else
			pronoun = newPronouns;
	}

	/**
	 * Setter method that assigns a new Weapon to this ZombieHunter.
	 * 
	 * @param in - Weapon object representing the new weapon used by this ZombieHunter.
	 */
	
	public void assignWeapon(Weapon in) {
		combatPower = in;
	}

	/**
	 * Setter method that assigns a new ZombieHunterGuild to this ZombieHunter.
	 * 
	 * @param zHG - ZombieHunterGuild object representing the new guild that this ZombieHunter is a part of.
	 */
	
	public void setGuild(ZombieHunterGuild zHG) {
		association = zHG;
	}
	
}
