package org.jboss.reddeer.junit.watcher;

import java.io.IOException;

import org.jboss.reddeer.common.context.ExecutionSetting;
import org.jboss.reddeer.common.logging.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * RedDeer Watchdog hooks executed tests and performs operations when if test
 * failes
 * 
 * @author Jiri Peterka
 * 
 */
public class RedDeerWatchdog extends TestWatcher {
	Logger log = Logger.getLogger(RedDeerWatchdog.class);

	/* (non-Javadoc)
	 * @see org.junit.rules.TestWatcher#failed(java.lang.Throwable, org.junit.runner.Description)
	 */
	@Override
	protected void failed(Throwable e, Description description) {
		if (ExecutionSetting.getInstance().isPauseFailedTest()) {
			try {
				log.info("Test execution is paused because of failing test, press [Enter] to continue");
				System.in.read();
			} catch (IOException ex) {
				log.error(ex.getMessage());
			}
		}

	}
}