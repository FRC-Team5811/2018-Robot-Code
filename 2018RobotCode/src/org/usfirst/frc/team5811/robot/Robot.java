
package org.usfirst.frc.team5811.robot;
import org.usfirst.frc.team5811.robot.commands.AutoDriveFlat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

//github.com/FRC-Team5811/2018-Robot-Code
import org.usfirst.frc.team5811.robot.commands.AutoLeft;
import org.usfirst.frc.team5811.robot.commands.AutoLeftSwitchExchange;
import org.usfirst.frc.team5811.robot.commands.AutoRight;
import org.usfirst.frc.team5811.robot.commands.AutoRightSwitchExchange;
import org.usfirst.frc.team5811.robot.commands.CompOn;
import org.usfirst.frc.team5811.robot.commands.GoNoGoTest;
import org.usfirst.frc.team5811.robot.commands.LineCrossAuto;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchLeftAuto;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchLeftAutoExtended;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchRightAuto;
import org.usfirst.frc.team5811.robot.commands.OutsideSwitchrightAutoExtended;
import org.usfirst.frc.team5811.robot.subsystems.Arms;
import org.usfirst.frc.team5811.robot.subsystems.Camera;
import org.usfirst.frc.team5811.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5811.robot.subsystems.Encoders;
import org.usfirst.frc.team5811.robot.subsystems.Intake;
import org.usfirst.frc.team5811.robot.subsystems.LEDS;
import org.usfirst.frc.team5811.robot.subsystems.NavX;
import org.usfirst.frc.team5811.robot.subsystems.Pivot;
import org.usfirst.frc.team5811.robot.subsystems.Ramp;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveSUB;
	public static LEDS ledsub;
	public static NavX navx;
	public static Encoders encoders;
	public static Intake intake;
	public static Pivot pivot;
	public static Ramp ramp;
	public static OI oi;
	public static Camera camera;
	public static Arms arms;
	double autoSelecter;

	double autoNumber;

	public static String gameData= null;

	char firstLetter;
	char secondLetter;

	Command autonomousCommand;
	
	double counterAuto;
	boolean autoChosen;
	boolean autoStarted;
	// Compressor compressor;

	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {

		driveSUB = new DriveTrain();
		ledsub = new LEDS();
		navx = new NavX();
		encoders = new Encoders();
		intake = new Intake();
		pivot = new Pivot();
		ramp = new Ramp();
		camera = new Camera();
		arms = new Arms();

		oi = new OI();
		
		gameData = ""; //Zippo, zilch, none, nada
		
		RobotMap.ultra.setAutomaticMode(true);
		RobotMap.PDP.clearStickyFaults();
		// SmartDashboard.getNumber("Auto Number", 0.0);
		//
		//
		// SmartDashboard.putData("Auto mode", chooser);
		//
		// chooser.addObject("Line Cross Auto", new LineCrossAuto());
		// chooser.addDefault("Center Auto choosing auto", new CenterAutoChooser());
		// chooser.addObject("Go No Go Right", new GoNoGoAutoMasterRight());
		// chooser.addObject("Go No Go Left", new GoNoGoAutoMasterLeft());
		// chooser.addObject("SAFETY AUTO", new SafetyAuto());
		// chooser.addObject("Left Auto DO NOT USE", new AutoLeft());
		// chooser.addObject("Right Auto DO NOT USE", new AutoRight());
		// chooser.addObject("Test Auto DO NOT USE" , new TestAuto());
		// chooser.addObject("Go no go test DO NOT USE", new GoNoGoTest());
		// System.out.print("I'm not slow?");
		autoNumber = SmartDashboard.getNumber("AUTO SELECTION USE THIS ONE: ", 0.0);

		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy1.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());

		arms.close();

		// gamedata = null;

		// compressor = new Compressor(0);
		// compressor.setClosedLoopControl(false);

		// chooser.addDefault("Drive Straight", new DriveAuto(100, 100, 100));
		// chooser.addObject("Drive", new DriveAuto(1,1,1));
		// UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

	}

	@Override
	public void disabledInit() {
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		// while(gameData == null) {
		// gameData = DriverStation.getInstance().getGameSpecificMessage();
		// //waiting for letter
		// }

	}


	@Override
	public void disabledPeriodic() {
		
		RobotMap.PDP.clearStickyFaults();
		Robot.ledsub.shooting();
		//autoNumber = SmartDashboard.getNumber("DB/Slider 0", 0.0);
		// System.out.println("Game data string:" + gameData);
//		Scheduler.getInstance().run();
		
		SmartDashboard.getNumber("AUTO SELECTION USE THIS ONE: ", 0.0);
		autoNumber = SmartDashboard.getNumber("AUTO SELECTION USE THIS ONE: ", 0.0);
		//autoNumber = 0;
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy1.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());
		
//		System.out.println("AUTONUMBER: " + autoNumber);
//		System.out.println("gamedata" + DriverStation.getInstance().getGameSpecificMessage());
		driveSUB.fullReset();

		
//		if (RobotMap.pivot.get() < -200 || RobotMap.pivot.get() > 10) {
//			System.out.println("POTENTIOMETER ERROR CHECK CONNECTION");
//		}
//		System.out.println("Disable periodic " + DriverStation.getInstance().getGameSpecificMessage());
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
<<<<<<< HEAD
=======
		
		if (gameData == null || gameData == "") {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			// waiting for letter
		}
>>>>>>> branch 'master' of https://github.com/FRC-Team5811/2018-Robot-Code
		
		
	}

	String distance;
	String angle;
	String type;
	String action;
	float startX = 0;
	float startY = 0;
	
    //github.com/FRC-Team5811/2018-Robot-Code
	@Override
	public void autonomousInit() {
		int wayCount = 0;
		counterAuto = 0;
		autoChosen = false; //We have not selected an auto yet
		driveSUB.fullReset(); // reseting angle storing variables
		driveSUB.motorReset();
		encoders.reset();
		arms.close();
		navx.reset(); // reseting navx hardware		
		//autonomousCommand = new LineCrossAuto();
        //autonomousCommand.start();
        autoChosen=false;
        autoStarted = false;
		
		Scheduler.getInstance().removeAll();
<<<<<<< HEAD
		//autoNumber =0.0;
		System.out.println("Auto Init GameData: " + gameData);
		
=======
		// gameData = ""; //This line of code literally ruined our season 
>>>>>>> branch 'master' of https://github.com/FRC-Team5811/2018-Robot-Code
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();//why was this commented out? //because we tried running the scheduler in robotPerdiodic() to always run the scheduler
		
		System.out.println("Auto Periodic GameData: " + gameData);
		
		counterAuto++;

		if(autoChosen == false && counterAuto < 500) {
				if (gameData.equals("") || gameData == null) {
						gameData = DriverStation.getInstance().getGameSpecificMessage();
						System.out.println("Looking for grandma");
				} else {
				
					firstLetter = Robot.gameData.charAt(0);
					secondLetter = Robot.gameData.charAt(1);
					if (autoNumber == 0.0) { // Center Auto
						if (firstLetter == 'L') {
							autonomousCommand = new AutoLeft();
							autoChosen = true;
						} else if (firstLetter == 'R') {
							autonomousCommand = new AutoRight();
							autoChosen = true;
						}
					} else if (autoNumber == 0.5) { // Left Auto
						if (firstLetter == 'L') {
							autonomousCommand = new GoNoGoTest();
							autoChosen = true;
						} else if (firstLetter == 'R') {
							autonomousCommand = new LineCrossAuto(); 
							autoChosen = true;// need
						}
			
					} else if (autoNumber == 1.0) { // Right Auto
						System.out.println("got to 1");
						if (firstLetter == 'R') {
							autonomousCommand = new GoNoGoTest();
							autoChosen = true;
						} else if (firstLetter == 'L') {
							autonomousCommand = new LineCrossAuto();
							autoChosen = true;// need
						}
			
					} else if (autoNumber == 1.5) { // Corner Right
						if (firstLetter == 'R') {
							autonomousCommand = new OutsideSwitchRightAuto();
							autoChosen = true;
						} else if (firstLetter == 'L') {
							autonomousCommand = new LineCrossAuto();
							autoChosen = true;// need
						}
					} else if(autoNumber == 2.0) { //corner Left
						if (firstLetter == 'L') {
							autonomousCommand = new OutsideSwitchLeftAuto();
							autoChosen = true;
						} else if (firstLetter == 'R') {
							autonomousCommand = new LineCrossAuto(); 
							autoChosen = true;// need
						}
					}else if (autoNumber == 2.5) { // 2 cube corner right
					
						if (firstLetter == 'R') {
							autonomousCommand = new OutsideSwitchrightAutoExtended();
							autoChosen = true;
						} else if (firstLetter == 'L') {
							autonomousCommand = new LineCrossAuto();
							autoChosen = true;
						}
					}else if (autoNumber == 3.0) { // 2 cube corner Left
						if (firstLetter == 'L') {
							autonomousCommand = new OutsideSwitchLeftAutoExtended();
							autoChosen = true;
						} else if (firstLetter == 'R' ) {
							autonomousCommand = new LineCrossAuto();
							autoChosen = true;
						}
					
					}else if(autoNumber == 3.5) {
						if (firstLetter == 'L') {
							autonomousCommand = new AutoLeftSwitchExchange();
							autoChosen = true;
						} else if (firstLetter == 'R' ) {
							autonomousCommand = new AutoRightSwitchExchange();
							autoChosen = true;
						}
					}else if(autoNumber == 4.0) { //Beaksquad auto left
						if(firstLetter == 'L' && secondLetter == 'L') {
							autonomousCommand = new OutsideSwitchLeftAuto();
							autoChosen = true;
						}else if(firstLetter == 'L'  && secondLetter == 'R') {
							autonomousCommand = new OutsideSwitchLeftAutoExtended();
							autoChosen = true;
						}else if(firstLetter == 'R') {
							autonomousCommand = new LineCrossAuto();
							autoChosen = true;
						}
					}else if(autoNumber == 4.5) { //Beaksquad auto right
						if(firstLetter == 'R' && secondLetter == 'R') {
							autonomousCommand = new OutsideSwitchRightAuto();
							autoChosen = true;
						}else if(firstLetter == 'R'  && secondLetter == 'L') {
							autonomousCommand = new OutsideSwitchrightAutoExtended();
							autoChosen = true;
						}else if(firstLetter == 'L') {
							autonomousCommand = new LineCrossAuto();
							autoChosen = true;
						}
					}else { // Default
						autonomousCommand = new LineCrossAuto();
						autoChosen = true;
						System.out.println("line cross");
					}
				}
				
		}else if(counterAuto >= 500 && autoChosen == false ) {
			autonomousCommand = new LineCrossAuto();
			autoChosen = true;
		}
		
		if(autoChosen == true && autoStarted == false) {
			autonomousCommand.start();
			autoStarted = true; 
		}
	/*	RobotMap.PDP.clearStickyFaults();//why are we doing this system call every time?
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy1.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());
		SmartDashboard.putNumber("AUTO SELECTION USE THIS ONE: ", autoNumber); */
		
	//	System.out.println("auto periodic " + DriverStation.getInstance().getGameSpecificMessage());

		
//		if (pivot.safety()) {
//			new StopPivot();
//			System.out.println("PIVOT DISABLED");
//		}
	}
	

	@Override
	public void teleopInit() {
		navx.reset(); // reseting navx hardware
		driveSUB.fullReset(); // reseting angle storing variables
		encoders.reset();
		
		arms.close();
		
		driveSUB.motorReset();
		
		// System.out.println("Navx: " + navx.grabValues());
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		Scheduler.getInstance().removeAll();
	}

	@Override 
	public void robotPeriodic() { //Is this for real? //It was a fix recommended by Girls of Steel (maybe someone else)
		//Scheduler.getInstance().run(); 
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run(); //
		// compressor.setClosedLoopControl(true);
		RobotMap.PDP.clearStickyFaults();
		SmartDashboard.putNumber("Left Encoder: ", encoders.getLeftVal()/108.6497744841);
		SmartDashboard.putNumber("Right Encoder: ", encoders.getRightVal()/108.6497744841);
		SmartDashboard.putNumber("NavX Angle: ", navx.grabValues());
		SmartDashboard.putNumber("POV: ", oi.joy2.getPOV());
		SmartDashboard.putNumber("Pivot current: ", driveSUB.monitorCurrent6());
		SmartDashboard.putBoolean("Is the compressor on???: ", Robot.driveSUB.checkCP());
		SmartDashboard.putNumber("Potentiometer Value: ", Robot.pivot.getAngle());
		SmartDashboard.putNumber("Current CX value: ", Robot.driveSUB.returnCX());
		SmartDashboard.putBoolean("Do we detect a cube?", Robot.driveSUB.detectsCube());
		SmartDashboard.putNumber("Pivot motor speed: ", Robot.pivot.getMotor());
		SmartDashboard.putNumber("Switch Goal - Current: ", Robot.pivot.differenceSwitchTrans());
		SmartDashboard.putNumber("Intake Right Current: ", Robot.driveSUB.monitorCurrentIntakeRight());
		SmartDashboard.putNumber("Intake Left Current: ", Robot.driveSUB.monitorCurrentIntakeLeft());
		
		new CompOn();//
		
		//System.out.println(RobotMap.ultra.getRangeInches());
		
	//	System.out.println(Robot.driveSUB.returnCX());

		// System.out.println(navx.grabValues());
//		if (pivot.safety()) {
//			new StopPivot();
//			System.out.println("PIVOT DISABLED");
//		}
	}

	@Override
	public void testPeriodic() {
		// LiveWindow.run();
	}
}
