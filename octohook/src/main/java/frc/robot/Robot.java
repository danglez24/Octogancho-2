// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  
  //NeumÃ¡tica
  Compressor compressor1 = new Compressor(0,PneumaticsModuleType.CTREPCM); //creas el objeto compresor para poder usarlo
  public final Solenoid piston1 = new Solenoid(PneumaticsModuleType.CTREPCM, 0); //declaracion del piston
  
  //Control
  XboxController control1 = new XboxController(0);




  //Variables

  boolean ePiston = false;
  double rightTurn = 0;
  double leftTurn = 0;
  double turn = 0;
  

  double motorFR = 0;
  double motorBR = 0;
  double motorFL = 0;
  double motorBL = 0;

  double finalFR = 0;
  double finalBR = 0;
  double finalFL = 0;
  double finalBL = 0;


  //Constante de velocidad aditiva
  final double additiveSpeed = 0.04;
  

  

  

  



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    compressor1.enableDigital();
    
    


  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    double motores = (control1.getRawAxis(1));
    double turn = (control1.getRawAxis(4));
    
    
    

    motorFR = speedRamp(motorFR, motores);
    motorBR = speedRamp(motorFR, motores);
    motorFL = speedRamp(motorFL, motores);
    motorBL = speedRamp(motorBL, motores);

    finalFR = (motorFR - turn);
    finalBR = (motorBR - turn);
    finalFL = (-motorFL + turn);
    finalBL = (-motorBL + turn);
    


    motorFrontRight.set(ControlMode.PercentOutput, finalFR);
    motorBackRight.set(ControlMode.PercentOutput, finalBR);
    motorFrontLeft.set(ControlMode.PercentOutput, finalFL);
    motorBackLeft.set(ControlMode.PercentOutput,  finalBL);
    motortest.set(ControlMode.PercentOutput, 0);

    ePiston = control1.getRawButton(3);

    compressor1.enableDigital();
    piston1.set(ePiston);

//      49017534

  

  }
  double speedRamp (double currentSpeed, double targetSpeed){
    if( Math.abs( (Math.abs(targetSpeed) - Math.abs(currentSpeed) ) ) < additiveSpeed) return targetSpeed;
    if( currentSpeed < targetSpeed ) return currentSpeed + additiveSpeed;
    else if( currentSpeed > targetSpeed ) return currentSpeed - additiveSpeed;
    return 0;
  }

//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa


public void variableOutput(){

  SmartDashboard.putNumber("Giro", turn);
  SmartDashboard.putNumber("MotorFR", finalFR);
  SmartDashboard.putNumber("MotorBR", finalBR);
  SmartDashboard.putNumber("MotorFL", finalFL);
  SmartDashboard.putNumber("MotorBL", finalBL);
  
}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
