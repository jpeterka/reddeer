package org.jboss.reddeer.uiforms.api;

import org.jboss.reddeer.core.reference.ReferencedComposite;
import org.jboss.reddeer.swt.widgets.Widget;

/**
 * Represents Section object. 
 * 
 * @author Lucia Jelinkova
 *
 */
public interface Section extends ReferencedComposite, Widget {

	/**
	 * Returns the title of the section. 
	 *
	 * @return the text
	 */
	String getText();
	
	
	/**
	 * Sets the expansion state of the section. 
	 *
	 * @param expanded the new expanded
	 */
	void setExpanded(boolean expanded);
}
