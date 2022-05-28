// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerSubsystem extends SubsystemBase {

  private WPI_TalonFX conveyerMotor=new WPI_TalonFX(13);

  /** Creates a new ConveyerSubsystem. */
  public ConveyerSubsystem() {
    conveyerMotor.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(double cSpeed){
    conveyerMotor.set(ControlMode.PercentOutput, cSpeed);
  }

  public void stop(){
    conveyerMotor.set(ControlMode.PercentOutput, 0);
  }
}
