package horde;

import java.util.ArrayList;
import zombie.HuntableZombie;
import horde.symbol.FactionSymbol;

/**
 * This abstract class defines the framework that all Horde-type objects must follow.
 * 
 * Classes of the Horde type model a Horde of Zombies, with a specific FactionSymbol
 * associated to that Horde describing the weakness those Zombies possess.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class Horde {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** String object representing the name associated to this Horde of zombies*/
	protected String hordeName;
	/** ArrayList<<r>HuntableZombies> object representing the collection of zombies in this Horde*/
	protected ArrayList<HuntableZombie> zomBoys;
	/** FactionSymbol object describing the identity of this Horde object; their weakness*/
	protected FactionSymbol factionIdentifier;
	
//---  Adder Methods   ------------------------------------------------------------------------
	
	/**
	 * Adder method that subscribes a provided HuntableZombie to this Horde (can be updated on
	 * Faction Symbol.)
	 * 
	 * @param zomGirl - HuntableZombie object being added to this Horde
	 */
	
	public void employZombie(HuntableZombie zomGirl) {
		zomBoys.add(zomGirl);
		zomGirl.setHorde(this);
	}
	
//---  Remover Methods   ----------------------------------------------------------------------
	
	/**
	 * Remover method that unsubscribes a defined HuntableZombie from this Horde.
	 * 
	 * @param zomThey
	 */
	
	public void removeZombie(HuntableZombie zomThey) {
		if(zomBoys.contains(zomThey)) {
			zomBoys.remove(zomThey);
			zomThey.setHorde(null);
		}
	}
	
//---  Setter Methods   -----------------------------------------------------------------------

	/**
	 * Setter method that assigns a new Faction Symbol to this Horde object.
	 * 
	 * @param newIdentifier - Faction Symbol object representing the new identity of this Horde
	 */
	
	public void changeHordeFactionSymbol(FactionSymbol newIdentifier) {
		factionIdentifier = newIdentifier;
	}

	/**
	 * Setter method that instructs the implemented Horde object to reset its
	 * Faction Symbol to the default Faction Symbol defined by that class.
	 * 
	 */
	
	public abstract void reassignFactionSymbol();

	/**
	 * Setter method that assigns a new String object as the name for this Horde
	 * 
	 * @param in - String object representing the new name of this Horde
	 */
	
	public void assignHordeTitle(String in) {
		hordeName = in;
	}
		
//---  Getter Methods   -----------------------------------------------------------------------

	/**
	 * Getter method that requests the Faction Symbol associated to this object.
	 * 
	 * @return - Returns a Faction Symbol describing the identity of this Horde object
	 */
	
	public FactionSymbol getFactionSymbol() {
		return factionIdentifier;
	}

	/**
	 * Getter method that requests the collection of zombies associated to this Horde.
	 * 
	 * @return - Returns an ArrayList<<r>HuntableZombie> object containing the zombies associated to this Horde.
	 */
	
	public ArrayList<HuntableZombie> getZombieRegistry(){
		return zomBoys;
	}

	/**
	 * Getter method that requests the collection of zombies associated to this Horde
	 * that possess the provided FactionSymbol object.
	 * 
	 * @param identifier - FactionSymbol object provided as an identifier for which zombies should be included
	 * @return - Returns an ArrayList<<r>HuntableZombie> containing the zombies that match the provided Faction Symbol
	 */
	
	public ArrayList<HuntableZombie> getZombieRegistry(FactionSymbol identifier){
		ArrayList<HuntableZombie> out = new ArrayList<HuntableZombie>();
		for(HuntableZombie hZ : out) {
			
		}
		return out;
	}

	/**
	 * Getter method that requests the title of this Horde.
	 * 
	 * @return - Returns a String object representing the title of this Horde.
	 */
	
	public String getHordeTitle() {
		return hordeName;
	}

	/**
	 * Getter method that requests whether or not the provided Horde object possesses
	 * the same identifier as this Horde object.
	 * 
	 * @param other - Horde object being compared to the calling Horde object
	 * @return - Returns a boolean value representing whether or not the two Horde objects match.
	 */
	
	public boolean queryCorrespond(Horde other) {
		return getHordeTitle().equals(other.getHordeTitle());
	}

	/**
	 * Getter method that requests whether or not the provided FactionSymbol object
	 * matches the one stored by this Horde object.
	 * 
	 * @param symbol - FactionSymbol object representing the object being matched to the one in this Horde
	 * @return - Returns a boolean value representing the result of the comparison of the provided object and the
	 * one stored by this object.
	 */
	
	public boolean queryMatchingSymbol(FactionSymbol symbol) {
		return factionIdentifier.compatible(symbol);
	}
	
//---  Operations   ---------------------------------------------------------------------------
	
	/**
	 * Updater method that requests each stored HuntableZombie to update
	 * their stored Faction Symbol according to the one stored in this Horde.
	 * 
	 */
	
	public void updateZombiesOnTrend() {
		for(HuntableZombie hZ : zomBoys)
			hZ.notifyNewFactionSymbol();
	}

}
