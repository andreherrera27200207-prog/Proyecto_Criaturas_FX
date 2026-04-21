package com.example.Modelo;
import java.util.List;

public class Jugador {
    static int contadorAtaque = 0;

    protected float vida;
    protected String nombre;
    protected int monocos;
    protected float danoMultiplicador;
    protected int segundosVisibles;
    protected int monocosPorParry;
    protected List<String> ataqueString;
   // protected List<Ataque> ataqueLista;
   // protected Ataque ataqueElegido;


    public float getVida() {
        return this.vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonocos() {
        return this.monocos;
    }

    public void setMonocos(int monocos) {
        this.monocos = monocos;
    }

    public float getDanoMultiplicador() {
        return this.danoMultiplicador;
    }

    public void setDanoMultiplicador(float danoMultiplicador) {
        this.danoMultiplicador = danoMultiplicador;
    }

    public int getSegundosVisibles() {
        return this.segundosVisibles;
    }

    public void setSegundosVisibles(int segundosVisibles) {
        this.segundosVisibles = segundosVisibles;
    }

    public int getMonocosPorParry() {
        return this.monocosPorParry;
    }

    public void setMonocosPorParry(int monocosPorParry) {
        this.monocosPorParry = monocosPorParry;
    }

    public List<String> getAtaqueString() {
        return this.ataqueString;
    }

    public void setAtaqueString(List<String> ataquesString) {
        this.ataqueString = ataquesString;
    }


//   public Ataque getAtaqueElegido() {
//       return this.ataqueElegido;
//   }
//
//   public void setAtaqueElegido(Ataque ataque) {
//       this.ataqueElegido = ataque;
//   }
//
//   public List<Ataque> getAtaqueLista() {
//       return this.ataqueLista;
//   }
//
//   public void setAtaqueLista(List<Ataque> ataqueLista) {
//       this.ataqueLista = ataqueLista;
//   }








    public void ejecutarAtaqueEnemigo(int dificultad, int visibilidad) throws InterruptedException {

    System.out.println("El enemigo va a realizar un ataque de dificultad: " + dificultad);
    System.out.println("Presiona enter cuando creas que el contador va por: \n\t\t\t\t\u001B[31m" + dificultad + "\u001B[m");

    final boolean[] terminado = {false};

    Thread contadorThread = new Thread(() -> {
        try {
            for (int i = 1; i < dificultad * 2 && !terminado[0]; i++) {
                contadorAtaque = i;

                if (i <= visibilidad)
                    System.out.println(i + "...");

                Thread.sleep(300);
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    Thread inputThread = new Thread(() -> {
        
       

        terminado[0] = true;

        if (contadorAtaque == dificultad) {
            System.out.println("Parry exitoso");
            System.out.println("Has conseguido " + monocosPorParry + " Monoco(s)");
            monocos += monocosPorParry;
        } else {
            System.out.println("Fallaste (" + contadorAtaque + ")");
            vida -=3;
            if(vida<0) vida=0;
            System.out.println("Has perdido " + 3 + " de vida. Tienes " + vida + " puntos de vida");
        }
    });

    contadorThread.start();
    inputThread.start();

    contadorThread.join();
    inputThread.join();

  //  JugadorManager.ordenarEnemigos();
    System.out.println("El ataque ha finalizado y los enemigos han rotado");
}

    

}
