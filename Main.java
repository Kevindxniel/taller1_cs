import java.util.ArrayList;
import java.util.List;

// Clase abstracta EquipmentKit con métodos comunes
abstract class EquipmentKit {
    protected List<String> items = new ArrayList<>();

    // Método para agregar un item al kit
    public final void addItem(String item) {
        items.add(item);
    }

    // Método para calcular el costo total del kit
    public int getTotalCost() {
        return items.size() * 100;
    }

    // Método para obtener una representación en cadena del kit
    @Override
    public String toString() {
        return "Equipment Kit: " + items.toString() + " | Total Cost: " + getTotalCost() + " gold";
    }
}

// Clase WarriorKit que extiende EquipmentKit
class WarriorKit extends EquipmentKit {
    public WarriorKit() {
        init();
    }

    private void init() {
        // Agregar items específicos para el kit de guerrero
        addItem("Steel Sword");
        addItem("Plate Armor");
        addItem("Health Potion");
        addItem("Ring of Strength");
    }
}

// Clase MageKit que extiende EquipmentKit
class MageKit extends EquipmentKit {
    public MageKit() {
        init();
    }

    private void init() {
        // Agregar items específicos para el kit de mago
        addItem("Magic Staff");
        addItem("Arcane Robe");
        addItem("Mana Potion");
        addItem("Amulet of Wisdom");
    }
}

// Clase Main con método main
public class Main {
    public static void main(String[] args) {
        // Crear instancias de WarriorKit y MageKit
        EquipmentKit warriorKit = new WarriorKit();
        EquipmentKit mageKit = new MageKit();

        // Imprimir información de los kits
        System.out.println(warriorKit);
        System.out.println(mageKit);
    }
}