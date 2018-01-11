package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	public DriveAuto (int accelTime, int flatTime, int decelTime) {
		addSequential (new AutoDriveAcc(accelTime));	
		addSequential (new AutoDriveFlat(flatTime));
		addSequential (new AutoDriveDec(decelTime));
	}
	

}
