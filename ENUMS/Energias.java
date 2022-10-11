package ENUMS;

public enum Energias {EOLICA("Eolica",25), SOLAR("Solar",15), HIDRICA("Hidrica",5), PETROLEO("Petroleo",30), CARVAO("Carvao",20), NUCLEAR("Nuclear",10);
        private final String nome;
        private final int taxa;

        Energias(String nome, int taxa){
            this.nome = nome;
            this.taxa = taxa;
        }

    public String getNome() {
        return nome;
    }

    public int getTaxa() {
        return taxa;
    }
}


