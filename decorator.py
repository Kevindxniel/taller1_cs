from abc import ABC, abstractmethod

class Notificador(ABC):
    @abstractmethod
    def enviar(self, mensaje):
        pass

class NotificadorEmail(Notificador):
    def enviar(self, mensaje):
        print(f"Enviado email: {mensaje}")

class NotificadorDecorator(Notificador):
    def __init__(self, notificador):
        self.notificador = notificador

    def enviar(self, mensaje):
        self.notificador.enviar(mensaje)

class NotificadorSMS(NotificadorDecorator):
    def enviar(self, mensaje):
        super().enviar(mensaje)
        print(f"Enviado SMS: {mensaje}")

class NotificadorPush(NotificadorDecorator):
    def enviar(self, mensaje):
        super().enviar(mensaje)
        print(f"Enviado Notificación Push: {mensaje}")

class NotificadorEmergencia(NotificadorDecorator):
    def enviar(self, mensaje):
        super().enviar(mensaje)
        print(f"⚠️ EMERGENCIA: {mensaje} ⚠️")

if __name__ == "__main__":
    notificador_basico = NotificadorEmail()
    notificador_sms = NotificadorSMS(notificador_basico)
    notificador_push = NotificadorPush(notificador_sms)
    notificador_emergencia = NotificadorEmergencia(notificador_push)
    
    print("Enviando notificación de emergencia con todos los canales:")
    notificador_emergencia.enviar("¡Alerta! Se ha detectado una emergencia en su área.")
