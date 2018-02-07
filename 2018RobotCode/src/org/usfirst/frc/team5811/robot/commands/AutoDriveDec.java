package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveDec extends Command{
	double duration, direction;
	//DriveTrain driveSUB = Robot.driveSUB;
	//Encoders encoders = Robot.encoders;
	public AutoDriveDec(double duration, double direction) {
		this.duration = duration;
		this.direction = direction;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
//		count = this.duration;
	
	}
	
	protected void execute() {
		Robot.driveSUB.autoDriveDec(duration, Math.abs(Robot.encoders.getRightVal()), direction);
		//System.out.println("Deccelerating");
		//System.out.print("duration: ");
		////System.out.println(duration);
		//System.out.println(Math.abs(Robot.encoders.getRightVal()));

	}
	
	protected boolean isFinished() {
		if (Math.abs(Robot.encoders.getRightVal()) > this.duration) {
			Robot.encoders.reset();
			Robot.navx.reset();
			return true;
		} else {
			return false;
		}
	}
}
