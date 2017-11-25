package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Tristan on 9/26/2016.
 */
public class RelicArm
{
    Servo servoClaw;
    Servo servoArm;
    DcMotor liftMotor;
    boolean clawClosed = true;
    double servoPosistion = 1;
    double clawPosistion = 1;
    double off = 1;

    public RelicArm(HardwareMap hardwareMap)
    {
        liftMotor = hardwareMap.dcMotor.get("relicMotor"); //sets DcMotors to type of motor
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        servoClaw = hardwareMap.servo.get("servoClaw");
        servoArm = hardwareMap.servo.get("servoArm");
    }

    public void lift(double power)
    {
        if(off + power > 0) {
            liftMotor.setPower(power);
        }
        off += power;

    }

    public void clawPosistion(double change) {
        clawPosistion += change;
        if(clawPosistion > 1)
        {
            clawPosistion = 1;
        }
        if(clawPosistion < 0)
        {
            clawPosistion = 0;
        }
        servoClaw.setPosition(clawPosistion);
    }

    public void armPosistion(double change) {
        servoPosistion += change;
        if(servoPosistion > 1)
        {
            servoPosistion = 1;
        }
        if(servoPosistion < 0)
        {
            servoPosistion = 0;
        }
        servoArm.setPosition(servoPosistion);
    }

}
