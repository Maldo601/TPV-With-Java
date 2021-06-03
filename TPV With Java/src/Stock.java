package src;
import java.util.Scanner;
public class Stock {
    static Scanner lect;
    static Boolean duple = false;
   
    // al no tenir DB, per lo que cuan el programa tanque, es buida a nulls de nou.

    // Suggeriment - Podriem intentar guardar-ho a un fitxer per tenir un catàleg permanent
    public static String [ ][ ] inventari = new String [9][5];
    static String [] Headers = {"ID","nom", "Stock","Seccio", "Preu"};
    static int id = 99;
    static void addProduct(){
        //Necessitaria que els id fossin unics
        String euroRe ="";
        lect = new Scanner(System.in);     
        id++;
        if (String.valueOf(id).length() != 3){
            System.out.println("\n\tError introdueix un ID numeric de 3 xifres.");
            Stock.addProduct();
        }
        System.out.print("\tIntrodueix el nom del producte: ");
        String producte = lect.nextLine();
        System.out.print("\tIntrodueix la quantitat d'stock: ");
        String stock = lect.nextLine();
        System.out.print("\tIntrodueix la secció: ");
        String seccio = lect.nextLine();
        if(stock.contains("[A-Z]") || stock.contains("[a-z]") || stock.contains(".") || stock.contains(",")){
            System.out.println("\tIntrodueix un numero enter! ");
            Stock.addProduct();
        }
        System.out.print("\tIntrodueix el preu per unitat: ");       
        String euros = lect.nextLine();
            euroRe = euros.replaceAll(",",".");
        System.out.println("");
        // addLoop
        boolean gate = true;    
        int i = 0;
        int x = 0;
        while (gate)
            if (Stock.inventari[x][0] == null){
                Stock.inventari[x][i++] = ""+id;
                Stock.inventari[x][i++] = producte;
                Stock.inventari[x][i++] = stock;
                Stock.inventari[x][i++] = seccio;
                Stock.inventari[x][i++] = euroRe;
                    gate = false;
            }else{
                x++;
            }
        }
    // Mateix While Loop pero tirant linea a null
    static void deleteProduct(){
        System.out.print("\n\tIntrodueix ID del producte a borrar: ");
        String delId = lect.next();
        boolean gate = true;    
        int i = 0;
        int x = 0;
        while (gate)
            if (Stock.inventari[x][0].equals(delId)){
                Stock.inventari[x][i++] = null;
                Stock.inventari[x][i++] = null;
                Stock.inventari[x][i++] = null;
                Stock.inventari[x][i++] = null;
                    gate = false;
            }else{
                x++;
            }
    }
    // Printer Array 
    static void reponerProducto(){
        System.out.println("\n\tIntrodueix un ID de producte per afegir: ");
        String idBusqueda = lect.next();
        System.out.println("\n\tIntrodueix quantes unitats vols afegir: ");
        String increment = lect.next();
        for(int i = 0; i < Stock.inventari.length; i++){
            if (inventari[i][0].equals(idBusqueda)){
                inventari[i][2] = "" + (Integer.parseInt(inventari[i][2])+increment);
                break;
            }
        }
    }
    static void printStock(){
        System.out.println();
        Main.printItem(Headers);
        System.out.println("\t+-------------------------------------------------------------------------------+");
        for (String [] prod:Stock.inventari){
            if(prod[0] != null)
                Main.printItem(prod);
        } 
    }
}
