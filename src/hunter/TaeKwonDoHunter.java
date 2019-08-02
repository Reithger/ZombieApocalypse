package hunter;

import hunterguild.ZombieHunterGuild;
import hunterguild.career.KickPowerCareer;
import pronoun.GenderPronoun;

/**
 * This class extends the ZombieHunter abstract class, specializing as a type of Hunter with
 * the KickPowerCareer (a set of classes defining what type of HunterGuild this ZombieHunter would
 * belong to, and sets a default Weapon for usage.)
 * 
 * @author Mac Clevinger
 *
 */

public class TaeKwonDoHunter extends ZombieHunter{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** KickPowerCareer constant value representing the default Career to assign to any ZombieHunter of this class type.*/
	private static final KickPowerCareer CAREER = new KickPowerCareer();

//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the TaeKwonDoHunter class, assigning the provided values and
	 * defaulting the TaeKwonDoHunter's career to the class constant value CAREER.
	 * 
	 * @param hunterName - String object representing the name of this TaeKwonDoHunter object.
	 * @param usedPronouns - GenderPronoun object representing the used pronouns of this TaeKwonDoHunter object.
	 * @param assocation - ZombieHunterGuild object representing the group that this TaeKwonDoHunter is a part of.
	 */
	
	public TaeKwonDoHunter(String hunterName, GenderPronoun usedPronouns, ZombieHunterGuild assocation) {
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
