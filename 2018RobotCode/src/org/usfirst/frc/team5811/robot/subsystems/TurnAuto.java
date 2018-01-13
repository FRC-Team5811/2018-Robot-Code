package org.usfirst.frc.team5811.robot.subsystems;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TurnAuto extends CommandGroup {
	double accelTime, flatTime, decelTime, direction;
	double accelFactor, decelFactor, flatFactor,totalTime;
	public TurnAuto (double totalTime, double direction) {
		this.accelFactor = 0.15;
		this.flatFactor = 0.1;
		this.decelFactor = 0.75;
		this.direction = direction;
		
		this.totalTime = totalTime;
		
		this.accelTime = this.totalTime * this.accelFactor;
		this.decelTime = this.totalTime * this.decelFactor;
		this.flatTime = this.totalTime * this.flatFactor;
		
		addSequential (new AutoTurnAcc(this.accelTime, this.direction));	
		addSequential (new AutoTurnFlat(this.flatTime, this.direction));
     	addSequential (new AutoTurnDec(this.decelTime, this.direction));
	}
	

}
