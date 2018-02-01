package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.OI;
import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Joysticks;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {
	//DriveTrain driveSUB = Robot.driveSUB;
	//Joysticks joysticks = Robot.joysticks;
	//OI oi = Robot.oi;
	protected void execute() {
	

		Robot.driveSUB.arcadeDrive(Robot.oi.getLeftY(),Robot.oi.getRightY());
	}

	
	protected boolean isFinished() {
		
		return false;
	}

}
