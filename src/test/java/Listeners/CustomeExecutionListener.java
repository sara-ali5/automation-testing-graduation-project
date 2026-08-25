package Listeners;

import Utilities.CMDRunner;
import org.testng.IExecutionListener;

public class CustomeExecutionListener implements IExecutionListener {

    private final String deleteJsonCommand =
            "cmd /c if exist target\\allure-results\\*.json del /q target\\allure-results\\*.json";

    private final String generateAllureReportCommand =
            "cmd /c allure generate target\\allure-results -o allure-report --clean --single-file";

    @Override
    public void onExecutionStart() {

        System.out.println("========== Allure Execution Started ==========");

        CMDRunner.executeCMD(deleteJsonCommand);
    }

    @Override
    public void onExecutionFinish() {

        System.out.println("========== Generating Allure Report ==========");

        int exitCode =
                CMDRunner.executeCMD(
                        generateAllureReportCommand
                );

        System.out.println(
                "Allure report generation exit code: "
                        + exitCode
        );

        System.out.println("========== Allure Execution Finished ==========");
    }
}