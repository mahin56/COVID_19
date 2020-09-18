package com.android.covid_19.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.covid_19.R
import com.android.covid_19.adapter.COVID_adapter
import com.android.covid_19.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var fromdateandtime:Calendar
    lateinit var todateandtime:Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)
         viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.mainViewModel = viewModel
        binding.c1
        fromdateandtime = GregorianCalendar()
        todateandtime = GregorianCalendar()
        binding.c3.setOnClickListener({showfromTimePicker(this)})
        binding.c1.setOnClickListener({showfromDatePicker(this)})
        binding.c2.setOnClickListener({showtoDatePicker(this)})
        binding.c4.setOnClickListener({showtoTimePicker(this)})
binding.but.setOnClickListener{
val linearLayout:LinearLayoutManager = LinearLayoutManager(binding.root.context)
    binding.rv.layoutManager = linearLayout
    val adapter = COVID_adapter()
    viewModel.get( fromdateandtime,todateandtime).observe(this, {
  if (it !=null){
      adapter.setCOVIDcases(it)

  }
    })
    binding.rv.adapter=adapter
}
    }

    private fun showfromDatePicker(context: Context) {
        val c = Calendar.getInstance()
        val year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        val dpd = DatePickerDialog(
            context,
            { datePicker: DatePicker?, pickedYear: Int, pickedMonth: Int, pickedDay: Int ->
                fromdateandtime.set(pickedYear, pickedMonth, pickedDay)
                val format = SimpleDateFormat("yyyy-MM-dd")
                val date = format.format(fromdateandtime.getTimeInMillis())
                binding.fromPickDate.setText(date)
            }, year, month, day
        )
        dpd.show()
    }

    private fun showfromTimePicker(context: Context) {
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
        val minute = mcurrentTime[Calendar.MINUTE]
        val timePickerDialog = TimePickerDialog(
            context,
            { timePicker: TimePicker?, pickedHour: Int, pickedMinute: Int ->
                fromdateandtime.set(Calendar.HOUR_OF_DAY, pickedHour)
                fromdateandtime.set(Calendar.MINUTE, pickedMinute)
                val format = SimpleDateFormat("HH:mm")
                val time = format.format(fromdateandtime.getTimeInMillis())
                binding.fromPickTime.setText(time)
            }, hour, minute, false
        )
        timePickerDialog.show()

    }
    private fun showtoDatePicker(context: Context) {
        val c = Calendar.getInstance()
        val year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        val dpd = DatePickerDialog(
            context,
            { datePicker: DatePicker?, pickedYear: Int, pickedMonth: Int, pickedDay: Int ->
                todateandtime.set(pickedYear, pickedMonth, pickedDay)
                val format = SimpleDateFormat("yyyy-MM-dd")
                val date = format.format(todateandtime.getTimeInMillis())
                binding.toPickDate.setText(date)
            }, year, month, day
        )
        dpd.show()
    }

    private fun showtoTimePicker(context: Context) {
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
        val minute = mcurrentTime[Calendar.MINUTE]
        val timePickerDialog = TimePickerDialog(
            context,
            { timePicker: TimePicker?, pickedHour: Int, pickedMinute: Int ->
                todateandtime.set(Calendar.HOUR_OF_DAY, pickedHour)
                todateandtime.set(Calendar.MINUTE, pickedMinute)
                val format = SimpleDateFormat("HH:mm")
                val time = format.format(todateandtime.getTimeInMillis())
                binding.toPickTime.setText(time)
            }, hour, minute, false
        )
        timePickerDialog.show()

    }

}