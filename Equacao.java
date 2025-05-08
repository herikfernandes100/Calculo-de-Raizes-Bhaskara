import javax.swing.JOptionPane;

public class Equacao {

    private double a;
    private double b;
    private double c;

    // Métodos get e set para cada atributo
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    // Método para calcular o delta
    public double delta() {
        return Math.pow(b, 2) - (4 * a * c);
    }

    // Método para calcular a primeira raiz
    public double retornaX1() {
        double d = delta();
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    // Método para calcular a segunda raiz
    public double retornaX2() {
        double d = delta();
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    public static void main(String[] args) {
        boolean continuar = true; // Variável para definir se o usuário deseja sair ou continuar

        do {
            try {
                Equacao equacao = new Equacao();

                // Leitura dos parâmetros informados pelo usuário
                equacao.setA(leituraParametro("Insira o parâmetro A:"));
                equacao.setB(leituraParametro("Insira o parâmetro B:"));
                equacao.setC(leituraParametro("Insira o parâmetro C:"));

                // Cálculos
                double delta = equacao.delta();
                if (delta < 0) {
                    JOptionPane.showMessageDialog(null, "Delta é negativo. Não existem raízes reais.", "Resultado", JOptionPane.WARNING_MESSAGE);
                } else {
                    double x1 = equacao.retornaX1();
                    double x2 = equacao.retornaX2();
                    // Exibição do resultado
                    JOptionPane.showMessageDialog(null, "X1 = " + x1 + "\nX2 = " + x2, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }

                // Pergunta se deseja continuar
                int resposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja continuar?\n[0] Não\n[1] Sim", "Continuar?", JOptionPane.QUESTION_MESSAGE));
                if (resposta == 0) {
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saindo...", "Encerrando", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira apenas números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (continuar); // O loop continua até o usuário escolher sair
    }

    // Método para ler um parâmetro e garantir que o valor inserido é válido
    private static double leituraParametro(String mensagem) {
        double parametro = 0;
        boolean valorValido = false;

        while (!valorValido) {
            try {
                String entrada = JOptionPane.showInputDialog(null, mensagem, "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
                parametro = Double.parseDouble(entrada); // Tenta converter para double
                valorValido = true; // Se a conversão for bem-sucedida, o valor é válido
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        return parametro;
    }
}
