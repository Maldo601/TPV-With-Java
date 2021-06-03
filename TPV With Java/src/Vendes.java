package src;
public class Vendes {
    // referencia l'index de l'inventari
    public static int [] noutiquet = new int[9];
    public static void tiquetPrint(){
        String [] headers = { "id", "nom", "unitats", "preu", "total"};
        double costTotal = 0;
        Main.printItem(headers);
        System.out.println("\t+-------------------------------------------------------------------------------+");
        for(int i = 0; i < Stock.inventari.length; i++){
            if (Stock.inventari[i][0] == null) 
                break;
            if (noutiquet[i] == 0)
                continue;
            double cost = noutiquet[i] * Double.parseDouble(Stock.inventari[i][4]);
            costTotal += cost;
            String [] linea = {
                Stock.inventari[i][0],
                Stock.inventari[i][1],
                ""+noutiquet[i],
                Stock.inventari[i][3],
                "" + (cost)
            };
            Main.printItem(linea);
        }
        System.out.println("\t+-------------------------------------------------------------------------------+");
        String[] resum = {"Total", "", "", "", ""+costTotal};
        Main.printItem(resum);
    }
    
    public static void compra() {
        for(int i = 0; i < Stock.inventari.length; i++){
            if (Stock.inventari[i][0] != null) 
                Stock.inventari[i][0] = "" + (Integer.parseInt(Stock.inventari[i][2]) - noutiquet[i]); 
        }
        System.out.println("La compra s'ha realitzat amb èxit!\n" + 
        "Aquí tens el tiquet:\n");
        tiquetPrint();
        tiquetBorrar();
    }
    public static void tiquetAfegirProducte(){
        String idBusqueda = ""+Main.inputEnterRang(0, 1000,"\n\tIntrodueix un ID de producte per afegir: ");
        boolean trobada = false;
        for(int i = 0; i < Stock.inventari.length; i++){
            if (Stock.inventari[i][0].equals(idBusqueda)){
                if (Integer.parseInt(Stock.inventari[i][2]) - noutiquet[i] > 0){
                    noutiquet[i]++;
                    System.out.println("\tS'ha afegit correctament");
                }
                else
                    System.out.println("\tNo hi ha prou elements en Stock!");
                trobada = true;
                break;
            }
        }
        if (!trobada)
            System.out.println("\tNo s'ha trobat l'id especificat");
    }
    public static void tiquetEliminarProducte(){
        String idBusqueda = ""+Main.inputEnterRang(0, 1000,"\n\tIntrodueix un ID de producte per afegir: ");
        boolean trobada = false;
        for(int i = 0; i < Stock.inventari.length; i++){
            if (Stock.inventari[i][0].equals(idBusqueda)){
                if (noutiquet[i] > 0){
                    noutiquet[i]--;
                    System.out.println("\tS'ha eliminat 1 unitat correctament");
                }
                else
                    System.out.println("\tAquest producte no es troba al tiquet");
                trobada = true;
                break;
            }
        }
        if (!trobada)
            System.out.println("\tNo s'ha trobat l'id especificat");
    }
    public static void tiquetBorrar() {
        noutiquet = new int [100];
        System.out.println("\n\tEl tiquet s'ha borrat");
        Main.getMenu("VEN");
    }
}
