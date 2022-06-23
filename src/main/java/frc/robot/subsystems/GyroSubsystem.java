// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  /** Creates a new GyroSubsystem. */
  private PigeonIMU gyro = new PigeonIMU(14);

  public GyroSubsystem() {

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("GYRO", getHeading());
  }

  public double getHeading(){
    return Math.IEEEremainder(gyro.getFusedHeading(), 360);
  }

  public void resetHeading(){
    gyro.setFusedHeading(0);
  }
}
