class TipoFantasma:
    def __init__(self, nombre, textura, sonido):
        self.nombre = nombre
        self.textura = textura
        self.sonido = sonido

    def mostrar(self, x, y):
        print(f"Mostrando {self.nombre} en la posición ({x}, {y}), con textura {self.textura} y sonido {self.sonido}")


class FabricaFantasmas:
    _tipos = {}

    @staticmethod
    def obtener_tipo_fantasma(nombre, textura, sonido):
        if nombre not in FabricaFantasmas._tipos:
            print(f"Creando nuevo tipo de fantasma: {nombre}")
            FabricaFantasmas._tipos[nombre] = TipoFantasma(nombre, textura, sonido)
        return FabricaFantasmas._tipos[nombre]


class Fantasma:
    def __init__(self, tipo, x, y):
        self.tipo = tipo
        self.x = x
        self.y = y

    def dibujar(self):
        self.tipo.mostrar(self.x, self.y)


if __name__ == "__main__":
    tipo_fantasma_etereo = FabricaFantasmas.obtener_tipo_fantasma("Fantasma Etéreo", "etereo.png", "susurro_etereo.mp3")
    tipo_fantasma_sombrio = FabricaFantasmas.obtener_tipo_fantasma("Fantasma Sombrío", "sombrio.png", "lamento_sombrio.mp3")

    fantasmas = [
        Fantasma(tipo_fantasma_etereo, 10, 20),
        Fantasma(tipo_fantasma_etereo, 50, 20),
        Fantasma(tipo_fantasma_sombrio, -10, 20),
        Fantasma(tipo_fantasma_sombrio, 0, 0),
    ]

    for fantasma in fantasmas:
        fantasma.dibujar()
