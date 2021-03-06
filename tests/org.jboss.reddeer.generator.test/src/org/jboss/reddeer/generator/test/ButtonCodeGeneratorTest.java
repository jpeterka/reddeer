package org.jboss.reddeer.generator.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.jboss.reddeer.generator.ButtonCodeGenerator;
import org.jboss.reddeer.generator.CodeGenerator;
import org.jboss.reddeer.core.util.Display;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author apodhrad
 *
 */
public class ButtonCodeGeneratorTest {

	private static CodeGenerator codeGenerator = new ButtonCodeGenerator();

	@Test
	public void getConstructorPushButtonTest() {
		Display.syncExec(new Runnable() {

			@Override
			public void run() {
				Button button = new Button(new Shell(), SWT.PUSH);
				button.setText("Test");
				Assert.assertEquals("new PushButton(\"Test\")", codeGenerator.getConstructor(button));
			}
		});
	}

	@Test
	public void getConstructorCheckButtonTest() {
		Display.syncExec(new Runnable() {

			@Override
			public void run() {
				Button button = new Button(new Shell(), SWT.CHECK);
				button.setText("Test");
				Assert.assertEquals("new CheckBox(\"Test\")", codeGenerator.getConstructor(button));
			}
		});
	}

	@Test
	public void getConstructorArrowButtonTest() {
		Display.syncExec(new Runnable() {

			@Override
			public void run() {
				Button button = new Button(new Shell(), SWT.ARROW);
				button.setText("Test");
				Assert.assertEquals("new ArrowButton(0)", codeGenerator.getConstructor(button));
			}
		});
	}

	@Test
	public void getConstructorRadioButtonTest() {
		Display.syncExec(new Runnable() {

			@Override
			public void run() {
				Button button = new Button(new Shell(), SWT.RADIO);
				button.setText("Test");
				Assert.assertEquals("new RadioButton(\"Test\")", codeGenerator.getConstructor(button));
			}
		});
	}

	@Test
	public void getConstructorToggleButtonTest() {
		Display.syncExec(new Runnable() {

			@Override
			public void run() {
				Button button = new Button(new Shell(), SWT.TOGGLE);
				button.setText("Test");
				Assert.assertEquals("new ToggleButton(\"Test\")", codeGenerator.getConstructor(button));
			}
		});
	}
}
