package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnAuto extends CommandGroup {
	double accelAngle, flatAngle, decelAngle, direction;
	double angle;
	
	double accelFactor, decelFactor, flatFactor,totalAngle;
	double accelAngleTrue, flatAngleTrue, decelAngleTrue;
	public TurnAuto (double angle, double direction) {
		this.accelFactor = 0.10;
		this.flatFactor = 0.05;
		this.decelFactor = 0.80;
		this.direction = direction;

		this.totalAngle = angle;
//		
		this.accelAngle = this.totalAngle * this.accelFactor;
		this.flatAngle = this.totalAngle * this.flatFactor;
		this.decelAngle = this.totalAngle * this.decelFactor;
		
		this.accelAngleTrue = this.accelAngle;
		this.flatAngleTrue = this.accelAngle + this.flatAngle;
		this.decelAngleTrue = this.accelAngle + this.flatAngle + this.decelAngle;
		
		/*
		this.direction = direction;
		this.accelTime = 10; // Set in constant time. 1 time = 20 milliseconds.
		this.decelTime = 30;
		this.flatTime = this.totalTime - this.accelTime - this.decelTime;
		*/
		NavX.reset();
		//this.angle = angle;
//		this.accelTime = this.totalTime/3;
//		this.decelTime = this.totalTime/3;
//		this.flatTime = this.totalTime/3;
		System.out.println("accel: " + this.accelAngleTrue);
		System.out.println("flat " + this.flatAngleTrue);
		System.out.println("decel " + this.decelAngleTrue);
		System.out.println("TURN AUTO START");
		NavX.reset();

		addSequential (new AutoTurnAcc(this.accelAngleTrue, this.direction));	
		//NavX.reset();
		addSequential (new AutoTurnFlat(this.flatAngleTrue, this.direction));
		//NavX.reset();
     	addSequential (new AutoTurnDec(this.decelAngleTrue, this.direction));
     	//NavX.reset();
		System.out.println("TURN AUTO STOP");

	}
	

}
