package govind.iiitl.app

import govind.iiitl.app.models.PostList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

internal object BloggerAPI {
    private const val key = "AIzaSyBpfJGq4L8xoKsue_jhXHtWLYlvwcMoREs"
    private const val url = "https://www.googleapis.com/blogger/v3/blogs/5429117628766351084/posts/"
    private var postService: PostService? = null
    @JvmStatic
    val service: PostService?
        get() {
            if (postService == null) {
                val retrofit = Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                postService = retrofit.create(PostService::class.java)
            }
            return postService
        }

    interface PostService {
        @get:GET("?key=$key")
        val postList: Call<PostList?>?
    }
}