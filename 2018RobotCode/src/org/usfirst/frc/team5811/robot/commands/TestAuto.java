package org.usfirst.frc.team5811.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestAuto extends CommandGroup {
	public TestAuto() {
		addSequential(new DriveAuto(2000,.5));
		addSequential(new FullStop(35));
		addSequential(new TurnAuto(90,.7));
		addSequential(new FullStop(35));
		
		
	}
}
