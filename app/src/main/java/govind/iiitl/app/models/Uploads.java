package govind.iiitl.app.models;

public class Uploads {

    public String name;
    public String url;

    public Uploads(){
    }
    public Uploads(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
