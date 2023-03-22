package unitTest;// Biblioteca

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

// Classe


public class TesteCalculadora {
    // Atributos

    // Funções e Métodos

    @Test
    @DisplayName("Teste para somar dois números")
    public void testeSomarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoExperado = 12;

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // Valida
        Assertions.assertEquals(resultadoExperado, resultadoAtual);
    }// final do teste do somar

    // Este é um teste de unidade data driven - direcionado por dados
    @ParameterizedTest
    @CsvSource(value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    @DisplayName("Teste para somar dois números usando lista")
    public void testeSomarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoExperado){
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1) , Integer.valueOf(txtNum2));

        // Valida
        Assertions.assertEquals(Double.valueOf(resultadoExperado), resultadoAtual);
    } // final do teste do somar


    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    @DisplayName("Teste para somar dois números usando arquivo")
    public void testeSomarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoExperado){
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1) , Integer.valueOf(txtNum2));

        // Valida
        Assertions.assertEquals(Double.valueOf(resultadoExperado), resultadoAtual);
    }




    @Test
    @DisplayName("Teste para subtrair dois números")
    public void testeSubtrairDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoExperado = 2;

        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        // Valida
        Assertions.assertEquals(resultadoExperado, resultadoAtual);
    }


    @Test
    @DisplayName("Teste para multiplicar dois números")
    public void testeMultiplicarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoExperado = 35;

        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        // Valida
        Assertions.assertEquals(resultadoExperado, resultadoAtual);
    }

    @Test
    @DisplayName("Teste para dividir dois números")
    public void testeDividirDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoExperado = 1.4;

        // Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

        // Valida
        Assertions.assertEquals(resultadoExperado, resultadoAtual);
    }

    @Test
    @DisplayName("Teste para dividir dois numeros inteiros")
    public void testeDividirDoisNumerosInteiros(){ // início do teste dividir inteiro
        // Configura
        int numA = 8;
        int numB = 2;
        int resultadoEsperado = 4;

        // Executa
        int resultadoAtual  = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        // Valida
        Assertions.assertEquals(resultadoEsperado, resultadoAtual);


    } // fim do teste dividir inteiro

}
