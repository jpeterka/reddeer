package org.jboss.reddeer.swt.impl.spinner;

import org.hamcrest.Matcher;
import org.jboss.reddeer.swt.api.Spinner;
import org.jboss.reddeer.core.matcher.WithLabelMatcher;
import org.jboss.reddeer.core.reference.ReferencedComposite;

/**
 * Default Spinner implementation. Most standard Spinner implementation
 * 
 * @author Andrej Podhradsky
 * 
 */
public class DefaultSpinner extends AbstractSpinner implements Spinner {

	/**
	 * Spinner with index 0.
	 */
	public DefaultSpinner(){
		this((ReferencedComposite) null);
	}
	
	/**
	 * Spinner with index 0 inside given composite.
	 *
	 * @param referencedComposite the referenced composite
	 */
	public DefaultSpinner(ReferencedComposite referencedComposite){
		this(referencedComposite, 0);
	}
	
	/**
	 * Spinner with given label.
	 *
	 * @param label of Spinner
	 */
	public DefaultSpinner(String label){
		this(null, label);
	}
	
	/**
	 * Spinner with given label inside given composite.
	 *
	 * @param referencedComposite the referenced composite
	 * @param label of Spinner
	 */
	public DefaultSpinner(ReferencedComposite referencedComposite, String label){
		this(referencedComposite, 0, new WithLabelMatcher(label));
	}
	
	/**
	 * Spinner that matches given matchers.
	 *
	 * @param matchers the matchers
	 */
	public DefaultSpinner(Matcher<?>... matchers){
		this(null, matchers);
	}
	
	/**
	 * Spinner that matches given matchers inside given composite.
	 *
	 * @param referencedComposite the referenced composite
	 * @param matchers the matchers
	 */
	public DefaultSpinner(ReferencedComposite referencedComposite, Matcher<?>... matchers){
		this(referencedComposite, 0, matchers);
	}
	
	/**
	 * Spinner with given index that matches given matchers.
	 *
	 * @param index of Spinner
	 * @param matchers the matchers
	 */
	public DefaultSpinner(int index, Matcher<?>... matchers){
		this(null, index, matchers);
	}
	
	/**
	 * Spinner with given index that matches given matchers inside given composite.
	 *
	 * @param referencedComposite the referenced composite
	 * @param index of Spinner
	 * @param matchers the matchers
	 */
	public DefaultSpinner(ReferencedComposite referencedComposite, int index, Matcher<?>... matchers){
		super(referencedComposite, index, matchers);
	}
}
