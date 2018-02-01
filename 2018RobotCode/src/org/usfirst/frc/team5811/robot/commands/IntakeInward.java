package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeInward extends Command {
//	Intake intake = Robot.intake;
	protected void execute(){
		Robot.intake.intakeIn();
	}
	protected void end(){
		Robot.intake.halt();
	}
	protected void interrupted(){
		end();
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
