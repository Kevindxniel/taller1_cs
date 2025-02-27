// Clase abstracta Manga con métodos comunes
abstract class Manga implements Cloneable {
    protected String title;
    protected String content;

    public Manga(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public Manga clone() {
        try {
            return (Manga) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Content: " + content;
    }
}

// Clase ShonenManga que extiende Manga
class ShonenManga extends Manga {
    private final String protagonist;

    public ShonenManga(String title, String content, String protagonist) {
        super(title, content);
        this.protagonist = protagonist;
    }

    @Override
    public String toString() {
        return super.toString() + ", Protagonist: " + protagonist;
    }
}


class SeinenManga extends Manga {
    private final String themes;

    public SeinenManga(String title, String content, String themes) {
        super(title, content);
        this.themes = themes;
    }

    @Override
    public String toString() {
        return super.toString() + ", Themes: " + themes;
    }
}


public class prototype_Type {
    public static void main(String[] args) {
        // Crear instancias de ShonenManga y SeinenManga
        ShonenManga naruto = new ShonenManga("Naruto", "Action-packed story", "Naruto Uzumaki");
        ShonenManga dragonBall = new ShonenManga("Dragon Ball", "Epic battles", "Goku");

        SeinenManga berserk = new SeinenManga("Berserk", "Dark and gritty", "Dark Fantasy, Revenge");
        SeinenManga monster = new SeinenManga("Monster", "Psychological thriller", "Thriller, Mystery");

        // Imprimir información de las instancias
        System.out.println(naruto.clone());
        System.out.println(dragonBall.clone());
        System.out.println(berserk.clone());
        System.out.println(monster.clone());
    }
}