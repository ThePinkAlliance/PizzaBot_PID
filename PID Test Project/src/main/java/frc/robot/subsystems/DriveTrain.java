package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private TalonSRX frontLeft;
    private TalonSRX backLeft;
    private TalonSRX frontRight;
    private TalonSRX backRight;

    private double circumference;

    private Encoder frontLeftEnc;
    private Encoder backLeftEnc;
    private Encoder frontRightEnc;
    private Encoder backRightEnc;

    private DigitalInput input = new DigitalInput(2);


    public DriveTrain() {
        this.frontLeft = new TalonSRX(2);
        this.backLeft = new TalonSRX(3);
        this.frontRight = new TalonSRX(1);
        this.backRight = new TalonSRX(4);

        this.frontLeftEnc = new Encoder(2,3);
        this.frontLeftEnc = new Encoder(8,9);

        this.backLeft.follow(frontLeft);
        this.backRight.follow(frontRight);

        this.frontLeft.setInverted(true);

        this.circumference = (2 * Math.PI * (5.875 / 2));
    }

    public void setSpeeds(double left, double right) {
        this.frontLeft.set(ControlMode.PercentOutput, left);
        this.frontRight.set(ControlMode.PercentOutput, right);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("DIO value", input.get());
        SmartDashboard.putNumber("left position", frontLeftEnc.getDistance());
    }
}
