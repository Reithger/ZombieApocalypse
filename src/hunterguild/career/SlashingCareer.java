package hunterguild.career;

import weapon.Machete;

/**
 * This class extends the Career abstract class to specify the Slashing-type Career path
 * for ZombieHunters.
 * 
 * @author Mac Clevinger
 *
 */

public class SlashingCareer extends Career{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** Machete constant value representing the Weapon associated to this Career*/
	private static final Machete STRENGTH = new Machete();
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the SlashingCareer type that assign the class constant.
	 * 
	 */
	
	public SlashingCareer() {
		assignPreferredWeapon(STRENGTH);
	}
	
}
