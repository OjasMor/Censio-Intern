
/**
 * The Class Address is a helper class to be used in tandem with the Person Class.
 */
public class Address {
	
	/** The street num. */
	String streetNum;
	
	/** The street. */
	String street;
	
	/** The city. */
	String city;
	
	/** The state. */
	String state;
	
	/** The zip. */
	String zip;
	
	/**
	 * Instantiates a new address.
	 */
	public Address() {
		
	}
	
	/**
	 * Sets the address.
	 *
	 * @param s the street address
	 */
	public void SetAddress(String s) {
		streetNum = s.substring(0, s.indexOf(" "));
		street = s.substring(s.indexOf(" ") + 1, s.indexOf(","));
		city = s.substring(s.indexOf(",") + 2, s.lastIndexOf(","));
		state = s.substring(s.lastIndexOf(",") + 2, s.lastIndexOf(" "));
		zip = s.substring(s.lastIndexOf(" ") + 1);
	}
}
