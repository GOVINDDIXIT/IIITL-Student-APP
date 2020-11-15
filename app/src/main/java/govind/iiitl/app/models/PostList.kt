package govind.iiitl.app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostList {
    @SerializedName("kind")
    @Expose
    var kind: String? = null

    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

    @SerializedName("etag")
    @Expose
    var etag: String? = null
}