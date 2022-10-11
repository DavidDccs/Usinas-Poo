package Usinas;

import ENUMS.Energias;

public class UsinaNaoRenovavel extends Usina {

        private Energias energias;
        private double custo;
        private double durabilidade;

    public UsinaNaoRenovavel(String nome, double prod, double custo, Energias energias, double durabilidade) {
        super(nome, prod, custo);
        this.custo = custo;
        this.energias = energias;
        this.durabilidade = durabilidade;

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


    public double getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(double durabilidade) {
        this.durabilidade = durabilidade;
    }

    @Override
        public double calculaMWh() {
            int taxa= energias.getTaxa();
            double preco = custo*(1+(taxa/100.));
            return preco;
        }

        @Override
        public String geraResumo() {
            return "2;"+getNome()+";"+getProducaoMWh()+";"+getCusto()+";"+energias.getNome()+";"+getDurabilidade();
        }

    }


