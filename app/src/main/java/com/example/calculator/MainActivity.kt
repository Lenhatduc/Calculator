package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var textResult: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0
    var calculationResult: Int = 0  // Đổi tên biến kết quả

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.textView2)

        // Khởi tạo các button
        findViewById<Button>(R.id.button).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.button10).setOnClickListener(this)
        findViewById<Button>(R.id.button11).setOnClickListener(this)
        findViewById<Button>(R.id.button13).setOnClickListener(this)
        findViewById<Button>(R.id.button14).setOnClickListener(this)
        findViewById<Button>(R.id.button15).setOnClickListener(this)
        findViewById<Button>(R.id.button18).setOnClickListener(this)
        findViewById<Button>(R.id.button16).setOnClickListener(this)
        findViewById<Button>(R.id.button12).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button20).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        when (id) {
            R.id.button -> remove()
            R.id.button18 -> addDigit(0)
            R.id.button13 -> addDigit(1)
            R.id.button14 -> addDigit(2)
            R.id.button15 -> addDigit(3)
            R.id.button11 -> addDigit(6)
            R.id.button10 -> addDigit(5)
            R.id.button9 -> addDigit(4)
            R.id.button7 -> addDigit(9)
            R.id.button6 -> addDigit(8)
            R.id.button5 -> addDigit(7)
            R.id.button16 -> { op = 1; state = 2 }
            R.id.button12 -> { op = 2; state = 2 }
            R.id.button8 -> { op = 3; state = 2 }
            R.id.button4 -> { op = 4; state = 2 }
            R.id.button20 -> calculateResult()
        }
    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            textResult.text = "$op1"
        } else {
            op2 = op2 * 10 + c
            textResult.text = "$op2"
        }
    }

    fun remove() {
        textResult.text = "0"
        op1 = 0
        op2 = 0
        state = 1
    }

    fun calculateResult() {
        if (state == 2) {
            calculationResult = when (op) {
                1 -> op1 + op2
                2 -> op1 - op2
                3 -> op1 * op2
                4 -> if (op2 != 0) op1 / op2 else 0 // Tránh chia cho 0
                else -> 0
            }
            textResult.text = "$calculationResult"
            op1 = calculationResult  // Lưu kết quả vào op1 để thực hiện phép tính tiếp theo
            op2 = 0  // Reset op2
            state = 1  // Chuyển về trạng thái nhập số đầu tiên
        }

    }

    fun resetCalculator() {
        state = 1
        op1 = 0
        op2 = 0
        op = 0
        calculationResult = 0  // Reset cả kết quả
    }
}