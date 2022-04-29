import java.util.ArrayList;

/**
 * Class for PublishingRetailer entity
 */
public class PublishingRetailer {
    private int ID;
    private String name;
    private ArrayList<IPublishingArtifact> publishingArtifacts = new ArrayList<>();
    private ArrayList<Country> countries = new ArrayList<>();

    // Getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IPublishingArtifact> getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void setPublishingArtifacts(IPublishingArtifact publishingArtifact) {
        this.publishingArtifacts.add(publishingArtifact);
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(Country country) {
        this.countries.add(country);
    }
}
