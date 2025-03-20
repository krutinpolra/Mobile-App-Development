package com.seneca.map524.assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch

class NewsletterSubscriptionForm : Fragment() {

    @SuppressLint("UseSwitchCompatOrMaterialCode", "CutPasteId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newsletter_subscription_form, container, false)

        val nameEditText : EditText = view.findViewById(R.id.nameEditText)
        val emailEditText : EditText = view.findViewById(R.id.emailEditText)
        val genderRadioGroup : RadioGroup = view.findViewById(R.id.genderRadioGroup)
        val familySwitch : Switch = view.findViewById(R.id.familySwitch)
        val termsCheckBox : CheckBox = view.findViewById(R.id.termsCheckBox)
        val registerButton : Button = view.findViewById(R.id.registerButton)

        registerButton.setOnClickListener {

            val registrationBundle : Bundle = Bundle()

            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                view.findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Not Specified"
            }

            registrationBundle.putString("key_name", nameEditText.text.toString().trim())
            registrationBundle.putString("key_email", emailEditText.text.toString().trim())
            registrationBundle.putString("key_gender", gender)
            registrationBundle.putBoolean("key_family_switch", familySwitch.isChecked)
            registrationBundle.putBoolean("key_check_box", termsCheckBox.isChecked)
            requireActivity().supportFragmentManager.popBackStack()

            val thankYouFrg = ThankYouPage()
            thankYouFrg.arguments = registrationBundle
            // Navigate to ThankYouPage Fragment
            requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, thankYouFrg)
            .addToBackStack(null)
            .commit()
        }

        return view
    }

}