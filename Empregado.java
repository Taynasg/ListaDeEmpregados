public class Empregado implements Comparable<Empregado>  {
    private String nome;
    private String cpf;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
          return "\n Nome: " + getNome()
                + "\n CPF: " + getCpf()
                + "\n Salario: " + getSalario()
                + "\n";

    }

    @Override
    public int compareTo(Empregado outroEmpregado) {
        return this.nome.compareTo(outroEmpregado.nome);
    }



}