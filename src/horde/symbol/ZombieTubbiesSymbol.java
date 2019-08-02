package horde.symbol;

import weapon.Machete;

/**
 * This class extends the FactionSymbol abstract class to specifically model a ZombieTubbies Horde
 * Symbol, whose weakness has been designated as the Machete.
 * 
 * @author Mac Clevinger
 *
 */

public class ZombieTubbiesSymbol extends FactionSymbol{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** Machete constant value representing the weakness that this FactionSymbol object designates a zombie as having*/
	private static final Machete VULNERABLE = new Machete();
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the ZombieTubbiesSymbol type that assigns the weakness
	 * as the constant weapon value stored by this class.
	 * 
	 */
	
	public ZombieTubbiesSymbol() {
		assignCulturalWeakness(VULNERABLE);
	}
	
}
