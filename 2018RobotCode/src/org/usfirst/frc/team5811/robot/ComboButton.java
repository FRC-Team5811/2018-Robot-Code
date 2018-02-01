package org.usfirst.frc.team5811.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class ComboButton extends Button{
	Joystick joy1;
	int button1;
	int button2;
	
	public ComboButton(Joystick joystick, int button1ID, int button2ID) {
		joy1 = joystick;
		button1 = button1ID;
		button2 = button2ID;
	}
	
	public boolean get() {
		if(joy1.getRawButton(button1) == true && joy1.getRawButton(button2)== true) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
