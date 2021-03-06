package org.jboss.reddeer.core.matcher;

import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Widget;
import org.hamcrest.Matcher;
import org.jboss.reddeer.core.handler.LinkHandler;
import org.jboss.reddeer.core.matcher.WithTextMatcher;

/**
 * Matcher matching text of {@link Link} to specified text. 
 * 
 * @author Lucia Jelinkova
 *
 */
public class LinkTextMatcher extends WithTextMatcher {
	

	/**
	 * Creates new LinkTextMatcher matching specified text to text of {@link Link}.
	 * 
	 * @param text text to match text of {@link Link}
	 */
	public LinkTextMatcher(String text) {
		super(text);
	}

	/**
	 * Creates new LinkTextMatcher matching specified string matcher to text of {@link Link}.
	 * 
	 * @param matcher matcher to match text of {@link Link}
	 */
	public LinkTextMatcher(Matcher<String> matcher) {
		super(matcher);
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.reddeer.core.matcher.AbstractWidgetWithTextMatcher#extractWidgetText(org.eclipse.swt.widgets.Widget)
	 */
	@Override
	protected String extractWidgetText(Widget widget) {
		if (widget instanceof Link){
			return LinkHandler.getInstance().getText((Link) widget);	
		}
		return null;
	}
}
