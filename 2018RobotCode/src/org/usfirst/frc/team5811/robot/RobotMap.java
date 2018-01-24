package org.usfirst.frc.team5811.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class RobotMap {
	public static Victor motor0 = new Victor(0);
	public static Victor motor1 = new Victor(1);
	public static Victor motor2 = new Victor(2);
	public static Victor motor3 = new Victor(3);
	public static Victor motor4 = new Victor(4);
	public static Victor motor5 = new Victor(5);
	public static Victor motor6 = new Victor(6);
	public static Victor motor7 = new Victor(7);
	

	public static Potentiometer pivot = new AnalogPotentiometer(7, 360, 150);
	
	public static DoubleSolenoid rampRelease = new DoubleSolenoid(0, 1);
	
	public static I2C arduino = new I2C(I2C.Port.kMXP, 58);
	public static AHRS navx;

	public static Encoder driveEncL = new Encoder(2,3, true, Encoder.EncodingType.k4X);
	public static Encoder driveEncR = new Encoder(0,1, false, Encoder.EncodingType.k4X);
}
