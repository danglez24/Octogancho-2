package frc.robot.Auto.Actions;

import frc.robot.subsystems.boxIntake;

public class ActBoxIntake {
    boxIntake mActBoxIntake = new boxIntake();

    public void boxIntakeActivate(){
        mActBoxIntake.mBoxIntake(true);
    }
    
}
