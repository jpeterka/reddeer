package org.jboss.reddeer.uiforms.impl.section;

import org.eclipse.swt.widgets.Control;
import org.hamcrest.Matcher;
import org.jboss.reddeer.core.handler.WidgetHandler;
import org.jboss.reddeer.core.reference.ReferencedComposite;
import org.jboss.reddeer.swt.widgets.AbstractWidget;
import org.jboss.reddeer.uiforms.api.Section;
import org.jboss.reddeer.core.handler.SectionHandler;

/**
 * Common ancestor for all {@link Section} implementations. 
 * 
 * @author Lucia Jelinkova
 *
 */
public abstract class AbstractSection extends AbstractWidget<org.eclipse.ui.forms.widgets.Section> implements Section {

	/**
	 * Instantiates a new abstract section.
	 *
	 * @param refComposite the ref composite
	 * @param index the index
	 * @param matchers the matchers
	 */
	protected AbstractSection(ReferencedComposite refComposite, int index, Matcher<?>... matchers){
		super(org.eclipse.ui.forms.widgets.Section.class, refComposite, index, matchers);
		setFocus();
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.reddeer.core.reference.ReferencedComposite#getControl()
	 */
	public Control getControl() {
		return swtWidget;
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.uiforms.api.Section#getText()
	 */
	public String getText() {
		return WidgetHandler.getInstance().getText(swtWidget);
	}
	
	/**
	 * Sets the focus.
	 */
	protected void setFocus() {
		WidgetHandler.getInstance().setFocus(swtWidget);
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.reddeer.uiforms.api.Section#setExpanded(boolean)
	 */
	public void setExpanded(final boolean expanded) {
		SectionHandler.getInstance().setExpanded(swtWidget, expanded);
	}
}
