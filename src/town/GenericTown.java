package town;

import java.util.ArrayList;
import hunterguild.ZombieHunterGuild;
import horde.Horde;

/**
 * This class extends the Town abstract class to model Generic Towns of any name.
 * 
 * @author Mac Clevinger
 *
 */

public class GenericTown extends Town{

//---  Constructors   -------------------------------------------------------------------------	

	/**
	 * Constructor for objects of the GenericTown type, assigning the provided String
	 * name for the town and initializing the lists of ZombieHunterGuilds and Hordes.
	 * 
	 */
	
	public GenericTown(String inName) {
		renameTown(inName);
		hunterGuilds = new ArrayList<ZombieHunterGuild>();
		epidemicHordes = new ArrayList<Horde>();
	}
	
}
