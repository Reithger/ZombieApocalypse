package hunter;

import pronoun.GenderPronoun;
import weapon.Machete;
import hunterguild.ZombieHunterGuild;
import hunterguild.career.SlashingCareer;

/**
 * This class extends the ZombieHunter abstract class, specializing as a type of Hunter with
 * the SlashingCareer (a set of classes defining what type of HunterGuild this ZombieHunter would
 * belong to, and sets a default Weapon for usage.)
 * 
 * @author Mac Clevinger
 *
 */

public class MacheteHunter extends ZombieHunter{
	
//---  Constant Values   ----------------------------------------------------------------------
	
	/** SlashingCareer constant value representing the default Career to assign to any ZombieHunter of this class type.*/
	private static final SlashingCareer CAREER = new SlashingCareer();

//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the MacheteHunter class, assigning the provided values and
	 * defaulting the MacheteHunter's career to the class constant value CAREER.
	 * 
	 * @param hunterName - String object representing the name of this MacheteHunter object.
	 * @param usedPronouns - GenderPronoun object representing the used pronouns of this MacheteHunter object.
	 * @param assocation - ZombieHunterGuild object representing the group that this MacheteHunter is a part of.
	 */
	
	public MacheteHunter(String hunterName, GenderPronoun usedPronouns, ZombieHunterGuild assocation) {
		assignWeapon(CAREER.getPreferredWeapon());
		applyNameChange(hunterName);
		chooseCareer(CAREER);
		applyPronouns(usedPronouns);
		joinGuild(assocation);
	}

//---  Setter Methods   -----------------------------------------------------------------------

	/**
	 * Setter method that resets the Career value of this object to the constant value default
	 * for this class.
	 * 
	 */
	
	public void reassignCareerWeapon() {
		assignWeapon(CAREER.getPreferredWeapon());
	}
	
}
