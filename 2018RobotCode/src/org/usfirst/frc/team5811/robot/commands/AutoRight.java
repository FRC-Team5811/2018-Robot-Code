package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRight extends CommandGroup {
	int waitTime = 35;
	double driveTime1Right = 3000;
	double driveDirection1Right = 0.45;
	double turnAngle1Right = 40;
	double turnDirection1Right = 0.8;
	double DT2Right = 8000;
	double DD2Right = 0.45;
	double TA2Right = 33;
	double TD2Right = -0.9;
	double DT3Right = 3000;
	double DD3Right = 0.45;
	
	public AutoRight() {
		requires(Robot.driveSUB);
		requires(Robot.navx);
		requires(Robot.encoders);
		

		addSequential(new DriveAuto(driveTime1Right, driveDirection1Right));
		System.out.println("First move");
		addSequential(new FullStop(waitTime));

		
		addSequential(new TurnAuto(turnAngle1Right, turnDirection1Right));
		addSequential(new FullStop(waitTime));

		
		addSequential(new DriveAuto(DT2Right, DD2Right));
		addSequential(new FullStop(waitTime));

		
		addSequential(new TurnAuto(TA2Right, TD2Right));
		addSequential(new FullStop(waitTime));

		
		addSequential(new DriveAuto(DT3Right, DD3Right));
		addSequential(new FullStop(waitTime));
	}
}