package org.jboss.reddeer.common.condition;

/**
 * Abstract implementation of {@link WaitCondition} which provides initial
 * implementations of description() and erroMessage(). The method description()
 * returns a canonical name of the implementing class. The method errorMessage()
 * simply calls the method description().
 * 
 * @author Andrej Podhradsky
 *
 */
public abstract class AbstractWaitCondition implements WaitCondition {

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.common.condition.WaitCondition#description()
	 */
	@Override
	public String description() {
		return getClass().getCanonicalName();
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.common.condition.WaitCondition#errorMessage()
	 */
	@Override
	public String errorMessage() {
		return description();
	}

}
