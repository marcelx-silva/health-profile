import javax.swing.*;

public class HealthProfileMain {
    public static void main(String... args){
        HealthProfile hp = new HealthProfile("","",0,0,0,2021,'U',0,0);

        String nome, sobrenome;
        int dia, mes, ano, anoAtual;
        int opcao = 0;
        char sexo;
        float altura, peso;

        JOptionPane.showMessageDialog(null,"Bem Vindo ao Perfil de Saúde !" +
                "\nAo cadastrar suas informações aqui não é preciso cadastrar seus registros de saúde toda vez" +
                "que for se apresentar a um profissional !");
        int dialogButton = JOptionPane.showConfirmDialog(null,"Agora que você já sabe para o que serve," +
                "Vamos registra-los !","Deseja Continuar ?",JOptionPane.YES_NO_OPTION);
        if(dialogButton==JOptionPane.YES_OPTION){
            do{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"Bem Vindo ao Menu !" +
                        "\n1- Cadastrar o seu Nome e Sobrenome" +
                        "\n2- Data de Nascimento" +
                        "\n3- Calcular IMC" +
                        "\n4- Exibir Dados"+
                        "\n0- Sair do Aplicativo","Registro de Saúde - Menu",JOptionPane.PLAIN_MESSAGE));
                switch (opcao){
                    case 1:
                        nome = JOptionPane.showInputDialog(null,"Entre com o Primeiro Nome","Registro de Saúde - Nome",JOptionPane.QUESTION_MESSAGE);
                        hp.setNome(nome);
                        sobrenome = JOptionPane.showInputDialog(null,"Entre com o Sobrenome","Registro de Saúde - Sobrenome",JOptionPane.QUESTION_MESSAGE);
                        hp.setSobrenome(sobrenome);
                        sexo = JOptionPane.showInputDialog(null,"Através de um unico caractere entre com o seu sexo\nF- Feminimo\nM- Masculino\nB - Não Binario","Registro de Saúde - Sexo",JOptionPane.QUESTION_MESSAGE).charAt(0);
                        hp.setSexo(sexo);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Data de Nascimento");
                        dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o dia do seu nascimento","Registro de Saúde - Data de Nascimento",JOptionPane.QUESTION_MESSAGE));
                        hp.setDia(dia);
                        mes  = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o mês do seu nascimento","Registro de Saúde - Data de Nascimento",JOptionPane.QUESTION_MESSAGE));
                        hp.setMes(mes);
                        ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Insira o ano do seu nascimento","Registro de Saúde - Data de Nascimento",JOptionPane.QUESTION_MESSAGE));
                        hp.setAno(ano);
                        break;
                    case 3:
                        hp.ExibirTabela();
                        JOptionPane.showMessageDialog(null,"Apos visualizar a tabela, insira os seguintes dados");
                        peso = Float.parseFloat(JOptionPane.showInputDialog(null,"Insira o seu peso:","Registro de Saúde - IMC",JOptionPane.QUESTION_MESSAGE));
                        hp.setPeso(peso);
                        altura = Float.parseFloat(JOptionPane.showInputDialog(null,"Insira a sua altura: ","Registro de Saúde - IMC",JOptionPane.QUESTION_MESSAGE));
                        hp.setAltura(altura);
                        break;
                    case 4:
                        HealthProfile.DisplayData(hp);
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null,"Você escolheu sair do programa");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Insira uma opção valida !");
                }
            }while(opcao!=0);

        }else{
            JOptionPane.showMessageDialog(null,"Você desejou sair do programa");
        }

    }
}
