package pronoun;

/**
 * This abstract class defines the framework for which all GenderPronoun objects should behave.
 * 
 * This class models the pronouns that a person may use to express their gender identity.
 * 
 * @author Mac Clevinger
 *
 */

public abstract class GenderPronoun {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** String object representing the subject pronoun of this GenderPronoun object.*/
	protected String subject;
	/** String object representing the pronoun of this GenderPronoun object.*/
	protected String pronoun;
	/** String object representing the possessive pronoun of this GenderPronoun object.*/
	protected String possessive;
	
//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests the subject pronoun of this GenderPronoun object.
	 * 
	 * @return - Returns a String object representing the subject pronoun of this GenderPronoun object.
	 */
	
	public String getSubject() {
		return subject;
	}

	/**
	 * Getter method that requests the pronoun of this GenderPronoun object.
	 * 
	 * @return - Returns a String object representing the pronoun of this GenderPronoun object.
	 */
	
	public String getPronoun() {
		return pronoun;
	}
	
	/**
	 * Getter method that requests the possessive pronoun of this GenderPronoun object.
	 * 
	 * @return - Returns a String object representing the possessive pronoun of this GenderPronoun object.
	 */
	
	public String getPossessive() {
		return possessive;
	}
	
}
