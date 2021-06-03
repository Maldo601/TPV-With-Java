package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Guardat {
    
    public static void inventariOut (String [][] inv, String nomArxiu){
        File f = new File(nomArxiu);
        if (f.exists() && !Main.preguntaSiNo("El fitxer " + nomArxiu +" ja existeix. Desitja sobreescriure'l?")){
            System.out.println("No s'ha realitzat cap canvi.");
            Main.getMenu("STC");
        }
        try (FileWriter fw = new FileWriter(f)){
            for (String [] i:inv){
                if (i[0] != null){
                    for(String prop:i)    
                        fw.write(prop + ", ");  
                    fw.write("\n");
                }
            }   
            System.out.println("Inventari actualitzat amb èxit");
        }catch(Exception e){
            System.out.println("Error de creació i escriptura del fitxer ");
            System.out.println(e.getMessage());
        }
    }
    
    public static String [][] inventariIn (String nomArxiu){
        String [][] nouInventari = new String [10][4];
        File fitxerLectura = new File(nomArxiu);
        try (BufferedReader br = new BufferedReader(new FileReader(fitxerLectura))){
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                nouInventari[lineNum] = values;
                lineNum++;
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        return nouInventari;
    }

}
