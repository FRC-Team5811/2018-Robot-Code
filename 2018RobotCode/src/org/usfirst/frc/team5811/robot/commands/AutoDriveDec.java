package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveDec extends Command{
	int count;
	int duration;
	
	public AutoDriveDec( int duration) {
		this.duration = duration;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		count = 0;
		duration = 25;
	}
	
	protected void execute() {
		DriveTrain.autoDriveDec(duration, count);
		count ++;
	}
	
	protected boolean isFinished() {
		if (count > duration) {
			return true;
		} else {
			return false;
		}
	}
