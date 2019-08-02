package horde;

import java.util.ArrayList;
import horde.symbol.ZombieTubbiesSymbol;
import zombie.HuntableZombie;

/**
 * This class extends the Horde abstract class, specifying a Horde of the type ZombieTubbies
 * 
 * @author Mac Clevinger
 *
 */

public class ZombieTubbiesHorde extends Horde{
	
//---  Constant Values   ----------------------------------------------------------------------
	
	/** Constant ZombieTubbiesSymbol object defining the default FactionSymbol for this type of Horde*/
	private static final ZombieTubbiesSymbol SYMBOL = new ZombieTubbiesSymbol();
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the ZombieTubbiesHorde type, initializing the ArrayList<<r>HuntableZombies>
	 * representing the members of this horde and assigning the default Faction Symbol for this horde.
	 * 
	 */
	
	public ZombieTubbiesHorde(String name) {
		zomBoys = new ArrayList<HuntableZombie>();
		assignHordeTitle(name);
		changeHordeFactionSymbol(SYMBOL);
	}
	
//---  Setter Methods   -----------------------------------------------------------------------

	@Override
	public void reassignFactionSymbol() {
		changeHordeFactionSymbol(SYMBOL);
	}
	
}
