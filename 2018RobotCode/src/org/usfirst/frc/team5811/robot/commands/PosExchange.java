package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class PosExchange extends Command {
	double angle = 5;
	boolean complete;
	int state = 1;
	public PosExchange() {
		
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
