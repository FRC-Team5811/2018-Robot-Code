
package org.usfirst.frc.team5811.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5811.robot.commands.AutoDriveAcc;
import org.usfirst.frc.team5811.robot.commands.AutonomousTestRoutine;
import org.usfirst.frc.team5811.robot.commands.DriveAuto;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.LEDS;
import org.usfirst.frc.team5811.robot.subsystems.NavX;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;
import org.usfirst.frc.team5811.robot.subsystems.Ramp;

import com.kauailabs.navx.frc.AHRS;


public class Robot extends IterativeRobot {

	public static DriveTrain driveSUB;
	public static LEDS ledsub;
	public static NavX navx;
	public static Encoders encoders;
	public static Intake intake;
	public static Pivot pivot;
	public static Ramp ramp;
	public static OI oi;
	//hi

	Command autonomousCommand;

	
	SendableChooser<Command> chooser = new SendableChooser<>();

	public Robot(){
		oi = new OI();
		driveSUB = new DriveTrain();
		ledsub = new LEDS();
		navx = new NavX();
		encoders = new Encoders();
		intake = new Intake();
		pivot = new Pivot();
		ramp = new Ramp();
	}
	@Override
	public void robotInit() {
	
	
		SmartDashboard.putData("Auto mode", chooser);
		
//		chooser.addDefault("Drive Straight", new DriveAuto(100, 100, 100)); 
		//chooser.addObject("Drive", new DriveAuto(1,1,1));
		//UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		 
//		navx.reset();
//		encoders.reset();
//		String gameData = DriverStation.getInstance().getGameSpecificMessage();
//		System.out.println(gameData);
//		if (gameData.charAt(0) == 'L') {
//			System.out.println("Left");
		chooser.addDefault("Drive Left", new AutonomousTestRoutine(3000,0.7,45,-.7, 5000, 0.7, 20, .7, 4000, .7));  
//		} 
//		if (gameData.charAt(0) == 'R') {
//			chooser.addObject("Drive Right", new AutonomousTestRoutine(3000,0.5,45,.7,7000,-0.7, 20, -.7, 4000, .7));  
//		}
//		
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null){
			autonomousCommand.start();
		}
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(navx.grabValues());
		

	}


	@Override
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
