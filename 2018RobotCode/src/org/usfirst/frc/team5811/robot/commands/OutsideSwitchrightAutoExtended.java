package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OutsideSwitchrightAutoExtended extends CommandGroup {

	public OutsideSwitchrightAutoExtended() {
		int waitTime = 35;
		double driveTime1Right = 122; //was 10000 pulses, now inches
		double driveTime2Right = 7;
		double driveTime3Right = 7;
		double driveTime4Right = 46;
		double DD1R = -0.6;
		double DD2R = -0.6;
		double DD3R = 0.6;
		double DD4R = -0.6;
		double TA1 = 90;
		double TD1 = -0.9;
		double TA2 = 90;
		double TD2 = 0.9;

		requires(Robot.driveSUB);
		requires(Robot.navx);
		requires(Robot.encoders);

		addSequential(new DriveAuto(driveTime1Right, DD1R), 7);
		addSequential(new FullStop(waitTime));

		addSequential(new TurnAuto(TA1, TD1), 3);
		addSequential(new FullStop(waitTime));

		addSequential(new DriveAuto(driveTime2Right, DD2R), 2);
		addSequential(new FullStop(waitTime));

		addSequential(new SmartShoot(), 1);
		addSequential(new FullStop(waitTime));
		
		addSequential(new DriveAuto(driveTime3Right, DD3R), 2);
		addSequential(new FullStop(waitTime));

		addSequential(new TurnAuto(TA2, TD2), 3);
		addSequential(new FullStop(waitTime));

		addSequential(new DriveAuto(driveTime4Right, DD4R), 7);
		addSequential(new FullStop(waitTime));
	}
}
