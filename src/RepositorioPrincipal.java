import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;

public class RepositorioPrincipal implements IRepositorioPrincipal {

    private Map<String, Funcionario> funcionarios = new HashMap<>();

    public RepositorioPrincipal() {
        this.funcionarios = new LinkedHashMap<>();
    }

    @Override
    public void inserirFuncionarios(){

        funcionarios.put("Maria", new Funcionario("Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal(2009.44),
                "Operador"));

        funcionarios.put("João", new Funcionario("João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal(2284.38),
                "Operador"));

        funcionarios.put("Caio", new Funcionario("Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal(9836.14),
                "Coordenador"));

        funcionarios.put("Miguel", new Funcionario("Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal(19119.88),
                "Diretor"));

        funcionarios.put("Alice", new Funcionario("Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal(2234.68),
                "Recepcionista"));

        funcionarios.put("Heitor", new Funcionario("Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal(1582.71),
                "Operador"));

        funcionarios.put("Arthur", new Funcionario("Arthur",
                LocalDate.of(1999, 11, 19),
                new BigDecimal(1582.71),
                "Operador"));

        funcionarios.put("Laura", new Funcionario("Laura",
                LocalDate.of(1999, 11, 19),
                new BigDecimal(1582.71),
                "Operador"));

        funcionarios.put("Heloisa", new Funcionario("Heloisa",
                LocalDate.of(1999, 11, 19),
                new BigDecimal(1582.71),
                "Operador"));

        funcionarios.put("Helena", new Funcionario("Helena",
                LocalDate.of(1999, 11, 19),
                new BigDecimal(1582.71),
                "Operador"));

    }

    @Override
    public void removerFuncionario(String nome) {
        funcionarios.remove(nome);
    }

    @Override
    public void buscarFuncionarios(){
        System.out.println("----------------------------");
        for (Funcionario funcionario : funcionarios.values()) {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            NumberFormat formatoNumero = NumberFormat.getInstance(new Locale("pt", "BR"));

            System.out.println(funcionario.getName());
            System.out.println(funcionario.getDataNascimento().format(formatoData));
            System.out.println(formatoNumero.format(funcionario.getSalario()));
            System.out.println(funcionario.getFuncao());
            System.out.println("----------------------------");
        }
    }

    @Override
    public Map<String, Funcionario> getFuncionarios(){
        return this.funcionarios;
    }

}
