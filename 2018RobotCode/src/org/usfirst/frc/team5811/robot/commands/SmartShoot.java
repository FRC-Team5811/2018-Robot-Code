package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;

import edu.wpi.first.wpilibj.command.Command;

public class SmartShoot extends Command {
	int state;
	Intake intake = Robot.intake;
	protected void initialize(){
		 state = Pivot.getState();
	}
	protected void execute(){
		intake.outtake(state);
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
