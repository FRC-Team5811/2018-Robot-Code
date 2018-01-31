package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

public class GrabNavX extends Command {
	NavX navX = Robot.navx;
	protected void execute(){
		
		navX.grabValues();
	}
	protected boolean isFinished() {
		
		return false;
	}

}
