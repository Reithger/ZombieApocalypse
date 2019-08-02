package horde;

import java.util.ArrayList;
import horde.symbol.FactionSymbol;
import zombie.HuntableZombie;

/**
 * This abstract class extends the Horde abstract class, specifying a Horde of the type GenericHorde.
 * 
 * @author Mac Clevinger
 *
 */

public class GenericHorde extends Horde{

//---  Instance Variables   -------------------------------------------------------------------
	
	/** FactionSymbol instance variable describing the Faction Symbol that has been associated to this object*/
	protected FactionSymbol defaultSymbol;
	
//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the GenericHorde type, initializing the ArrayList<<r>HuntableZombies>
	 * representing the members of this horde and assigning the provided FactionSymbol object as the
	 * FactionSymbol associated to this object. This Faction Symbol will be considered the default for
	 * the purposes of 'resetting' this object's Faction Symbol.
	 * 
	 * @param providedSymbol - FactionSymbol object representing the default Faction Symbol for this object
	 */
	
	public GenericHorde(FactionSymbol providedSymbol, String name) {
		zomBoys = new ArrayList<HuntableZombie>();
		changeHordeFactionSymbol(providedSymbol);
		assignHordeTitle(name);
		defaultSymbol = providedSymbol;
	}

//---  Setter Methods   -----------------------------------------------------------------------
	
	@Override
	public void reassignFactionSymbol() {
		changeHordeFactionSymbol(defaultSymbol);
	}
	
}
