from abc import ABC, abstractmethod 

# Interfaz Mediator
class StockExchangeMediator(ABC):
    @abstractmethod
    def send(self, stock, amount, sender):
        pass

# Mediador concreto: Bolsa de Valores
class StockMarket(StockExchangeMediator):
    def __init__(self):
        self.investors = []

    def add_investor(self, investor):
        self.investors.append(investor)

    def send(self, stock, amount, sender):
        for investor in self.investors:
            if investor != sender:
                investor.receive(stock, amount)

# Clase Inversor
class Investor:
    def __init__(self, name, market):
        self.name = name
        self.market = market
        self.market.add_investor(self)

    def buy(self, stock, amount):
        print(f"💰 {self.name} compra {amount} acciones de {stock}.")
        self.market.send(stock, amount, self)

    def sell(self, stock, amount):
        print(f"📉 {self.name} vende {amount} acciones de {stock}.")
        self.market.send(stock, amount, self)

    def receive(self, stock, amount):
        print(f"📢 {self.name} se entera de una transacción: {amount} acciones de {stock} fueron negociadas.")

# Simulación de inversores en la bolsa de valores
stock_market = StockMarket()
investor1 = Investor("Carlos", stock_market)
investor2 = Investor("Ana", stock_market)
investor3 = Investor("Luis", stock_market)

investor1.buy("Tesla", 10)
investor2.sell("Apple", 5)
investor3.buy("Amazon", 15)
