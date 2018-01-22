package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem {
	static DoubleSolenoid rampRelease = RobotMap.rampRelease;
	public Ramp() {
		
	}
	
	public static void extend() {
		rampRelease.set(DoubleSolenoid.Value.kForward);
	}
	public static void retract() {
		rampRelease.set(DoubleSolenoid.Value.kReverse);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}