// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.UnitConversion;

public class ShooterSubsystemClosedLoop extends SubsystemBase {

  private WPI_TalonFX shooterMotorPrimary = new WPI_TalonFX(10);
  private WPI_TalonFX shooterMotor1 = new WPI_TalonFX(7);

  public static int targetVelocity=4000;
  
  /** Creates a new ShooterSubsystemClosedLoop. */
  public ShooterSubsystemClosedLoop() {

    shooterMotorPrimary.configFactoryDefault();
    shooterMotor1.configFactoryDefault();

    shooterMotorPrimary.setNeutralMode(NeutralMode.Coast);
    shooterMotor1.setNeutralMode(NeutralMode.Coast);

    shooterMotorPrimary.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0 , 30);
    shooterMotor1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0 , 30);

    shooterMotorPrimary.configNominalOutputForward(0);
    shooterMotorPrimary.configNominalOutputReverse(0);
    shooterMotorPrimary.configPeakOutputForward(1);
    shooterMotorPrimary.configPeakOutputReverse(-1);
    
    shooterMotor1.configNominalOutputForward(0);
    shooterMotor1.configNominalOutputReverse(0);
    shooterMotor1.configPeakOutputForward(1);
    shooterMotor1.configPeakOutputReverse(-1);

    shooterMotorPrimary.config_kP(0, 0);
    shooterMotorPrimary.config_kI(0, 0);
    shooterMotorPrimary.config_kD(0, 0);
    shooterMotorPrimary.config_kF(0, 0);

    shooterMotor1.config_kP(0, 0);
    shooterMotor1.config_kI(0, 0);
    shooterMotor1.config_kD(0, 0);
    shooterMotor1.config_kF(0, 0);

    shooterMotorPrimary.setInverted(InvertType.None);
    shooterMotor1.setInverted(InvertType.InvertMotorOutput);

    shooterMotor1.follow(shooterMotorPrimary);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Current Motor RPM", UnitConversion.nativeUnitstoRPM(getVelocity()));
    SmartDashboard.putNumber("Target RPM", targetVelocity);

 }

 public double getVelocity(){
   return shooterMotorPrimary.getSelectedSensorVelocity();
 }

 public void setShooterSpeed(double spd){
   shooterMotorPrimary.set(TalonFXControlMode.Velocity, UnitConversion.RPMtoNativeUnits(spd));
 }

 public void stopShooter(){
   shooterMotorPrimary.set(TalonFXControlMode.PercentOutput, 0);
 }}
