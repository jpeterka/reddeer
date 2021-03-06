package org.jboss.reddeer.workbench.condition;

import org.jboss.reddeer.common.condition.AbstractWaitCondition;
import org.jboss.reddeer.workbench.impl.editor.DefaultEditor;

/**
 * Check whether editor is active
 * @author rawagner
 *
 */
public class EditorWithTitleIsActive extends AbstractWaitCondition {
	
	private String title;
	
	/**
	 * Default constructor.
	 *
	 * @param title of editor
	 */
	public EditorWithTitleIsActive(String title){
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.common.condition.WaitCondition#test()
	 */
	@Override
	public boolean test() {
		return new DefaultEditor().getTitle().equals(title);
	}

	/* (non-Javadoc)
	 * @see org.jboss.reddeer.common.condition.AbstractWaitCondition#description()
	 */
	@Override
	public String description() {
		return "Editor title is "+title;
	}

}
