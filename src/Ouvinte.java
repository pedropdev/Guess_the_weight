import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Ouvinte {
    String nome, localidade, numTel;

    int jogos, ganhou;

    double palpite;

    List<String> info;




    public Ouvinte(String name, String sitio, String tele){
        this.nome = name;
        this.localidade = sitio;
        this.numTel = tele;
        this.palpite = 0.0;
        this.jogos = 0;
        this.ganhou = 0;
//        this.info = new ArrayList<>();
//        this.info.add(name);
//        this.info.add(sitio);
//        this.info.add(tele);
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public double getPalpite() {
        return palpite;
    }

    public void setPalpite(double palpite) {
        this.palpite = palpite;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getGanhou() {
        return ganhou;
    }

    public void setGanhou(int ganhou) {
        this.ganhou = ganhou;
    }

//    public List<String> getInfo() {
//        return info;
//    }
//
//    public void setInfo(List<String> info) {
//        this.info = info;
//    }



    @Override
    public String toString() {
        String text = "Nome: " + this.nome + "\t\tLocalidade: " + this.localidade + "\tTel:" + this.numTel + "\n";

        return text;
    }
}
