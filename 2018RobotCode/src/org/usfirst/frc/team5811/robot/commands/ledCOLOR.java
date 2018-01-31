package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.LEDS;

import edu.wpi.first.wpilibj.command.Command;

public class ledCOLOR extends Command{
	LEDS leds = Robot.ledsub;
	protected void execute(){
		leds.color ();
	}

	
	protected boolean isFinished() {
		
		return false;
	}

}
