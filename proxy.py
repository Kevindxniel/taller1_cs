from abc import ABC, abstractmethod

class CuentaBancaria(ABC):
    @abstractmethod
    def ver_saldo(self):
        pass

class CuentaReal(CuentaBancaria):
    def __init__(self, titular, saldo):
        self.titular = titular
        self.saldo = saldo

    def ver_saldo(self):
        print(f"El saldo de la cuenta de {self.titular} es: ${self.saldo}")

class ProxyCuentaBancaria(CuentaBancaria):
    def __init__(self, titular, saldo, usuario):
        self.titular = titular
        self.saldo = saldo
        self.usuario = usuario
        self.cuenta_real = None

    def ver_saldo(self):
        if self.usuario == self.titular:
            if not self.cuenta_real:
                self.cuenta_real = CuentaReal(self.titular, self.saldo)
            self.cuenta_real.ver_saldo()
        else:
            print(f"Acceso denegado. {self.usuario} no tiene permiso para ver esta cuenta.")

# Prueba del proxy
cuenta1 = ProxyCuentaBancaria("Carlos", 5000, "Carlos")
cuenta1.ver_saldo()

cuenta2 = ProxyCuentaBancaria("Carlos", 5000, "Juan")
cuenta2.ver_saldo()