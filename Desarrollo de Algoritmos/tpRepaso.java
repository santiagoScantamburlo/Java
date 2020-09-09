import java.util.Scanner;
import utiles.TecladoIn;

/**
 * tpRepaso
 */
public class tpRepaso {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        boolean continuar = true;
        int opcion;

        while (continuar) {
            menu(); // Llama al módulo que muestra un menu con las opciones
            opcion = pufu.nextInt();
            continuar = acciones(opcion); // Llama al modulo en el que se ejecuta cada ejercicio
        }
    }

    public static void menu() { // Muestra un menu con todos los ejercicios y su opcion correspondiente
        System.out.println("Ingrese la opcion deseada: ");
        System.out.println("1: Ejercicio 1");
        System.out.println("2: Ejercicio 2");
        System.out.println("3: Ejercicio 3");
        System.out.println("4: Ejercicio 4");
        System.out.println("5: Ejercicio 5");
        System.out.println("6: Ejercicio 6");
        System.out.println("7: Ejercicio 7");
        System.out.println("8: Ejercicio 8");
        System.out.println("9: Ejercicio 9");
        System.out.println("10: Ejercicio 10");
        System.out.println("11: Ejercicio 11");
        System.out.println("0: Terminar");
    }

    public static boolean acciones(int o) { // Segun la opcion elegida, ejecuta el ejercicio correspondiente.
        boolean retorno = true;

        switch (o) {
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
            case 5:
                ejercicio5();
                break;
            case 6:
                ejercicio6();
                break;
            case 7:
                ejercicio7();
                break;
            case 8:
                ejercicio8();
                break;
            case 9:
                ejercicio9();
                break;
            case 10:
                ejercicio10();
                break;
            case 11:
                ejercicio11();
                break;
            case 0:
                retorno = false;
                break;
            default:
                break;
        }
        return retorno;
    }

    public static void ejercicio1() { // Modulo que realiza el ejercicio 1
        Scanner pufu = new Scanner(System.in);
        int num;
        System.out.println("Ingrese un numero");
        num = pufu.nextInt();

        for (int i = 1; i <= 10; i++) {
            if (i != 10) { // Va a imprimir comas siempre que no se encuentre en la ultima iteracion
                System.out.print(num * i + ", ");
            } else { // Si llega a la ultima iteracion no va a imprimir la coma
                System.out.println(num * i);
            }
        }
    }

    public static void ejercicio2() { // Modulo que realiza el ejercicio 2
        Scanner pufu = new Scanner(System.in);
        int num = 0, n, p = 100;
        boolean valido = false;

        while (!valido) { // Va a iterar mientras que el numero ingresado no sea valido
            System.out.println("Ingrese un numero para invertir");
            num = pufu.nextInt();

            if (num >= -999 && num <= 999 && (num >= 100 || num <= -100)) { // Verifico que el numero no tenga mas o
                                                                            // menos de 3 cifras
                valido = true;
            }
        }

        System.out.println("Numero invertido: " + invertir(num));
    }

    private static int invertir(int num) { // Este modulo invierte el numero ingresado
        int n, p = 100, retorno = 0;
        for (int i = 0; i < 3; i++) { // Sabiendo que el numero tiene 3 cifras, va a iterar 3 veces
            n = num % 10; // Saca el ultimo digito del numero
            retorno += n * p; // Lo multiplica por p, que se va reduciendo en 10 en cada iteracion
            num = num / 10; // Elimina el ultimo digito del numero
            p = p / 10; // Divide por 10 para poder seguir trabajando con la unidad siguiente
        }
        return retorno;
    }

    public static void ejercicio3() { // Modulo que realiza el ejercicio 3
        Scanner pufu = new Scanner(System.in);
        int num, copia;
        boolean esBinario = true;
        System.out.println("Ingrese un número binario");
        num = pufu.nextInt();
        copia = num; // Creo el int copia para no perder el valor original del numero ingresado para
                     // despues mostrarlo

        while (esBinario && copia != 0) { // Itera mientras que sea binario y todavia queden digitos para verificar
            if (copia % 10 != 1 && copia % 10 != 0) { // Si el ultimo digito es diferente de 1 y 0, entonces no es
                                                      // binario
                esBinario = false;
            } else {
                copia = copia / 10; // Si el ultimo digito era 1 o 0, entonces pasa al siguiente
            }
        }

        if (esBinario) { // Verifica el valor de verdad luego de la iteracion, ya que no se sabe si corto
                         // por ese valor o porque se consumio todo el numero
            System.out.println("El numero " + num + " es binario");
        } else {
            System.out.println(("El numero " + num + " no es binario"));
        }
    }

    public static void ejercicio4() { // Modulo que realiza el ejercicio 4
        Scanner pufu = new Scanner(System.in);
        int num, pares = 0, impares = 0, n;

        System.out.println("Ingrese un numero");
        num = pufu.nextInt();
        int copia = num; // Creo el int copia para no perder el valor original del numero ingresado y así
                         // despues mostrarlo

        while (copia != 0) { // Itera hasta que se consuma todo el numero
            n = copia % 10; // Obtengo el ultimo digito del numero

            if (n % 2 == 0) { // Si el resto al dividir por 2 es 0, entonces es par
                pares++;
            } else { // Sino, es impar
                impares++;
            }
            copia = copia / 10; // Consumo el ultimo digito y paso al siguiente
        }

        System.out.println("El numero " + num + " tiene " + pares + " digitos pares y " + impares + " digitos impares");
    }

    public static void ejercicio5() { // Modulo que realiza el ejercicio 5
        Scanner pufu = new Scanner(System.in);
        int num = 0, pares = 0, mayor = 0;

        while (num >= 0) { // Itera mientras que el numero ingresado sea positivo
            System.out.println("Ingrese un numero");
            num = pufu.nextInt();

            if (num >= 0) { // Verifica que el numero ingresado sea positivo porque sino sumaria uno de mas
                            // en caso de ser un negativo par
                if (num % 2 == 0) {
                    pares++;
                }
                if (num >= mayor) { // Verifica si el numero ingresado es mayor al ya existente
                    mayor = num;
                }
            }
        }

        System.out.println("Cantidad de numeros pares: " + pares);
        System.out.println("Mayor numero ingresado: " + mayor);
    }

    public static void ejercicio6() { // Modulo que realiza el ejercicio 6
        Scanner pufu = new Scanner(System.in);
        String frase, palabra, palabraMasLarga = "";
        int masLarga = 0;

        System.out.println("Ingrese una frase");
        frase = pufu.nextLine();

        while (frase.contains(" ")) { // Itera mientras que encuentre espacios en la frase
            palabra = frase.substring(0, frase.indexOf(" ")); // Hace un substring desde la primer posicion al primer
                                                              // espacio para separar la primer palabra
            frase = frase.substring(frase.indexOf(" ") + 1); // Hace un substring desde el primer espacio en adelante
                                                             // para alamacenar el resto de la frase

            if (palabra.length() >= masLarga) { // Verifica si la longitud de la palabra actual es mayor a la anterior
                masLarga = palabra.length(); // Reemplaza el valor de la mayor longitud en caso de cumplir la condicion
                palabraMasLarga = palabra; // Reemplaza por la nueva palabra
            }
        }

        if (frase.length() >= masLarga) { // Verifica una ultima vez ya que queda una palabra sin espacios al final de
                                          // la frase y hace la misma comparacion que antes
            masLarga = frase.length();
            palabraMasLarga = frase;
        }
        System.out.println("La palabra mas larga es: " + palabraMasLarga);
    }

    public static void ejercicio7() { // Modulo que realiza el ejercicio 7
        Scanner pufu = new Scanner(System.in);
        String frase;
        char caracter;
        boolean encontrado = false;
        int i = 0;

        System.out.println("Ingrese una frase");
        frase = TecladoIn.readLine();
        System.out.println("Ingrese el caracter que desea buscar");
        caracter = pufu.next().charAt(0);

        while (!encontrado && i < frase.length()) { // Itera hasta encontrar el caracter elegido, o hasta que llegue al
                                                    // final de la cadena
            if (frase.charAt(i) == caracter) {
                encontrado = true; // En caso de coincidir cambia el valor de verdad y corta la iteracion
            } else {
                i++; // En caso de no coincidir aumenta el valor de i y pasa a la siguiente posicion
            }
        }

        if (encontrado) { // Verifica el valor de verdad porque no se sabe si termino la iteracion por
                          // encontrar o llegar al final de la cadena
            System.out.println("El caracter '" + caracter + "' se encuentra en la frase");
        } else {
            System.out.println("El caracter '" + caracter + "' no se encuentra en la frase");
        }
    }

    public static void ejercicio8() { // Modulo que realiza el ejercicio 8
        Scanner pufu = new Scanner(System.in);
        int opcion;
        boolean valida = false;

        System.out.println("Ingrese la forma de hacer el ejercicio: ");
        System.out.println("1: Usando operacion length y charAt");
        System.out.println("2: Usando las operaciones de String necesarias");
        opcion = pufu.nextInt();

        while (!valida) { // Verifica que la opcion ingresada sea alguna de las propuestas
            switch (opcion) { // Se tienen en consideracion ambas resoluciones propuestas en el ejercicio
                case 1:
                    opcion1();
                    valida = true;
                    break;
                case 2:
                    opcion2();
                    valida = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void opcion1() { // Modulo que realiza el ejercicio haciendo uso de charAt y length
        Scanner pufu = new Scanner(System.in);
        String frase, palabra;
        int contador;

        System.out.println("Ingrese una frase");
        frase = pufu.nextLine();
        System.out.println("Ingrese una palabra a buscar");
        palabra = pufu.next();

        contador = contarOcurrenciasPalabra(frase, palabra); // Llama al modulo que cuenta la cantidad de ocurrencias de
                                                             // la palabra ingresada
        System.out.println("La palabra ''" + palabra + "'' aparece " + contador + " veces en la frase");
    }

    private static int contarOcurrenciasPalabra(String frase, String palabra) { // Este modulo cuenta la cantidad de
                                                                                // veces que se repite la palabra en la
                                                                                // frase
        int contador = 0;
        String pNueva = "";
        boolean igual;
        char letra;

        for (int i = 0; i < frase.length(); i++) { // Empiezo a recorrer toda la cadena
            igual = false;
            letra = frase.charAt(i);
            if (letra == ' ') { // Si la posicion actual es un espacio, la cadena se vacia
                pNueva = "";
            } else { // Si la posicion no es un espacio, concatena el caracter en esa posicion a la
                     // nueva palabra
                pNueva += letra;
                if (i == frase.length() - 1 || frase.charAt(i + 1) == ' ') { // Si i se encuentra en la ultima posicion
                                                                             // o si la siguiente es un espacio, llama
                                                                             // al modulo que compara las palabras
                    igual = compararPalabras(pNueva, palabra);
                }
            }
            if (igual) { // En caso de ser iguales aumenta el contador
                contador++;
            }
        }
        return contador;
    }

    private static boolean compararPalabras(String pNueva, String palabra) { // Modulo que compara 2 palabras
                                                                             // recorriendolas caracter por caracter
        boolean iguales = true;
        int i = 0;

        while (iguales && i < pNueva.length() && i < palabra.length()) { // Itera mientras que el valor de verdad sea
                                                                         // true, y que i no se salga de ninguna cadena
            if (pNueva.charAt(i) != palabra.charAt(i)) { // En caso de ser diferentes cambia el valor de verdad a false
                iguales = false;
            } else { // Si los caracteres son iguales pasa a la siguien posicion en ambas cadenas
                i++;
            }
        }
        return iguales;
    }

    private static void opcion2() { // Modulo que realiza el ejercicio haciendo uso de los metodos necesarios
        Scanner pufu = new Scanner(System.in);
        String frase, palabra, pNueva;
        int contador = 0;

        System.out.println("Ingrese una frase");
        frase = pufu.nextLine();
        System.out.println("Ingrese una palabra a buscar");
        palabra = pufu.nextLine();

        while (frase.contains(" ")) { // Itera mientras que queden espacios en la cadena
            pNueva = frase.substring(0, frase.indexOf(" ")); // Hace un substring separando la primer palabra del resto
                                                             // de la cadena
            frase = frase.substring(frase.indexOf(" ") + 1); // Hace un substring con el resto de la cadena

            if (palabra.equals(pNueva)) { // Verifica si las cadena son iguales
                contador++;
            }
        }

        if (frase.equals(palabra)) { // Verifica una ultima vez ya que queda una palabra sin espacios al final
            contador++;
        }

        System.out.println("La palabra ''" + palabra + "'' aparece " + contador + " veces en la frase");
    }

    public static void ejercicio9() { // Modulo que realiza el ejercicio 9
        Scanner pufu = new Scanner(System.in);
        int cantP, contCapicua = 0, cantMas2Vocales = 0;
        String palabra, masLarga = "";

        System.out.println("Ingrese la cantidad de palabras a cargar");
        cantP = pufu.nextInt();

        for (int i = 0; i < cantP; i++) { // Itera segun la cantidad de palabras que se vayan a ingresar
            System.out.println("Ingrese una palabra");
            palabra = pufu.next();

            if (capicua(palabra)) { // Llama al modulo que verifica si es capicua
                contCapicua++;
            }

            if (mas2Vocales(palabra)) { // Llama al modulo que cuenta la cantidad de vocales
                cantMas2Vocales++;
            }

            if (palabra.length() >= masLarga.length()) { // Verifica si la palabra actual es mas larga que la mas larga
                                                         // actual
                masLarga = palabra;
            }
        }

        System.out.println("Se ingresaron " + contCapicua + " palabras capicua");
        System.out.println("Se ingresadon " + cantMas2Vocales + " palabras con mas de dos vocales");
        System.out.println("La palabra mas larga es: " + masLarga);
    }

    private static boolean capicua(String palabra) { // Modulo que verifica si una palabra ingresada es capicua
        boolean esCapicua = true;
        int i = 0, j = palabra.length() - 1; // i empieza desde la primera posicion y j desde la ultima

        while (esCapicua && i != j) { // Itera mientras que el valor de verdad sea true, y j e i esten en posiciones
                                      // diferentes
            if (palabra.charAt(i) != palabra.charAt(j)) { // En caso de ser diferentes cambia el valor de verdad a false
                                                          // y corta
                esCapicua = false;
            } else { // En caso de ser iguales, aumenta va a la siguiente posicion segun corresponda
                i++;
                j--;
            }
        }
        return esCapicua;
    }

    private static boolean mas2Vocales(String palabra) { // Modulo que cuenta si la palabra tiene mas de 2 vocales
        boolean masDos = false;
        int i = 0, contVocales = 0;

        while (!masDos && i < palabra.length()) { // Itera mientras que el valor de verdad sea false y no se salga de la
                                                  // cadena
            String letra = "";
            letra += palabra.charAt(i);
            if ("aeiouAEIOUáéíóúÁÉÍÓÚ".contains(letra)) { // Verifica que la letra actual sea una vocal
                contVocales++;
            }
            i++;

            if (contVocales > 2) { // Si hay mas de 2 vocales corta
                masDos = true;
            }
        }
        return masDos;
    }

    public static void ejercicio10() { // Modulo que realiza el ejercicio 10
        String mensaje, encriptado;

        System.out.println("Ingrese un mensaje");
        mensaje = TecladoIn.readLine();

        encriptado = encriptarMensaje(mensaje); // Llama al modulo que se encarga de modificar las letras ingresadas

        System.out.println(encriptado);
    }

    private static String encriptarMensaje(String mensaje) { // Modulo que realiza el cambio de vocales por simbolos
        String retorno = "";
        char letra;

        for (int i = 0; i < mensaje.length(); i++) { // Itera hasta llegar al final de la cadena
            letra = mensaje.charAt(i);

            switch (letra) { // Segun la letra actual, concatena el simbolo o no a la cadena encriptada
                case 'a':
                    retorno += '*';
                    break;
                case 'e':
                    retorno += '/';
                    break;
                case 'i':
                    retorno += '+';
                    break;
                case 'o':
                    retorno += '-';
                    break;
                case 'u':
                    retorno += '#';
                    break;
                case 'A':
                    retorno += '*';
                    break;
                case 'E':
                    retorno += '/';
                    break;
                case 'I':
                    retorno += '+';
                    break;
                case 'O':
                    retorno += '-';
                    break;
                case 'U':
                    retorno += '#';
                    break;
                default:
                    retorno += letra;
            }
        }
        return retorno;
    }

    public static void ejercicio11() { // Modulo que realiza el ejercicio 11
        Scanner pufu = new Scanner(System.in);
        boolean valida = false, longitud = false, letra = false, numero = false, caracter = false;
        String contrasenia;

        while (!valida) { // Itera mientras que la cadena no sea valida
            System.out.println("Ingrese su contrasenia");
            contrasenia = pufu.next();

            if (contrasenia.length() == 8) { // Si la cadena es de exactamente 8 caracteres, la longitud es correcta
                longitud = true;
                letra = verificarLetra(contrasenia); // Llama al modulo que verifica si hay alguna letra
                numero = verificarNumero(contrasenia); // Llama al modulo que verifica si hay algun numero
                caracter = verificarCaracter(contrasenia); // Llama al modulo que verifica si hay algun simbolo
            }

            if (longitud && letra && numero && caracter) { // En caso de cumplir todas las condiciones, es correcta
                valida = true;
            }
        }
        System.out.println("La contrasenia ingresada es valida");
    }

    private static boolean verificarLetra(String contrasenia) { // Modulo que verifica que haya al menos una letra en la
                                                                // cadena
        boolean retorno = false;
        int i = 0;
        char caracter;

        while (!retorno && i < contrasenia.length()) { // Itera mientras que no encuentre ninguna letra y siga dentro de
                                                       // la cadena
            caracter = contrasenia.charAt(i);
            if (Character.isLetter(caracter)) { // En caso de encontrar una letra corta
                retorno = true;
            } else {
                i++;
            }
        }
        return retorno;
    }

    private static boolean verificarNumero(String contrasenia) { // Modulo que verifica que haya al menos un numero en
                                                                 // la cadena
        boolean retorno = false;
        int i = 0;
        char caracter;

        while (!retorno && i < contrasenia.length()) { // Itera mientras que no encuentre ningun numero y siga dentro de
                                                       // la cadena
            caracter = contrasenia.charAt(i);
            if (Character.isDigit(caracter)) { // En caso de encontrar un numero corta
                retorno = true;
            } else {
                i++;
            }
        }
        return retorno;
    }

    private static boolean verificarCaracter(String contrasenia) { // Modulo que verifica que haya al menos un simbolo
                                                                   // en la cadena
        boolean retorno = false;
        String caracter;
        int i = 0;

        while (!retorno && i < contrasenia.length()) { // Itera mientras que no encuentre ningun simbolo y siga dentro
                                                       // de la cadena
            caracter = "";
            caracter += contrasenia.charAt(i);
            if ("*/-$%#".contains(caracter)) { // En caso de encontrar un simbolo corta
                retorno = true;
            } else {
                i++;
            }
        }
        return retorno;
    }
}