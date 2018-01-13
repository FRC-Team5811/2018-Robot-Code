package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	double duration1, duration2,direction;
	public Autonomous(double duration1, double duration2,double direction) {
		this.duration1 = duration1;
		this.duration2 = duration2;
		this.direction = direction;
		
		addSequential(new DriveAuto(this.duration1, this.direction));
//		addSequential(new DriveAuto(this.duration2));
	}
}
