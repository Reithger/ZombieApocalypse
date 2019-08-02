package town;

import java.util.ArrayList;

import horde.Horde;
import hunterguild.ZombieHunterGuild;

/**
 * This class extends the Town abstract class to model the specific town of Sackville
 * 
 * @author Mac Clevinger
 *
 */

public class Sackville extends Town{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** String constant value representing the default name of this Town object*/
	private static final String TOWN_NAME = "Sackville";
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Sackville type, assigning the default constant-value
	 * name for the town and initializing the lists of ZombieHunterGuilds and Hordes.
	 * 
	 */
	
	public Sackville() {
		renameTown(TOWN_NAME);
		hunterGuilds = new ArrayList<ZombieHunterGuild>();
		epidemicHordes = new ArrayList<Horde>();
	}
	
}
