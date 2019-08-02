package hunterguild.career;

import weapon.Bow;

/**
 * This class extends the Career abstract class to specify the Archery-type Career path
 * for ZombieHunters.
 * 
 * @author Mac Clevinger
 *
 */

public class ArcheryCareer extends Career{

//---  Constant Values   ----------------------------------------------------------------------

	/** Bow constant value representing the Weapon associated to this Career*/
	private static final Bow STRENGTH = new Bow();

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the ArcheryCareer type that assign the class constant.
	 * 
	 */
	
	public ArcheryCareer() {
		assignPreferredWeapon(STRENGTH);
	}
	
}
