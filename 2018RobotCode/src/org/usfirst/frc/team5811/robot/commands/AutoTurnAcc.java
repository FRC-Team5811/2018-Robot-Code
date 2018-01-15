package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurnAcc extends Command{
	double count;
	double finalAngSeg,direction;
	
	public AutoTurnAcc(double angleInput, double direction) {
		
		this.finalAngSeg = angleInput;
		this.direction = direction;
		count = 0;
		//input finalAngSeg length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
		System.out.println("Initialized.");
	
	
	}
	
	protected void execute() {
		
		DriveTrain.autoTurnAcc(this.finalAngSeg, count, direction);
		count++;
		System.out.println("Accelerating");
		//System.out.print("count: ");
		//System.out.println(count);
		//System.out.print("finalAngSeg: ");
		//System.out.println(finalAngSeg);
		System.out.println("ANGLE: "+NavX.grabValues());
	}
	
	
	protected boolean isFinished() {
//		System.out.println("Calling isFinished");
		if (Math.abs(NavX.grabValues()) > this.finalAngSeg) {
			return true;
		} else {
			
			return false;
		}
	}
}
