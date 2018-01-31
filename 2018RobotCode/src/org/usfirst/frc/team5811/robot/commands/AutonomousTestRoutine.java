package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTestRoutine extends CommandGroup {
	NavX navX = Robot.navx;
	Encoders encoders = Robot.encoders;
	//double driveTime1,driveDirection1, turnDirection1, turnAngle1;
	public AutonomousTestRoutine(double driveTime1, double driveDirection1, double turnAngle1, double turnDirection1 ) {
		/*
		this.driveTime1 = driveTime1;
		this.turnAngle1 = turnAngle1;
		this.driveDirection1 = driveDirection1;
		this.turnDirection1 = turnDirection1;
		*/
		navX.reset();
		encoders.reset();
		
		addSequential(new DriveAuto(driveTime1, driveDirection1));
//	NavX.reset();
//		Encoders.reset();
//		addSequential(new FullStop(1));
//		NavX.reset();
//		Encoders.reset();
//		addSequential(new TurnAuto(turnAngle1, turnDirection1));
//		addSequential(new FullStop(0));
//	NavX.reset();
//	Encoders.reset();
//		addSequential(new DriveAuto(driveTime1/2, -driveDirection1));
//		addSequential(new FullStop(1));
////		NavX.reset();
////		addSequential(new TurnAuto(turnAngle1, -turnDirection1 ));
//		NavX.reset();
//		addSequential(new FullStop(0));
//		addSequential(new DriveAuto(driveTime1, driveDirection1));
		
	}
}
