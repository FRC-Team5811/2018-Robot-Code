package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class PosSwitch extends Command {
	Pivot pivot = Robot.pivot;
	double angle = 80;
	boolean complete;
	int state = 2;
	public PosSwitch() {
		
	}
	
	protected void execute() {
		this.complete = pivot.changeAngle(angle, 0);
	}
	
	protected boolean isFinished() {
		if (this.complete) {
			return true;
		} else {
			return false;
		}
	}
	
}
