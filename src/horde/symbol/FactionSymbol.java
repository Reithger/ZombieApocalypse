package horde.symbol;

import weapon.Weapon;

/**
 * This abstract class defines the framework that all FactionSymbol objects must adhere to.
 * 
 * This class models FactionSymbols, which denote for a Horde of zombies what weakness they possess.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class FactionSymbol {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** Weapon instance variable representing the Weapon that zombies with this FactionSymbol are weak to*/
	protected Weapon vulnerableTo;

//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests the Weapon to which zombies with this FactionSymbol are weak to.
	 * 
	 * @return - Returns a Weapon object representing the Weapon zombies with this FactionSymbol are vulnerable to.
	 */
	
	public Weapon getCulturalWeakness() {
		return vulnerableTo;
	}
	
//---  Setter Methods   -----------------------------------------------------------------------
	
	/**
	 * Setter method that assigns a provided Weapon as the new Weapon to which zombies with this
	 * Faction Symbol are weak to.
	 * 
	 * @param newWeakness - Weapon object defining the new vulnerability of zombies with this FactionSymbol.
	 */
	
	protected void assignCulturalWeakness(Weapon newWeakness) {
		vulnerableTo = newWeakness;
	}
	
//---  Operations   ---------------------------------------------------------------------------
	
	/**
	 * This method decides whether two Faction Symbols are compatible with one another, defined
	 * as two Faction Symbols being effectively the same in the vulnerability they store.
	 * 
	 * @param other - FactionSymbol object representing the other Faction Symbol to compare to the calling one.
	 * @return - Returns a boolean value denoting the result of the comparison of these two Faction Symbols.
	 */
	
	public boolean compatible(FactionSymbol other) {
		return(other.getCulturalWeakness().compatible(getCulturalWeakness()));
	}
	
}
