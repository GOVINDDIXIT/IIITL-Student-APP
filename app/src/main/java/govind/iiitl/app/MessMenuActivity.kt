package govind.iiitl.app

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView

class MessMenuActivity : AppCompatActivity() {

    lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_mess_menu)
        pdfView = findViewById(R.id.pdf_viewer)
        if (intent != null)
        {
            val viewType = intent.getStringExtra("ViewType")
            if (viewType != null || TextUtils.isEmpty(viewType))
            {
                if (viewType == "assets")
                {
                    pdfView.fromAsset("MessMenu.pdf")
                            .password(null)//enter password if PDF is password protected
                            .defaultPage(0)//set the default page
                            .enableSwipe(true)//enable the swipe to change page
                            .swipeHorizontal(false)//set horizontal swipe to false
                            .enableDoubletap(true)//double tap to zoom
                            .onDraw { canvas, pageWidth, pageHeight, displayedPage -> }
                            .onDrawAll { canvas, pageWidth, pageHeight, displayedPage -> }
                            .onPageError { page, t -> Toast.makeText(this@MessMenuActivity, "Error", Toast.LENGTH_LONG).show() }
                            .onPageChange { page, pageCount -> }
                            .onTap { true }
                            .onRender { nbPages, pageWidth, pageHeight -> pdfView.fitToWidth() }
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.WHITE)
                            .load()
                }
            }
        }
    }
}
