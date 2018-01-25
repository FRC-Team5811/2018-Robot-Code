package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	double accelDistance, flatDistance, decelDistance, direction;
	double accelFactor, decelFactor, flatFactor, totalDistance;
	double accelDistanceTrue, flatDistanceTrue, decelDistanceTrue;
	public DriveAuto (double totalTime, double direction) {
		this.accelFactor = 0.20;
		this.flatFactor = 0.20;
		this.decelFactor = 0.6;

		this.totalDistance = totalTime;
		
		this.accelDistance = this.totalDistance * this.accelFactor;
		this.flatDistance = this.totalDistance * this.flatFactor;
		this.decelDistance = this.totalDistance * this.decelFactor;
		
		this.accelDistanceTrue = this.accelDistance;
		this.flatDistanceTrue = this.accelDistance + this.flatDistance;
		this.decelDistanceTrue = this.accelDistance + this.flatDistance + this.decelDistance;
		
		
		this.direction = direction;
//		this.accelTime = 10; // Set in constant time. 1 time = 20 milliseconds.
//		this.decelTime = 30;
//		this.flatTime = this.totalTime - this.accelTime - this.decelTime;
//		
//		System.out.print("acceltime: ");
//		System.out.println(this.accelTime);
//		System.out.print("deceltime: ");
//		System.out.println(this.decelTime);
//		System.out.print("flattime: ");
//		System.out.println(this.flatTime);
//		DriveTrain.setCurrentAngle();
		System.out.println("Does this owrk?");
		addSequential(new AutoDriveAcc(this.accelDistanceTrue, this.direction));	
		addSequential(new AutoDriveFlat(this.flatDistanceTrue, this.direction));
     	addSequential(new AutoDriveDec(this.decelDistanceTrue, this.direction));
	}
	

}
