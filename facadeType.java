
class Cafetera {
    public void encender() {
        System.out.println("Cafetera encendida");
    }

    public void apagar() {
        System.out.println("Cafetera apagada");
    }
}

class MaquinaDeSnacks {
    public void encender() {
        System.out.println("Máquina de snacks encendida");
    }

    public void apagar() {
        System.out.println("Máquina de snacks apagada");
    }
}

class Licuadora {
    public void encender() {
        System.out.println("Licuadora encendida");
    }

    public void apagar() {
        System.out.println("Licuadora apagada");
    }
}

// Clase Cafetería Inteligente
class CafeteriaInteligente {
    private Cafetera cafetera;
    private MaquinaDeSnacks snacks;
    private Licuadora licuadora;

    public CafeteriaInteligente() {
        cafetera = new Cafetera();
        snacks = new MaquinaDeSnacks();
        licuadora = new Licuadora();
    }

    public void modoDesayuno() {
        System.out.println("Activando Modo Desayuno ....");
        cafetera.encender();
        snacks.apagar();
        licuadora.encender();
    }

    public void modoMerienda() {
        System.out.println("Activando Modo Merienda ....");
        cafetera.apagar();
        snacks.encender();
        licuadora.encender();
    }
}

// Programa principal
public class facadeType {
    public static void main(String[] args) {
        CafeteriaInteligente cafeteria = new CafeteriaInteligente();

        cafeteria.modoDesayuno(); 
        cafeteria.modoMerienda();  
    }
}
