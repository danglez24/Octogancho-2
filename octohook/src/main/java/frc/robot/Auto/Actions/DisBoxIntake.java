package frc.robot.Auto.Actions;

import frc.robot.subsystems.boxIntake;

public class DisBoxIntake {
    boxIntake mActBoxOut = new boxIntake();

    public void boxOut(){
        mActBoxOut.getBox(0);
    }
    
}
