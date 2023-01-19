import java.util.ArrayList;
import java.util.List;

public class RepositorioDeDados {
    private List<Empregado> listaDeEmpregados = new ArrayList<Empregado>();

    public void cadastrarNovosEmpregados(Empregado empregado) {
        listaDeEmpregados.add(empregado);
    }

    public List<Empregado> mostrarlistaDeEmpregados() {
        return listaDeEmpregados;
    }


    public boolean excluirEmpregado(String cpf) {
        for (int i = 0; i < listaDeEmpregados.size(); i++) {
            Empregado empregado = listaDeEmpregados.get(i);
            if (empregado.getCpf().equals(cpf)) {
                listaDeEmpregados.remove(empregado);
                return true;
            }
        }
        return false;
    }
}