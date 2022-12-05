package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;

import java.util.FormatFlagsConversionMismatchException;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class ballIntake extends SubsystemBase{
    //motores
    public TalonSRX ballIntake = new TalonSRX(Constants.BALLSconstant);

    XboxController control1 = new XboxController(0);
    
    public ballIntake() {}

    public void mBallIntake(boolean getButton){
        boolean secIntake = getButton;

        if(secIntake == true){
            ballIntake.set(ControlMode.PercentOutput,Constants.ballIntakeSpeed);
        }

        else{
            ballIntake.set(ControlMode.PercentOutput,0);
        }

    }

    //por si acaso
    public void mBallOutake(boolean getButton){
        boolean secOutake = getButton;

        if(secOutake == true){
            ballIntake.set(ControlMode.PercentOutput,Constants.ballOutakeSpeed);

        }
        else{
            ballIntake.set(ControlMode.PercentOutput,0);
        }
    }
    
}
