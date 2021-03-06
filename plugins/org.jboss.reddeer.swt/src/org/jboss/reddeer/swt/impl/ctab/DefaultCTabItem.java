package org.jboss.reddeer.swt.impl.ctab;

import org.eclipse.swt.custom.CTabItem;
import org.hamcrest.Matcher;
import org.jboss.reddeer.core.matcher.WithMnemonicTextMatcher;
import org.jboss.reddeer.core.reference.ReferencedComposite;

/**
 * Default CTabItem implementation
 * @author Vlado Pakan
 *
 */
public class DefaultCTabItem extends AbstractCTabItem {

	/**
	 * Default parameter-less constructor.
	 */
	public DefaultCTabItem() {
		this(0);
	}
	
	/**
	 * CTabItem inside given composite.
	 *
	 * @param referencedComposite the referenced composite
	 */
	public DefaultCTabItem(ReferencedComposite referencedComposite) {
		this(referencedComposite, 0);
	}
	
	/**
	 * CTabItem with specified text will be constructed .
	 *
	 * @param text the text
	 */
	public DefaultCTabItem(String text) {
		this(null, text);
	}
	
	/**
	 * CTabItem with specified text inside given composite will be constructed .
	 *
	 * @param referencedComposite the referenced composite
	 * @param text the text
	 */
	public DefaultCTabItem(ReferencedComposite referencedComposite, String text) {
		this(referencedComposite, 0, new WithMnemonicTextMatcher(text));
	}
	
	/**
	 * CTabItem that matches given matchers.
	 *
	 * @param matchers the matchers
	 */
	public DefaultCTabItem(Matcher<?>... matchers) {
		this(null, matchers);
	}
	
	/**
	 * CTabItem that matches given matchers.
	 *
	 * @param referencedComposite the referenced composite
	 * @param matchers the matchers
	 */
	public DefaultCTabItem(ReferencedComposite referencedComposite, Matcher<?>... matchers) {
		this(referencedComposite, 0, matchers);
	}
	
	/**
	 * CTabItem with specified index will be constructed .
	 *
	 * @param index the index
	 * @param matchers the matchers
	 */
	public DefaultCTabItem(int index, Matcher<?>... matchers) {
		this(null, index, matchers);
	}
	
	/**
	 * CTabItem with specified index inside given composite will be constructed .
	 *
	 * @param referencedComposite the referenced composite
	 * @param index the index
	 * @param matchers the matchers
	 */
	public DefaultCTabItem(ReferencedComposite referencedComposite, int index, Matcher<?>... matchers) {
		super(referencedComposite, index, matchers);
	}
	
	/**
	 * Constructs CTabItem from given swt widget
	 * @param swtWidget
	 */
	DefaultCTabItem(CTabItem swtWidget){
		super(swtWidget);
	}
}
