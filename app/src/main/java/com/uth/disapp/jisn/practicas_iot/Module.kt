package com.uth.disapp.jisn.practicas_iot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


class Module : Fragment() {
    private var selectedOption: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_module, container, false)
        val opcion = view.findViewById<Spinner>(R.id.devices)

        if (opcion != null) {

            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.options)
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            opcion.adapter = adapter

            opcion.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    selectedOption = position
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }

            return view
        }

        return null
    }
}
