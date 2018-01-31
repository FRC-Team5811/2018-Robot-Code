package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.OI;
import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {
	DriveTrain driveSUB = Robot.driveSUB;
	OI oi = Robot.oi;
	protected void execute() {
		driveSUB.arcadeDrive(oi.getRightX(), oi.getLeftY());
	}

	
	protected boolean isFinished() {
		
		return false;
	}

}
