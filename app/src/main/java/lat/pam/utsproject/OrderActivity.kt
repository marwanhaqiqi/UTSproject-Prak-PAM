package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("FOOD_NAME")

        val foodNameTextView: TextView = findViewById(R.id.etFoodName)
        val servingsEditText: EditText = findViewById(R.id.etServings)
        val orderingNameEditText: EditText = findViewById(R.id.etName)
        val additionalNotesEditText: EditText = findViewById(R.id.etNotes)
        val placeOrderButton: Button = findViewById(R.id.btnOrder)

        foodNameTextView.text = foodName ?: "Nama makanan tidak tersedia"

        placeOrderButton.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("FOOD_NAME", foodNameTextView.text.toString())
            intent.putExtra("FOOD_SERVINGS", servingsEditText.text.toString())
            intent.putExtra("ORDERING_NAME", orderingNameEditText.text.toString())
            intent.putExtra("ADDITIONAL_NOTES", additionalNotesEditText.text.toString())
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}