from abc import ABC, abstractmethod

# Estado base
class OrderState(ABC):

    @abstractmethod
    def place_order(self):
        pass

    @abstractmethod
    def prepare_order(self):
        pass

    @abstractmethod
    def deliver_order(self):
        pass

# Estado: No hay pedido aún
class NoOrderState(OrderState):

    def place_order(self):
        print("✅ Pedido realizado en KFC")
        return OrderPlacedState()

    def prepare_order(self):
        print("❌ No puedes preparar un pedido que no existe")
        return self

    def deliver_order(self):
        print("❌ No puedes entregar un pedido que no existe")
        return self

# Estado: Pedido ha sido realizado
class OrderPlacedState(OrderState):

    def place_order(self):
        print("❌ Ya hiciste un pedido")
        return self

    def prepare_order(self):
        print("🍳 Pedido en preparación...")
        return OrderPreparedState()

    def deliver_order(self):
        print("❌ No puedes entregar un pedido que no está listo")
        return self

# Estado: Pedido preparado
class OrderPreparedState(OrderState):

    def place_order(self):
        print("❌ No puedes hacer otro pedido sin recoger el actual")
        return self

    def prepare_order(self):
        print("❌ El pedido ya está preparado")
        return self

    def deliver_order(self):
        print("🎁 Pedido entregado, disfruta tu KFC!")
        return NoOrderState()

# Clase Máquina de Pedidos de KFC
class KFCPOS:

    def __init__(self):
        self.state = NoOrderState()

    def place_order(self):
        self.state = self.state.place_order()

    def prepare_order(self):
        self.state = self.state.prepare_order()

    def deliver_order(self):
        self.state = self.state.deliver_order()

# Simulación de la máquina de pedidos de KFC
kfc_machine = KFCPOS()

kfc_machine.prepare_order()  # ❌ No puedes preparar un pedido que no existe
kfc_machine.place_order()    # ✅ Pedido realizado en KFC
kfc_machine.deliver_order()  # ❌ No puedes entregar un pedido que no está listo
kfc_machine.prepare_order()  # 🍳 Pedido en preparación...
kfc_machine.deliver_order()  # 🎁 Pedido entregado, disfruta tu KFC!
