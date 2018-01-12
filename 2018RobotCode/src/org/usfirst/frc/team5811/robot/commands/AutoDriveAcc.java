package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveAcc extends Command{
	int count;
	int duration;
	
	public AutoDriveAcc( int durationInput) {
		
//		this.duration = durationInput;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		System.out.println("Initialized.");
		duration = 50;
		count = 0;		
	}
	
	protected void execute() {
//		DriveTrain.autoDriveAcc(duration, count);
		count ++;
//		System.out.print("count: ");
//		System.out.println(count);
//		System.out.print("duration: ");
//		System.out.println(duration);
	}
	
	
	protected boolean isFinished() {
//		System.out.println("Calling isFinished");
//		if (count > duration) {
//			return true;
//		} else {
//			return false;
//		}
		return false;
	}
}
