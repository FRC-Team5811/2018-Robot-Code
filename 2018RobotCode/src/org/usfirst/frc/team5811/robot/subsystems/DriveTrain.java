package org.usfirst.frc.team5811.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5811.robot.RobotMap;

/**
 *
 */
public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	static Victor motor0 = RobotMap.motor0;
	static Victor motor1 = RobotMap.motor1;
	static Victor motor2 = RobotMap.motor2;
	static Victor motor3 = RobotMap.motor3;
	
	static float rotationPos = 0;
	
	static float correctionStrength = 7;

	public void initDefaultCommand() {
		
	}

	public static void tankDrive(double x, double y){
		motor0.set(x);
		motor1.set(x);
		motor2.set(-y);
		motor3.set(-y);
	}
	public static void arcadeDrive(double turn, double throttle) {
		motor0.set(throttle + turn);
		motor1.set(throttle + turn);
		motor2.set(-(throttle - turn));
		motor3.set(-(throttle - turn));
		//arcade drive algor
		//gdfg
	}

	public static void autoDriveAcc(double durationAccel, double i,double direction) {
		float currentAngle = NavX.grabValues();
		float error = rotationPos - currentAngle;
		System.out.println((direction*(i/(durationAccel*0.5))*0.5f)-error/correctionStrength);
		motor0.set((direction*(i/(durationAccel*0.5))*0.5f)-error/correctionStrength);
		motor1.set((direction*(i/(durationAccel*0.5))*0.5f)-error/correctionStrength);
		motor2.set((direction*-(i/(durationAccel*0.5))*0.5f)-error/correctionStrength);
		motor3.set((direction*-(i/(durationAccel*0.5))*0.5f)-error/correctionStrength);
		
	}
	public static void autoDriveDec(double durationDecel, double i, double direction){
		float currentAngle = NavX.grabValues();
		float error = rotationPos - currentAngle;
		System.out.println((direction*(i/(durationDecel*0.5))*0.5f)-error/correctionStrength);
		motor0.set((direction*(i/(durationDecel*0.5))*0.5f)-error/correctionStrength);
		motor1.set((direction*(i/(durationDecel*0.5))*0.5f)-error/correctionStrength);
		motor2.set((direction*-(i/(durationDecel*0.5))*0.5f)-error/correctionStrength);
		motor3.set((direction*-(i/(durationDecel*0.5))*0.5f)-error/correctionStrength);
	}
	public static void autoDriveFlat(double direction){
		float currentAngle = NavX.grabValues();
		float error = rotationPos - currentAngle;
		//direction = 1;
		System.out.println((direction*1)-error/correctionStrength);
		motor0.set((direction*1)-error/correctionStrength);
		motor1.set((direction*1)-error/correctionStrength);
		motor2.set((direction*-1)-error/correctionStrength);
		motor3.set((direction*-1)-error/correctionStrength);
	}
	public static void fullStop() {
		System.out.println(0);
		motor0.set(0);
		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		
	}
	public static void autoTurnAcc(double finalAngle, double currentAngle, double direction) {
		
		System.out.println(direction*(currentAngle/finalAngle + 0.2));
//		motor0.set(direction*(i/(durationAccel*0.5))*0.5f);
//		motor1.set(direction*(i/(durationAccel*0.5))*0.5f);
//		motor2.set(direction*(i/(durationAccel*0.5))*0.5f);
//		motor3.set(direction*(i/(durationAccel*0.5))*0.5f);
		motor0.set(direction*(currentAngle/finalAngle + 0.2)* 0.5);
		motor1.set(direction*(currentAngle/finalAngle + 0.2)* 0.5);
		motor2.set(direction*(currentAngle/finalAngle + 0.2)* 0.5);
		motor3.set(direction*(currentAngle/finalAngle + 0.2)* 0.5);

	
		
	}
	public static void autoTurnDec(double finalAngle, double currentAngle, double direction){
		System.out.println(direction*(1-(currentAngle/finalAngle + 0.2)));
//		motor0.set(direction*(i/(durationDecel*0.5))*0.5f);
//		motor1.set(direction*(i/(durationDecel*0.5))*0.5f);
//		motor2.set(direction*(i/(durationDecel*0.5))*0.5f);
//		motor3.set(direction*(i/(durationDecel*0.5))*0.5f);
		motor0.set(direction*(1-(currentAngle/finalAngle)) * 0.5);
		motor1.set(direction*(1-(currentAngle/finalAngle))* 0.5);
		motor2.set(direction*(1-(currentAngle/finalAngle))* 0.5);
		motor3.set(direction*(1-(currentAngle/finalAngle))* 0.5);
	}
	public static void autoTurnFlat(double direction){
		//direction = 0.2;
		System.out.println(direction*1);
		motor0.set(direction*1);
		motor1.set(direction*1);
		motor2.set(direction*1);
		motor3.set(direction*1);
	}
	
}
