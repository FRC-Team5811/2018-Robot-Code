package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurnDec extends Command{
	double count;
	double finalAngSeg, direction;
	double recip;
	//double rotationPos = 0;
	//float error;
	DriveTrain driveSUB = Robot.driveSUB;
	
	public AutoTurnDec(double angleInput, double direction) {
		this.finalAngSeg = angleInput;
		this.direction = direction;
	
		//count = this.finalAngSeg;
		
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
//		count = this.duration;
	
	}
	
	protected void execute() {
		driveSUB.autoTurnDec(this.finalAngSeg, Math.abs(NavX.grabValues()), direction);
		//error = (float) (rotationPos - NavX.grabValues());
		//count -=1;
		//System.out.println("Deccelerating");
//		//System.out.print("count: ");
//		//System.out.println(count);
//		//System.out.print("duration: ");
//		//System.out.println(finalAngSeg);
		//System.out.println("ANGLE: "+Math.abs(NavX.grabValues()));
	}
	
	protected boolean isFinished() {
		if (Math.abs(NavX.grabValues())> this.finalAngSeg) {
			return true;
		} else {
			return false;
		}
	}
}
