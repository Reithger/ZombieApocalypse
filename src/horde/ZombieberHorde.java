package horde;

import horde.symbol.ZombieberSymbol;
import java.util.ArrayList;
import zombie.HuntableZombie;

/**
 * This class extends the Horde abstract class, specifying a Horde of the type Zombieber
 * 
 * @author Mac Clevinger
 *
 */

public class ZombieberHorde extends Horde{
	
//---  Constant Values   ----------------------------------------------------------------------
	
	/** Constant ZombieberSymbol object defining the default FactionSymbol for this type of Horde*/
	private static final ZombieberSymbol SYMBOL = new ZombieberSymbol();
	
//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the ZombieberHorde type, initializing the ArrayList<<r>HuntableZombies>
	 * representing the members of this horde and assigning the default Faction Symbol for this horde.
	 * 
	 */
	
	public ZombieberHorde(String name) {
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
