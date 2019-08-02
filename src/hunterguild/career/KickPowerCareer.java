package hunterguild.career;

import weapon.KickPower;

/**
 * This class extends the Career abstract class to specify the KickPower-type Career path
 * for ZombieHunters.
 * 
 * @author Mac Clevinger
 *
 */

public class KickPowerCareer extends Career {
	
//---  Constant Values   ----------------------------------------------------------------------
	
	/** KickPower constant value representing the Weapon associated to this Career*/
	private static final KickPower STRENGTH = new KickPower();

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the KickPowerCareer type that assign the class constant.
	 * 
	 */
	
	public KickPowerCareer() {
		assignPreferredWeapon(STRENGTH);
	}
	
}
