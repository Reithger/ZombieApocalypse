package horde.symbol;

import weapon.KickPower;

/**
 * This class extends the FactionSymbol abstract class to specifically model a Zombieber Horde
 * Symbol, whose weakness has been designated as KickPower.
 * 
 * @author Mac Clevinger
 *
 */

public class ZombieberSymbol extends FactionSymbol{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** KickPower constant value representing the weakness that this FactionSymbol object designates a zombie as having*/
	private static final KickPower VULNERABLE = new KickPower();
		
//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the ZombieberSymbol type that assigns the weakness
	 * as the constant weapon value stored by this class.
	 * 
	 */
	
	public ZombieberSymbol() {
		assignCulturalWeakness(VULNERABLE);
	}
	
}
