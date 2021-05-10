package org.facebook;

import org.baseclass.BaseClass;

public class Facebook extends BaseClass {
	public static void main(String[] args) {
		getDriver();
		launchUrl("www.facebook.com");
		enterText(findElementId("email"), "rushan");
		enterText(findElementId("pass"), "rushan");

	}
}
