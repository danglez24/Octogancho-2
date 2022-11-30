package frc.robot.Auto.Actions;

import frc.robot.subsystems.boxIntake;

public class DisBoxIntake {
    boxIntake mDisBoxIntake = new boxIntake();

    public void boxIntakeDisable(){
        mDisBoxIntake.mBoxIntake(false);
    }
    
}
