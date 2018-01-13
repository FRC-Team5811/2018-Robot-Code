package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurnAcc extends Command{
	double count;
	double duration,direction;
	
	public AutoTurnAcc(double durationInput, double direction) {
		
		this.duration = durationInput;
		this.direction = direction;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		System.out.println("Initialized.");
	
		count = 0;		
	}
	
	protected void execute() {
	DriveTrain.autoTurnAcc(this.duration, count, direction);
		count ++;
		System.out.println("Accelerating");
		System.out.print("count: ");
		System.out.println(count);
		System.out.print("duration: ");
		System.out.println(duration);
	}
	
	
	protected boolean isFinished() {
//		System.out.println("Calling isFinished");
		if (count > duration) {
			return true;
		} else {
			return false;
		}
	}
}
