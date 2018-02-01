package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class HaltIntake extends Command {
	//Intake intake = Robot.intake;
	protected void initialize()
	{
		//Intake.halt();
	}
	protected void execute(){
		Robot.intake.halt();
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
