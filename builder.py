class EquipmentKit:
    def __init__(self):
        self.items = []


    def add(self, item):
        self.items.append(item)
    
    def get_total_cost(self):
        return sum(item.get_cost() for item in self.items)
    
    def __str__(self):
        text = "Equipment Kit:\n"
        text += "\n".join(str(item) for item in self.items)
        text += f"\nTotal Cost: {self.get_total_cost()} gold"
        return text
    
class Item:
    def __init__(self, name, cost):
        self.name = name
        self.cost = cost
    
    def get_cost(self):
        return self.cost
    
    def __str__(self):
        return f"{self.name}: {self.cost} gold"
    
class EquipmentKitBuilder:
    def __init__(self):
        self.kit = EquipmentKit()

    def add_weapon(self):
        pass

    def add_armor(self):
        pass

    def add_potion(self):
        pass

    def add_accessory(self):
        pass

    def reset(self):
        self.kit = EquipmentKit()

    def get_kit(self):
        return self.kit
    
class WarriorKitBuilder(EquipmentKitBuilder):
    
    def add_weapon(self):
        self.kit.add(Item("Espada de acero", 150))
    
    def add_armor(self):
        self.kit.add(Item("Armadura de placas", 200))

    def add_potion(self):
        self.kit.add(Item("Poción de vida", 50))

    def add_accessory(self):
        self.kit.add(Item("Anillo de fuerza", 100))

class MageKitBuilder(EquipmentKitBuilder):
    
    def add_weapon(self):
        self.kit.add(Item("Báculo mágico", 180))
    
    def add_armor(self):
        self.kit.add(Item("Túnica arcana", 120))

    def add_potion(self):
        self.kit.add(Item("Poción de maná", 50))

    def add_accessory(self):
        self.kit.add(Item("Amuleto de sabiduría", 130))

class EquipmentDirector: 
    def __init__(self, builder):
        self.builder = builder
    
    def construct_full_kit(self):
        self.builder.reset()
        self.builder.add_weapon()
        self.builder.add_armor()
        self.builder.add_potion()
        self.builder.add_accessory()

    def construct_basic_kit(self):
        self.builder.reset()
        self.builder.add_weapon()
        self.builder.add_potion()

warrior_builder = WarriorKitBuilder()
warrior_director = EquipmentDirector(warrior_builder)
warrior_director.construct_full_kit()
print(warrior_builder.get_kit())

mage_builder = MageKitBuilder()
mage_director = EquipmentDirector(mage_builder)
mage_director.construct_full_kit()
print(mage_builder.get_kit())
