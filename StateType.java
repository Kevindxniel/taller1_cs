// Interfaz Estado
interface OrderState {
    OrderState placeOrder();
    OrderState prepareOrder();
    OrderState deliverOrder();
}

// Estado: No hay pedido aún
class NoOrderState implements OrderState {
    @Override
    public OrderState placeOrder() {
        System.out.println("✅ Pedido realizado en KFC");
        return new OrderPlacedState();
    }

    @Override
    public OrderState prepareOrder() {
        System.out.println("❌ No puedes preparar un pedido que no existe");
        return this;
    }

    @Override
    public OrderState deliverOrder() {
        System.out.println("❌ No puedes entregar un pedido que no existe");
        return this;
    }
}

// Estado: Pedido ha sido realizado
class OrderPlacedState implements OrderState {
    @Override
    public OrderState placeOrder() {
        System.out.println("❌ Ya hiciste un pedido");
        return this;
    }

    @Override
    public OrderState prepareOrder() {
        System.out.println("🍳 Pedido en preparación...");
        return new OrderPreparedState();
    }

    @Override
    public OrderState deliverOrder() {
        System.out.println("❌ No puedes entregar un pedido que no está listo");
        return this;
    }
}

// Estado: Pedido preparado
class OrderPreparedState implements OrderState {
    @Override
    public OrderState placeOrder() {
        System.out.println("❌ No puedes hacer otro pedido sin recoger el actual");
        return this;
    }

    @Override
    public OrderState prepareOrder() {
        System.out.println("❌ El pedido ya está preparado");
        return this;
    }

    @Override
    public OrderState deliverOrder() {
        System.out.println("🎁 Pedido entregado, disfruta tu KFC!");
        return new NoOrderState();
    }
}

// Clase Máquina de Pedidos de KFC
class KFCPOS {
    private OrderState state;

    public KFCPOS() {
        this.state = new NoOrderState();
    }

    public void placeOrder() {
        state = state.placeOrder();
    }

    public void prepareOrder() {
        state = state.prepareOrder();
    }

    public void deliverOrder() {
        state = state.deliverOrder();
    }
}


public class StateType {
    public static void main(String[] args) {
        KFCPOS kfcMachine = new KFCPOS();

        kfcMachine.prepareOrder();  // ❌ No puedes preparar un pedido que no existe
        kfcMachine.placeOrder();    // ✅ Pedido realizado en KFC
        kfcMachine.deliverOrder();  // ❌ No puedes entregar un pedido que no está listo
        kfcMachine.prepareOrder();  // 🍳 Pedido en preparación...
        kfcMachine.deliverOrder();  // 🎁 Pedido entregado, disfruta tu KFC!
    }
}
