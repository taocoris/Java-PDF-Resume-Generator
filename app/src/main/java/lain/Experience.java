package lain;
public class Experience {
    private final String companyName;
    private final String position;
    private final String duration;
    private final String description;

    public Experience(String companyName, String position, String duration, String description) {
        this.companyName = companyName;
        this.position = position;
        this.duration = duration;
        this.description = description;
    }

    public String getCompanyName() { return companyName; }
    public String getPosition() { return position; }
    public String getDuration() { return duration; }
    public String getDescription() { return description; }
}