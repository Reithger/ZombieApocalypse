package hunter;

import pronoun.GenderPronoun;
import hunterguild.career.ArcheryCareer;
import hunterguild.ZombieHunterGuild;

/**
 * This class extends the ZombieHunter abstract class, specializing as a type of Hunter with
 * the ArcheryCareer (a set of classes defining what type of HunterGuild this ZombieHunter would
 * belong to, and sets a default Weapon for usage.)
 * 
 * @author Mac Clevinger
 *
 */

public class BowHunter extends ZombieHunter{
	
//---  Constant Values   ----------------------------------------------------------------------
	
	/** ArcheryCareer constant value representing the default Career to assign to any ZombieHunter of this class type.*/
	private static final ArcheryCareer CAREER = new ArcheryCareer();
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the BowHunter class, assigning the provided values and
	 * defaulting the BowHunter's career to the class constant value CAREER.
	 * 
	 * @param hunterName - String object representing the name of this BowHunter object.
	 * @param usedPronouns - GenderPronoun object representing the used pronouns of this BowHunter object.
	 * @param assocation - ZombieHunterGuild object representing the group that this BowHunter is a part of.
	 */
	
	public BowHunter(String hunterName, GenderPronoun usedPronouns, ZombieHunterGuild assocation) {
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
