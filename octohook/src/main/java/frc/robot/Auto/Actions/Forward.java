package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;


public class Forward {
    Drive mAutoDrive = new Drive();

    public void moveForwardAction(){
        mAutoDrive.motoresAuto(0.6, 0.6, -0.6, -0.6);
    }
}