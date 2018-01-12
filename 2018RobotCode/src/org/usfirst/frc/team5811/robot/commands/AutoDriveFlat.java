package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveFlat extends Command{
	int count;
	int duration;
	
	public AutoDriveFlat( int duration) {
		this.duration = duration;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		count = 0;
		duration = 25;
	}
	
	protected void execute() {
		DriveTrain.autoDriveFlat();
		count ++;
	}
	
	protected boolean isFinished() {
		if (count > duration) {
			return true;
		} else {
			return false;
		}
	}
}
