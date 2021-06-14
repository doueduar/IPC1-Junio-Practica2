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
    //Mas prestadas
    int contador[] = new int[100];

    public Practica2(){
        int n = 1;
        while(n!=0){
            System.out.println("------------------Arquiler de peliculas Memorabilia---------------");
            System.out.println("1.ingresar cliente 2.ingresar pelicula 3.mostrar cliente 4.mostrar peliculas");
            System.out.println("5.Prestar pelicula 6.Devolver pelicula 7.ordenar peliculas 8.reportes");
            System.out.print("9. mostrar prestamos 10.Salir  ingrese la opción: ");
            n = scanner.nextInt();
            switch (n) {
                case 10:
                    n=0;
                    break;
                case 1:
                    System.out.println("------------ingresar clientes----------------");
                    ingresarClientes();
                    break;
                case 2:
                    System.out.println("-------------ingresar peliculas----------------------");
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
                    devolucionPelicula();
                    break;
                case 7:
                    System.out.println("---------------------------ordenar las peliculas-----------------------------------");
                    ordenar();
                    mostrarPeliculas("Ordenado las peliculas");
                    break;
                case 8:
                    System.out.println("--------------------------Reportes-----------------------------------");
                    cantidadCategoria();
                    cantidadPrestamo();
                    masPrestado();
                    menosPrestado();
                    int s = 0;
                    System.out.print("Deseas buscar una cantidad de una categoria en especifico (1/0): ");
                    s =scanner.nextInt();
                    if (s == 1) {
                        verificarcategoria();
                        for (int i = 0; i < tipocategoria.length; i++) {
                            if (tipocategoria[i]!=null) {
                                System.out.print(i+". "+tipocategoria[i]);
                            }
                        }
                        System.out.print("\n ingresa que tipo de categoria: ");
                        s = scanner.nextInt();
                        if (tipocategoria[s]!=null) {
                            categoriaCantidad(tipocategoria[s]);
                        }else{
                            System.out.println("no existe");
                        }
                    }
                    break;
                case 9:
                    mostrarPrestamos("Prestamos realizados");
                    break;
                      
                default:
                    System.out.print("no es valido esta opcion");
                    break;
            }
        }
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
               contador[i] = 0;
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
    public void mostrarPrestamos(String nombre){
        System.out.println("----------------------------"+nombre+"---------------------------");
        for (int i = 0; i < DiasPrestamo.length; i++) {
            if (DiasPrestamo[i]!=0) {
                System.out.println(i+". Cliente id."+idClienttePrestada[i]+"nombre: "+cliente[posicion(idClienttePrestada[i],idCliente)]+"Pelicula id."+idPeliculaPrestada[i]+" nombre: "+pelicula[posicion(idClienttePrestada[i],idPelicula)]);
            }
        }
        System.out.println("------------------------FIN---------------------------");
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
                System.out.print("Aceptas prestar la pelicula: "+pelicula[posicion(p, idPelicula)]+" cliente: "+cliente[posicion(c, idCliente)]+": ");
                int m = scanner.nextInt();
                if (m == 1) {
                    puedePrestarPelicula[posicion(c,idCliente)]=false;
                    disponible[posicion(p,idPelicula)]=false;
                    contador[posicion(p,idPelicula)] += 1; 
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
        System.out.print("desear ingresar otros valores 1/0");
            int n = scanner.nextInt();
            if (n==1) {
                prestamoPelicula();
            }
    }
    public void devolucionPelicula(){
        mostrarPrestamos("Devolución de peliculas");
        System.out.print("ingresa la posicion: ");
        int n = scanner.nextInt();
        devolver(n);
    }
    public void devolver(int n){
        if (DiasPrestamo[n]!=0) {
            boolean a = disponible[posicion(idPeliculaPrestada[n],idPelicula)];
            boolean b =puedePrestarPelicula[posicion(idClienttePrestada[n], idCliente)];
            if ((!b)&&(!a)) {
                a = true;
                b = true;
                idPeliculaPrestada[n] = 0;
                idClienttePrestada[n] = 0;
                DiasPrestamo[n] = 0;
                ordenarprestamos();
            }else{
                System.out.println("error prestamo");
            }
        }
    }
    public void ordenarprestamos(){
        for (int i = 0; i < DiasPrestamo.length; i++) {
            int a = i+1;
            if ((DiasPrestamo[i]==0)&&(DiasPrestamo[a]!=0)) {
                idClienttePrestada[i] = idClienttePrestada[a];
                idPeliculaPrestada[i] = idClienttePrestada[a];
                DiasPrestamo[i] = DiasPrestamo[a];
                idClienttePrestada[a]=0;
                idPeliculaPrestada[a]=0;
                DiasPrestamo[a]=0;
            }
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
    //menos prestado
    public int menosPrestado(){
        if (pelicula[0]!= null) {
            int minimo = contador[0];
            for (int i = 0; i < pelicula.length; i++) {
                if (pelicula!=null) {
                    if (contador[i]<minimo) {
                        minimo = contador[i];
                    }
                }
            }
            if (minimo == 0) {
                System.out.println(" No hay prestamos ");
                return 0;
            }
            return minimo;
        }else{
            System.out.println("no hay peliculas ingresadas");
            return 0;
        } 
    }
    //mas prestado
    public int masPrestado(){
        int n = 0;
        if (pelicula[0]!= null) {
            int maximo = contador[0];
            for (int i = 0; i < pelicula.length; i++) {
                if (pelicula!=null) {
                    if (contador[i]>maximo) {
                        maximo = contador[i];
                    }
                }
            }
            return maximo;
        }else{
            System.out.println("no hay peliculas ingresadas");
            return 0;
        }
    }
    //cantidad de prestamos total
    public void cantidadPrestamo(){
        System.out.println("--------------------------cantidad de prestamos------------------------------------");
        for (int i = 0; i < pelicula.length; i++) {
            if (pelicula[i]!=null) {
                System.out.println("id."+idPelicula[i]+" Pelicula: "+pelicula[i]+" cantidad de prestamos: "+contador[i]);            
            }else{
                return;
            }
        }
    }
    public void categoriaCantidad(String tipo){
        System.out.println("Listado de una categoria: ");
        int n = 0;
        for (int i = 0; i < pelicula.length; i++) {
            if (pelicula[i]!=null) {
                if (categoria[i].equalsIgnoreCase(tipo)) {
                    System.out.println(idPelicula[i]+". Pelicula: "+pelicula[i]);
                    ++n;
                }
            }else{
                System.out.println("cantidad de la categoria "+tipo+" es: "+n);
                return;
            }
        }
    }
    //Muestra la cantidad de peliculas con las diferentes categorias
    String [] tipocategoria = new String[20]; 
    public boolean validarCategoria(String tipo){
        for (int i = 0; i < tipocategoria.length; i++) {
            if (tipocategoria[i]!=null) {
                if (tipocategoria[i].equalsIgnoreCase(tipo)) {
                    return true;
                }
            }else{
                break;
            }
        }
        return false;
    }
    //Muestra la cantidad de peliculas
    public void cantidadCategoria(){
        System.out.println("---------------------------Cantidad de categoria-------------------------------------");
        verificarcategoria();
        for (int i = 0; i < tipocategoria.length; i++) {
            if (tipocategoria[i]!=null) {
                categoriaCantidad(tipocategoria[i]);
            }
        }
    }
    public void agregar(String tipo){
        int n = 0;
        for (int i = 0; i < tipocategoria.length; i++) {
            if (n<1) {
                if (tipocategoria[i]==null) {
                    tipocategoria[i] =tipo;
                    ++n;
                }
            }else{
                return;
            }
        }
    }
    public void verificarcategoria(){
        for (int i = 0; i < categoria.length; i++) {
            if (categoria[i]!= null) {
                if(!validarCategoria(categoria[i])){
                    agregar(categoria[i]);            
                }
            }
        }
        for (int i = 0; i < tipocategoria.length; i++) {
            if (tipocategoria[i]!=null) {
                System.out.print(tipocategoria[i]+" ");
            }
        }
        System.out.print("\n");
    }
    //darle posicion a los string para luego ordenarlos
    public int pString(String dato){
        String abc[] = {" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i = 0; i < abc.length; i++) {
            System.out.print(abc[i]+" ");
            if (dato.equalsIgnoreCase(abc[i])) {
                System.out.println(i);
                return i;
            }
        }
        System.out.print("no existe este valor");
        return 0;
    }
    //metodo de ordenamiento 
    public void ordenar(){
        mostrarPeliculas("Lista de peliculas");
        //metodo burbuja para ordenar
        for (int i = 0; i < pelicula.length; i++) {
            if (pelicula[i]!=null) {
                for (int j = 0; j < pelicula.length; j++) {
                    int a = 1+j;
                    if ((pelicula[j]!=null)&&(pelicula[a]!=null)) {
                        if (pString(pelicula[j].substring(0,1)) > pString(pelicula[a].substring(0,1))) {
                            int auxiid =0; String auxiNombre = ""; int auxiano = 0; String auxicategoria =" "; boolean auxiDisponible = false;
                            // ingreso de c = a
                            auxiid = idPelicula[j];
                            auxiNombre = pelicula[j];
                            auxiano = ano[j];
                            auxicategoria = categoria[j];
                            auxiDisponible = disponible[j];
                            //ingreso de a = b
                            idPelicula[j] = idPelicula[a];
                            pelicula[j] = pelicula[a];
                            ano[j] = ano[a];
                            categoria[j]= categoria[a];
                            disponible[j]= disponible[a];
                            //ingreso de b = c
                            idPelicula[a]=auxiid;
                            pelicula[a]=auxiNombre;
                            ano[a]=auxiano;
                            categoria[a]=auxicategoria;
                            disponible[a]=auxiDisponible;
                        }   
                    }else{
                        break;
                    }       
                }
            }else{
                return;
            }
        }
    }

}