package org.usfirst.frc.team5811.robot.commands;

import org.usfirst.frc.team5811.robot.subsystems.LEDS;

import edu.wpi.first.wpilibj.command.Command;

public class ledOFF extends Command{
	protected void execute(){
		LEDS.off();
	}
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	

}
