/*
* Created on Jul 31, 2014
* @author Madhava
*/
package com.madhava.domain.common;

/**
 * Class Theme
 * @author Madhava
 * @since Jul 31, 2014 - 2:33:24 PM
 * @version UserManagement 1.0
 */
public enum Theme {
	
	CLASSIC("classic"),
	CLASSICLITE("classiclite", "classic"),
	EMERALDTOWN("emeraldTown"),
	ENTERPRISE("enterprise", "emeraldTown"),
	GREY("grey","DEFAULT");
	
	private final String theme;// theme for application
	private final String primeFacesTheme; // theme for Prime Faces
	
	
	/**
	 * Constructor Theme
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:38:08 PM
	 * @version UserManagement 1.0
	 * @param theme
	 */
	Theme(String theme) {
		this.theme = theme;
		this.primeFacesTheme = theme;
	}
	
	/**
	 * Constructor Theme
	 * @author Madhava
	 * @since Jul 31, 2014 - 2:38:14 PM
	 * @version UserManagement 1.0
	 * @param theme
	 * @param jsfTheme
	 */
	Theme(String theme, String jsfTheme) {
		this.theme = theme;
		this.primeFacesTheme = jsfTheme;
	}
	
	
	public String getName() {
		return name();
	}

	public String getValue() {
		return theme;
	}
}
