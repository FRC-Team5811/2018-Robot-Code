package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class FullStop extends Command {
	int count;
	int duration;
	
	public FullStop(int duration) {
		this.duration = duration;
	}
	
	protected void intialize() {
		count = 0;
	}
	
	protected void execute() {
		DriveTrain.fullStop();
		count ++;
	}

	protected boolean isFinished() {
		if (count > duration) {
			return true;
		} else {
			return false;
		}
	}
}
