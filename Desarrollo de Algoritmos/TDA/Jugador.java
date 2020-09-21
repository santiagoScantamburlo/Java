public class Jugador {
    private String nickname;
    private int[] puntos;

    // CONSTRUCTORES
    public Jugador(String nom) {
        this.nickname = nom;
        this.puntos = new int[10];
    }

    // OBSERVADORES
    public String getNickname() {
        return this.nickname;
    }

    public int[] getPuntos() {
        return this.puntos;
    }

    public String toString() {
        return this.nickname + "\n" + puntajes(this.puntos);
    }

    private String puntajes(int[] puntos) {
        String retorno = "[";

        for (int i = 0; i < puntos.length; i++) {
            if (i + 1 != puntos.length) {
                retorno += puntos[i] + " - ";
            } else {
                retorno += puntos[i];
            }
        }
        retorno += "]";
        return retorno;
    }

    public boolean equals(Jugador j) {
        return this.nickname.equalsIgnoreCase(j.nickname);
    }

    // MODIFICADORES
    public void setNickname(String nom) {
        this.nickname = nom;
    }

    public void setPuntos(int p) {
        int menor = 0, posicion = 0;
        boolean primero = false;
        for (int i = 0; i < this.puntos.length; i++) {
            if (!primero) {
                menor = puntos[i];
                posicion = i;
                primero = true;
            } else {
                if (puntos[i] < menor) {
                    menor = puntos[i];
                    posicion = i;
                }
            }
        }
        if (p > menor) {
            puntos[posicion] = p;
        }
    }

    // PROPIAS DEL TIPO
    public void sumarPuntos(int mas) {
        boolean lleno = true;
        int i = 0;
        while (lleno && i < this.puntos.length) {
            if (this.puntos[i] == 0) {
                this.puntos[i] = mas;
                lleno = false;
            } else {
                i++;
            }
        }
        if (lleno) {
            setPuntos(mas);
        }
    }

    public int puntajeMasAlto() {
        int retorno = this.puntos[0];
        for (int i = 0; i < puntos.length; i++) {
            if (this.puntos[i] >= retorno) {
                retorno = this.puntos[i];
            }
        }
        return retorno;
    }
}
