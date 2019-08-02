package hunterguild;

import hunterguild.career.ArcheryCareer;
import java.util.ArrayList;
import hunter.ZombieHunter;

/**
 * This class extends the abstract class ZombieHunterGuild for Archery-type guilds.
 * 
 * @author Mac Clevinger
 *
 */

public class HunterGuildArchery extends ZombieHunterGuild{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** ArcheryCareer object representing the default Career for objects of the HunterGuildArchery type.*/
	private static final ArcheryCareer CAREER = new ArcheryCareer();

//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the HunterGuildArchery object type, initializing the list of ZombieHunters
	 * assigning the provided name to this object, and assigning the class's career constant value as the career
	 * for this object..
	 * 
	 * @param title - String object representing the title/name associated to this object.
	 */
	
	public HunterGuildArchery(String title) {
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
