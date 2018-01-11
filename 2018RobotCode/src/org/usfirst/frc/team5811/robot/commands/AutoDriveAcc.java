package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveAcc extends Command{
	int count;
	int duration;
	
	public AutoDriveAcc( int duration) {
		
		this.duration = duration;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		duration = 25;
		count = duration;		
	}
	
	protected void execute() {
		DriveTrain.autoDriveAcc(duration, count);
		count --;
	}
	
	protected boolean isFinished() {
		if (count < duration) {
			return true;
		} else {
			return false;
		}
	}
}
