package frc.robot.Auto.Actions;

import frc.robot.subsystems.Drive;


public class Left {
    Drive mAutoDrive = new Drive();

    public void moveLeftAction(){
        mAutoDrive.motoresAuto(0.5, 0.5, 0.5, 0.5);
    }
}
