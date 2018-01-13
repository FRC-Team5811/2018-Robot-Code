package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurnDec extends Command{
	double count;
	double duration, direction;
	
	public AutoTurnDec(double duration, double direction) {
		this.duration = duration;
		this.direction = direction;
		count = duration;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
//		count = this.duration;
	
	}
	
	protected void execute() {
		DriveTrain.autoDriveDec(duration, count, direction);
		count --;
		System.out.println("Deccelerating");
		System.out.print("count: ");
		System.out.println(count);
		System.out.print("duration: ");
		System.out.println(duration);
	}
	
	protected boolean isFinished() {
		if (count < 0) {
			return true;
		} else {
			return false;
		}
	}
}
