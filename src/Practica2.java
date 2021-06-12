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
    boolean puedePrestarPelicula[] = new boolean[100];

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
        int n = 1;
        while(n!=0){
            System.out.println("Arquiler de peliculas Memorabilia");
            System.out.println("1.ingresar cliente 2.ingresar pelicula 3.mostrar cliente 4.mostrar peliculas");
            System.out.println("5.Prestar pelicula 6.Devolver pelicula 7.ordenar peliculas 8.reportes 0.salir");
            n = scanner.nextInt();
            switch (n) {
                case 0:
                    n=0;
                    break;
                case 1:
                    ingresarClientes();
                    break;
                case 2:
                    ingresarPeliculas();
                    break;
                case 3:
                    mostrarClientes("--------------Mostrar clientes-------------");
                    break;
                case 4:
                    mostrarPeliculas("------------------Mostrar peliculas-------------------------");
                    break;
                case 5:
                    prestamoPelicula();
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                      
                default:
                    System.out.print("no es valido esta opcion");
                    break;
            }
        }
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
                puedePrestarPelicula[i] = true;
                System.out.println("Se registro: "+idCliente[i]+". nombre: "+cliente[i]+" telefono: "+telefono[i]+" Puede prestar: "+puedePrestarPelicula[i]);
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
    public void mostrarClientes(String nombre){
        System.out.println("----------------"+nombre+"------------");
        for (int i = 0; i < cliente.length; i++) {
            if (cliente[i]!=null) {
                System.out.println(i+"  id."+idCliente[i]+" nombre: "+cliente[i]+" telefono: "+telefono[i]+" peliculas prestadas: "+puedePrestarPelicula[i]);
            }
        }
        System.out.println("----------------FIN---------------------");
    }
    public void mostrarPeliculas(String nombre){
        System.out.println("-------------------------"+nombre+"----------------------");
        for (int i = 0; i < pelicula.length; i++) {
            if (pelicula[i] != null) {
                System.out.println(i+" id. "+idPelicula[i]+" nombre: "+pelicula[i]+" año: "+ano[i]+" categoria: "+categoria[i]+" disponible: "+disponible[i]);
            }
        }
        System.out.println("--------------------FIN-------------------------");
    }
    public void prestamoPelicula(){
        System.out.println("------------------Opcion de prestamo de pelicula-----------------");
        mostrarClientes("Clientes");
        System.out.print("ingresa el id del cliente: ");
        int n = scanner.nextInt();
        mostrarPeliculas("Peliculas");
        System.out.print("ingresa el id de la pelicula si esta disponible: ");
        int d = scanner.nextInt();
        prestar(n,d);
    }
    public void ingresarPrestamo(int c, int p, int dias){
        for (int i = 0; i < idPeliculaPrestada.length; i++) {
            if (DiasPrestamo[i]==0) {
                idClienttePrestada[i] = c;
                idPeliculaPrestada[i] = p;
                DiasPrestamo[i] = dias;
                System.out.println("se ingreso cliente: "+idClienttePrestada[i]+" pelicula: "+idPeliculaPrestada[i]+" dias: "+DiasPrestamo[i]+"\n");
                return;
            }
        }
    }
    public void prestar(int c, int p){
        if ((verificarID(c,idCliente)&&(verificarID(p, idPelicula)))) { 
            if ((estado(c,idCliente ,puedePrestarPelicula))&&(estado(p, idPelicula, disponible))) {
                System.out.print("Aceptas prestar la pelicula: "+pelicula[posicion(p, idPelicula)]+" cliente: "+cliente[posicion(c, idCliente)]);
                int m = scanner.nextInt();
                if (m == 1) {
                    puedePrestarPelicula[posicion(c,idCliente)]=false;
                    disponible[posicion(p,idPelicula)]=false; 
                    System.out.print("ingresar la cantidad de dias: ");
                    int dias = scanner.nextInt();
                    ingresarPrestamo(c,p,dias);
                }else{
                    repetirPrestamo("no acepto las condiciones");
                }
            }else{
                repetirPrestamo("no esta disponible");
            }

        }else{
                repetirPrestamo("no existe ese id");
        }
    }
    public void repetirPrestamo(String mensaje){
        System.out.println(mensaje);
        System.out.println("desear ingresar otros valores 1/0");
            int n = scanner.nextInt();
            if (n==1) {
                prestamoPelicula();
            }
    }
    public boolean estado(int a, int b[], boolean c[]){
        if (c[posicion(a,b)] == true ) {
            return true;
        } 
        return false;
    }
    public int posicion(int a, int b[]){
        for (int i = 0; i < b.length; i++) {
            if (a == b[i]) {
                return i;
            }
        }
        System.out.println("no existe");
        return 0;
    }
}