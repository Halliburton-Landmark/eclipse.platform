/*******************************************************************************
 * Copyright (c) 2002, 2003 GEBIT Gesellschaft fuer EDV-Beratung
 * und Informatik-Technologien mbH, 
 * Berlin, Duesseldorf, Frankfurt (Germany) and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     GEBIT Gesellschaft fuer EDV-Beratung und Informatik-Technologien mbH - initial API and implementation
 * 	   IBM Corporation - bug 32890, bug 24108
 *******************************************************************************/

package org.eclipse.ant.internal.ui.editor.text;

/*
 * This file originates from an internal package of Eclipse's 
 * Manifest Editor. It has been copied by GEBIT to here in order to
 * permanently use those features. It has been renamed and edited by GEBIT 
 * after copying.
 */

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * Scanner that scans the document and partitions the document into the two 
 * supported content types:
 * <ul>
 * <li>XML_COMMENT</li>
 * <li>XML_TAG</li>
 * </ul>
 */
public class AntEditorPartitionScanner extends RuleBasedPartitionScanner {

	public final static String XML_COMMENT = "__xml_comment"; //$NON-NLS-1$
	public final static String XML_TAG = "__xml_tag"; //$NON-NLS-1$

    /**
     * Creates an instance.
     */
	public AntEditorPartitionScanner() {

		IPredicateRule[] rules =new IPredicateRule[2];

        IToken xmlComment = new Token(XML_COMMENT);
		rules[0]= new MultiLineRule("<!--", "-->", xmlComment, '\\', true); //$NON-NLS-1$ //$NON-NLS-2$

        IToken tag = new Token(XML_TAG);
		rules[1]= new TagRule(tag);
	
		setPredicateRules(rules);
	}
}