package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeInward extends Command {

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute(){
		Intake.intakeIn();
	}

}
