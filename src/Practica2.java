package src;
import java.util.*;

class Practica2 {
    public static void main(String[] args) {
    Practica2 practica2 = new Practica2();    
    }
    Scanner scanner = new Scanner(System.in);

    // Estos los arreglos para los clientes
    String cliente[] = new String[100];
    int idCliente[] = new int[100];
    int telefono[] = new int [100];
    boolean TienePeliculasPrestado[] = new boolean[100];

    // Estos son los arreglos para las peliculas
    int idPelicula[] = new int[100];
    String pelicula[] = new String[100];
    int ano[] = new int[100];
    String categoria[] = new String[100];
    boolean disponible[] = new boolean[100];

    //Estos son los prestamos que se realizo 
    int idPeliculaPrestada[] = new int[100];
    int idClienttePrestada[] = new int[100];
    int DiasPrestamo[] = new int[100];

    public Practica2(){
        ingresarClientes();
        ingresarClientes();
        ingresarPeliculas();
        ingresarPeliculas();
    }
    public void ingresarClientes(){
        int n = 0;
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i] == null) {
                System.out.print("ingrese el id: ");
                do {
                    n = scanner.nextInt();
                    if (verificarID(n,idCliente)) {
                        System.out.print("ingrese otro id: ");
                    }
                } while (verificarID(n, idCliente));
                idCliente[i] = n;
                System.out.println("Ingrese nombre del cliente");
                cliente[i] = scanner.next();
                System.out.print("ingrese numero de telefono: ");
                telefono[i] = scanner.nextInt();
                TienePeliculasPrestado[i] = false;
                System.out.println("Se registro: "+idCliente[i]+". nombre: "+cliente[i]+" telefono: "+telefono[i]+" prestado: "+TienePeliculasPrestado[i]);
                return;
            }else{
                System.out.println("esta lleno en "+i);
            }
        }
    }
    public void ingresarPeliculas(){
        int n = 0;
        for (int i = 0; i < DiasPrestamo.length; i++) {
            if (pelicula[i]==null) {
                System.out.print("ingrese el id: ");
               do {
                   n = scanner.nextInt();
                   if (verificarID(n,idPelicula)) {
                       System.out.print("ingrese otro id: ");
                   }
               } while (verificarID(n, idPelicula));
               idPelicula[i] = n;
               System.out.print("ingrese el nombre de la pelicula: ");
               pelicula[i] = scanner.next();
               System.out.print("ingrese la categoria: ");
               categoria[i] = scanner.next();
               System.out.print("Ingrese el año: ");
               ano[i] = scanner.nextInt();
               disponible[i] = true;
               System.out.println("se registro: "+idPelicula[i]+" nombre: "+pelicula[i]+" año: "+ano[i]+" categoria: "+categoria[i]+" disponible: "+disponible[i]);
               return;
            }else{
                System.out.println("esta lleno en "+i);
            }
        }
    }
    public boolean verificarID(int id, int[] arreglo ){
        for (int i = 0; i < arreglo.length; i++) {
            if (id == arreglo[i]) {
                return true;
            }
        }
        return false;
    }
    public void mostrarClientes(){
        System.out.println("----------------Mostrar los clientes------------");
        for (int i = 0; i < cliente.length; i++) {
            if (cliente!=null) {
                System.out.println(i+"  id."+idCliente[i]+" nombre: "+cliente[i]+" telefono: "+telefono[i]+" peliculas prestadas: "+TienePeliculasPrestado[i]);
            }
        }
    }
    public void mostrarPeliculas(){
        System.out.println("-------------------------Mostrar Peliculas----------------------");
        for (int i = 0; i < pelicula.length; i++) {
            if (pelicula[i] != null) {
                System.out.print(i+" id. "+idPelicula[i]+" nombre: "+pelicula[i]+" año: "+ano[i]+" categoria: "+categoria[i]+" disponible: "+disponible[i]);
            }
        }
    }


}