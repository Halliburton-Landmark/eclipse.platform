/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.core.runtime;

import org.eclipse.core.runtime.IPluginDescriptor;

/**
 * An extension point declared in a plug-in.
 * Except for the list of extensions plugged in to it, the information 
 * available for an extension point is obtained from the declaring plug-in's 
 * manifest (<code>plugin.xml</code>) file.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 */
public interface IExtensionPoint {
	/**
	 * Returns all configuration elements from all extensions configured
	 * into this extension point. Returns an empty array if this extension 
	 * point has no extensions configured, or none of the extensions 
	 * contain configuration elements.
	 *
	 * @return the configuration elements for all extension configured 
	 *   into this extension point
	 */
	public IConfigurationElement[] getConfigurationElements();
	/** 
	 * Returns the descriptor of the plug-in that declares this extension point.
	 * <p>
	 * <b>Note</b>: This is obsolete API that will be replaced in time with
	 * the OSGI-based Eclipse Platform Runtime introduced with Eclipse 3.0.
	 * This API will be deprecated once the APIs for the new Eclipse Platform
	 * Runtime achieve their final and stable form (post-3.0). </p>
	 *
	 * @return the plug-in that declares this extension point
	 */
	public IPluginDescriptor getDeclaringPluginDescriptor();

	/**
	 * Returns the identifier of the parent of this extension point.  This value can be used
	 * in various global facilities to discover the actual parent.
	 * <p>
	 * <b>Note</b>: This is an early access API to the new OSGI-based Eclipse 3.0
	 * Platform Runtime. Because the APIs for the new runtime have not yet been fully
	 * stabilized, they should only be used by clients needing to take particular
	 * advantage of new OSGI-specific functionality, and only then with the understanding
	 * that these APIs may well change in incompatible ways until they reach
	 * their finished, stable form (post-3.0). </p>
	 * 
	 * @return the idenifier of the parent
	 * @see Platform.getBundle(String)
	 * @since 3.0
	 * @deprecated Use #getNamespace instead. This method is going to be removed 
	 * after M8 
	 */
	public String getParentIdentifier();
	/**
	 * Returns the namespace for this extension point. This value can be used
	 * in various global facilities to discover this extension point's provider.
	 * <p>
	 * <b>Note</b>: This is an early access API to the new OSGI-based Eclipse 3.0
	 * Platform Runtime. Because the APIs for the new runtime have not yet been fully
	 * stabilized, they should only be used by clients needing to take particular
	 * advantage of new OSGI-specific functionality, and only then with the understanding
	 * that these APIs may well change in incompatible ways until they reach
	 * their finished, stable form (post-3.0). </p>
	 * 
	 * @return the namespace for this extension point
	 * @see Platform.getBundle(String)
	 * @see IExtensionRegistry
	 * @since 3.0
	 */	 
	public String getNamespace();	
	/**
	 * Returns the extension with the given unique identifier configured into
	 * this extension point, or <code>null</code> if there is no such extension.
	 * Since an extension might not have an identifier, some extensions
	 * can only be found via the <code>getExtensions</code> method.
	 *
	 * @param extensionId the unique identifier of an extension 
	 *		(e.g. <code>"com.example.acme.main"</code>).
	 * @return an extension, or <code>null</code>
	 */
	public IExtension getExtension(String extensionId);
	/**
	 * Returns all extensions configured into this extension point.
	 * Returns an empty array if this extension point has no extensions.
	 *
	 * @return the extensions configured into this extension point
	 */
	public IExtension[] getExtensions();
	/**
	 * Returns a displayable label for this extension point.
	 * Returns the empty string if no label for this extension point
	 * is specified in the plug-in manifest file.
	 * <p> Note that any translation specified in the plug-in manifest
	 * file is automatically applied.
	 * </p>
	 *
	 * @return a displayable string label for this extension point,
	 *    possibly the empty string
	 * @see IPluginDescriptor#getResourceString 
	 */
	public String getLabel();
	/**
	 * Returns reference to the extension point schema. The schema 
	 * reference is returned as a URL path relative to the plug-in 
	 * installation URL. 
	 * Returns the empty string if no schema for this extension point
	 * is specified in the plug-in manifest file.
	 *
	 * @return a relative URL path, or an empty string
	 * @see IPluginDescriptor#getInstallURL
	 */
	public String getSchemaReference();
	/**
	 * Returns the simple identifier of this extension point.
	 * This identifier is a non-empty string containing no
	 * period characters (<code>'.'</code>) and is guaranteed
	 * to be unique within the defining plug-in.
	 *
	 * @return the simple identifier of the extension point (e.g. <code>"builders"</code>)
	 */
	public String getSimpleIdentifier();
	/**
	 * Returns the unique identifier of this extension point.
	 * This identifier is unique within the plug-in registry, and
	 * is composed of the namespace for this extension point 
	 * and this extension point's simple identifier.
	 *
	 * @return the unique identifier of the extension point
	 *    (e.g. <code>"org.eclipse.core.resources.builders"</code>)
	 */
	public String getUniqueIdentifier();

}
