package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousTestRoutine extends CommandGroup {
	double duration1, duration2,direction, turnDirection, turnDuration1;
	public AutonomousTestRoutine(double duration1, double turnDur1,double direction0, double turnDirection) {
		this.duration1 = duration1;
		this.turnDuration1 = turnDur1;
		this.direction = direction0;
		this.turnDirection = turnDirection;
		
		addSequential(new DriveAuto(this.duration1, this.direction));
		addSequential(new TurnAuto(this.turnDuration1, this.turnDirection));
	}
}
