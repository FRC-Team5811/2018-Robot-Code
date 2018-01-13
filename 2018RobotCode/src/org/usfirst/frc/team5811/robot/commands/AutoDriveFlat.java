package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveFlat extends Command{
	double count;
	double duration, direction;
	
	public AutoDriveFlat(double duration, double direction) {
		this.duration = duration;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		count = 0;
	
	}
	
	protected void execute() {
		DriveTrain.autoDriveFlat(direction);
		count ++;
		System.out.println("Flat");
		System.out.print("count: ");
		System.out.println(count);
		System.out.print("duration: ");
		System.out.println(duration);
	}
	
	protected boolean isFinished() {
		if (count > this.duration) {
			return true;
		} else {
			return false;
		}
	}
}
