package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

public class RampRetract extends Command {
	public RampRetract() {
		Ramp.retract();
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
