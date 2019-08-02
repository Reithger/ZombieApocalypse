package pronoun;

/**
 * This class extends the abstract class GenderPronoun to define Custom pronouns.
 * 
 * @author Mac Clevinger
 *
 */

public class Custom extends GenderPronoun{

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Custom type that utilize input to define the subject,
	 * pronoun, and possessive components of a person's pronouns.
	 * 
	 * @param subj - String object representing the subject pronoun for this class.
	 * @param pron - String object representing the pronoun for this class.
	 * @param poss - String object representing the possessive pronoun for this class.
	 */
	
	public Custom(String subj, String pron, String poss) {
		subject = subj;
		pronoun = pron;
		possessive = poss;
	}
	
}
