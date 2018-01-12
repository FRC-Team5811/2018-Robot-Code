package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	int accelTime, flatTime, decelTime;
	public DriveAuto (int accelTime, int flatTime, int decelTime) {
		
		this.decelTime = decelTime;
		this.flatTime = flatTime;
		this.accelTime = accelTime;
		
		addSequential (new AutoDriveAcc(this.accelTime));	
		addSequential (new AutoDriveFlat(this.flatTime));
     	addSequential (new AutoDriveDec(this.decelTime));
	}
	

}
