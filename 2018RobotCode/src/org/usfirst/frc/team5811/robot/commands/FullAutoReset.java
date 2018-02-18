package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FullAutoReset extends Command {

    public FullAutoReset() {
    	requires(Robot.navx);
		requires(Robot.encoders);
		requires(Robot.driveSUB);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		Robot.navx.reset(); //reseting navx hardware
		Robot.driveSUB.fullReset(); //reseting  angle storing variables
		Robot.encoders.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
