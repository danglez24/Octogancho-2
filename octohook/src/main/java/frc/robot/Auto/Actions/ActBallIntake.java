package frc.robot.Auto.Actions;

import frc.robot.subsystems.ballIntake;

public class ActBallIntake {
    ballIntake mActBallIntake = new ballIntake();

    public void ballIntakeActivate(){
        mActBallIntake.mBallIntake(true);
    }
    
}
