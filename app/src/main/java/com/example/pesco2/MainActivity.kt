package com.example.pesco2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            myInfoDialog()
        }
        goBtn.setOnClickListener {
            search()
        }

// A separate thread to perform async function that required time

    }
    fun search(){

        Thread {
            var result: MutableList<String> = pesco(etxt.text.toString())
            runOnUiThread {
                try {
                    address.setText(result[0])
                    ref.setText(result[1])
                    withDueDate.setText(result[2])
                    afterDueDate.setText(result[3])
                    lpSurcharge.setText(result[4])
                    dueDate.setText(result[5])
                    arrears.setText(result[6])
                    units.setText(result[7])
                    currentBill.setText(result[8])
                } catch (e: Exception) {
                    resetAll()
                }
            }
        }.start()
    }

    // A Small intro Dailogue box
    fun myInfoDialog() {
        AlertDialog.Builder(this) //set icon
            .setIcon(android.R.drawable.ic_dialog_info) //set title
            .setTitle("Developer Info") //set message
            .setMessage("Software on Demand\nEmail : imran1102@gmail.com") //set positive button
            .setPositiveButton("OK") { dialogInterface, i -> //set what would happen when positive button is clicked
            } //set negative button
//                .setNegativeButton("No") { dialogInterface, i -> //set what should happen when negative button is clicked
//                    Toast.makeText(applicationContext, "Nothing Happened", Toast.LENGTH_LONG).show()
//                }
            .show()

    }

    fun resetAll(){
        address.setText("Check Internet / Server Down")
        ref.setText("")
        withDueDate.setText("")
        afterDueDate.setText("")
        lpSurcharge.setText("")
        dueDate.setText("")
        arrears.setText("")
        units.setText("")
        currentBill.setText("")
    }
}