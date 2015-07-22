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
	
	ARISTO("aristo","aristo"),
	AFTERDARK("afterdark", "afterdark"),
	AFTERNOON("Afternoon", "afternoon"),
	AFTERWORK("Afterwork", "afterwork"),
    BLACK_TIE( "Black-Tie", "black-tie"),
    BLITZER( "Blitzer", "blitzer"),
    BLUESKY ("Bluesky", "bluesky"),
    BOOTSTRAP("Bootstrap", "bootstrap"),
    CASABLANCA("Casablanca", "casablanca"),
    CUPERTINO("Cupertino", "cupertino"),
    CRUZE( "Cruze", "cruze"),
    Dark_Hive("Dark-Hive", "dark-hive"),
    Delta("Delta", "delta"),
    DOT_LUV("Dot-Luv", "dot-luv"),
    EGGPLANT("Eggplant", "eggplant"),
    EXCITE_BIKE("Excite-Bike", "excite-bike"),
    FLICK("Flick", "flick"),
    GLASS_X("Glass-X", "glass-x"),
    HOME("Home", "home"),
    HOT_SNEAKS("Hot-Sneaks", "hot-sneaks"),
    HUMANITY("Humanity", "humanity"),
    LE_FROG("Le-Frog", "le-frog"),
    MIDNIGHT("Midnight", "midnight"),
    MINT_CHOC("Mint-Choc", "mint-choc"),
    OVERCAST("Overcast", "overcast"),
    PEPPER_GRINDER("Pepper-Grinder", "pepper-grinder"),
    REDMOND("Redmond", "redmond"),
    ROCKET("Rocket", "rocket"),
    SAM("Sam", "sam"),
    SMOOTHNESS("Smoothness", "smoothness"),
    SOUTH_STREET("South-Street", "south-street"),
    START("Start", "start"),
    SUNNY("Sunny", "sunny"),
    SWANKY_PURSE("Swanky-Purse", "swanky-purse"),
    TRONTASTIC("Trontastic", "trontastic"),
    UI_DARKNESS("UI-Darkness", "ui-darkness"),
    UI_LIGHTNESS("UI-Lightness", "ui-lightness"),
    VADER("Vader", "vader");
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

	public String getPrimeFacesTheme() {
		return primeFacesTheme;
	}
}
