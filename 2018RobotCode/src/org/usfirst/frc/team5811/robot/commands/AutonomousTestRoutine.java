package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTestRoutine extends CommandGroup {
	double driveTime1,driveDirection1, turnDirection1, turnAngle1;
	public AutonomousTestRoutine(double driveTime1, double driveDirection1, double turnAngle1, double turnDirection1 ) {
		this.driveTime1 = driveTime1;
		this.turnAngle1 = turnAngle1;
		this.driveDirection1 = driveDirection1;
		this.turnDirection1 = turnDirection1;
		
		addSequential(new DriveAuto(this.driveTime1, this.driveTime1));
		//addSequential(new TurnAuto(this.turnAngle1, this.turnDirection1));
	}
}
