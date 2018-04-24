package sample;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;



public class RobotTest{
  @Test
  public void Login() throws AWTException{
    // Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    // System.out.printf("Screen is %dx%d%n", screen.width, screen.height);
    //
    // // Click in top-left corner
    //
    // Robot robot = new Robot();
    // robot.mouseMove(25, 10);
    // robot.mousePress(InputEvent.BUTTON1_MASK);
    // robot.mouseRelease(InputEvent.BUTTON1_MASK);
    //
    // // Select first menu item after 1 sec
    //
    // robot.delay(1000);
    // robot.mouseMove(75, 35);
    // robot.mousePress(InputEvent.BUTTON1_MASK);
    // robot.mouseRelease(InputEvent.BUTTON1_MASK);

  }


}
