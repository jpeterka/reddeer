package org.jboss.reddeer.eclipse.jdt.ui.preferences;

/**
 * POJO representing row in "Installed JREs" table (Preferences->Java->Installed
 * JREs).
 * 
 * @author rhopp
 *
 */

public class JREItem {

	private String name;
	private String location;
	private String type;

	/**
	 * Instantiates a new JRE item.
	 *
	 * @param name the name
	 * @param location the location
	 * @param type the type
	 */
	public JREItem(String name, String location, String type) {
		this.name = name;
		this.location = location;
		this.type = type;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
