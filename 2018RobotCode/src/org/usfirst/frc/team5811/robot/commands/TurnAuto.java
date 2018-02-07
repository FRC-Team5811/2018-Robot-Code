package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnAuto extends CommandGroup {
	double accelAngle, flatAngle, decelAngle, direction;
	double angle;
	
	double accelFactor, decelFactor, flatFactor,totalAngle;
	double accelAngleTrue, flatAngleTrue, decelAngleTrue;
	//NavX navX = Robot.navx;
	public TurnAuto (double angle, double direction) {
		this.accelFactor = 0.20;
		this.flatFactor = 0.3;
		this.decelFactor = 0.50;
		this.direction = direction;

		this.totalAngle = angle;
//		
		this.accelAngle = this.totalAngle * this.accelFactor;
		this.flatAngle = this.totalAngle * this.flatFactor;
		this.decelAngle = this.totalAngle * this.decelFactor;
		
		this.accelAngleTrue = this.accelAngle;
		this.flatAngleTrue = this.accelAngle + this.flatAngle;
		this.decelAngleTrue = this.accelAngle + this.flatAngle + this.decelAngle;
		
		
		Robot.navx.reset();
		
		addSequential (new AutoTurnAcc(this.accelAngleTrue, this.direction));	
		//NavX.reset();
		addSequential (new AutoTurnFlat(this.flatAngleTrue, this.direction));
		//NavX.reset();
     	addSequential (new AutoTurnDec(this.decelAngleTrue, this.direction));
     	
     	//NavX.reset();
		//System.out.println("TURN AUTO STOP");
     	Robot.navx.reset();
		Robot.encoders.reset();

	}
	

}
