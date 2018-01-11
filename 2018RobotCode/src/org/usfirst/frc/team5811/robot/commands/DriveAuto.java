package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	public DriveAuto () {
		addSequential (new AutoDriveAcc());	
		addSequential (new AutoDriveFlat());
	}
	

}
