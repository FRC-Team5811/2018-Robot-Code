
package org.usfirst.frc.team5811.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5811.robot.commands.AutoDriveAcc;
import org.usfirst.frc.team5811.robot.commands.SwitchLeftAuto;
import org.usfirst.frc.team5811.robot.commands.SwitchRightAuto;
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
	
	
	String gamedata;

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
		gamedata = DriverStation.getInstance().getGameSpecificMessage();
		
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

		
		
		
		navx.reset(); //reseting navx hardware
		driveSUB.navXReset(); //reseting  angle storing variables
		encoders.reset();
		if(gamedata.charAt(0) == 'L'){
			////System.out.println(gamedata.charAt(1));
			chooser.addDefault("Drive Straight", new SwitchLeftAuto(3000,0.45,38,-0.9, 4000, 0.45, 38, .9, 6500, .45 ));
		}else if(gamedata.charAt(0) == 'R'){
			////System.out.println(gamedata.charAt(1));
			chooser.addDefault("Drive Straight", new SwitchRightAuto(3000,0.45,33,0.8, 8000, 0.45, 33, -.9, 6000, .45 ));
		}
		
		
		
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
		////System.out.println(navx.grabValues());
		

	}


	@Override
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
