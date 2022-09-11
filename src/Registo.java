import java.util.ArrayList;
import java.util.List;

public class Registo {

    List<Ouvinte> listaOuvintes;

    public Registo(){
        this.listaOuvintes = new ArrayList<>();
    }

    public void setListaOuvintes(List<Ouvinte> listaOuvintes) {
        this.listaOuvintes = listaOuvintes;
    }
}
