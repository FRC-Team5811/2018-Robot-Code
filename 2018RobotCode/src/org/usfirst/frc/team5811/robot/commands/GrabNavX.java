package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

public class GrabNavX extends Command {
	protected void execute(){
		
		NavX.grabValues();
	}
	protected boolean isFinished() {
		
		return false;
	}

}
