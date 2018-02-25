package org.usfirst.frc.team5811.robot.subsystems;

import org.usfirst.frc.team5811.robot.Robot;
import org.usfirst.frc.team5811.robot.RobotMap;
import org.usfirst.frc.team5811.robot.commands.PivotHold;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class Pivot extends Subsystem {

	Potentiometer pivot = RobotMap.pivot;
	Victor pivotMotor = RobotMap.motor1;
	double tolerance = 1; // how close to target is acceptable, in degrees
	int state = 0; // position state of arm
	public int goTo = 0;
	double difference;
	double proportionDist = 30;
	double antiGravHat = -.05;
	double antiGravScale = 50;

	double downAngle = 0; // Find based on potentiometer offset
	double downTransitionAngle = 15;
	public double switchAngle = 60; // Find based on potentiometer offset
	public double backAngle = 120; // Find based on potentiometer offset
	double backTransitionAngle = 110;
	double exchangeAngle = 5;

	double kpDown = .01; // plan to do increase
	double kpUp = .01; // plan to do increase
	double kpUpIntake = .05;

	public double downPosTolerance = 10;
	public double switchPosTolerance = 3;
	public double backPosTolerance = 5;
	double exchangePosTolerance = 1;

	double switchHoldingPower = 0.3;
	double exchangeHoldingPower = 0.47;
	double switchFullPower = -0.75;
	double switchDownPower = -0.75;

	public Pivot() {

	}

	public double getAngle() {
		return pivot.get();
	}

	public int getState() {
		return state;
	}

	public void setMotor(double speed) {
		pivotMotor.set(speed);
	}

	public double getMotor() {
		return pivotMotor.get();
	}

	public double differenceSwitchTrans() {
		return switchAngle + getAngle();
	}

	public boolean changeAngle(double angle, int stateIn) {
		state = stateIn;
		difference = angle - (pivot.get() - 30);
		System.out.println("angle;  " + (pivot.get() - 30));
		if (difference > tolerance) {
			setMotor(difference / proportionDist);
		} else if (difference < -tolerance) {
			setMotor(difference / proportionDist);
		} else {
			setMotor(0);
			return true;
		}
		return false;

	}

	// public void chooser() {
	// if (goTo == 1) {
	// moveToBack(Robot.navx.grabValues());
	// } else if (goTo == 2) {
	// moveToSwitch(Robot.navx.grabValues());
	// } else if (goTo == 3) {
	// moveToDown(Robot.navx.grabValues());
	// } else if (goTo == 4) {
	// moveToDown(Robot.navx.grabValues());
	// }
	// }
	//
	public boolean moveToDown(double currentPos) {

		if (currentPos > downTransitionAngle) {
			pivotMotor.set(switchDownPower * (-kpDown * (currentPos - downTransitionAngle)));
		} else {
			pivotMotor.set(switchDownPower * (kpUpIntake * (currentPos - downAngle)));
		}

		return (currentPos < downAngle + downPosTolerance);

	}

	public boolean moveToBack(double currentPos) {
		Robot.arms.close();
		if (currentPos < backTransitionAngle) {
			pivotMotor.set(switchFullPower * (kpUp * (backTransitionAngle - currentPos)));
		} else {
			pivotMotor.set(switchFullPower * (-kpDown * (backAngle - currentPos)));
		}

		return (currentPos > backAngle - backPosTolerance);

	}

	public boolean moveToSwitch(double currentPos) {
		Robot.arms.close();
		if (currentPos < switchAngle - switchPosTolerance) {
			pivotMotor.set(switchFullPower * (switchHoldingPower + kpUp * (switchAngle - currentPos)));
		} else if (currentPos > switchAngle + switchPosTolerance) {
			pivotMotor.set(switchFullPower * (kpDown * (switchAngle - currentPos)));
		} else {
			pivotMotor.set(switchFullPower * (switchHoldingPower));
		}

		return (currentPos > switchAngle - switchPosTolerance && currentPos < switchAngle + switchPosTolerance);

	}

	public void moveToExchange(double currentPos) {
		if (currentPos < exchangeAngle - exchangePosTolerance) {
			pivotMotor.set(switchFullPower * (exchangeHoldingPower + kpUp * (exchangeAngle - currentPos)));
		} else if (currentPos > exchangeAngle + exchangePosTolerance) {
			pivotMotor.set(switchFullPower * (kpDown * (switchAngle - currentPos)));
		} else {
			pivotMotor.set(switchFullPower * (switchHoldingPower));
		}

	}

	public void manual(double input) {
		if (input > Math.abs(0.1)) {
			Robot.arms.close();
		}
		double antiGrav;
		antiGrav = 0;
		if (input < antiGravHat) {
			antiGrav = (-(1 / input)) / antiGravScale;
		}
		pivotMotor.set((0.6 * input) + antiGrav);

	}

	protected void initDefaultCommand() {
		// setDefaultCommand(new PivotHold());

	}

}
