package org.jboss.reddeer.swt.keyboard;

import org.jboss.reddeer.common.platform.RunningPlatform;
import org.jboss.reddeer.swt.keyboard.internal.DefaultKeyboard;
import org.jboss.reddeer.swt.keyboard.internal.MacKeyboard;

/**
 * Factory class determining which keyboard will be used based on current OS.
 * 
 * @author rhopp
 *
 */

public class KeyboardFactory {

	/**
	 * Gets the keyboard.
	 *
	 * @return the keyboard
	 */
	public static Keyboard getKeyboard() {
		if (RunningPlatform.isOSX()) {
			return new MacKeyboard();
		} else {
			return new DefaultKeyboard();
		}
	}

}
