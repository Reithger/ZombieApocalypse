package pronoun;

/**
 * This class extends the abstract class GenderPronoun to define Masculine pronouns.
 * 
 * @author Mac Clevinger
 *
 */

public class Masculine extends GenderPronoun{

//---  Constant Values   ----------------------------------------------------------------------

	/** String constant value defining the subject pronoun for this class*/
	private static final String SUBJECT = "he";
	/** String constant value defining the pronoun for this class*/
	private static final String PRONOUN = "him";
	/** String constant value defining the possessive pronoun for this class*/
	private static final String POSSESSIVE = "his";
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Masculine type that assign class constants to define
	 * the pronouns for this class.
	 * 
	 */
	
	public Masculine() {
		subject = SUBJECT;
		pronoun = PRONOUN;
		possessive = POSSESSIVE;
	}
	
}
