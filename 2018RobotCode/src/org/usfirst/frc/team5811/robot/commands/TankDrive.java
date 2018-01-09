package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.OI;
import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	

	
	protected void execute() {
		DriveTrain.tankDrive(OI.getRightY(), OI.getLeftY());
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
