package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

public class AutoDriveAcc {
	int count;
	int duration;
	
	public AutoDriveAcc() {
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		count = 0;
		duration = 25;
	}
	
	protected void execute() {
		DriveTrain.autoDriveAcc(duration, count);
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
