package TDA;

public class Patinador {
    private String apellido, nombre, dni;
    private int edad;
    private char categoria;

    // CONSTRUCTORES
    public Patinador(String dni) {
        this.apellido = "";
        this.nombre = "";
        this.dni = dni;
        this.edad = 0;
        this.categoria = '\0';
    }

    public Patinador(String ape, String nom, String doc, int ed, char cat) {
        this.apellido = ape;
        this.nombre = nom;
        this.dni = doc;
        this.edad = ed;
        this.categoria = cat;
    }

    // OBSERVADORES
    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public int getEdad() {
        return this.edad;
    }

    public char getCategoria() {
        return this.categoria;
    }

    public String toString() {
        return this.apellido + ", " + nombre + "\n" + "DNI: " + this.dni + "\n" + "Edad: " + this.edad + "\n"
                + "Categoria: " + this.categoria;
    }

    // MODIFICADORES
    public void setApellido(String ape) {
        this.apellido = ape;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setDni(String doc) {
        this.dni = doc;
    }

    public void setEdad(int ed) {
        this.edad = ed;
    }

    public void setCategoria(char cat) {
        this.categoria = cat;
    }

    // PROPIAS DEL TIPO
    public void asciendeCategoria() {
        switch (this.categoria) {
            case 'P':
                setCategoria('I');
                break;
            case 'I':
                setCategoria('C');
                break;
            case 'C':
                setCategoria('B');
                break;
            case 'B':
                setCategoria('A');
                break;
            case 'A':
                System.out.println("Ya no puede ascender más de categoria");
                break;
            default:
                System.out.println("Categoria no valida");
                break;
        }
    }

    public boolean equals(Patinador p) {
        boolean retorno = false;

        if (this.dni.equalsIgnoreCase(p.dni)) {
            retorno = true;
        }
        return retorno;
    }
}
