package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by robouser on 10/11/2016.
 */

public class Hardware6194Mecanum {
 
    /* Important constants for the robot */
    public final double LauncherRatio = 1.0;   // Temp Value until robot is built
    public final int EncoderCounts = 1120;

    /* Public OpMode members. */
    public DcMotor rearleftMotor   = null;
    public DcMotor rearrightMotor  = null;
    public DcMotor frontleftMotor = null;
    public DcMotor frontrightMotor = null;
    public DcMotor launchMotor = null;
    public Servo BeaconServo = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    public Hardware6194Mecanum(){

    }
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors and servos
        frontleftMotor   = hwMap.dcMotor.get("Front_LeftMotor");
        frontrightMotor  = hwMap.dcMotor.get("Front_RightMotor");
        rearleftMotor    = hwMap.dcMotor.get("Rear_LeftMotor");
        rearrightMotor   = hwMap.dcMotor.get("Rear_RightMotor");
        launchMotor    = hwMap.dcMotor.get("Launcher_Motor");

        //BeaconServo= hwMap.servo.get("BeaconServo");

        // Set all motors to zero power and servos to default positions
        frontleftMotor.setPower(0);
        frontleftMotor.setPower(0);
        frontleftMotor.setPower(0);
        frontleftMotor.setPower(0);
        //BeaconServo.setPosition(0);

        // Set all motors to run without encoders.
        frontleftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontrightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearleftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearrightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

}
