public class Boxeador {
    private String apellido;
    private double estatura;
    private int peso;
    private char categoria;

    //CONSTRUCTORES
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

    //MODIFICADORES
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

    //Define la categoria segun el peso del boxeador
    private void setCategoria(int peso) {
        if(peso < 79) {
            this.categoria = 'S';
        } else if(peso >= 79 && peso <= 94) {
            this.categoria = 'C';
        } else if(peso > 94){
            this.categoria = 'P';
        }
    }

    //PROPIAS DEL TIPO
    private double obtenerIMC() {
        return this.peso / (this.getEstatura() * this.getEstatura());
    }

    //Verifica si un boxeador ingresado puede ganarle a otro basandose en su IMC
    public boolean puedeGanarle(Boxeador box) {
        boolean retorno = false;
        if(this.obtenerIMC() > box.obtenerIMC() ) { //Si el IMC es mayor entonces puede ganarle
            retorno = true;
        }
        return retorno;
    }
}
