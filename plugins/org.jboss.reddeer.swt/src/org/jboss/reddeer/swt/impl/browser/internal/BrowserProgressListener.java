package org.jboss.reddeer.swt.impl.browser.internal;

import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.swt.api.Browser;
/**
 * Internal Progress Listener of Browser 
 * @author Vlado Pakan
 *
 */
public class BrowserProgressListener implements ProgressListener {
	private final Browser browser;
	private boolean done = true;
	private int numCalledIsDoneWithNoChange = 0;
	private static final Logger log = Logger.getLogger(BrowserProgressListener.class);
	
	/**
	 * Instantiates a new browser progress listener.
	 *
	 * @param browser the browser
	 */
	public BrowserProgressListener(Browser browser) {
		this.browser = browser;
	}

	/**
	 * Returns true in case page is loaded completely or
	 * there is no change after calling this method more then 20 times
	 * because on MS Windows method completed is not called properly
	 *
	 * @return true, if is done
	 */
	public synchronized boolean isDone() {
		log.debug("Calling isDone()");		
		numCalledIsDoneWithNoChange++;
		return done || numCalledIsDoneWithNoChange > 20;
	}

	/**
	 * Sets if the page is done loading or not-
	 *
	 * @param done true if done, false if not
	 */
	public synchronized void setDone(boolean done) {
		this.done = done;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.browser.ProgressListener#changed(org.eclipse.swt.browser.ProgressEvent)
	 */
	public synchronized void changed(ProgressEvent event) {
		log.debug("Calling chanded()");
		numCalledIsDoneWithNoChange = 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.browser.ProgressListener#completed(org.eclipse.swt.browser.ProgressEvent)
	 */
	public void completed(ProgressEvent event) {
		setDone(true);
		browser.getSWTWidget().removeProgressListener(this);
	}

}
