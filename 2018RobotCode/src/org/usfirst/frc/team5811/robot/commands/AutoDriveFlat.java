package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveFlat extends Command{
	double duration, direction;
	
	public AutoDriveFlat(double duration, double direction) {
		this.duration = duration;
		this.direction = direction;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
	
	}
	
	protected void execute() {
		DriveTrain.autoDriveFlat(this.direction);
		System.out.println("Flat");
		System.out.print("duration: ");
		System.out.println(duration);
		System.out.println(Math.abs(Encoders.getLeftVal()));

	}
	
	protected boolean isFinished() {
		if (Math.abs(Encoders.getLeftVal()) > this.duration) {
			return true;
		} else {
			return false;
		}
	}
}
