package frc.robot.Auto.Actions; 

import frc.robot.subsystems.Drive; 

    public class Backward { 
        Drive mAutoDrive = new Drive();
        
        public void moveBackwardAction(){
            
            mAutoDrive.motoresAuto(-0.5, -0.5, 0.5, 0.5);
        }
    }