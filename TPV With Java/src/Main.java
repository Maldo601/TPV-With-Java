package src;
import java.util.*;
public class Main {
    public static Scanner lect;
    public static String mainOption;
    public static void getMenu(String options){
        /**
         * Cada opcio del menú cridara funcions dels fitxers de Stock o de Vendes.
         * Torna cap atras en una crida a un main args[] buit.
         */
        int selectOption;
        String [] args = new String[0];                        
        if(mainOption.equalsIgnoreCase("STC")){
            System.out.println("\n\t[1].- Afegir Productes. ");
            System.out.println("\t[2].- Eliminar Productes. "); 
            System.out.println("\t[3].- Llistar Stock existent.");
            System.out.println("\t[4].- Afegir Stock.");
            System.out.println("\t[5].- Enrere.");
            System.out.println("\t[6].- Sortir del Programa.");
            System.out.print("\n\tSelecciona una opció: ");
            selectOption = lect.nextInt();
                if      (selectOption == 1){
                    Stock.addProduct();
                    getMenu(options);
                }else if(selectOption == 2){
                    Stock.deleteProduct();
                    getMenu(options);
                }else if(selectOption == 3){
                    Stock.printStock();      // Printer. 
                    getMenu(options);        // Retorn al menú de secció.
                }else if(selectOption == 4){
                    Stock.reponerProducto();
                    getMenu(options); 
                }else if(selectOption == 5){  
                    main(args);              // Retorn al main menu.
                }else{
                    System.exit(0);          // R.I.P
                }
        }else if(mainOption.equalsIgnoreCase("VEN")){
            System.out.println("\n\t[1].- Afegir productes. ");
            System.out.println("  \t[2].- Eliminar productes. ");
            System.out.println("  \t[3].- Veure Tiquet.");
            System.out.println("  \t[4].- Reiniciar Tiquet.");
            System.out.println("  \t[5].- Comprar.");
            System.out.println("  \t[6].- Enrere.");
            System.out.println("  \t[7].- Sortir del Programa.");
            int ventaOpcio = Main.inputEnterRang(1, 7, "\n\tSelecciona una opció: ");
                if      (ventaOpcio == 1){
                    Vendes.tiquetAfegirProducte();
                    getMenu(options);
                }else if(ventaOpcio == 2){
                    Vendes.tiquetEliminarProducte();
                    getMenu(options);
                }else if(ventaOpcio == 3){
                    Vendes.tiquetPrint();
                    getMenu(options);
                }else if(ventaOpcio == 4){
                    Vendes.tiquetBorrar();
                    getMenu(options);
                }else if(ventaOpcio == 5){
                    Vendes.compra();
                    getMenu(options);
                }else if(ventaOpcio == 6){  
                    main(args);
                }else{
                    System.exit(0);
                }
             
        }else if(mainOption.equalsIgnoreCase("EXIT")){
            System.exit(0);
        }else {}
    }
    public static int inputEnterRang(int min, int max, String missatge){
        //Solicita un enter dins el rang especificat fins que es compleixi.
        //Imprimeix per consola un missatge on es pot detallar que s'ha d'introduir
        int num = min - 1;
        do{
            System.out.print(missatge);
            try {
                num = Integer.parseInt(Main.lect.nextLine());
            }catch(Exception e){
                num = min - 1;
            }
        }while(num > max || num < min);
        return num;
    }
    public static boolean preguntaSiNo (String pregunta){
        // Pregunta i espera una resposta del tipus Si o No
        String input;
        do{
            System.out.print(pregunta+" [S/N] ");
            input = lect.nextLine().toUpperCase();
            if (!input.equals("N") && !input.equals("S"))
                System.out.println("S'esperava una resposta S/N");
        }
        while (!input.equals("N") && !input.equals("S"));
        return input.equals("S");
    }
    public static void printItem(String [] item){
        System.out.print("\t|. ");
        for(String it:item)
            System.out.printf("%-15s", it);
        System.out.println(" ·|");
    }
    public static void main(String[] args){
        
        lect = new Scanner(System.in);
        System.out.println("\n\tBenvingut al TPV. ");
        System.out.print("\tIntrodueix el mòdul d'accés [STC], [VEN] o [EXIT]: ");
        getMenu(mainOption = lect.nextLine());
    }
}


