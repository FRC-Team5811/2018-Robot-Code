package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

public class AutoTurnFlat extends Command{
	double count;
	double duration, direction;
	
	public AutoTurnFlat(double angleInput, double direction) {
		this.duration = angleInput;
		//input duration length here, not sure how to do it yet.
		//Automatically assign values through group
	}
	
	protected void intialize() {
	
	}
	
	protected void execute() {
		DriveTrain.autoTurnFlat(this.direction);
		count++;
		System.out.println("Flat");
		System.out.print("count: ");
		System.out.println(count);
		System.out.print("duration: ");
		System.out.println(duration);
		System.out.println("ANGLE: "+NavX.grabValues());
	}
	
	protected boolean isFinished() {
		if (Math.abs(NavX.grabValues()) > this.duration*2) {
			return true;
		} else {
			return false;
		}
	}
}
