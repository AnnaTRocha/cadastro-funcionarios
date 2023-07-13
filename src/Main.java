import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ControladorPrincipal controlador = new ControladorPrincipal();

        //item 3.1
        controlador.inserirFuncionarios();

        //Caso queira imprimir todos antes da remoção
        //controlador.imprimeFuncionarios();

        //item 3.2
        controlador.removerFuncionario("João");

        //item 3.3
        controlador.imprimeFuncionarios();

        //item 3.4
        controlador.aumentoSalarial(new BigDecimal(10.0));

        //item 3.5 e 3.6
        controlador.agruparPorFuncao();

        //item 3.8
        controlador.aniversariantes(10, 12);

        //item 3.9
        controlador.retornaFuncionarioMaisVelho();

        //item 3.10
        controlador.imprimirPorOrdemAlfabetica();

        //item 3.11
        controlador.somaTotalSalario();

        //item 3.12
        controlador.quantosSalariosMinimos();

    }


}