package weapon;

/**
 * This class implements the Weapon interface, specifying it as a Bow.
 * 
 * @author Mac Clevinger
 *
 */

public class Bow implements Weapon{

//---  Constant Values   ----------------------------------------------------------------------
	
	private static final String WEAPON_IDENTITY = "Arrow Strike";
	
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
