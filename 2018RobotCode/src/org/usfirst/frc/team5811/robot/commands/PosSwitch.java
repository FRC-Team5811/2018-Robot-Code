package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class PosSwitch extends Command {
	double angle = 80;
	boolean complete;
	int state = 2;
	public PosSwitch() {
		
	}
	
	protected void execute() {
		this.complete = Pivot.changeAngle(angle, 0);
	}
	
	protected boolean isFinished() {
		if (this.complete) {
			return true;
		} else {
			return false;
		}
	}
	
}
