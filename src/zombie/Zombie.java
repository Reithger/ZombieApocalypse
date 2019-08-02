package zombie;

import horde.symbol.FactionSymbol;
import pronoun.GenderPronoun;

/**
 * This class extends the abstract class HuntableZombie to specify a regular Zombie guy/girl/folk/other.
 * 
 * @author Mac Clevinger
 *
 */

public class Zombie extends HuntableZombie{
    
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Zombie type.
	 * 
	 * @param ID - int value representing an ID value associated to this Zombie object
	 * @param name - String object representing the name of this Zombie object
	 * @param numLimbs - int value representing the number of limbs on the Zombie modeled by this object
	 * @param family - FactionSymbol object representing the type of Zombie this is
	 * @param givenPronouns - GenderPronoun object representing the used pronouns of the Zombie modeled by this object
	 */
	
	public Zombie(int ID, String name, int numLimbs, FactionSymbol family, GenderPronoun givenPronouns){
		setZombieID(ID);
		setZombieName(name);
		setLimbCount(numLimbs);
		setFactionSymbol(family);
		applyPronouns(givenPronouns);
	}
	
}
