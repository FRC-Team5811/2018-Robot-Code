package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveAcc extends Command{
	double duration,direction;
	
	public AutoDriveAcc(double durationInput, double direction) {
		
		this.duration = durationInput;
		this.direction = direction;
		
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		System.out.println("Initialized.");
	
	}
	
	protected void execute() {
		//System.out.println("does this work?");
		DriveTrain.autoDriveAcc(this.duration, Math.abs(Encoders.getRightVal()), direction);
		System.out.println("Accelerating");
		System.out.print("duration: ");
		System.out.println(duration);
		//System.out.println(Math.abs(Encoders.getRightVal()));
	}
	
	
	protected boolean isFinished() {
//		System.out.println("Calling isFinished");
		if (Math.abs(Encoders.getRightVal()) > this.duration) {
			return true;
		} else {
			return false;
		}
	}
}
