package hunterguild;

import java.util.ArrayList;
import hunterguild.career.Career;
import hunter.ZombieHunter;

/**
 * This class extends the abstract class ZombieHunterGuild for Generic-type guilds.
 * 
 * @author Mac Clevinger
 *
 */

public class GenericHunterGuild extends ZombieHunterGuild{

//---  Instance Variables   -------------------------------------------------------------------
	
	/** Career object representing the assigned default Career for this GenericHunterGuild class*/
	protected Career defaultCareer;
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the GenericHunterGuild object type, assigning the provided
	 * default value for this object's Career and initializing the list of ZombieHunters.
	 * 
	 * @param inCareer - Career object representing the default Career for this GenericHunterGuild object.
	 * @param title - String object representing the title/name associated to this GenericHunterGuild.
	 */
	
	public GenericHunterGuild(Career inCareer, String title) {
		defaultCareer = inCareer;
		changeGuildCareer(inCareer);
		assignGuildTitle(title);
		freelanceHunters = new ArrayList<ZombieHunter>();
	}
	
//---  Setter Methods   -----------------------------------------------------------------------

	@Override
	public void reassignDefaultGuildCareer() {
		changeGuildCareer(defaultCareer);
	}
}
