// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  private WPI_TalonFX shooterMotorPrimary = new WPI_TalonFX(10);
  private WPI_TalonFX shooterMotor1 = new WPI_TalonFX(7);
  private double currShooter = 0;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterMotorPrimary.configFactoryDefault();
    shooterMotor1.configFactoryDefault();

    shooterMotor1.follow(shooterMotorPrimary);
    shooterMotor1.setInverted(InvertType.InvertMotorOutput);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("SHOOTER SPEED", currShooter);
  }

  public void set(double shooterSpeed) {
    shooterMotorPrimary.set(ControlMode.PercentOutput, shooterSpeed);
    currShooter = shooterSpeed;
  }

  public void stop() {
    shooterMotorPrimary.set(ControlMode.PercentOutput, 0);
    currShooter = 0;
  }
}
