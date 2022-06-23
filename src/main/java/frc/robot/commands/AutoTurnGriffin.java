// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTurnGriffin extends CommandBase {

  DriveSubsystem DRIVE_SUBSYSTEM;
  double Degrees;
  double encoderDegreesLeft, encoderDegreesRight;
  boolean finished;

  /** Creates a new AutoTurn. */
  public AutoTurnGriffin(DriveSubsystem drive, double deg) {
    addRequirements(drive);
    DRIVE_SUBSYSTEM=drive;
    Degrees=deg;
    finished=false;

    
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DRIVE_SUBSYSTEM.resetPosition();
    encoderDegreesLeft=Constants.LeftMotor360ETicks*(Math.abs(Degrees)/360);
    encoderDegreesRight=Constants.RightMotor360ETicks*(double)(Math.abs(Degrees)/360.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if (Math.abs(Degrees)!=Degrees){
        if (DRIVE_SUBSYSTEM.getRightPosition()<encoderDegreesRight+100 && DRIVE_SUBSYSTEM.getRightPosition()>encoderDegreesRight-100){
          finished=true;
        }
        else if (DRIVE_SUBSYSTEM.getRightPosition()>encoderDegreesRight+100){
          DRIVE_SUBSYSTEM.set(0, 0.6);
        }
        else{
          DRIVE_SUBSYSTEM.set(0, -0.6);
        }
      }
      else{
        if (DRIVE_SUBSYSTEM.getLeftPosition()<encoderDegreesLeft+100 && DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft-100){
          finished=true;
        }
        else if (DRIVE_SUBSYSTEM.getLeftPosition()>encoderDegreesLeft+100){
          DRIVE_SUBSYSTEM.set(0, -0.6);
        }
        else{
          DRIVE_SUBSYSTEM.set(0, 0.6);
      }
    }
      
      
      SmartDashboard.putNumber("encoderDegreesLeft: ", encoderDegreesLeft);
      SmartDashboard.putNumber("encoderDegreesRight: ", encoderDegreesRight);
      SmartDashboard.putBoolean("finshed: ", finished);
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
