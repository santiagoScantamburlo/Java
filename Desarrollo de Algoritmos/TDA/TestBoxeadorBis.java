import utiles.TecladoIn;
public class TestBoxeadorBis {

    public static void main(String[] args) {
        boolean continuar;
        System.out.println("Ingrese la cantidad de boxeadores");
        int cantidad_boxeadores = TecladoIn.readInt();
        Boxeador[] boxeadores = new Boxeador[cantidad_boxeadores];
        do {
            continuar = ejecutarSeleccion(mostrarMenu(), boxeadores);
            if (continuar == true){
                System.out.println("Desea seleccionar otra opción del menú? T(Si)/F(No) ");
            continuar = TecladoIn.readLineBoolean();
            }
        } while (continuar == true);
    }
    public static void cargarBoxeadores(Boxeador[] boxeadores) {
        for (int i = 0; i < boxeadores.length; i++) {
            boxeadores[i] = cargarBoxeador();
            System.out.println("Cargó a el boxeador " + (i + 1));
            System.out.println("");
        }
    }
    public static Boxeador cargarBoxeador() {
        System.out.println("Ingrese apellido");
        String apellido = TecladoIn.readLine();
        System.out.println("Ingrese estatura");
        double altura = TecladoIn.readDouble();
        System.out.println("Ingrese peso");
        int peso = TecladoIn.readInt();
        Boxeador box = new Boxeador(apellido, altura, peso);
        return box;
    }
    public static void mostrarBoxeadoresPorCategoria(Boxeador[] boxeadores, char cat) {
        System.out.println("APELLIDO" + "\t" + "ESTATURA" + "\t" + "PESO" + "\t" + "CATEGORIA" + "\t" + "IMC");
        for (int i = 0; i < boxeadores.length; i++) {
            if(boxeadores[i].getCategoria() == cat){
                System.out.println(boxeadores[i].toString());
            }
        }
    }
public static void puedeGanarleA(Boxeador[] boxeadores, Boxeador box) {
        System.out.println("APELLIDO" + "\t" + "ESTATURA" + "\t" + "PESO" + "\t" + "CATEGORIA" + "\t" + "IMC");
        for (int i = 0; i < boxeadores.length; i++) {
            if((box.getCategoria() == boxeadores[i].getCategoria()) && (box.puedeGanarle(boxeadores[i]))){
                System.out.println(boxeadores[i].toString());
            }
        }
    }
    public static void mostrarTodosBoxeadores(Boxeador[] boxeadores) {
        System.out.println("APELLIDO" + "\t" + "ESTATURA" + "\t" + "PESO" + "\t" + "CATEGORIA" + "\t" + "IMC");
        for (int i = 0; i < boxeadores.length; i++) {
            System.out.println(boxeadores[i].toString());
        }
    }
    public static int mostrarMenu() {
        System.out.println("**");
        System.out.println("Ingrese el número de la opción que desea realizar");
        System.out.println();
        System.out.println("1_Cargar los datos de los boxeadores");
        System.out.println("2_Mostrar todos los boxeadores de una categoria dada");
        System.out.println("3_Dado un boxeador, mostrar boxeadores de la misma categoria a los que les puede ganar");
        System.out.println("4_Salir");
        System.out.println("**");
        int seleccion=TecladoIn.readInt();
        return seleccion;
    }
public static boolean ejecutarSeleccion(int seleccion,Boxeador[] array) {
        boolean continuar;
        switch(seleccion){
            case 1:
                cargarBoxeadores(array);
                continuar = true;
                break;
            case 2:
                char cat;
                do {
                    System.out.println("Ingrese la categoria que desea mostrar");
                    cat = TecladoIn.readLineNonwhiteChar();
                    cat = Character.toUpperCase(cat);
                } while ((cat != 'P') && (cat != 'C') && (cat != 'S'));
                mostrarBoxeadoresPorCategoria(array, cat);
                continuar = true;
                break;
            case 3:
                int posicion_boxeador;
                do {
                    System.out.println("Seleccione la posición del boxeador con el que "
                        + "desea comparar a los demás de la misma categoría");
                    posicion_boxeador = TecladoIn.readInt();
                } while ((posicion_boxeador < 0) || (posicion_boxeador >= array.length));
                puedeGanarleA(array, array[posicion_boxeador]);
                continuar = true;
                break;
            case 4:
                continuar = false;
                break;
            default:
                System.out.println("La opción ingresada no corresponde");
                continuar = true;
                break;
        } 
        return continuar;
    }
}
