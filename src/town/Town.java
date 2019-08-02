package town;

import zombie.HuntableZombie;
import hunter.ZombieHunter;
import weapon.Weapon;
import horde.symbol.FactionSymbol;
import horde.Horde;
import hunterguild.ZombieHunterGuild;
import java.util.ArrayList;
import hunterguild.career.Career;

/**
 * This abstract class defines the framework that all Town objects must abide by.
 * 
 * This class models Towns, which possess a name and a collection of ZombieHunterGuilds and
 * Hordes, while also permitting individual ZombieHunters and HuntableZombies to be pitted
 * against one another.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class Town {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** String object representing the name associated to this Town object*/
	String townName;
	/** ArrayList<<r>ZombieHunterGuild> object representing the ZombieHunterGuilds associated to this Town object*/
	ArrayList<ZombieHunterGuild> hunterGuilds;
	/** ArrayList<<r>Horde> object representing the Hordes associated to this Town object*/
	ArrayList<Horde> epidemicHordes;
	
//---  Operations   ---------------------------------------------------------------------------

	/**
	 * This method pits a ZombieHunter against a HuntableZombie, either removing the
	 * HuntableZombie if their vulnerability matched the hunter's weapon, or removing
	 * the ZombieHunter if they did not match.
	 * 
	 * @param hunter - ZombieHunter object being instructed to fight the provided HuntableZombie
	 * @param zomB - HuntableZombie object being instructed to fight the provided ZombieHunter
	 * @return - Returns a boolean value representing the result of the conflict; true if the ZombieHunter won, false otherwise
	 */
	
	public boolean orderSlaying(ZombieHunter hunter, HuntableZombie zomB) {
		boolean result = hunter.attackZombie(zomB);
		if(result) {
			exileZombie(zomB);
			return true;
		}
		else {
			fireZombieHunter(hunter);
			return false;
		}
	}
	
//---  Adder Methods   ------------------------------------------------------------------------

	/**
	 * Adder method that subscribes the provided ZombieHunter to whichever ZombieHunterGuild
	 * matches their chosen Career. (If no ZombieHunterGuild is present that matches their
	 * Career, they are not added.)
	 * 
	 * @param newbie - ZombieHunter object being added to this Town via a ZombieHunterGuild already present
	 * @return - Returns a boolean value; true if the ZombieHunter was added to a ZombieHunterGuild, false otherwise
	 */
	
	public boolean employZombieHunter(ZombieHunter newbie) {
		Career car = newbie.getHunterType();
		for(ZombieHunterGuild zHG : hunterGuilds) {
			if(zHG.queryMatchingCareer(car)) {
				zHG.employZombieHunter(newbie);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adder method that subscribes the provided ZombieHunter to the ZombieHunterGuild in this
	 * Town object that corresponds to the provided ZombieHunterGuild; if no such ZombieHunterGuild
	 * is found, add the reference ZombieHunterGuild object to the Town and subscribe the ZombieHunter.
	 * 
	 * @param newbie - ZombieHunter object being added to this Town via the provided ZombieHunterGuild.
	 * @param reference - ZombieHunterGuild object representing the guild to which the provided ZombieHunter is being added.
	 */
	
	public void employZombieHunter(ZombieHunter newbie, ZombieHunterGuild reference) {
		for(ZombieHunterGuild zHG : hunterGuilds) {
			if(zHG.queryCorresponds(reference)) {
				zHG.employZombieHunter(newbie);
			}
		}
		ratifyNewGuild(reference);
		reference.employZombieHunter(newbie);
	}

	/**
	 * Adder method that subscribes the provided HuntableZombie to whichever Horde has
	 * a matching FactionSymbol to the one possessed by the provided HuntableZombie.
	 * (Returns false if no such match was found.)
	 * 
	 * @param zomB - HuntableZombie object being added to this Town via a pre-existing Horde
	 * @return - Returns a boolean value representing the result of this addition; true if succesful, false otherwise.
	 */
	
	public boolean attractZombie(HuntableZombie zomB) {
		FactionSymbol facSymb = zomB.getFactionSymbol();
		for(Horde h : epidemicHordes) {
			if(h.queryMatchingSymbol(facSymb)) {
				h.employZombie(zomB);
				return true;
			}
		}
		return false;
	}

	/**
	 * Adder method that subscribes the provided HuntableZombie to the Horde in this Town
	 * that corresponds to the provided Horde object; if no such match is found, add the
	 * reference Horde and subscribe the provided HuntableZombie to it.
	 * 
	 * @param zomB - HuntableZombie object being added to this Town via a provided Horde
	 * @param reference - Horde object provided as reference to which Horde to add the provided HuntableZombie to.
	 */
	
	public void attactZombie(HuntableZombie zomB, Horde reference) {
		for(Horde h : epidemicHordes) {
			if(h.queryCorrespond(reference)) {
				h.employZombie(zomB);
			}
		}
		amalgamateNewHorde(reference);
		reference.employZombie(zomB);
	}

	/**
	 * Adder method that adds a new ZombieHunterGuild object to the list maintained by
	 * this Town object. (So long as no existing ZombieHunterGuild corresponds to the
	 * provided object.)
	 * 
	 * @param collective - ZombieHunterGuild object being added to this Town object. 
	 * @return - Returns a boolean value representing the result of this operation; true if added, false if not.
	 */
	
	public boolean ratifyNewGuild(ZombieHunterGuild collective) {
		for(ZombieHunterGuild zHG : hunterGuilds) {
			if(zHG.queryCorresponds(collective)) {
				return false;
			}
		}
		hunterGuilds.add(collective);
		return true;
	}

	/**
	 * Adder method that adds a new Horde object to the list maintained by this Town object.
	 * (So long as no existing Horde corresponds to the provided object.)
	 * 
	 * @param collective - Horde object being added to this town.
	 * @return - Returns a boolean value representing the result of this operation; true if added, false otherwise.
	 */
	
	public boolean amalgamateNewHorde(Horde collective) {
		for(Horde h : epidemicHordes) {
			if(h.queryCorrespond(collective)) {
				return false;
			}
		}
		epidemicHordes.add(collective);
		return true;
	}
	
//---  Remover Methods   ----------------------------------------------------------------------
	
	/**
	 * Remover method that unsubscribes the provided ZombieHunter from their ZombieHunterGuild.
	 * 
	 * @param trash - ZombieHunter object being removed from this Town (by being removed from their ZombieHunterGuild)
	 */
	
	public void fireZombieHunter(ZombieHunter trash) {
		trash.quitGuild();
	}
	
	/**
	 * Remover method that unsubscribes the provided HuntableZombie from their Horde.
	 * 
	 * @param trash - HuntableZombie object being removed from this Town (by being removed from their Horde)
	 */
	
	public void exileZombie(HuntableZombie trash) {
		trash.leaveHorde();
	}

	/**
	 * Remover method that removes the provided ZombieHunterGuild from this Town (if
	 * it is present in the list stored by the Town.)
	 * 
	 * @param collective - ZombieHunterGuild object being removed from this Town
	 * @return - Returns a boolean value representing the result of this operation; true if successful, false otherwise
	 */
	
	public boolean dissolveGuild(ZombieHunterGuild collective) {
		for(ZombieHunterGuild zHG : hunterGuilds) {
			if(zHG.queryCorresponds(collective)) {
				hunterGuilds.remove(zHG);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remover method that removes the provided Horde from this Town (if it is present
	 * in the list stored by the Town.)
	 * 
	 * @param collective - Horde object being removed from this Town
	 * @return - Returns a boolean value representing the result of this operation; true if successful, false otherwise
	 */
	
	public boolean dissolveHorde(Horde collective) {
		for(Horde h : epidemicHordes) {
			if(h.queryCorrespond(collective)) {
				epidemicHordes.remove(h);
				return true;
			}
		}
		return false;
	}
	
//---  Setter Methods   -----------------------------------------------------------------------

	/**
	 * Setter method that reassigns a new name to this Town object.
	 * 
	 * @param name - String object representing the new name of this Town object.
	 */
	
	public void renameTown(String name) {
		townName = name;
	}
	
//---  Getter Methods   -----------------------------------------------------------------------

	/**
	 * Getter method that requests the name of this Town object.
	 * 
	 * @return - Returns a String object representing the name of this Town object.
	 */
	
	public String getTownName() {
		return townName;
	}

	//-- Hunters  ---------------------------------------------

	/**
	 * Getter method that requests a list of ZombieHunters associated to this Town object.
	 * (Compiles a list of ZombieHunters from each ZombieHunterGuild.)
	 * 
	 * @return - Returns an ArrayList<<r>ZombieHunter> object containing all ZombieHunters in this Town.
	 */
	
	public ArrayList<ZombieHunter> seeZombieHunterRegistry() {
		ArrayList<ZombieHunter> out = new ArrayList<ZombieHunter>();
		for(ZombieHunterGuild zHG : hunterGuilds) {
			out.addAll(zHG.getHunterRegistry());
		}
		return out;
	}
	
	/**
	 * Getter method that requests a list of ZombieHunters associated to this Town object that
	 * share in the provided Career. (Compiles a list of ZombieHunters from each ZombieHunterGuild.)
	 * 
	 * @param type - Career object representing the desired Career type of each returned ZombieHunter.
	 * @return - Returns an ArrayList<<r>ZombieHunter> object containing all ZombieHunters in this Town meeting criteria.
	 */
	
	public ArrayList<ZombieHunter> seeZombieHunterRegistry(Career type){
		ArrayList<ZombieHunter> out = new ArrayList<ZombieHunter>();
		for(ZombieHunterGuild zHG : hunterGuilds) {
			out.addAll(zHG.getHunterRegistry(type));
		}
		return out;
	}
	
	/**
	 * Getter method that requests a list of ZombieHunters associated to this Town object that
	 * share in the provided Weapon. (Compiles a list of ZombieHunters from each ZombieHunterGuild.)
	 * 
	 * @param type - Weapon object representing the desired Weapon type of each returned ZombieHunter.
	 * @return - Returns an ArrayList<<r>ZombieHunter> object containing all ZombieHunters in this Town meeting criteria.
	 */
	
	public ArrayList<ZombieHunter> seeZombieHunterRegistry(Weapon type) {
		ArrayList<ZombieHunter> out = new ArrayList<ZombieHunter>();
		for(ZombieHunterGuild zHG : hunterGuilds) {
			out.addAll(zHG.getHunterRegistry(type));
		}
		return out;
	}
	
	/**
	 * Getter method that requests the list of ZombieHunterGuilds associated to this Town object.
	 * 
	 * @return - Returns an ArrayList<<r>ZombieHunterGuild> object containing all ZombieHunterGuilds in this Town.
	 */
	
	public ArrayList<ZombieHunterGuild> seeZombieHunterGuilds(){
		return hunterGuilds;
	}
	
	/**
	 * Getter method that requests the list of ZombieHunterGuilds associated to this Town object that
	 * meet the criteria of being of the same Career as that provided to this method.
	 * 
	 * @param type - Career object representing the desired Career type of each returned ZombieHunterGuild
	 * @return - Returns an ArrayList<<r>ZombieHunterGuild> object containing all ZombieHunterGuilds in this Town meeting criteria.
	 */
	
	public ArrayList<ZombieHunterGuild> seeZombieHunterGuilds(Career type){
		ArrayList<ZombieHunterGuild> out = new ArrayList<ZombieHunterGuild>();
		for(ZombieHunterGuild zHG : hunterGuilds) {
			if(zHG.queryMatchingCareer(type)) {
				out.add(zHG);
			}
		}
		return out;
	}
	
	//-- Zombies  ---------------------------------------------
	
	/**
	 * Getter method that requests the list of all HuntableZombies associated to this Town object.
	 * (Compiles a list of HuntableZombies from each Horde.)
	 * 
	 * @return - Returns an ArrayList<<r>HuntableZombie> object containing the HuntableZombies associated to this Town.
	 */
	
	public ArrayList<HuntableZombie> seeZombieRegistry() {
		ArrayList<HuntableZombie> out = new ArrayList<HuntableZombie>();
		for(Horde h : epidemicHordes) {
			out.addAll(h.getZombieRegistry());
		}
		return out;
	}

	/**
	 * Getter method that requests the list of all HuntableZombies associated to this Town object
	 * that match the criteria of possessing the FactionSymbol provided to this method. (Compiles a list
	 * of HuntableZombies from each Horde.)
	 * 
	 * @param type - FactionSymbol object representing the Faction which all returned HuntableZombies must share.
	 * @return - Returns an ArrayList<<r>HuntableZombie> object representing the list of all HuntableZombies meeting criteria
	 */
	
	public ArrayList<HuntableZombie> seeZombieRegistry(FactionSymbol type) {
		ArrayList<HuntableZombie> out = new ArrayList<HuntableZombie>();
		for(Horde h : epidemicHordes) {
			if(h.queryMatchingSymbol(type))
				out.addAll(h.getZombieRegistry());
		}
		return out;
	}
	
	/**
	 * Getter method that requests the list of all Hordes associated to this Town object.
	 * 
	 * @return - Returns an ArrayList<<r>Horde> object representing the list of all Hordes in this Town object.
	 */
	
	public ArrayList<Horde> seeZombieHordes() {
		return epidemicHordes;
	}
		
	/**
	 * Getter method that requests the list of all Hordes associated to this Town object that possess
	 * a corresponding FactionSymbol to the one provided to this method.
	 * 
	 * @param type - FactionSymbol object representing the Faction to which all returned Hordes should be
	 * @return - Returns an ArrayList<<r>Horde> representing the list of Hordes in this Town object that meet criteria.
	 */
	
	public ArrayList<Horde> seeZombieHordes(FactionSymbol type) {
		ArrayList<Horde> out = new ArrayList<Horde>();
		for(Horde h : epidemicHordes) {
			if(h.queryMatchingSymbol(type))
				out.add(h);
		}
		return out;
	}

}