package govind.iiitl.app.models;

import androidx.annotation.Keep;

@Keep
public class QuestionPaper {
    public String name;
    public String url;

    public QuestionPaper(String name, String url) {
        this.name = name;
        this.url = url;
    }
    public QuestionPaper() {

    }
}
