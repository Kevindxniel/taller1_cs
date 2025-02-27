import java.util.Stack;


interface Command {
    void execute();
    void undo();
}


class Airplane {
    void takeOff() {
        System.out.println(" Avión despegando...");
    }

    void land() {
        System.out.println(" Avión aterrizando...");
    }

    void accelerate() {
        System.out.println(" Avión acelerando...");
    }

    void decelerate() {
        System.out.println(" Avión desacelerando...");
    }
}

// Comando para el despegue
class TakeOffCommand implements Command {
    private Airplane airplane;

    public TakeOffCommand(Airplane airplane) {
        this.airplane = airplane;
    }

    public void execute() {
        airplane.takeOff();
    }

    public void undo() {
        airplane.land();
    }
}

// Comando para el aterrizaje
class LandCommand implements Command {
    private Airplane airplane;

    public LandCommand(Airplane airplane) {
        this.airplane = airplane;
    }

    public void execute() {
        airplane.land();
    }

    public void undo() {
        airplane.takeOff();
    }
}

// Comando para acelerar
class AccelerateCommand implements Command {
    private Airplane airplane;

    public AccelerateCommand(Airplane airplane) {
        this.airplane = airplane;
    }

    public void execute() {
        airplane.accelerate();
    }

    public void undo() {
        airplane.decelerate();
    }
}

// Comando para desacelerar
class DecelerateCommand implements Command {
    private Airplane airplane;

    public DecelerateCommand(Airplane airplane) {
        this.airplane = airplane;
    }

    public void execute() {
        airplane.decelerate();
    }

    public void undo() {
        airplane.accelerate();
    }
}

// Control remoto para los comandos
class RemoteControl {
    private Stack<Command> commandStack = new Stack<>();

    public void addCommand(Command command) {
        System.out.println("Comando agregado: " + command.getClass().getSimpleName());
        commandStack.push(command);
    }

    public void executeCommands() {
        System.out.println("🔹 Ejecutando comandos...");
        for (Command command : commandStack) {
            command.execute();
        }
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            System.out.println("🔄 Deshaciendo último comando...");
            commandStack.pop().undo();
        } else {
            System.out.println("⚠ No hay comandos para deshacer.");
        }
    }

    public void undoCommands() {
        System.out.println("🔄 Deshaciendo todos los comandos...");
        while (!commandStack.isEmpty()) {
            commandStack.pop().undo();
        }
    }
}


public class commandtype  {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        RemoteControl remoteControl = new RemoteControl();

        Command takeOffCommand = new TakeOffCommand(airplane);
        Command landCommand = new LandCommand(airplane);
        Command accelerateCommand = new AccelerateCommand(airplane);
        Command decelerateCommand = new DecelerateCommand(airplane);

        remoteControl.addCommand(takeOffCommand);
        remoteControl.addCommand(accelerateCommand);
        remoteControl.addCommand(decelerateCommand);
        remoteControl.addCommand(landCommand);

        remoteControl.executeCommands();
        remoteControl.undoLastCommand();
        remoteControl.undoCommands();
    }
}




