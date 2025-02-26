import copy
from abc import ABC, abstractmethod

class Manga(ABC):

    def __init__(self, title, content):
        self.title = title
        self.content = content
    
    @abstractmethod
    def clone(self):
        pass

    def __str__(self):
        return f"Title: {self.title}, Content: {self.content}"
    
class ShonenManga(Manga):

    def __init__(self, title, content, protagonist):
        super().__init__(title, content)
        self.protagonist = protagonist

    def clone(self):
        return copy.deepcopy(self)
    
    def __str__(self):
        return super().__str__() + f", Protagonist: {self.protagonist}"
    
class SeinenManga(Manga):
    def __init__(self, title, content, themes):
        super().__init__(title, content)
        self.themes = themes

    def clone(self):
        return copy.deepcopy(self)
    
    def __str__(self):
        return super().__str__() + f", Themes: {self.themes}"
    
shonen_prototype = ShonenManga("Título Shonen", "Historia llena de acción", "Héroe")
seinen_prototype = SeinenManga("Título Seinen", "Narrativa madura", "Psicológico, Drama")


shonen1 = shonen_prototype.clone()
shonen1.title = "Naruto"
shonen1.protagonist = "Naruto Uzumaki"

shonen2 = shonen_prototype.clone()
shonen2.title = "Dragon Ball"
shonen2.protagonist = "Goku"

print(shonen1)
print(shonen2)

seinen1 = seinen_prototype.clone()
seinen1.title = "Berserk"
seinen1.themes = "Dark Fantasy, Revenge"

seinen2 = seinen_prototype.clone()
seinen2.title = "Monster"
seinen2.themes = "Thriller, Mystery"

print(seinen1)
print(seinen2)
