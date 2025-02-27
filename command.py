from abc import ABC, abstractmethod

class Command(ABC):
    @abstractmethod
    def execute(self):
        pass

    @abstractmethod
    def undo(self):
        pass

class Airplane:
    def take_off(self):
        print("Avión despegando...")
    
    def land(self):
        print("Avión aterrizando...")
    
    def accelerate(self):
        print("Avión acelerando...")
    
    def decelerate(self):
        print("Avión desacelerando...")

class TakeOffCommand(Command):
    def __init__(self, airplane):
        self.airplane = airplane
    
    def execute(self):
        self.airplane.take_off()
    
    def undo(self):
        self.airplane.land()

class LandCommand(Command):
    def __init__(self, airplane):
        self.airplane = airplane
    
    def execute(self):
        self.airplane.land()
    
    def undo(self):
        self.airplane.take_off()

class AccelerateCommand(Command):
    def __init__(self, airplane):
        self.airplane = airplane
    
    def execute(self):
        self.airplane.accelerate()
    
    def undo(self):
        self.airplane.decelerate()

class DecelerateCommand(Command):
    def __init__(self, airplane):
        self.airplane = airplane
    
    def execute(self):
        self.airplane.decelerate()
    
    def undo(self):
        self.airplane.accelerate()

class RemoteControl:
    def __init__(self):
        self.commands = []
    
    def add_command(self, command):
        print("Comando Agregado: " + command.__class__.__name__)
        self.commands.append(command)

    def execute_commands(self):
        print("Ejecutando Comandos...")
        for command in self.commands:
            command.execute()
    
    def undo_last_command(self):
        if self.commands:
            print("Deshaciendo Último Comando...")
            self.commands.pop().undo()
    
    def undo_commands(self):
        print("Deshaciendo Comandos...")
        for command in reversed(self.commands):
            command.undo()
        self.commands.clear()


airplane = Airplane()
remote_control = RemoteControl()

take_off_command = TakeOffCommand(airplane)
land_command = LandCommand(airplane)
accelerate_command = AccelerateCommand(airplane)
deccelerate_command = DecelerateCommand(airplane)

remote_control.add_command(take_off_command)
remote_control.add_command(accelerate_command)
remote_control.add_command(deccelerate_command)
remote_control.add_command(land_command)

remote_control.execute_commands()
remote_control.undo_last_command()
remote_control.undo_commands()
