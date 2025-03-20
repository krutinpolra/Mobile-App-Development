package com.seneca.map524.assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ThankYouPage : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_thank_you_page, container, false)

        val thankYouTextView : TextView = view.findViewById(R.id.thankYouTextView)
        val detailsTextView : TextView = view.findViewById(R.id.detailsTextView)
        val goToActivityButton : TextView = view.findViewById(R.id.goToActivityButton)

        val receivedName = arguments?.getString("key_name") ?: "N/A"
        val receivedEmail = arguments?.getString("key_email") ?: "N/A"
        val receivedGender = arguments?.getString("key_gender") ?: "Not Specified"
        val receivedFamilySwitch = arguments?.getBoolean("key_family_switch") ?: false
        val receivedCheckBox = arguments?.getBoolean("key_check_box") ?: false

        // Formatting details text with bold labels using HTML
        val formattedDetails = """
            <b>Name:</b> $receivedName<br>
            <b>Email:</b> $receivedEmail<br>
            <b>Gender:</b> $receivedGender<br>
            <b>Family Events Opt-In:</b> ${if (receivedFamilySwitch) "Yes" else "No"}<br>
            <b>Agreed to Terms:</b> ${if (receivedCheckBox) "Yes" else "No"}
        """.trimIndent()

        detailsTextView.text = Html.fromHtml(formattedDetails, Html.FROM_HTML_MODE_LEGACY)
        goToActivityButton.setOnClickListener {
            val intent = Intent(requireContext(), ActivityTwo::class.java).apply {
                putExtra("userName", receivedName)
            }
            startActivity(intent)
        }
        return view
    }
}