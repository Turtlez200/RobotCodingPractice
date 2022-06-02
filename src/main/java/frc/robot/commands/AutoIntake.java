// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntake extends CommandBase {

  private IntakeSubsystem INTAKE_SUBSYSTEM;
  private ConveyerSubsystem CONVEYER_SUBSYSTEM;

  private double intakeSpeed;
  private double gateSpeed;
  private double conveyerSpeed;

  /** Creates a new AutoIntake. */
  public AutoIntake(IntakeSubsystem intake, ConveyerSubsystem conveyer, double iS, double gS, double cS) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
    addRequirements(conveyer);

    intakeSpeed=iS;
    gateSpeed=gS;
    conveyerSpeed=cS;

    INTAKE_SUBSYSTEM=intake;
    CONVEYER_SUBSYSTEM=conveyer;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    INTAKE_SUBSYSTEM.set(intakeSpeed, gateSpeed);
    CONVEYER_SUBSYSTEM.set(conveyerSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    INTAKE_SUBSYSTEM.set(0, 0);
    CONVEYER_SUBSYSTEM.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
