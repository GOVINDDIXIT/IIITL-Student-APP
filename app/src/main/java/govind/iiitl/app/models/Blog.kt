package govind.iiitl.app.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Blog {
    @SerializedName("id")
    @Expose
    var id: String? = null
}