package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;
import org.usfirst.frc.team5811.robot.subsystems.NavX;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTestRoutine extends CommandGroup {

	int waitTime = 35;
	public AutonomousTestRoutine(double driveTime1, double driveDirection1, double turnAngle1, double turnDirection1, double DT2, double DD2, double TA2, double TD2, double DT3, double DD3) {

		Robot.navx.reset();
		Robot.encoders.reset();
		
		addSequential(new DriveAuto(driveTime1, driveDirection1));
		addSequential(new FullStop(waitTime));
		
		Robot.navx.reset();
		Robot.encoders.reset();
		
		addSequential(new TurnAuto(turnAngle1, turnDirection1));
		addSequential(new FullStop(waitTime));
		
		Robot.navx.reset();
		Robot.encoders.reset();
		
		addSequential(new DriveAuto(DT2, DD2));
		addSequential(new FullStop(waitTime));
		
		Robot.navx.reset();
		Robot.encoders.reset();
		
		addSequential(new TurnAuto(TA2, TD2));
		addSequential(new FullStop(waitTime));
		
		Robot.navx.reset();
		Robot.encoders.reset();
		
		addSequential(new DriveAuto(DT3, DD3));
		addSequential(new FullStop(waitTime));
		
		Robot.navx.reset();
		Robot.encoders.reset();
		
	}
}
