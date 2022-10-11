package Aplication;
import ENUMS.Energias;
import Usinas.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ACMEEnergy {
    private static Conglomerado conglomerado = new Conglomerado();
    public ACMEEnergy(){
    }
    static Scanner in = new Scanner(System.in);
    public static void executa() {
        inicializa();
        while (true) {try{
            int escolha = menu();
            if (escolha == 0) {
                System.out.println("\nVoce fechou o programa, ate :)");
                break;
            }
            switch (escolha){
                default: System.out.println("\fEscolha uma opção valida!\n\n\n"); break;
                case 1: cadastraUsina(conglomerado); break;
                case 2: pesquisarUnisa(); break;
                case 3: listarUsinas(); break;
                case 4: consultarMWh(); break;
                case 5: salvarUsinas(); break;
                case 6: carregarUsinas(); break;
            }}catch (InputMismatchException e){System.out.println("Insira um numero valido!"); in.nextLine();}

        }


    }

    public static void inicializa(){
        UsinaRenovavel u1 = new UsinaRenovavel("Uno", 300,45,Energias.EOLICA);
        UsinaRenovavel u2 = new UsinaRenovavel("Dos", 450, 25, Energias.HIDRICA);
        UsinaNaoRenovavel u3= new UsinaNaoRenovavel("Three", 450,25,Energias.NUCLEAR, 300);
        UsinaNaoRenovavel u4 = new UsinaNaoRenovavel("Four", 365,11.42,Energias.CARVAO, 3);
        Usina u5 = new UsinaRenovavel("Cinco",321,12,Energias.SOLAR);
        conglomerado.cadastraUsina(u1);
        conglomerado.cadastraUsina(u2);
        conglomerado.cadastraUsina(u3);
        conglomerado.cadastraUsina(u4);
        conglomerado.cadastraUsina(u5);

    }

    public static void pesquisarUnisa(){
        System.out.println("Insira aqui o nome da Usina que deseja procurar");
        in.nextLine();
        String nome = in.nextLine();
        Usina usina = conglomerado.pesquisaUsina(nome);
        if(usina!=null){System.out.println("Usina encontrada!\n" + "Nome da Usina: "+usina.getNome() +" Producao MWh: " +usina.getProducaoMWh() + " Custo MWh: " + usina.getCustoMWh() + " Tipo de energias: " + usina.getEnergias().getNome());}
        else{System.out.println("Nenhuma usina cadastrada com esse nome");}
    }


    public static void listarUsinas(){
        ArrayList<Usina> usinas = conglomerado.listaTodasUsinas();
        if (usinas == null || usinas.size()==0){System.out.println("Nenhuma Usina Cadastrada");}
        else{
        for(int i = 0; i<usinas.size();i++){
            if(usinas.get(i) instanceof UsinaRenovavel){System.out.println("Nome da Usina: "+usinas.get(i).getNome() +" | " +" Producao MWh: " +usinas.get(i).getProducaoMWh() +" | " + " Custo MWh: " + usinas.get(i).getCustoMWh()+" | " + " Tipo de energias: " + usinas.get(i).getEnergias().getNome() + "\n");}
            if(usinas.get(i) instanceof UsinaNaoRenovavel){System.out.println("Nome da Usina: "+usinas.get(i).getNome() +" | " +" Producao MWh: " +usinas.get(i).getProducaoMWh() +" | " + " Custo MWh: " + usinas.get(i).getCustoMWh()+" | " + " Tipo de energias: " + usinas.get(i).getEnergias().getNome() + " | " + " Durabilidade da Energia: " + ((UsinaNaoRenovavel) usinas.get(i)).getDurabilidade() +"\n");}
        }}
    }



    public static void cadastraUsina(Conglomerado conglomerado){
        int tipousina = 0;
        while(tipousina>2 || tipousina<1){
        try{
        System.out.println("Insira aqui o tipo de usina: 1-Renovavel // 2-Nao Renovavel");
        tipousina = in.nextInt();
        if(tipousina< 1 || tipousina> 2){System.out.println("Insira um numero valido!");}
        }catch(InputMismatchException e){ System.out.println("Por favor, Insira um numero valido!"); in.nextLine();}}
        in.nextLine();
        boolean renovavel = false;
        boolean naorenovavel = false;
        if(tipousina == 1){renovavel = true;}
        else{naorenovavel= true;}
        System.out.println("Insira o nome da Usina:");
        String nome = in.nextLine();
        double producao=-1;
        while (producao<0){try{System.out.println("Insira aqui a producao MWh da Usina");
            producao= in.nextDouble();
            if(producao<0){System.out.println("Por favor, Insira um numero valido!");}}
        catch(InputMismatchException e){ System.out.println("Por favor, insira um numero valido!"); in.nextLine();}}

        double preco = -1;
        while(preco<0){try{System.out.println("Insira aqui o custo do MWh da Usina");
            preco = in.nextDouble();
            if(preco<0){System.out.println("Por favor, Insira um numero valido!");}
        }catch (InputMismatchException e){System.out.println("Por favor, insira um numero valido!"); in.nextLine();}}
        int escolha = 0;
        Energias energia = null;
        while(escolha <1 || escolha>3){
            try{if(renovavel == true){System.out.println("Insira aqui o tipo de energia da Usina Renovavel\n1-Solar\n2-Eolica\n3-Hidrica");
            escolha = in.nextInt();
            if(escolha<1 || escolha>3){System.out.println("Por favor, Insira um numero valido!");}
            switch (escolha){
                case 1: energia = Energias.SOLAR; break;
                case 2: energia = Energias.EOLICA; break;
                case 3: energia = Energias.HIDRICA; break;
            }
        }
        else if(naorenovavel == true){System.out.println("Insira aqui o tipo de energia da Usina Nao Renovavel\n1-Petroleo\n2-Carvao\n3-Nuclear");
            escolha = in.nextInt();
            switch (escolha){
                case 1: energia = Energias.PETROLEO; break;
                case 2: energia = Energias.CARVAO; break;
                case 3: energia = Energias.NUCLEAR; break;}
            }} catch (InputMismatchException e){System.out.println("Por favor, Insira um numero valido!"); in.nextLine();}
        }
        double durabilidade = -1;
       if(naorenovavel){ while(durabilidade<0){
            try{System.out.println("Insira aqui a durabilidade da Usina em anos");
                durabilidade= in.nextDouble();} catch(InputMismatchException e){ System.out.println("Por favor, Insira um numero valido");}}
        if(naorenovavel){UsinaNaoRenovavel nova = new UsinaNaoRenovavel(nome,producao,preco,energia,durabilidade);if(conglomerado.cadastraUsina(nova)){System.out.println("Usina Cadastrada com sucesso");}else{System.out.println("Usina repetida");}}
        }
        if(renovavel){UsinaRenovavel nova = new UsinaRenovavel(nome,producao,preco,energia);;if(conglomerado.cadastraUsina(nova)){System.out.println("Usina Cadastrada com sucesso");}else{System.out.println("Usina repetida");}}}
    public static int menu() {
        System.out.println("\nO que deseja fazer?");
        System.out.println("1-Cadastrar uma nova usina  \n2-Pesquisar uma usina  \n3-Listar todas as usinas  \n4-Consultar o preco do MWh  \n5-Salvar Usinas em um arquivo \n6-Carregar Usinas de um arquivo \n0-Sair do programa");
        int menu = in.nextInt();

        return menu;
    }

    public static void consultarMWh(){
        System.out.println("Insira aqui o nome da Usina que deseja procurar");
        in.nextLine();
        String nome = in.nextLine();
        Usina usina = conglomerado.pesquisaUsina(nome);
        if(usina!=null){System.out.println("Usina encontrada! O preco de seu Mwh eh de: " +usina.calculaMWh());}
        else{System.out.println("Nenhuma usina encontrada com este nome");}
    }

    public static void salvarUsinas(){
        System.out.println("Insira aqui o nome do arquivo que deseja salvar");
        in.nextLine();
        String nomeArquivo = in.nextLine();
        conglomerado.salvaDadosArquivo(nomeArquivo);

    }

    public static void carregarUsinas(){
        System.out.println("Insira Aqui o path do arquivo que deseja ler");
        in.nextLine();
        String path2 = in.nextLine();
        Path path = Paths.get(path2);
        try(BufferedReader br = new BufferedReader(new FileReader(path2))){
            String fileContent;
            for(String linha ; (linha = br.readLine()) != null;){
                fileContent = linha;
                if(fileContent.charAt(0) == '1'){
                    String[] array = fileContent.split(";",5);
                    String nome = array[1];
                    double producao = Double.parseDouble(array[2]);
                    double custo = Double.parseDouble(array[3]);
                    Energias energias = switch (array[4]) {
                        case "Eolica" -> Energias.EOLICA;
                        case "Hidrica" -> Energias.HIDRICA;
                        case "Solar" -> Energias.SOLAR;
                        default -> null;
                    };
                    if(energias == null){System.out.println("A energia em " + array[1] + " deve ser um energia valida");}
                    boolean adicionavel = false;
                    if(custo!= 0 && producao!=0 && energias!= null){adicionavel= true;}else{System.out.println("Reveja os valores do arquivo em " + array[1]);}
                    if(adicionavel){
                    if(conglomerado.cadastraUsina(new UsinaRenovavel(nome,producao,custo,energias))){System.out.println("|Usina " + array[1] + " adicionada com sucesso|");}}
                }
                else if(fileContent.charAt(0)=='2'){
                    String[] array = fileContent.split(";",6);
                    String nome = array[1];
                    double producao = Double.parseDouble(array[2]);
                    double custo = Double.parseDouble(array[3]);
                    double durabilidade = Double.parseDouble(array[5]);
                    Energias energias = switch (array[4]) {
                        case "Carvao" -> Energias.CARVAO;
                        case "Nuclear" -> Energias.NUCLEAR;
                        case "Petroleo" -> Energias.PETROLEO;
                        default ->null;
                    };
                    if(energias == null){System.out.println("A energia em " + array[1] + " deve ser uma energia valida");}
                    boolean adicionavel = false;
                    if(custo>0 && producao>0 && energias!= null && durabilidade>0){ adicionavel = true;}else{System.out.println("Reveja os valores do arquivo em " + array[1]);}
                    if(adicionavel){
                        if(conglomerado.cadastraUsina(new UsinaNaoRenovavel(nome,producao,custo,energias,durabilidade))){System.out.println("|Usina " + array[1] + " adicionada com sucesso|");}
                    }
                }
            }
            }
        catch(Exception e){System.out.println("\n"+ e);}

    }
}
