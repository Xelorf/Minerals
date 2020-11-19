package sample.models;

public class Mineral {
    private long id;
    private String name;
    private String formula;
    private String color;
    private String lineColor;
    private String shine;
    private String transparency;
    private String hardness;
    private String density;

    public Mineral(long id, String name, String formula, String color, String line_color, String shine, String transparency, String hardness, String density) {
        this.id = id;
        this.name = name;
        this.formula = formula;
        this.color = color;
        this.lineColor = line_color;
        this.shine = shine;
        this.transparency = transparency;
        this.hardness = hardness;
        this.density = density;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public String getShine() {
        return shine;
    }

    public void setShine(String shine) {
        this.shine = shine;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }
}
