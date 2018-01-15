package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTestRoutine extends CommandGroup {
	double duration1, duration2,direction, turnDirection, turnAngle1;
	public AutonomousTestRoutine(double duration1, double turnAngle1,double direction0, double turnDirection) {
		this.duration1 = duration1;
		this.turnAngle1 = turnAngle1;
		this.direction = direction0;
		this.turnDirection = turnDirection;
		
	//	addSequential(new DriveAuto(this.duration1, this.direction));
		addSequential(new TurnAuto(this.turnAngle1, this.turnDirection));
	}
}
