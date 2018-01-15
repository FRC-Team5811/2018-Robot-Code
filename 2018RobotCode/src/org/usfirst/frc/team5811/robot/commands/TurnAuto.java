package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnAuto extends CommandGroup {
	double accelTime, flatTime, decelTime, direction;
	double angle;
	
	double accelFactor, decelFactor, flatFactor,totalAngle;
	public TurnAuto (double angle, double direction) {
		this.accelFactor = 0.33;
		this.flatFactor = 0.33;
		this.decelFactor = 0.34;
		this.direction = direction;

		this.totalAngle = angle;
//		
		this.accelTime = this.totalAngle * this.accelFactor;
		this.decelTime = this.totalAngle * this.decelFactor;
		this.flatTime = this.totalAngle * this.flatFactor;
		/*
		this.direction = direction;
		this.accelTime = 10; // Set in constant time. 1 time = 20 milliseconds.
		this.decelTime = 30;
		this.flatTime = this.totalTime - this.accelTime - this.decelTime;
		*/
		NavX.navX.reset();
		//this.angle = angle;
//		this.accelTime = this.totalTime/3;
//		this.decelTime = this.totalTime/3;
//		this.flatTime = this.totalTime/3;
		addSequential (new AutoTurnAcc(this.accelTime, this.direction));	
		//NavX.navX.reset();
		addSequential (new AutoTurnFlat(this.flatTime, this.direction, 1/this.flatTime));
		//NavX.navX.reset();
     	addSequential (new AutoTurnDec(this.decelTime, this.direction, 1/this.decelFactor));
     	//NavX.navX.reset();
	}
	

}
