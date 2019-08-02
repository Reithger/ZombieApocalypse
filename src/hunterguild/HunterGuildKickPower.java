package hunterguild;

import java.util.ArrayList;
import hunter.ZombieHunter;
import hunterguild.career.KickPowerCareer;

/**
 * This class extends the abstract class ZombieHunterGuild for KickPower-type guilds.
 * 
 * @author Mac Clevinger
 *
 */

public class HunterGuildKickPower extends ZombieHunterGuild{
	
//---  Constant Values   ----------------------------------------------------------------------
	
	/** KickPowerCareer object representing the default Career for objects of the HunterGuildKickPower type.*/
	private static final KickPowerCareer CAREER = new KickPowerCareer();

//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the HunterGuildKickPower object type, initializing the list of ZombieHunters
	 * assigning the provided name to this object, and assigning the class's career constant value as the career
	 * for this object..
	 * 
	 * @param title - String object representing the title/name associated to this object.
	 */
	
	public HunterGuildKickPower(String title) {
		changeGuildCareer(CAREER);
		assignGuildTitle(title);
		freelanceHunters = new ArrayList<ZombieHunter>();
	}

//---  Setter Methods   -----------------------------------------------------------------------

	@Override
	public void reassignDefaultGuildCareer() {
		changeGuildCareer(CAREER);
	}
}
