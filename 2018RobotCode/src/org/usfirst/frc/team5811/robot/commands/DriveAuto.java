package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	double accelTime, flatTime, decelTime, direction;
	double accelFactor, decelFactor, flatFactor, totalTime;
	public DriveAuto (double totalTime, double direction) {
//		this.accelFactor = 0.15;
//		this.flatFactor = 0.1;
//		this.decelFactor = 0.75;
//		this.direction = direction;
//		
//		this.totalTime = totalTime;
//		
//		this.accelTime = this.totalTime * this.accelFactor;
//		this.decelTime = this.totalTime * this.decelFactor;
//		this.flatTime = this.totalTime * this.flatFactor;
		
		this.direction = direction;
		this.accelTime = 10; // Set in constant time. 1 time = 20 milliseconds.
		this.decelTime = 30;
		this.flatTime = this.totalTime - this.accelTime - this.decelTime;
		
		addSequential (new AutoDriveAcc(this.accelTime, this.direction));	
		addSequential (new AutoDriveFlat(this.flatTime, this.direction));
     	addSequential (new AutoDriveDec(this.decelTime, this.direction));
	}
	

}
