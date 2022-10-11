
package Usinas;
import ENUMS.Energias;
public class UsinaRenovavel extends Usina {

    private Energias energias;
    private double custo;




    public UsinaRenovavel(String nome, double prod, double custo, Energias energias) {
        super(nome, prod, custo);
        this.energias = energias;
        this.custo = custo;
    }

    public Energias getEnergias() {
        return energias;
    }

    public void setEnergias(Energias energias) {
        this.energias = energias;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }


    @Override
    public double calculaMWh() {
        int taxa= energias.getTaxa();
        double preco = custo*(1+(taxa/100.));
        return preco;
    }

    @Override
    public String geraResumo() {
        return "1;"+getNome()+";"+getProducaoMWh()+";"+getCusto()+";"+energias.getNome();
    }
}
