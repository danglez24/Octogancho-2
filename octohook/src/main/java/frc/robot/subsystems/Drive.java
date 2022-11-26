// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;

import java.util.FormatFlagsConversionMismatchException;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;


public class Drive extends SubsystemBase {

    //Motores
    public TalonSRX motorFrontRight = new TalonSRX(Constants.FRconstant);
    public TalonSRX motorBackRight = new TalonSRX(Constants.BRconstant);
    public TalonSRX motorFrontLeft = new TalonSRX(Constants.FLconstant);
    public TalonSRX motorBackLeft = new TalonSRX(Constants.BLconstant);
  
    public TalonSRX motortest = new TalonSRX(0);

    //Control
   

   //Variables
    double turn = 0;

  //Constante de velocidad aditiva
  final double additiveSpeed = 0.04;
  

    double motorFR = 0;
    double motorBR = 0;
    double motorFL = 0;
    double motorBL = 0;
  
    double finalFR = 0;
    double finalBR = 0;
    double finalFL = 0;
    double finalBL = 0;


  /** Creates a new ExampleSubsystem. */
  public Drive() {
  }

  public void mDrive(double speed, double getTurn){

    double motores = speed;
    double turn = getTurn;
    
    
    

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

   
  }
  private double speedRamp (double currentSpeed, double targetSpeed)
  {
    if( Math.abs( (Math.abs(targetSpeed) - Math.abs(currentSpeed) ) ) < additiveSpeed) return targetSpeed;
    if( currentSpeed < targetSpeed ) return currentSpeed + additiveSpeed;
    else if( currentSpeed > targetSpeed ) return currentSpeed - additiveSpeed;
    return 0;
  }

  @Override
  public void periodic() {
   
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
