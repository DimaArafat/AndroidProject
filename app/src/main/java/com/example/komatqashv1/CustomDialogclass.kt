package com.example.komatqashv1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class CustomDialogclass: DialogFragment(R.layout.fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    val cancelbt: Button = view.findViewById(R.id.cancelBT)
    val submitbt: Button = view.findViewById(R.id.submitBT)
    val radioGroup = view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
    cancelbt.setOnClickListener {
        dismiss()

    }
    submitbt.setOnClickListener {
     val selectedOption: Int = radioGroup.checkedRadioButtonId
     val radioButton = view.findViewById<RadioButton>(selectedOption)
     Toast.makeText(context,radioButton.text,Toast.LENGTH_LONG).show()
     dismiss()

    }
}
}