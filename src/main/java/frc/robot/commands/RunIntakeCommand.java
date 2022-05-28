// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class RunIntakeCommand extends CommandBase {

  private IntakeSubsystem INTAKE_SUBSYSTEM;
  private ConveyerSubsystem CONVEYER_SUBSYSTEM;
  private boolean InOut;

  /** Creates a new RunIntakeCommand. */
  public RunIntakeCommand(IntakeSubsystem intake, ConveyerSubsystem conveyer, boolean IO) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.INTAKE_SUBSYSTEM=intake;
    this.CONVEYER_SUBSYSTEM=conveyer;

    InOut=IO;
    addRequirements(INTAKE_SUBSYSTEM);
    addRequirements(CONVEYER_SUBSYSTEM);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (InOut)
    {
      INTAKE_SUBSYSTEM.set(-1, -0.75);
      CONVEYER_SUBSYSTEM.set(0.5);
    }
    if (!InOut)
    {
      INTAKE_SUBSYSTEM.set(1, -0.75);
      CONVEYER_SUBSYSTEM.set(-0.5);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { //can measure current for motors

    INTAKE_SUBSYSTEM.stop();
    CONVEYER_SUBSYSTEM.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; //INTAKE_SUBSYSTEM.getCurrent()>10; //make method called getCurrent, get current, if it is too high return true, stop motor
  }
}
