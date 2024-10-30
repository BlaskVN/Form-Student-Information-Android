package com.blask.formstudentinfomation

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etMSSV: EditText
    private lateinit var etName: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var calendarView: CalendarView
    private lateinit var btnShowCalendar: Button
    private lateinit var spinnerProvince: Spinner
    private lateinit var spinnerDistrict: Spinner
    private lateinit var spinnerWard: Spinner
    private lateinit var cbSports: CheckBox
    private lateinit var cbMovies: CheckBox
    private lateinit var cbMusic: CheckBox
    private lateinit var cbAgree: CheckBox
    private lateinit var btnSubmit: Button
    private lateinit var tvErrorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các view từ XML
        etMSSV = findViewById(R.id.etMSSV)
        etName = findViewById(R.id.etName)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        calendarView = findViewById(R.id.calendarView)
        btnShowCalendar = findViewById(R.id.btnShowCalendar)
        spinnerProvince = findViewById(R.id.spinnerProvince)
        spinnerDistrict = findViewById(R.id.spinnerDistrict)
        spinnerWard = findViewById(R.id.spinnerWard)
        cbSports = findViewById(R.id.cbSports)
        cbMovies = findViewById(R.id.cbMovies)
        cbMusic = findViewById(R.id.cbMusic)
        cbAgree = findViewById(R.id.cbAgree)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvErrorMessage = findViewById(R.id.tvErrorMessage)

        // Hiển thị/ẩn CalendarView khi nhấn nút
        btnShowCalendar.setOnClickListener {
            if (calendarView.visibility == View.GONE) {
                calendarView.visibility = View.VISIBLE
            } else {
                calendarView.visibility = View.GONE
            }
        }

        // Xử lý khi nhấn nút Submit
        btnSubmit.setOnClickListener {
            validateForm()
        }
    }

    // Hàm kiểm tra form nhập
    private fun validateForm() {
        val mssv = etMSSV.text.toString().trim()
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val genderId = radioGroupGender.checkedRadioButtonId
        val agree = cbAgree.isChecked

        if (mssv.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty() || genderId == -1 || !agree) {
            tvErrorMessage.text = "Vui lòng điền đầy đủ thông tin và đồng ý với các điều khoản."
            tvErrorMessage.visibility = View.VISIBLE
        } else {
            tvErrorMessage.visibility = View.GONE
            Toast.makeText(this, "Thông tin đã được gửi!", Toast.LENGTH_SHORT).show()
            // Thực hiện các xử lý tiếp theo nếu cần
        }
    }
}
