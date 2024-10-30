package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("FOOD_NAME") ?: "Food Name not available"
        val foodServings = intent.getStringExtra("FOOD_SERVINGS") ?: "Number of Servings not available"
        val orderingName = intent.getStringExtra("ORDERING_NAME") ?: "Ordering Name not available"
        val additionalNotes = intent.getStringExtra("ADDITIONAL_NOTES") ?: "Additional Notes not available"

        val foodNameTextView: TextView = findViewById(R.id.foodText)
        val foodServingsTextView: TextView = findViewById(R.id.ServingsText)
        val orderingNameTextView: TextView = findViewById(R.id.orderingName)
        val additionalNotesTextView: TextView = findViewById(R.id.NotesText)

        foodNameTextView.text = "Food Name: $foodName"
        foodServingsTextView.text = "Number of Servings: $foodServings"
        orderingNameTextView.text = "Ordering Name: $orderingName"
        additionalNotesTextView.text = "Additional Notes: $additionalNotes"

        val backButton: Button = findViewById(R.id.backtoMenu)
        backButton.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }

    }
}