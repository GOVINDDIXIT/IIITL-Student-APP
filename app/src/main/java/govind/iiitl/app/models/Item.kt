package govind.iiitl.app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("kind")
    @Expose
    var kind: String? = null

    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("blog")
    @Expose
    var blog: Blog? = null

    @SerializedName("published")
    @Expose
    var published: String? = null

    @SerializedName("updated")
    @Expose
    var updated: String? = null

    @SerializedName("etag")
    @Expose
    var etag: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("selfLink")
    @Expose
    var selfLink: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null

    @SerializedName("author")
    @Expose
    var author: Author? = null

    @SerializedName("replies")
    @Expose
    var replies: Replies? = null

    @SerializedName("labels")
    @Expose
    var labels: List<String>? = null
}