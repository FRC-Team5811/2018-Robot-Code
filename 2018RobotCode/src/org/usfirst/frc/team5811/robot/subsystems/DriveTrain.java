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
	/*
	public static void AutoDrive(double durationAccel, double durationFull, double durationDecel) {
		
		for(float i = 0; i < durationAccel; i++){
			System.out.println((i/(durationAccel*0.5))*0.5f);
			motor0.set((i/(durationAccel*0.5))*0.5f);
			motor1.set((i/(durationAccel*0.5))*0.5f);
			motor2.set(-(i/(durationAccel*0.5))*0.5f);
			motor3.set(-(i/(durationAccel*0.5))*0.5f);
		
		}
		for(float i = 0; i < durationFull; i++){
			System.out.println(1);
			motor0.set(1);
			motor1.set(1);
			motor2.set(-1);
			motor3.set(-1);
		}
		for(double i = durationDecel; i >0 ; i--){
			System.out.println((i/(durationDecel*0.5))*0.5f);
			motor0.set((i/(durationDecel*0.5))*0.5f);
			motor1.set((i/(durationDecel*0.5))*0.5f);
			motor2.set(-(i/(durationDecel*0.5))*0.5f);
			motor3.set(-(i/(durationDecel*0.5))*0.5f);
		}
	}
	*/
	public static void autoDriveAcc(int duration, int i) {
		
		System.out.println((i/(duration*0.5))*0.5f);
		motor0.set((i/(duration*0.5))*0.5f);
		motor1.set((i/(duration*0.5))*0.5f);
		motor2.set(-(i/(duration*0.5))*0.5f);
		motor3.set(-(i/(duration*0.5))*0.5f);
		
	}
	public static void autoDriveDec(int duration, int i){
		System.out.println((i/(durationDecel*0.5))*0.5f);
		motor0.set((i/(durationDecel*0.5))*0.5f);
		motor1.set((i/(durationDecel*0.5))*0.5f);
		motor2.set(-(i/(durationDecel*0.5))*0.5f);
		motor3.set(-(i/(durationDecel*0.5))*0.5f);
	}
	public static void autoDriveFlat(int duration, int i){
		System.out.println(1);
		motor0.set(1);
		motor1.set(1);
		motor2.set(1);
		motor3.set(1);
        }
	
}
