import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.math.RoundingMode;

public class ControladorPrincipal {

    private Map<String, Funcionario> funcionarios;
    private RepositorioPrincipal repositorioPrincipal;

    public ControladorPrincipal() {
        this.repositorioPrincipal = new RepositorioPrincipal();
    }

    public void inserirFuncionarios() {
        repositorioPrincipal.inserirFuncionarios();
    }

    public void removerFuncionario(String nome) {
        repositorioPrincipal.removerFuncionario(nome);
    }

    public void imprimeFuncionarios(){
        System.out.println("-------- Funcionários ---------");
        repositorioPrincipal.buscarFuncionarios();
    }

    public void aumentoSalarial(BigDecimal percentualAumento){
        funcionarios = repositorioPrincipal.getFuncionarios();
        for (Funcionario funcionario : funcionarios.values()) {
            BigDecimal aumento = funcionario.getSalario().multiply(percentualAumento.divide(new BigDecimal(100)));
            BigDecimal novoSalario = funcionario.getSalario().add(aumento);
            funcionario.setSalario(novoSalario);

            NumberFormat formatoNumero = NumberFormat.getInstance(new Locale("pt", "BR"));

            String mensagem = String.format("O funcionário %s teve seu " +
                    "salário ajustado para %s com o percentual aplicado.",
                    funcionario.getName(), formatoNumero.format(funcionario.getSalario()));
            System.out.println(mensagem);

        }
    }

    public void agruparPorFuncao(){
        List<Funcionario> funcionarios = getListaFuncionarios();
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            String funcao = funcionario.getFuncao();
            if (!funcionariosPorFuncao.containsKey(funcao)) {
                funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }
            funcionariosPorFuncao.get(funcao).add(funcionario);
        }

        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcionariosPorFuncaoLista = entry.getValue();

            System.out.println("Função: " + funcao);
            for (Funcionario funcionario : funcionariosPorFuncaoLista) {
                System.out.println("- " + funcionario.getName());
            }
            System.out.println();
        }
    }

    public List<Funcionario> getListaFuncionarios(){
        List<Funcionario> listaFuncionarios = new ArrayList<>(repositorioPrincipal.getFuncionarios().values());
        return listaFuncionarios;
    }

    public void aniversariantes(int... meses){
        List<Funcionario> funcionarios = getListaFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (mesAniversario == mes) {
                    System.out.println(funcionario.getName() + " faz aniversário no mês "
                                        + funcionario.getDataNascimento().getMonthValue());
                    break;
                }
            }
        }

    }

    public void retornaFuncionarioMaisVelho(){
        Funcionario maisVelho = getListaFuncionarios().get(0);
        for (Funcionario funcionarioAtual : getListaFuncionarios()) {
            if (funcionarioAtual.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionarioAtual;
            }
        }
        int idade = calcularIdade(maisVelho.getDataNascimento());

        System.out.println("");
        System.out.println("O funcionário mais velho é " + maisVelho.getName() + " com "+ idade + " anos.");
    }

    public int calcularIdade(LocalDate data){
        return (int) ChronoUnit.YEARS.between(data, LocalDate.now());
    }

    public void imprimirPorOrdemAlfabetica(){
        List<Funcionario> FuncionariosAlfa =getListaFuncionarios();
        Collections.sort(FuncionariosAlfa, Comparator.comparing(Funcionario::getName));

        System.out.println("");
        for (Funcionario funcionario : FuncionariosAlfa) {
            System.out.println(funcionario.getName());
        }
    }

    public void somaTotalSalario(){
        BigDecimal total = new BigDecimal(0.0);
        NumberFormat formatoNumero = NumberFormat.getInstance(new Locale("pt", "BR"));

        for(Funcionario funcionario : getListaFuncionarios()){
            total = total.add(funcionario.getSalario());
        }
        System.out.println("");
        System.out.println("Total do salário da equipe: " + formatoNumero.format(total));
    }

    public void quantosSalariosMinimos(){
        BigDecimal salarioMinimo = new BigDecimal(1212.00);

        for (Funcionario funcionario : getListaFuncionarios()) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.DOWN);
            System.out.println(funcionario.getName() + " recebe " + salariosMinimos + " salários mínimos");
        }
    }




}
