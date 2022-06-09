// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  //initializing motors for drivetrain
  private WPI_TalonFX leftDrivePrimary=new WPI_TalonFX(1);
  private WPI_TalonFX leftDriveF1=new WPI_TalonFX(2);
  private WPI_TalonFX leftDriveF2=new WPI_TalonFX(3);

  private WPI_TalonFX rightDrivePrimary=new WPI_TalonFX(4);
  private WPI_TalonFX rightDriveF1=new WPI_TalonFX(5);
  private WPI_TalonFX rightDriveF2=new WPI_TalonFX(6);

  public final DifferentialDrive DRIVE;


  public DriveSubsystem() {

    //configing to fac default
    leftDrivePrimary.configFactoryDefault();
    leftDriveF1.configFactoryDefault();
    leftDriveF2.configFactoryDefault();

    rightDrivePrimary.configFactoryDefault();
    rightDriveF1.configFactoryDefault();
    rightDriveF2.configFactoryDefault();

    //setting up follows
    leftDriveF1.follow(leftDrivePrimary);
    leftDriveF2.follow(leftDrivePrimary);

    rightDriveF1.follow(rightDrivePrimary);
    rightDriveF2.follow(rightDrivePrimary);

    //inverting left side
    leftDrivePrimary.setInverted(InvertType.InvertMotorOutput); //actually inverts it
    leftDriveF1.setInverted(InvertType.FollowMaster); //follows same invert type as the thing it is following
    leftDriveF2.setInverted(InvertType.FollowMaster);

    //setting right to not invert (makes it easy to swap invert)
    rightDrivePrimary.setInverted(InvertType.None); 
    rightDriveF1.setInverted(InvertType.FollowMaster); //follows same invert type as the thing it is following
    rightDriveF2.setInverted(InvertType.FollowMaster);


    //can cap voltage, or many other things, check CTRE docs

     DRIVE=new DifferentialDrive(leftDrivePrimary, rightDrivePrimary);

  }

  @Override
  public void periodic() { //used for debug, print stuff to dashboard
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("LEFT MOTOR SPEED", leftDrivePrimary.getSelectedSensorVelocity());
    SmartDashboard.putNumber("RIGHT MOTOR SPEED", rightDrivePrimary.getSelectedSensorVelocity());

    SmartDashboard.putNumber("LEFT MOTOR POSITION", getLeftPosition());
    SmartDashboard.putNumber("RIGHT MOTOR POSITION", getRightPosition());
  }

  public void set(double lYSpeed, double rXSpeed){
    lYSpeed=0.7*lYSpeed;
    rXSpeed=0.7*rXSpeed;
    DRIVE.arcadeDrive(lYSpeed, rXSpeed);
  }

  public void stop(){
    leftDrivePrimary.set(ControlMode.PercentOutput, 0);
    rightDrivePrimary.set(ControlMode.PercentOutput, 0);
  }


  public double getLeftPosition(){
    return leftDrivePrimary.getSelectedSensorPosition();
  }

  public double getRightPosition(){
    return rightDrivePrimary.getSelectedSensorPosition();
  }

  public void resetPosition(){
    leftDrivePrimary.setSelectedSensorPosition(0);
    rightDrivePrimary.setSelectedSensorPosition(0);
  }
}
