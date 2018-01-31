package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class PosDown extends Command {
	Pivot pivot = Robot.pivot;
	double angle = 0;
	boolean complete;
	int state = 0;
	public PosDown() {
		
	}
	
	protected void execute() {
		this.complete = pivot.changeAngle(this.angle, this.state);
	}
	
	protected boolean isFinished() {
		if (this.complete) {
			return true;
		} else {
			return false;
		}
	}
	
}
