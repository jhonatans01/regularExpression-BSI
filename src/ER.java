
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

public class ER {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();

            if (file != null) {
                System.out.println("Arquivo pronto");
            } else {
                System.out.println("Nenhum arquivo selecionado!");
                System.exit(0);
            }
            
            BufferedReader br
                    = new BufferedReader(
                            new FileReader(file));

            System.out.println("Digite a palavra a ser pesquisada: ");
            String entrada = scanner.next();
            int count = 0;
            String texto = "";

            Pattern p = Pattern.compile("(?i)(.*)(" + entrada + ")(.*)");

            while (br.ready()) {
                String linha = br.readLine();
                texto += linha + "\n";
                if (Pattern.matches(p.pattern(), linha)) {
                    count++;
                }
            }

            System.out.println("Palavra encontrada " + count + " vezes no texto");
            Matcher m = p.matcher(texto);

            System.out.println("Deseja mostrar as ocorrências? s/n");
            String resp = scanner.next();
            if (resp.equals("s") || resp.equals("S")) {
                while (m.find()) {
                    System.out.println(m.group());
                }
            }

            System.out.print("\nDeseja substituir? s/n ");
            resp = scanner.next();

            if (resp.equals("s") || resp.equals("S")) {
                System.out.print("Por qual palavra deseja substuir? ");
                String replace = scanner.next();
                texto = texto.
                        replaceAll("(?i)" + entrada, replace);
            }

            System.out.println(texto);

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
