import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;



/**
 * The Class Person.
 */
public class Person {
	
	/** The name of person. */
	String name;
	
	/** The birthday of person. */
	LocalDate birthday;
	
	/** The location of person. */
	ArrayList<Double> location;
	
	/** The address of person. */
	Address address = new Address();

	/**
	 * The main method for testing functions.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Person John = new Person("John", "2002-01-30", 40.789, -73.347, "3827 Overland Ave, Culver City, CA 90232");
		Person Jillian = new Person("Jillian", "1984-04-10", 80.473, -2.478, "4893 N Overland Ave, Los Angeles, CA 90232");
		Person Narveen = new Person("Narveen", "1999-04-12", 75.832, 52.874, "1245 Dating St, Los Angeles, CA 90232");
		Person Kayla = new Person("Kayla", "1997-03-25", 12.832, 8.839, "5678 Relationship Dr, Culver City, CA 90232");
		
		Person Rodger = new Person("Rodger", "1995-03-22", 13.832, 7.839, "3827 Underland Ave, Cupertino, CA 95014");
		
		Person[] personArray = new Person[4];
		personArray[0] = John;
		personArray[1] = Jillian;
		personArray[2] = Narveen;
		personArray[3] = Kayla;
		
		System.out.println("The closest person to Rodger is " + Rodger.getClosestPerson(personArray));
		
		HashMap<String, List<Person>> h = groupPeople(personArray);
		for (Entry<String, List<Person>> entry: h.entrySet()) {
			 String key = entry.getKey();
			 List<Person> p = entry.getValue();
			 System.out.println("Key: " + key + "  Value: " + (Arrays.toString(p.toArray())));
		}
		
	}
	
	/**
	 * Instantiates a new person.
	 *
	 * @param n the name
	 * @param d the birthday
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param addrs the address
	 */
	public Person(String n, String d, double latitude, double longitude, String addrs) {
		name = n;
		birthday = LocalDate.parse(d);
		location = new ArrayList<Double>();
		location.add(latitude);
		location.add(longitude);
		address.SetAddress(addrs);
	}
	
	/**
	 * Gets the closest person.
	 *
	 * @param array the array of people with whom to compare locations with.
	 * @return the closest person
	 */
	public Person getClosestPerson(Person[] array) {
		Person closest = null;
		double closestDistance = this.distance(array[0]);
		for (int i = 0; i < array.length; i++) {
			if (this.distance(array[i]) < closestDistance) {
				closest = array[i];
				closestDistance = this.distance(array[i]);
			}
		}
		return closest;
	}
	
	
	/**
	 * A helper function for getClosestPerson. Used to find the "as the crow flies" distance between two geo-coordinates. 
	 *
	 * @param p the person
	 * @return the distance
	 */
	public double distance(Person p) {
		//Convert all longitude and latitude to radians
		double myLat = Math.toRadians(this.location.get(0));
		double myLong = Math.toRadians(this.location.get(1));
		double otherLat = Math.toRadians(p.location.get(0));
		double otherLong = Math.toRadians(p.location.get(1));
		
		//find difference between longitude and latitude
		double dlon = otherLong - myLong;  
	    double dlat = otherLat - myLat; 
	    
	    //Use Haversine formula
	    double a = Math.pow(Math.sin(dlat / 2), 2) 
                + Math.cos(myLat) * Math.cos(otherLat) 
                * Math.pow(Math.sin(dlon / 2),2);
	   
	    double c = 2 * Math.asin(Math.sqrt(a));
	    double r = 3956; //radius of Earth in miles
	    
	    return (c * r); //calculate result
	}
	
	/**
	 * Group people based on matching cities and states.
	 *
	 * @param array the array of people.
	 * @return a hashmap containing a key (city and state) and value (list of people)
	 */
	public static HashMap<String, List<Person>> groupPeople(Person[] array) {
		HashMap<String, List<Person>> hashMap = new HashMap<String, List<Person>>();
		for (int i = 0; i < array.length; i++) {
			String cityAndState = (array[i].address.city) + (array[i].address.state);
			if (!hashMap.containsKey(cityAndState)) {
			    List<Person> list = new ArrayList<Person>();
			    list.add(array[i]);

			    hashMap.put(cityAndState, list);
			} else {
			    hashMap.get(cityAndState).add(array[i]);
			}
		}
		return hashMap;
	}
	
	/**
	 * overriding the to string.
	 *
	 * @return the name of person
	 */
	@Override
    public String toString() { 
        return String.format(this.name); 
    } 

}
