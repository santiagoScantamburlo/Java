
public class Racional {

    // Atributos
    private int numerador;
    private int denominador;

    // Constructor
    public Racional(int n, int d) {
        this.numerador = n;
        this.denominador = d;
    }

    // Observadores
    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public double pasarADouble() {
        double numeroRacional;
        numeroRacional = this.numerador / this.denominador;
        return numeroRacional;
    }

    public String toString() {
        return "Numerador: " + this.numerador + " Denominador: " + this.denominador;
    }

    public boolean equals(Racional r) {
        boolean retorno = false;

        if (this.numerador == r.getNumerador() && this.denominador == r.getDenominador()) {
            retorno = true;
        }
        return retorno;
    }

    // Modificadores
    public void setNumerador(int n) {
        this.numerador = n;
    }

    public void serDenominador(int d) {
        this.denominador = d;
    }

    // Propias del tipo
    public Racional sumar(Racional r) {
        Racional s;
        int sumaNum, sumaDen;
        sumaNum = this.numerador + r.getNumerador();
        sumaDen = this.denominador + r.getDenominador();
        s = new Racional(sumaNum, sumaDen);
        return s;
    }

    public Racional restar(Racional r) {
        Racional s;
        int restaNum, restaDen;
        restaNum = this.numerador - r.getNumerador();
        restaDen = this.denominador - r.getDenominador();
        s = new Racional(restaNum, restaDen);
        return s;
    }

    public Racional multiplicar(Racional r) {
        Racional s;
        int multNum, multDen;
        multNum = this.numerador * r.getNumerador();
        multDen = this.denominador * r.getDenominador();
        s = new Racional(multNum, multDen);
        return s;
    }

    public Racional dividir(Racional r) {
        Racional s;
        int sumaNum = 0, sumaDen = 0;
        if (r.getNumerador() > 0 && r.getDenominador() > 0) {
            sumaNum = this.numerador / r.getDenominador();
            sumaDen = this.denominador + r.getNumerador();
        } else {
            System.out.println("No se puede dividir por 0");
        }
        s = new Racional(sumaNum, sumaDen);
        return s;
    }

    public void simplificar() {
        int mcd;

        if (this.denominador != this.numerador) {
            mcd = maximoComunDivisor(this.numerador, this.denominador);
            this.denominador /= mcd;
            this.numerador /= mcd;
        }
    }

    private int maximoComunDivisor(int num, int den) {
        int retorno;
        while (num != den) {
            if (num > den) {
                num = num - den;
            } else {
                den = den - num;
            }
        }
        retorno = num;
        return retorno;
    }
}