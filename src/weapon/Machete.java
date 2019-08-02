package weapon;

/**
 * This class implements the Weapon interface, specifying it as a Machete.
 * 
 * @author Mac Clevinger
 *
 */

public class Machete implements Weapon{

//---  Constant Values   ----------------------------------------------------------------------
	
	private static final String WEAPON_IDENTITY = "Chop-Chop";
	
//---  Getter Methods   -----------------------------------------------------------------------
	
	@Override
	public String getWeaponIdentity() {
		return WEAPON_IDENTITY;
	}

	@Override
	public boolean compatible(Weapon variant) {
		return(variant.getWeaponIdentity().equals(WEAPON_IDENTITY));
	}

}
