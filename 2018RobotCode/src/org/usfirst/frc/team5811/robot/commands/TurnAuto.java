package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnAuto extends CommandGroup {
	double accelTime, flatTime, decelTime, direction;
	double angle;
	
	double accelFactor, decelFactor, flatFactor,totalTime;
	public TurnAuto (double angle, double direction) {
		this.accelFactor = 0.33;
		this.flatFactor = 0.33;
		this.decelFactor = 0.33;
		this.direction = direction;

		this.totalTime = angle;
//		
		this.accelTime = this.totalTime * this.accelFactor;
		this.decelTime = this.totalTime * this.decelFactor;
		this.flatTime = this.totalTime * this.flatFactor;
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
		addSequential (new AutoTurnFlat(this.flatTime, this.direction));
     	addSequential (new AutoTurnDec(this.decelTime, this.direction));
     	NavX.navX.reset();
	}
	

}
