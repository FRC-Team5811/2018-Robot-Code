package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
	DoubleSolenoid arms = RobotMap.intakeArms;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void close() {
		arms.set(DoubleSolenoid.Value.kForward);
		// System.out.print("Right motor power" + rightMotor.get()); //Left intake would
		// shut off when the arms are in... resolved by increasing the wait for a
		// initial current spike...
		// System.out.println(" Left motor power" + leftMotor.get());
	}

	public void open() {
		arms.set(DoubleSolenoid.Value.kReverse);
	}
}
