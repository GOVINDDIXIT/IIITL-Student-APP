package govind.iiitl.app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Author {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("displayName")
    @Expose
    var displayName: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("image")
    @Expose
    var image: Image? = null
}