package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	double accelDistance, flatDistance, decelDistance, direction;
	double accelFactor, decelFactor, flatFactor, totalDistance;
	double accelDistanceTrue, flatDistanceTrue, decelDistanceTrue;
	public DriveAuto (double totalTime, double direction) {
		System.out.println("goes all the way here");

		this.accelFactor = 0.05;
		this.flatFactor = 0.05;
		this.decelFactor = 0.9;

		this.totalDistance = totalTime;
		
		this.accelDistance = this.totalDistance * this.accelFactor;
		this.flatDistance = this.totalDistance * this.flatFactor;
		this.decelDistance = this.totalDistance * this.decelFactor;
		
		this.accelDistanceTrue = this.accelDistance;
		this.flatDistanceTrue = this.accelDistance + this.flatDistance;
		this.decelDistanceTrue = this.accelDistance + this.flatDistance + this.decelDistance;
		
		
		this.direction = direction;
		addSequential (new SetCurrentAngle());
		addSequential(new AutoDriveAcc(this.accelDistanceTrue, this.direction));	
		addSequential(new AutoDriveFlat(this.flatDistanceTrue, this.direction));
     	addSequential(new AutoDriveDec(this.decelDistanceTrue, this.direction));
     	

     	Robot.navx.reset();
		Robot.encoders.reset();
     	
		

	}
	

}
