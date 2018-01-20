package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

public class RampExtend extends Command {
	public RampExtend() {
		Ramp.extend();
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
