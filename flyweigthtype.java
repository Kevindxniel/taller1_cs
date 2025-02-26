import java.util.HashMap;
import java.util.Map;

class TipoFantasma {
    private String nombre;
    private String textura;
    private String sonido;

    public TipoFantasma(String nombre, String textura, String sonido) {
        this.nombre = nombre;
        this.textura = textura;
        this.sonido = sonido;
    }

    public void mostrar(int x, int y) {
        System.out.println("Mostrando " + nombre + " en la posición (" + x + ", " + y + "), con textura " + textura + " y sonido " + sonido);
    }
}

class FabricaFantasmas {
    private static Map<String, TipoFantasma> tipos = new HashMap<>();

    public static TipoFantasma obtenerTipoFantasma(String nombre, String textura, String sonido) {
        if (!tipos.containsKey(nombre)) {
            System.out.println("Creando nuevo tipo de fantasma: " + nombre);
            tipos.put(nombre, new TipoFantasma(nombre, textura, sonido));
        }
        return tipos.get(nombre);
    }
}

class Fantasma {
    private TipoFantasma tipo;
    private int x, y;

    public Fantasma(TipoFantasma tipo, int x, int y) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    public void dibujar() {
        tipo.mostrar(x, y);
    }
}

public class flyweigthtype {
    public static void main(String[] args) {
        TipoFantasma tipoFantasmaEtereo = FabricaFantasmas.obtenerTipoFantasma("Fantasma Etéreo", "etereo.png", "susurro_etereo.mp3");
        TipoFantasma tipoFantasmaSombrio = FabricaFantasmas.obtenerTipoFantasma("Fantasma Sombrío", "sombrio.png", "lamento_sombrio.mp3");

        Fantasma[] fantasmas = {
            new Fantasma(tipoFantasmaEtereo, 10, 20),
            new Fantasma(tipoFantasmaEtereo, 50, 20),
            new Fantasma(tipoFantasmaSombrio, -10, 20),
            new Fantasma(tipoFantasmaSombrio, 0, 0)
        };

        for (Fantasma fantasma : fantasmas) {
            fantasma.dibujar();
        }
    }
}
