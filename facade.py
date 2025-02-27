class Cafetera:
    def encender(self):
        print("Cafetera encendida")

    def apagar(self):
        print("Cafetera apagada")

class MaquinaDeSnacks:
    def encender(self):
        print("Máquina de snacks encendida")

    def apagar(self):
        print("Máquina de snacks apagada")

class Licuadora:
    def encender(self):
        print("Licuadora encendida")

    def apagar(self):
        print("Licuadora apagada")

class CafeteriaInteligente:
    def __init__(self):
        self.cafetera = Cafetera()
        self.snacks = MaquinaDeSnacks()
        self.licuadora = Licuadora()

    def modo_desayuno(self):
        print("Activando Modo Desayuno ....")
        self.cafetera.encender()
        self.snacks.apagar()
        self.licuadora.encender()

    def modo_merienda(self):
        print("Activando Modo Merienda ....")
        self.cafetera.apagar()
        self.snacks.encender()
        self.licuadora.encender()

# Simulación del sistema
cafeteria = CafeteriaInteligente()
cafeteria.modo_desayuno()  
cafeteria.modo_merienda()   