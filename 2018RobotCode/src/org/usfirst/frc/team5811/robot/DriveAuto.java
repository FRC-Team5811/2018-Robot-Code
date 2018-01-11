package org.usfirst.frc.team5811.robot;

import org.usfirst.frc.team5811.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {
	public DriveAuto () {
		addSequential (new Drive()) ;
		driving();
	}
	public void driving(){
		addSequential (new Drive()) ;
		addSequential (new Drive()) ;
		addSequential (new Drive()) ;
	}

}
