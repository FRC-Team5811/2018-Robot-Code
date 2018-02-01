package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.command.Command;

public class RampExtend extends Command {
	//Ramp ramp = Robot.ramp;
	public RampExtend() {
		Robot.ramp.extend();
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
}
