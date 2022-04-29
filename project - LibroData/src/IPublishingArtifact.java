/**
 * Class for IPublishingArtifact interface
 */
public interface IPublishingArtifact {
    // Getters and setters
    public void setID(int ID);
    public int getID();

    public void setName(String Name);
    public String getName();

    // Publish method
    public String Publish();
}
