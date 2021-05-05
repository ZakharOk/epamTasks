package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        final Process p;
        try {
            p = Runtime.getRuntime().exec("KeccakCli.exe -w=256 text.txt");
        new Thread(() -> {
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            try {
                while ((line = input.readLine()) != null)
                    System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        p.waitFor();
        } catch (IOException | InterruptedException e) {
            return;
        }
    }
}
