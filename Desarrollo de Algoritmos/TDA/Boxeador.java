public class Boxeador {
    private String apellido;
    private double estatura;
    private int peso;
    private char categoria;

    //Constructores
    public Boxeador() {
        this.apellido = "";
        this.estatura = 0;
        this.peso = 0;
        this.categoria = '\0';
    }

    public Boxeador(String apellido, double altura, int peso) {
        this.apellido = apellido;
        this.estatura = altura;
        this.peso = peso;
        setCategoria(peso);
    }

    //Observadores
    public String getApellido() {
        return this.apellido;
    }

    public double getEstatura() {
        return this.estatura;
    }

    public int getPeso() {
        return this.peso;
    }

    public char getCategoria() {
        return this.categoria;
    }

    public String toString() {
        return "Apellido: " + getApellido() + "\n" +
        "Estatura: " + getEstatura() + "\n" +
        "Peso: " + getPeso() + "\n" + 
        "Categoria: " + getCategoria();
    }

    //Modificadores
    public void setApellido(String ape) {
        this.apellido = ape;
    }

    public void setEstatura(double alt) {
        this.estatura = alt;
    }

    public void setPeso(int peso) {
        this.peso = peso;
        setCategoria(peso);
    }

    private void setCategoria(int peso) {
        if(peso < 79) {
            this.categoria = 'S';
        } else if(peso >= 79 && peso <= 94) {
            this.categoria = 'C';
        } else if(peso > 94){
            this.categoria = 'P';
        }
    }

    //Propias del Tipo
    private double obtenerIMC() {
        return this.peso / (this.estatura * this.estatura);
    }

    public boolean puedeGanarle(Boxeador box) {
        boolean retorno = false;
        if(this.obtenerIMC() > box.obtenerIMC() ) {
            retorno = true;
        }
        return retorno;
    }
}
