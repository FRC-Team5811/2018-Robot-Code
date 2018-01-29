package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.OI;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {
	
	protected void execute() {
		DriveTrain.arcadeDrive(OI.getRightX(), OI.getLeftY());
	}

	
	protected boolean isFinished() {
		
		return false;
	}

}
