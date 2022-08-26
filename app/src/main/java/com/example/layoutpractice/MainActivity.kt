package com.example.layoutpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnSubmit: Button
    private lateinit var etName: EditText
    private lateinit var etIDNumber: EditText
    private lateinit var rgrpGender: RadioGroup
    private lateinit var rgrpCourse: RadioGroup
    private lateinit var spnrYearLevel: Spinner

    private var gender = "Male"
    private var course = "BSCS"
    private var subjects = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSubmit = findViewById(R.id.btn_submit)
        etName = findViewById(R.id.etName)
        etIDNumber = findViewById(R.id.etIDNum)
        rgrpGender = findViewById(R.id.rgrp_gender)
        rgrpCourse = findViewById(R.id.rgrp_course)
        spnrYearLevel = findViewById(R.id.spnr_year_lvl)

        btnSubmit.setOnClickListener { showInformation() }

        rgrpGender.setOnCheckedChangeListener { _, i -> run {
            when (i) {
                R.id.rbtn_male -> gender = "Male"
                R.id.rbtn_female -> gender = "Female"
            }
        }}

        rgrpCourse.setOnCheckedChangeListener { _, i -> run {
            when (i) {
                R.id.rbtn_bscs -> course = "BCSC"
                R.id.rbtn_bsit -> course = "BCIT"
            }
        }}

    }

    private fun showInformation() {
        var message = ""
        message += "Name: ${etName.text}\n"
        message += "ID: ${etIDNumber.text}\n"
        message += "Gender: $gender\n"
        message += "Course: $course\n"
        message += "Year Level: ${getSpinnerValue()}\n"
        message += "Subjects: "
        message += if (subjects.isEmpty()) "No subjects" else "\n${subjects.joinToString("\n")}"

        doLongToast(message)
    }

    private fun getSpinnerValue(): String {
        var year = ""
        when (spnrYearLevel.selectedItem) {
            "First Year" -> year = "First Year"
            "Second Year" -> year = "Second Year"
            "Third Year" -> year = "Third Year"
            "Fourth Year" -> year = "Fourth Year"
        }
        return year
    }

    fun onCheckboxChecked(view: View?) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.cb_subject_1 -> {
                    if (checked) {
                        subjects.add(" - Web Development")
                    } else {
                        subjects.remove(" - Web Development")
                    }
                }
                R.id.cb_subject_2 -> {
                    if (checked) {
                        subjects.add(" - Computer Organization")
                    } else {
                        subjects.remove(" - Computer Organization")
                    }
                }
                R.id.cb_subject_3 -> {
                    if (checked) {
                        subjects.add(" - Programming 1")
                    } else {
                        subjects.remove(" - Programming 1")
                    }
                }
                R.id.cb_subject_4 -> {
                    if (checked) {
                        subjects.add(" - Data Structure")
                    } else {
                        subjects.remove(" - Data Structure")
                    }
                }
            }
        }
    }

    private fun doLongToast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }
}