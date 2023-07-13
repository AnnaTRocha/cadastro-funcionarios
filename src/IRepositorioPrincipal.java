import java.util.Map;

public interface IRepositorioPrincipal {
    public void inserirFuncionarios();
    public void removerFuncionario(String nome);
    public void buscarFuncionarios();
    public Map<String, Funcionario> getFuncionarios();

}
