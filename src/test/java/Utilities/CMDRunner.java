package Utilities;

public class CMDRunner {

    public static int executeCMD(String command) {

        int exitCode = -1;

        try {

            System.out.println(
                    "Executing command: " + command
            );

            Process process =
                    Runtime.getRuntime().exec(command);

            exitCode = process.waitFor();

            if (exitCode != 0) {

                System.out.println(
                        "Command failed with exit code: "
                                + exitCode
                );

            } else {

                System.out.println(
                        "Command executed successfully."
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return exitCode;
    }
}