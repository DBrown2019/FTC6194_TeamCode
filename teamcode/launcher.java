package org.firstinspires.ftc.teamcode;
import java.io.*;
import java.lang.*;

public class launcher{
    
    
    boolean Feedback = false;

    double Ratio;                    //Gear Ratio Motor:LaunchRotor
    double EncoderCount;
    public boolean completedRotation = true;
    boolean g = true;

    Hardware6194Mecanum robot = new Hardware6194Mecanum();
    

    public launcher(){}

    public void init(double ratio, double count){
        this.Ratio = ratio;
        this.EncoderCount = count;
    }
    private double targetCount(){
        return (this.EncoderCount / this.Ratio);
    }

    public void SingleShot(double power){
        
        if(completedRotation){
            completedRotation = false;
            //Add a statement to reset encoders
            robot.launchMotor.setPower(0);
        }
        else if (g){
            //sets motor mode to run using encoders
            g = false;
            robot.launchMotor.setPower(power);
        }
        else if (Feedback){
            robot.launchMotor.setPower(0);
            completedRotation = true;

        }
        
    }
     
}

