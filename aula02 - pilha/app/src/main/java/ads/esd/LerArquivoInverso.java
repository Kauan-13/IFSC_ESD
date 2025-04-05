package ads.esd;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class LerArquivoInverso {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Passe um argumento");
        } else {
            try {
                FileInputStream arq = new FileInputStream(args[0]);
                Scanner scanner = new Scanner(arq);
                Stack<String> stack = new Stack<>();

                while (scanner.hasNextLine()) {
                    stack.push(scanner.nextLine());
                }

                while (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
