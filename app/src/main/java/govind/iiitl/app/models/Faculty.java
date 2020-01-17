package govind.iiitl.app.models;

import com.google.gson.annotations.SerializedName;

public class Faculty {
    @SerializedName("ResearchAreas")
    private String ResearchAreas;

    @SerializedName("name")
    private String name;

    @SerializedName("imgSrc")
    private String imgSrc;

    @SerializedName("description")
    private String description;

    public Faculty(String name, String imgSrc, String description, String researchAreas) {
        this.name = name;
        this.imgSrc = imgSrc;
        this.description = description;
        ResearchAreas = researchAreas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResearchAreas() {
        return ResearchAreas;
    }

    public void setResearchAreas(String researchAreas) {
        ResearchAreas = researchAreas;
    }


}
