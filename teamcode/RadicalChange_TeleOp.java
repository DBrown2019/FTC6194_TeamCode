package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.*;
import java.io.*;


@TeleOp (name="6194: Teleop Mecanum", group="6194")

public class RadicalChange_TeleOp extends OpMode {

    Hardware6194Mecanum robot = new Hardware6194Mecanum(); //establishes Hardware Object
    DriveTrain drive = new DriveTrain();
    launcher launch = new launcher();

    double angle;
    double magnitude;
    double rotation;

    @Override
    public void init() {
        robot.init(hardwareMap); //Defines hardware using HardwareMap in Hardware6194Mecanum
    }

    @Override
    public void loop() {
        angle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x);  // What direction the robot should move in
        if (Double.isNaN(angle)){
            angle = 0;              //Prevents NaN error later in the Program
        }

        magnitude = Math.sqrt(Math.pow(gamepad1.left_stick_x, 2) + Math.pow(gamepad1.left_stick_y, 2));  
        // How fast the robot should go in that direction

        rotation = gamepad1.right_stick_x;
        // How much the robot should turn while moving in that direction

        drive.MotorsArray(angle, magnitude, rotation); //Calculates values for Mecanum Wheels in drive class

        robot.frontleftMotor.setPower(drive.Motor1Speed);
        robot.frontrightMotor.setPower(drive.Motor2Speed);   //sets motors to run at chosen speeds in range [-1, 1]
        robot.rearleftMotor.setPower(drive.Motor3Speed);
        robot.rearrightMotor.setPower(drive.Motor4Speed);

	    if(gamepad1.a || !(launch.completedRotation)){
            launch.SingleShot(1);
        }

        telemetry.addData("Angle: ", Math.toDegrees(angle));
        telemetry.addData("Speed: ", 100.0* (magnitude / Math.sqrt(2)) );
        telemetry.addData("Rotation: ", rotation*100.0);





    }

    @Override
    public void stop(){
        robot.frontleftMotor.setPower(0);
        robot.frontrightMotor.setPower(0);
        robot.rearleftMotor.setPower(0);
        robot.rearrightMotor.setPower(0);
        robot.launchMotor.setPower(0);
    }

}
