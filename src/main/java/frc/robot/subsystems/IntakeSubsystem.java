// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  private WPI_TalonFX intakeMotor = new WPI_TalonFX(11);
  private WPI_TalonFX gateMotor = new WPI_TalonFX(9);
  private double currIntake = 0, currGate = 0;

  public IntakeSubsystem() {
    intakeMotor.configFactoryDefault();
    gateMotor.configFactoryDefault();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("INTAKE MOTOR SPEED", currIntake);
    SmartDashboard.putNumber("GATE MOTOR SPEED", currGate);

  }

  public void set(double intakeSpeed, double gateSpeed) {
    intakeMotor.set(ControlMode.PercentOutput, intakeSpeed);
    gateMotor.set(ControlMode.PercentOutput, gateSpeed);
    currIntake = intakeSpeed;
    currGate = gateSpeed;
  }

  public void stop() {
    intakeMotor.set(ControlMode.PercentOutput, 0);
    gateMotor.set(ControlMode.PercentOutput, 0);
    currGate = 0;
    currIntake = 0;
  }
}
