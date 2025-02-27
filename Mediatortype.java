import java.util.ArrayList;
import java.util.List;

// Interfaz Mediator
interface StockExchangeMediator {
    void send(String stock, int amount, Investor sender);
        void addInvestor(Investor investor);
    }
    
    // Mediador concreto: Bolsa de Valores
    class StockMarket implements StockExchangeMediator {
        private List<Investor> investors = new ArrayList<>();
    
        public void addInvestor(Investor investor) {
            investors.add(investor);
        }
    
        public void removeInvestor(Investor investor) {
            investors.remove(investor);
        }
    
        @Override
        public void send(String stock, int amount, Investor sender) {
            for (Investor investor : investors) {
                if (investor != sender) {
                    investor.receive(stock, amount);
                }
            }
        }
    }
    
    // Clase Inversor
    class Investor {
        private String name;
        private StockExchangeMediator market;
    
        public Investor(String name, StockExchangeMediator market) {
            this.name = name;
            this.market = market;
        }
    
        public String getName() {
            return name;
        }
    
        public StockExchangeMediator getMarket() {
            return market;
        }
    
        public void joinMarket() {
            market.addInvestor(this);
    }

    public void buy(String stock, int amount) {
        System.out.println(" " + name + " compra " + amount + " acciones de " + stock + ".");
        market.send(stock, amount, this);
    }

    public void sell(String stock, int amount) {
        System.out.println(" " + name + " vende " + amount + " acciones de " + stock + ".");
        market.send(stock, amount, this);
    }

    public void receive(String stock, int amount) {
        System.out.println(" " + name + " se entera de una transacción: " + amount + " acciones de " + stock + " fueron negociadas.");
    }
}

// Programa principal
public class Mediatortype {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Investor investor1 = new Investor("Carlos", stockMarket);
        Investor investor2 = new Investor("Ana", stockMarket);
        Investor investor3 = new Investor("Luis", stockMarket);

        investor1.joinMarket();
        investor2.joinMarket();
        investor3.joinMarket();

        investor1.buy("Tesla", 10);
        investor2.sell("Apple", 5);
        investor3.buy("Amazon", 15);
    }
}