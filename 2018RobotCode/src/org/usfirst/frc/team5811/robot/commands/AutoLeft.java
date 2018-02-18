package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeft extends CommandGroup {
	int  waitTime = 35;
	double driveTime1Left = 3000;
	double driveDirection1Left = -0.45;
	double turnAngle1Left = 45;
	double turnDirection1Left = -0.9;
	double DT2Left = 7500;
	double DD2Left = -0.45;
	double TA2Left = 45; 
	double TD2Left = 0.9;
	double DT3Left = 3000;
	double DD3Left = -0.45;
	
	public AutoLeft() {
		requires(Robot.driveSUB);
		requires(Robot.navx);
		requires(Robot.encoders);
	
		
		addSequential(new DriveAuto(driveTime1Left, driveDirection1Left));
		System.out.println("First move");
		addSequential(new FullStop(waitTime));
		
	
		
		addSequential(new TurnAuto(turnAngle1Left, turnDirection1Left));
		addSequential(new FullStop(waitTime));
		
		
		
		addSequential(new DriveAuto(DT2Left, DD2Left));
		addSequential(new FullStop(waitTime));
		
		
		
		addSequential(new TurnAuto(TA2Left, TD2Left));
		addSequential(new FullStop(waitTime));
		
	
		
		addSequential(new DriveAuto(DT3Left, DD3Left));
		addSequential(new FullStop(waitTime));
		addSequential(new SmartShoot(), 1);
		
	}
}
