package pronoun;

/**
 * This class extends the abstract class GenderPronoun to define Feminine pronouns.
 * 
 * @author Mac Clevinger
 *
 */

public class Feminine extends GenderPronoun{

//---  Constant Values   ----------------------------------------------------------------------

	/** String constant value defining the subject pronoun for this class*/
	private static final String SUBJECT = "she";
	/** String constant value defining the pronoun for this class*/
	private static final String PRONOUN = "her";
	/** String constant value defining the possessive pronoun for this class*/
	private static final String POSSESSIVE = "her";
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Feminine type that assign class constants to define
	 * the pronouns for this class.
	 * 
	 */
	
	public Feminine() {
		subject = SUBJECT;
		pronoun = PRONOUN;
		possessive = POSSESSIVE;
	}
	
}
