package Sprint05.task2;

enum Color {
    WHITE, RED, BLUE
}

enum Type {
    RARE, ORDINARY
}

public class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws ColorException, TypeException {
        this.name = name;

        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException argumentException) {
            throw new TypeException("Invalid value " + type + " for field type");
        }

        try {
            this.color = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException argumentException) {
            throw new ColorException("Invalid value " + color + " for field color");
        }

    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type +
                ", color: "
                + color +
                ", name: " + name + //"MyPlant"
                '}';
    }
}


class ColorException extends Exception {
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}
