package Usinas;
import ENUMS.Energias;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Conglomerado {
    private ArrayList<Usina> usinas;

    public Conglomerado(){
        usinas = new ArrayList<>();
    }

    public boolean cadastraUsina(Usina usina){
           for (Usina value : usinas) {
               if (value.getNome().equalsIgnoreCase(usina.getNome())) {
                   return false;
               }
           } usinas.add(usina); return true;
       }

 public Usina pesquisaUsina(String nome){
        if(usinas.size()<1){return null;}
     for(int i=0; i<usinas.size();i++){
         if(nome.equalsIgnoreCase(usinas.get(i).getNome())){return usinas.get(i);};
     }
     return null;}


    public ArrayList<Usina> listaTodasUsinas(){
        if(usinas.size()<1){return null;}
        return usinas;
    }

    public double consultaPreco(String nome){
        if(usinas.size()<1){return -1;}
        for(int i=0; i<usinas.size();i++){
            if(nome.equalsIgnoreCase(usinas.get(i).getNome())){return usinas.get(i).getCustoMWh();};
        }
        return -1;
    }

    public boolean salvaDadosArquivo(String nomeArquivo){
        nomeArquivo = nomeArquivo+".txt";
        Path path = Paths.get(nomeArquivo);
        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));){
            for (Usina usina : usinas) {
                pw.println(usina.geraResumo());
            }
        }
        catch(Exception e){System.out.println("Erro encontrado"); return false;}
        return true;
    }

}
