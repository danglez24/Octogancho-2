package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;

import java.util.FormatFlagsConversionMismatchException;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    //motores
    public TalonSRX intake1 = new TalonSRX(Constants.INT1constant);
    public TalonSRX intake2 = new TalonSRX(Constants.INT2constant);

    XboxController control1 = new XboxController(0);
    
    public Intake() { }

    public void mIntake(){
        boolean Intake = control1.getRawButton(4);

        if(Intake == true){
            intake1.set(ControlMode.PercentOutput,Constants.intakeSpeed);
            intake2.set(ControlMode.PercentOutput,Constants.intakeSpeed);
        }
        else{
            intake1.set(ControlMode.PercentOutput,0);
            intake2.set(ControlMode.PercentOutput,0);
        }

    }
    
}
