abstract class Notificador {
    public abstract void enviar(String mensaje);
}

class NotificadorEmail extends Notificador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviado email: " + mensaje);
    }
}

abstract class NotificadorDecorator extends Notificador {
    protected Notificador notificador;

    public NotificadorDecorator(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void enviar(String mensaje) {
        notificador.enviar(mensaje);
    }
}

class NotificadorSMS extends NotificadorDecorator {
    public NotificadorSMS(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviado SMS: " + mensaje);
    }
}

class NotificadorPush extends NotificadorDecorator {
    public NotificadorPush(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviado Notificación Push: " + mensaje);
    }
}

class NotificadorEmergencia extends NotificadorDecorator {
    public NotificadorEmergencia(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("⚠️ EMERGENCIA: " + mensaje + " ⚠️");
    }
}

public class decoratortype {
    public static void main(String[] args) {
        Notificador notificadorBasico = new NotificadorEmail();
        Notificador notificadorSMS = new NotificadorSMS(notificadorBasico);
        Notificador notificadorPush = new NotificadorPush(notificadorSMS);
        Notificador notificadorEmergencia = new NotificadorEmergencia(notificadorPush);
        
        System.out.println("Enviando notificación de emergencia con todos los canales:");
        notificadorEmergencia.enviar("¡Alerta! Se ha detectado una emergencia en su área.");
    }
}
