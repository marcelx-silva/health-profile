

import javax.swing.*;
import java.security.SecureRandom;

public class HealthProfile {
    SecureRandom random = new SecureRandom();

    private String nome, sobrenome;
    private int dia, mes, ano, anoAtual;
    private char sexo;
    private float altura, peso; // variaveis para calcular o IMC

    public HealthProfile (String nome, String sobrenome, int dia, int mes, int ano, int anoAtual, char sexo, float peso, float altura){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        if(dia > 0){
            this.dia = dia;
        }
        if(mes > 0){
            this.mes = mes;
        }
        if(ano > 0){
            this.ano = ano;
        }if(anoAtual>ano){
            this.anoAtual = anoAtual;
        }else{
            this.anoAtual = anoAtual;
        }

        if(peso>0){
            this.peso = peso;
        }
        if(altura>0){
            this.altura = altura;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAnoAtual() {
        return anoAtual;
    }
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    public char getSexo(){
        return sexo;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }



    //metodo para pegar a idade em anos do usuário
    public int IdadeAnos(){
        int idade = 0;
        idade = getAnoAtual() - getAno();
        return idade;
    }

    // calcula a frequencia cardiaca maxima
    public double freqCardMax(){
        double freqCardMax = 0.0;
        freqCardMax = 220 - IdadeAnos();
        return freqCardMax;
    }

    //calcula a frequencia cardiaca alvo
    public double freqCardAlvo(){
        double  freqCardAlvo = 0.0;
        float intervalo = random.nextInt(50,85);
        freqCardAlvo = freqCardMax()*(intervalo/100);
        return freqCardAlvo;
    }

    //calcula o IMC do usuário
    public float calcularImc(){
        return getPeso()/(getAltura()*getAltura());
    }

    //Mostra a situação do Usuário com base no seu IMC
    public String situacaoIMC(){
        float imc = calcularImc();
        String situacao = " ";
        if(imc<=18.5){
            situacao = "Abaixo do Peso";
        }else if(imc>=18.6 && imc<=24.9){
            situacao = "Peso Ideial";
        }else if(imc>=25 && imc<=29.9){
            situacao = "Levemente Acima do Peso";
        }else if(imc >=30 && imc<=34.9){
            situacao = "Obesidade Grau 1";
        }else if(imc>=35 && imc<=39.9){
            situacao = "Obesidade Grau 2 ( Severa)";
        }else{
            situacao = "Obesidade Grau 3 ( Mórbida)";
        }
        return situacao;
    }

    //Exibe a tabela do IMC
    public void ExibirTabela(){
        String tabela = " ";
        tabela = "Abaixo do Peso : Menor que 18.5" +
                "\nPeso Ideal: Entre 18.6 e 24.9" +
                "\nLevemente Acima do Peso: Entre 25 e 29.9" +
                "\nObesidade Grau 1: Entre 30 e 34.9" +
                "\nObesidade Grau 2 (Severa): Entre 35 e 39.9" +
                "\nObesidade Grau 3 (Mórbida): Acima de 40";
        JOptionPane.showMessageDialog(null,tabela,"Tabela de Indice de Massa Corporal",JOptionPane.PLAIN_MESSAGE);
    }

    //Exibe as informações do usuário
    public static void DisplayData(HealthProfile hp){
        String display = "Informações Sobre o Paciente " + hp.getNome() + " " + hp.getSobrenome() +
                "\n\nSexo:"+hp.getSexo()+
                "\n\nData de Nascimento: " + hp.getDia() + "/" + hp.getMes() + "/" + hp.getAno() +
                "\n\nIdade em Anos: " + hp.IdadeAnos() +
                "\n\nFrequencia Cardiaca Máxima: " + hp.freqCardMax() +
                "\n\nFrequencia Cardiaca Alvo: " + hp.freqCardAlvo() +
                "\n\nInformações Sobre o Indice de Massa Corporal" +
                "\n\nValor do IMC: " + hp.calcularImc() +
                "\n\nSituação: " + hp.situacaoIMC();

        JOptionPane.showMessageDialog(null,display);
    }

}
