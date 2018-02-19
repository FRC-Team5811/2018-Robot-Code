package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	 Victor leftMotor = RobotMap.motor0;
	 Victor rightMotor = RobotMap.motor5;
	 DoubleSolenoid arms = RobotMap.intakeArms;
	
	public int cyclesOn = 0;
	public int cyclesSpike = 0;
	public static final int intSpikeWait = 25;
	public static final int currentThreshold = 20;
	public static final int timeout = 15; // how many cycles it waits to turn off after current spike is reached
	public boolean leftOff;
	public boolean rightOff;

	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void intakeRightIn(){
		rightMotor.set(-0.5);
	}
	
	public void intakeLeftIn(){
		leftMotor.set(0.5);
	}
	
	public void haltRight(){
		rightMotor.set(0);
	}
	
	public void haltLeft(){
		leftMotor.set(0);
	}
	
	public void outtake(double power){
		leftMotor.set(-power);
		rightMotor.set(power);
	}
	public void armsClose() {
		arms.set(DoubleSolenoid.Value.kForward);
	}
	public void armsOpen() {
		arms.set(DoubleSolenoid.Value.kReverse);
	}
	
}
