package pronoun;

/**
 * This class extends the abstract class GenderPronoun to define Non-Binary pronouns.
 * 
 * @author Mac Clevinger
 *
 */

public class NonBinary extends GenderPronoun{

//---  Constant Values   ----------------------------------------------------------------------
	
	/** String constant value defining the subject pronoun for this class*/
	private static final String SUBJECT = "they";
	/** String constant value defining the pronoun for this class*/
	private static final String PRONOUN = "them";
	/** String constant value defining the possessive pronoun for this class*/
	private static final String POSSESSIVE = "their";
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the NonBinary type that assign class constants to define
	 * the pronouns for this class.
	 * 
	 */
	
	public NonBinary() {
		subject = SUBJECT;
		pronoun = PRONOUN;
		possessive = POSSESSIVE;
	}
	
}
