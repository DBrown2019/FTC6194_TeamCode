package org.firstinspires.ftc.teamcode;
import java.io.*;
import java.lang.*;

/**
 * Created by Donny Brown on 10/14/2016.
 */


/* Sources for algorthims used:
 * Equations for calculating mecanum wheel powers can be found at:
 *      thinktank.wpi.edu/resources/346/ControllingMecanumDrive.pdf
 */

public class DriveTrain {

    double Motor1Raw;
    double Motor2Raw;      //These values are the unprocessed values for the motor speeds, ranging [-2, 2]
    double Motor3Raw;
    double Motor4Raw;

    public double Motor1Speed;      ///////////////////////////////////////////////////////////////////////////////////////////
    public double Motor2Speed;      //These values are the processed values for the motor speeds, if Raw values exceed [-1, 1],
    public double Motor3Speed;      //All Values are scaled to fit
    public double Motor4Speed;      ///////////////////////////////////////////////////////////////////////////////////////////

    double SpeedDivider;

    double[] SpeedsList;

    public DriveTrain(){

    }

    public double[] MotorsArray(double angle, double magnitude, double rotation){

        Motor1Raw = ((magnitude*(Math.sin(angle+(Math.PI/4))))+rotation);
        Motor2Raw = ((magnitude*(Math.cos(angle+(Math.PI/4))))-rotation);  //Generates Raw Values for Motors
        Motor3Raw = ((magnitude*(Math.cos(angle+(Math.PI/4))))+rotation);
        Motor4Raw = ((magnitude*(Math.sin(angle+(Math.PI/4))))+rotation);

        if (SpeedDivider < Math.abs(Motor1Raw)){
            SpeedDivider = Math.abs(Motor1Raw);          //If Speed divider is less than abs(raw Motor Value), sets value to match it.
        }                                                //This allows speed to be at maximum without loss of turning capability.
        if (SpeedDivider < Math.abs(Motor2Raw)){
            SpeedDivider = Math.abs(Motor2Raw);
        }
        if (SpeedDivider < Math.abs(Motor3Raw)){
            SpeedDivider = Math.abs(Motor3Raw);
        }
        if (SpeedDivider < Math.abs(Motor4Raw)){
            SpeedDivider = Math.abs(Motor4Raw);
        }

        if (SpeedDivider > 1) {                            //This if statement makes it so that SpeedDivider is only called if it is necessary
            Motor1Speed = Motor1Raw / SpeedDivider;        //This also avoids a NaN error when the Joysticks are at (0,0)
            Motor2Speed = Motor2Raw / SpeedDivider;
            Motor3Speed = Motor3Raw / SpeedDivider;     
            Motor4Speed = Motor4Raw / SpeedDivider;
        }
        else {
            Motor1Speed = Motor1Raw;
            Motor2Speed = Motor2Raw;
            Motor3Speed = Motor3Raw;
            Motor4Speed = Motor4Raw;
        }
        SpeedsList[0] = Motor1Speed;
        SpeedsList[1] = Motor2Speed;
        SpeedsList[2] = Motor3Speed;
        SpeedsList[3] = Motor4Speed;

        return SpeedsList;

    }


}
