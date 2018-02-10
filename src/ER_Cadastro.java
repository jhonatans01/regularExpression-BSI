
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jhonatan
 */
public class ER_Cadastro {

    public static Scanner scanner = new Scanner(System.in);
    public static String texto = "";
    public static String[] dados = new String[3];

    public static void mostrarMenu() {
        System.out.println("Escolha a opção: ");
        System.out.println("1 - Preencher dados");
        System.out.println("2 - Pesquisar dados");
        System.out.println("3 - Substituir dados");
    }

    public static void nomeForm() {

        System.out.print("\nDigite o nome: ");
        dados[0] = scanner.nextLine();

        while (!Pattern.matches("\\D+", dados[0])) {
            System.out.print("Digite o nome novamente: ");
            dados[0] = scanner.nextLine();
        }
    }

    public static void telefoneForm() {

        System.out.print("Digite o telefone: ");
        dados[1] = scanner.nextLine();

        while (!Pattern.matches("(\\d{8,})"
                + "|(\\w{4,5}\\W{1}\\d{4})"
                + "|(\\W{1}\\d{2}\\W{1}\\w{4,5}\\W{1}\\d{4})", dados[1])) {
            System.out.print("Digite o telefone novamente: ");
            dados[1] = scanner.nextLine();
        }
    }

    public static void emailForm() {

        System.out.print("Digite o email: ");
        dados[2] = scanner.nextLine();
        while (!Pattern.matches("\\w+@[^\\d^\\s]+", dados[2])) {
            System.out.print("Digite o email novamente: ");
            dados[2] = scanner.nextLine();
        }
    }

    public static void preencherForm() {

        nomeForm();
        telefoneForm();
        emailForm();

        texto = "Nome: " + dados[0]
                + "\nTelefone: " + dados[1]
                + "\nEmail: " + dados[2];
    }

    public static void pesquisar() {
        System.out.println("Pesquisar: ");
        System.out.println("1 - Nome");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        System.out.println("4 - Ver todos");
        int resp = scanner.nextInt();

        switch (resp) {
            case 1:
//                if(Matcher()..ma)
                break;

            case 2:
                telefoneForm();
                break;

            case 3:
                emailForm();
                break;

            default:
                break;
        }
    }

    public static void substituir() {

        System.out.println("Substituir: ");
        System.out.println("1 - Nome");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        int resp = scanner.nextInt();

        switch (resp) {
            case 1:
                nomeForm();
                texto = texto.
                        replaceAll("^Nome: \\w+", "Nome: " + dados[0]);
                System.out.println(texto);
        }
    }

    public static void main(String[] args) {
        preencherForm();

        mostrarMenu();

        int opt = scanner.nextInt();
        do {
            switch (opt) {
                case 1:

                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    substituir();
                    break;
                case 4:
                    System.exit(opt);
                default:
                    System.out.println("Opção não existente\n");
                    break;
            }
            mostrarMenu();
            opt = scanner.nextInt();
        } while (opt != 4);

    }
}
