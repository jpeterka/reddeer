package org.jboss.reddeer.swt.lookup;

import org.eclipse.swt.widgets.List;
import org.hamcrest.Matcher;
import org.jboss.reddeer.swt.reference.ReferencedComposite;
import org.jboss.reddeer.swt.widgets.AbstractWidget;


/**
 * List lookup containing lookup routines for List widget type
 * @author Rastislav Wagner
 * @deprecated Since 1.0.0 use {@link AbstractWidget}
 */
public class ListLookup {

	private static ListLookup instance = null;

	private ListLookup() {
	}

	/**
	 * Creates and returns instance of List Lookup
	 * 
	 * @return ListLookup instance
	 */
	public static ListLookup getInstance() {
		if (instance == null)
			instance = new ListLookup();
		return instance;
	}

	/**
	 * Return List instance
	 * 
	 * @param matcher
	 * @return List Widget matching criteria
	 */
	@SuppressWarnings({ "rawtypes" })
	public List getList(ReferencedComposite refComposite, int index, Matcher... matchers) {
		return (List)WidgetLookup.getInstance().activeWidget(refComposite, List.class, index, matchers);
	}

}
