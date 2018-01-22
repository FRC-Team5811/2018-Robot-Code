package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class PosStore extends Command {
	double angle = 150;
	boolean complete;
	int state = 4;
	public PosStore() {
		
	}
	
	protected void execute() {
		this.complete = Pivot.changeAngle(this.angle, this.state);
	}
	
	protected boolean isFinished() {
		if (this.complete) {
			return true;
		} else {
			return false;
		}
	}
	
}
