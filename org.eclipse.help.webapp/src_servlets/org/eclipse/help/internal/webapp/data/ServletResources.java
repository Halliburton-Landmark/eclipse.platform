/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.help.internal.webapp.data;

 

import javax.servlet.http.HttpServletRequest;

import org.eclipse.help.internal.webapp.WebappResources;


/**
 * Uses a resource bundle to load images and strings from
 * a property file in a documentation plugin
 */
public class ServletResources {

	/**
	 * Resources constructor.
	 */
	protected ServletResources() {
		super();
	}

	/**
	 * Returns a string from a property file.
	 * It uses 'name' as a the key to retrieve from the webapp.properties file.
	 * @param request HttpServletRequest or null; default locale will be used if null passed
	 */
	public static String getString(String name, HttpServletRequest request) {
		String property = WebappResources.getString(name, request.getLocale());
		if (property == null || property.length() <= 0) {
			return property;
		}
		int amp = property.indexOf('&');
		if (amp <= 0) {
			return property;
		}
		return property.substring(0, amp - 1)
			+ property.substring(amp + 1, property.length());
	}

	/**
	 * Returns a string from a property file.
	 * It uses 'name' as a the key to retrieve from the webapp.properties file.
	 * @param request HttpServletRequest or null; default locale will be used if null passed
	 */
	public static String getString(String name, String replace0, HttpServletRequest request) {
		String property = WebappResources.getString(name, request.getLocale(), replace0);
		if (property == null || property.length() <= 0) {
			return property;
		}
		int amp = property.indexOf('&');
		if (amp <= 0) {
			return property;
		}
		return property.substring(0, amp - 1)
			+ property.substring(amp + 1, property.length());
	}
	/**
	 * Returns a string from a property file, with underlined access key.
	 * Access key can be specified in the label by &amp: character following
	 * character in the label that is to serve as access key
	 * It uses 'name' as a the key to retrieve from the webapp.properties file.
	 * @param request HttpServletRequest or null; default locale will be used if null passed
	 */
	public static String getLabel(String name, HttpServletRequest request) {
		String property = WebappResources.getString(name, request.getLocale());
		if (property == null || property.length() <= 0) {
			return property;
		}
		int amp = property.indexOf('&');
		if (amp <= 0) {
			return property;
		}
		return property.substring(0, amp - 1)
			+ "<u>"
			+ property.charAt(amp - 1)
			+ "</u>"
			+ property.substring(amp + 1, property.length());
	}

	/**
	 * Returns access key for a named label from property file.
	 * It uses 'name' as a the key to retrieve from the webapp.properties file.
	 * @param request HttpServletRequest or null; default locale will be used if null passed
	 */
	public static String getAccessKey(String name, HttpServletRequest request) {
		String property = WebappResources.getString(name, request.getLocale());
		if (property == null || property.length() <= 0) {
			return null;
		}
		int amp = property.indexOf('&');
		if (amp <= 0) {
			return null;
		}
		return ("" + property.charAt(amp - 1)).toLowerCase();
	}

}
