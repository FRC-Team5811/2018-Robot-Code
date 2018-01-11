package org.usfirst.frc.team5811.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;

public class NavX extends Subsystem {
	
	
	@Override
	protected void initDefaultCommand() {
		
		
	}
	public static void grabValues(){
		float angle = Robot.thing;
		System.out.println(angle + " degrees");
	}

}
