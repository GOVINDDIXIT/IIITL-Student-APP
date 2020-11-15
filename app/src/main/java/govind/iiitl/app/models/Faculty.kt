package govind.iiitl.app.models

import com.google.gson.annotations.SerializedName

class Faculty(
        @field:SerializedName("name") var name: String,
        @field:SerializedName("imgSrc") var imgSrc: String,
        @field:SerializedName("description") var description: String,
        @field:SerializedName("ResearchAreas") var researchAreas: String
)