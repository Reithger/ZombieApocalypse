package hunterguild;

import java.util.ArrayList;
import hunter.ZombieHunter;
import weapon.Weapon;
import hunterguild.career.Career;

/**
 * This abstract class describes the framework for all classes of the ZombieHunterGuild type.
 * 
 * This class models a ZombieHunterGuild, that being a collection of ZombieHunters unified
 * by a common Career path.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class ZombieHunterGuild {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** String object representing the title of this ZombieHunterGuild object.*/
	protected String guildTitle;
	/** ArrayList<<r>ZombieHunter> object representing the collection of ZombieHunters in this ZombieHunterGuild*/
	protected ArrayList<ZombieHunter> freelanceHunters;
	/** Career object representing the common Career associated to this ZombieHunterGuild*/
	protected Career guildCareer;
	
//---  Adder Methods   ------------------------------------------------------------------------
	
	/**
	 * Adder method that subscribes a ZombieHunter object to this ZombieHunterGuild object.
	 * 
	 * @param zHunt - ZombieHunter object representing the ZombieHunter to be added to this ZombieHunterGuild.
	 */
	
	public void employZombieHunter(ZombieHunter zHunt) {
		zHunt.setGuild(this);
		if(!freelanceHunters.contains(zHunt))
			freelanceHunters.add(zHunt);
	}
	
//---  Remover Methods   ----------------------------------------------------------------------

	/**
	 * Remover method that unsubscribes a ZombieHunter object from this ZombieHunterGuild object.
	 * 
	 * @param byebye - ZombieHunter object representing the ZombieHunter to be removed from this ZombieHunterGuild.
	 */
	
	public void fireZombieHunter(ZombieHunter byebye) {
		byebye.setGuild(null);
		if(freelanceHunters.contains(byebye))
			freelanceHunters.remove(byebye);
	}
	
//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests the list of ZombieHunters in this ZombieHunterGuild.
	 * 
	 * @return - Returns an ArrayList<<r>ZombieHunter> containing all ZombieHunters associated to this ZombieHunterGuild
	 */
	
	public ArrayList<ZombieHunter> getHunterRegistry(){
		return freelanceHunters;
	}
	
	/**
	 * Getter method that requests the list of ZombieHunters in this ZombieHunterGuild who possess
	 * the Weapon specified by input. (ZombieHunters are able to choose their weapon/Career within
	 * their ZombieHunterGuild if desired.)
	 * 
	 * @param type - Weapon object representing the desired Weapon used by all returned ZombieHunters
	 * @return - Returns an ArrayList<<r>ZombieHunter> containing all ZombieHunters that use the specified Weapon.
	 */
	
	public ArrayList<ZombieHunter> getHunterRegistry(Weapon type){
		ArrayList<ZombieHunter> out = new ArrayList<ZombieHunter>();
		for(ZombieHunter zH : freelanceHunters)
			if(zH.getHuntingPower().compatible(type))
				out.add(zH);
		return out;
	}

	/**
	 * Getter method that requests the list of ZombieHunters in this ZombieHunterGuild who possess
	 * the Career specified by input. (ZombieHunters are able to choose their weapon/Career within
	 * their ZombieHunterGuild if desired.)
	 * 
	 * @param type - Career object representing the desired Career used by all returned ZombieHunters
	 * @return - Returns an ArrayList<<r>ZombieHunter> containing all ZombieHunters that follow the specified Career.
	 */
	
	public ArrayList<ZombieHunter> getHunterRegistry(Career type){
		ArrayList<ZombieHunter> out = new ArrayList<ZombieHunter>();
		for(ZombieHunter zH : freelanceHunters)
			if(zH.getHunterType().compatible(type))
				out.add(zH);
		return out;
	}

	/**
	 * Getter method that requests the title of this ZombieHunterGuild.
	 * 
	 * @return - Returns a String object representing the title of this ZombieHunterGuild.
	 */
	
	public String getGuildTitle() {
		return guildTitle;
	}
	
	/**
	 * Getter method that queries whether the provided ZombieHunterGuild possesses the
	 * same name as the calling ZombieHunterGuild object, which is posed as their being the same.
	 * 
	 * @param zHG - ZombieHunterGuild object that is being compared to the calling object.
	 * @return - Returns a boolean value representing whether the objects are the same or not.
	 */
	
	public boolean queryCorresponds(ZombieHunterGuild zHG) {
		return getGuildTitle().equals(zHG.getGuildTitle());
	}

	/**
	 * Getter method that queries whether the provided Career type object is the same kind
	 * as that associated to this ZombieHunterGuild.
	 * 
	 * @param type - Career object representing the Career being compared to that of this ZombieHunterGuild.
	 * @return - Returns a boolean value representing whether the provided Career matches that of this ZombieHunterGuild.
	 */
	
	public boolean queryMatchingCareer(Career type) {
		return guildCareer.compatible(type);
	}

	/**
	 * Getter method to access the Career associated to this ZombieHunterGuild.
	 * 
	 * @return - Returns a Career object representing the Career associated to this ZombieHunterGuild.
	 */
	
	public Career getCareer() {
		return guildCareer;
	}
	
//---  Setter Methods   -----------------------------------------------------------------------

	/**
	 * Setter method that assigns a new Career to this ZombieHunterGuild object.
	 * 
	 * @param newCareer - Career object representing the new Career associated to this ZombieHunterGuild object.
	 */
	
	public void changeGuildCareer(Career newCareer) {
		guildCareer = newCareer;
	}

	/**
	 * Abstract setter method that resets the Career of this ZombieHunterGuild to a default
	 * as defined by the implementing class.
	 * 
	 */
	
	public abstract void reassignDefaultGuildCareer();

	/**
	 * Setter method that assigns the provided name as the new title of this ZombieHunterGuild.
	 * 
	 * @param newName - String object representing the new title of this ZombieHunterGuild.
	 */
	
	public void assignGuildTitle(String newName) {
		guildTitle = newName;
	}
	
//---  Operations   ---------------------------------------------------------------------------
	
	/**
	 * This method notifies all subscribers to this ZombieHunterGuild (members of the guild)
	 * to update their Career instance variable to that of the ZombieHunterGuild.
	 * 
	 */
	
	public void updateHuntersOnCareer() {
		for(ZombieHunter zH : freelanceHunters) {
			zH.notifyNewCareer();
		}
	}

}
