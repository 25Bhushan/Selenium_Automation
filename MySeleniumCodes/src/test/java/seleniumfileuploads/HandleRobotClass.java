package seleniumfileuploads;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class HandleRobotClass {
	
	public static void handleNotpad() throws Exception 
	{	
		//Notepad open, Dhole JAVA
		
		Runtime.getRuntime().exec("Notepad.exe");
		
		Robot rb=new Robot();
		
		rb.keyPress(KeyEvent.VK_CAPS_LOCK);
		rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
		
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_H);
		rb.keyRelease(KeyEvent.VK_H);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_O);
		rb.keyRelease(KeyEvent.VK_O);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_L);
		rb.keyRelease(KeyEvent.VK_L);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_SPACE);
		rb.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_J);
		rb.keyRelease(KeyEvent.VK_J);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_A);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(750);
		
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_A);
		Thread.sleep(750);
		
	}

	public static void main(String[] args) throws Exception {
		
		handleNotpad();

	}

}
