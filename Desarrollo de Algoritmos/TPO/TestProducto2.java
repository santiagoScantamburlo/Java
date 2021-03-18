import java.util.Scanner;

public class TestProducto2 {
    public static Scanner pufu = new Scanner(System.in);

    public static void main(String[] args) {
        Producto[] arreglo;
        int opcion = -1, cantProductos;
        char cargar = '\0';
        while (cargar != 'n' && cargar != 's') {
            System.out.println("¿Desea usar el arreglo ya cargado? (s/n)");
            cargar = pufu.next().charAt(0);
        }

        if (cargar == 'n') {
            System.out.println("Ingrese la cantidad de productos a cargar: ");
            cantProductos = pufu.nextInt();
            arreglo = new Producto[cantProductos];
            cargarArreglo(arreglo, cantProductos);
        } else {
            arreglo = new Producto[10];
            arregloPredefinido(arreglo);
        }

        do {
            menu();
            opcion = pufu.nextInt();
            if (opcion != 0) {
                acciones(arreglo, opcion);
            }
        } while (opcion != 0);
    }

    public static void arregloPredefinido(Producto[] a) {
        a[0] = new Producto("mayonesa", "Helmanns", 13524, 32, 21.5);
        a[1] = new Producto("queso", "S&P", 65423, 74, 126.87);
        a[2] = new Producto("aceite", "Cocinero", 78956, 41, 156);
        a[3] = new Producto("jabon", "Dove", 38529, 32, 41.54);
        a[4] = new Producto("detergente", "Magistral", 31635, 8, 43.64);
        a[5] = new Producto("lavandina", "Clorox", 54637, 5, 85.86);
        a[6] = new Producto("tirabuzones", "Luchetti", 48296, 52, 23.74);
        a[7] = new Producto("lapicera", "BIC", 48674, 3, 4.52);
        a[8] = new Producto("te", "La Virginia", 46852, 7, 56.41);
        a[9] = new Producto("mate cocido", "La Tranquera", 71852, 0, 78.29);
    }

    public static void cargarArreglo(Producto[] a, int cantProductos) {
        Producto p;
        String nombre, marca;
        int codigo, cantEnStock;
        double precio;

        for (int i = 0; i < cantProductos; i++) {
            System.out.println("Ingrese el nombre del producto: ");
            nombre = "";
            nombre = pufu.next();

            System.out.println("Ingrese la marca del producto: ");
            marca = pufu.next();

            System.out.println("Ingrese el codigo del producto: ");
            codigo = pufu.nextInt();

            System.out.println("Ingrese el stock del producto: ");
            cantEnStock = pufu.nextInt();

            System.out.println("Ingrese el precio del producto: ");
            precio = pufu.nextDouble();

            p = new Producto(nombre, marca, codigo, cantEnStock, precio);
            a[i] = p;
        }
    }

    public static void menu() {
        System.out.println("Ingrese la opción que desea realizar: ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("1: Contar la cantidad de productos con un stock menor a 10");
        System.out.println("2: Encontrar el producto con el mayor precio");
        System.out.println("3: Verificar si existe un producto con un codigo dado");
        System.out.println("4: Ordenar el arreglo segun su nombre");
        System.out.println("0: SALIR");
    }

    public static void acciones(Producto[] a, int op) {
        int menosADiez, codigoBuscado, posicionEncontrado;
        double mayorPrecio;

        switch (op) {
            case 1:
                menosADiez = contarProductos(a, 0, a.length - 1);
                System.out.println("Hay " + menosADiez + " productos con un stock menor a 10");
                break;
            case 2:
                mayorPrecio = buscarMayorPrecio(a, 0, a.length - 1);
                System.out.println("El mayor precio es de: " + mayorPrecio);
                break;
            case 3:
                System.out.println("Ingrese el codigo que desea buscar: ");
                codigoBuscado = pufu.nextInt();
                ordenarArreglo(a);
                posicionEncontrado = buscarPorCodigo(a, codigoBuscado);
                if (posicionEncontrado != -1) {
                    System.out.println("El producto \n" + a[posicionEncontrado].toString()
                            + "se encuentra en la posicion " + posicionEncontrado);
                } else {
                    System.out.println("El codigo ingresado no se encuentra en el arreglo");
                }
                break;
            case 4:
                heapSort(a, a.length);
                mostrarArreglo(a);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }

    public static int contarProductos(Producto[] a, int i, int n) {
        int retorno = 0;

        if (i == n) {
            if (a[i].getCantEnStock() < 10) {
                retorno = 1;
            }
        } else {
            if (a[i].getCantEnStock() < 10) {
                retorno = 1 + contarProductos(a, i + 1, n);
            } else {
                retorno = contarProductos(a, i + 1, n);
            }
        }
        return retorno;
    }

    public static double buscarMayorPrecio(Producto[] a, int i, int n) {
        double mayor, retorno;
        if (i == 0) {
            mayor = a[i].getPrecio();
            retorno = buscarMayorPrecio(a, i + 1, n);
            if (retorno >= mayor) {
                mayor = retorno;
            }
        } else if (i < n) {
            mayor = a[i].getPrecio();
            retorno = buscarMayorPrecio(a, i + 1, n);
            if (retorno >= mayor) {
                mayor = retorno;
            }
        } else {
            mayor = a[i].getPrecio();
        }
        return mayor;
    }

    public static void ordenarArreglo(Producto[] a) {
        int opcion;

        do {
            System.out.println("Ingrese el metodo de ordenamiento que desea utilizar: ");
            System.out.println("1: Burbuja Mejorado");
            System.out.println("2: Seleccion");
            System.out.println("3: Insercion");
            opcion = pufu.nextInt();
        } while (opcion < 0 || opcion > 3);

        switch (opcion) {
            case 1:
                burbujaMejorado(a);
                break;
            case 2:
                seleccion(a);
                break;
            case 3:
                insercion(a);
                break;
        }
        mostrarArreglo(a);
    }

    public static void burbujaMejorado(Producto[] a) {
        int i, n;
        boolean sinCambio = false;
        Producto aux;

        i = 0;
        n = a.length;

        while (i < n && !sinCambio) {
            sinCambio = true;

            for (int j = 0; j < n - i - 1; j++) {

                if (a[j].getCodigo() > a[j + 1].getCodigo()) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                    sinCambio = false;
                }
            }
            i++;
        }
    }

    public static void seleccion(Producto[] a) {
        int min;
        Producto aux;

        for (int i = 0; i < a.length - 1; i++) {
            min = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j].getCodigo() < a[min].getCodigo()) {
                    min = j;
                }
            }
            aux = a[i];
            a[i] = a[min];
            a[min] = aux;
        }
    }

    public static void insercion(Producto[] a) {
        Producto p;
        int j, aux, largo;
        largo = a.length;

        for (int i = 1; i < largo; i++) {
            p = a[i];
            aux = a[i].getCodigo();
            j = i;

            while (j > 0 && aux < a[j - 1].getCodigo()) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = p;
        }
    }

    public static int buscarPorCodigo(Producto[] a, int cod) {
        int inicio, fin, resultado, medio;

        inicio = 0;
        fin = a.length - 1;
        resultado = -1;

        while (inicio <= fin) {
            medio = ((inicio + fin) / 2);
            inicio = fin + 1;

            if (cod == a[medio].getCodigo()) {
                resultado = medio;
            } else if (cod < a[medio].getCodigo()) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return resultado;
    }

    public static void heapSort(Producto[] a, int n) {
        Producto temp;
        for (int i = n / 2; i >= 0; i--) {
            hacerMonticulo(a, i, n - 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            hacerMonticulo(a, 0, i - 1);
        }
    }

    public static void hacerMonticulo(Producto[] a, int i, int fin) {
        int izq = 2 * i + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            if (a[izq].getNombre().compareTo(a[der].getNombre()) > 0) {
                may = izq;
            } else {
                may = der;
            }
        }
        if (a[i].getNombre().compareTo(a[may].getNombre()) < 0) {
            Producto tmp = a[i];
            a[i] = a[may];
            a[may] = tmp;
            hacerMonticulo(a, may, fin);
        }
    }

    public static void mostrarArreglo(Producto[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].toString());
            System.out.println("-------------------------");
        }
    }
}
