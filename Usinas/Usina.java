package Usinas;
import ENUMS.Energias;
public abstract class Usina {
    private Energias energias;
    private String nome;
    private double producaoMWh;
    private double custoMWh;
    public Usina(String nome, double prod, double custo) {
        this.nome=nome;
        producaoMWh=prod;
        custoMWh=custo;
    }

    public Energias getEnergias() {
        return energias;
    }

    public void setEnergias(Energias energias) {
        this.energias = energias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getProducaoMWh() {
        return producaoMWh;
    }

    public void setProducaoMWh(double producaoMWh) {
        this.producaoMWh = producaoMWh;
    }

    public double getCustoMWh() {
        return custoMWh;
    }

    public void setCustoMWh(double custoMWh) {
        this.custoMWh = custoMWh;
    }

    public abstract double calculaMWh();
    public abstract String geraResumo();


}
