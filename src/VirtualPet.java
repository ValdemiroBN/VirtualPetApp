import javax.swing.*;

public class VirtualPet {
    String nome;
    int fome;
    int felicidade;

    public VirtualPet(String nome) {
        this.nome = nome;
        fome = 60;
        felicidade = 60;
    }

    public String getNome() {
        return nome;
    }

    public int getFome() {
        return fome;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public void alimentar() {
        fome -= 10;
        System.out.println("Você alimentou " + nome + ". Fome: " + fome);
    }

    public void brincar() {
        felicidade += 10;
        System.out.println("Você brincou com " + nome + ". Felicidade: " + felicidade);
    }

    public void acariciar() {
        felicidade += 5;
        System.out.println("Você acariciou " + nome + ". Felicidade: " + felicidade);
    }
}