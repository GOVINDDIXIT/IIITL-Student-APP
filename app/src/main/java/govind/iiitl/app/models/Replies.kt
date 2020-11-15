package govind.iiitl.app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Replies {
    @SerializedName("totalItems")
    @Expose
    var totalItems: String? = null

    @SerializedName("selfLink")
    @Expose
    var selfLink: String? = null
}