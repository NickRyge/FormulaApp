package com.example.formulaez

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import viewmodels.FormulaViewModel

class FormulaDescriptionFragment : Fragment() {

    private val formulaViewModel: FormulaViewModel by activityViewModels()
    private var currentPosition = -1
    private lateinit var formula_description: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        // Inflate the layout for this fragment
        formula_description = inflater.inflate(R.layout.formula_desciption_view, container, false) as TextView
        return formula_description
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        formulaViewModel.getClickedFormula().observe(viewLifecycleOwner,{formula_description.text = formulaViewModel.getClickedFormula(). ,currentPosition = })
    }
}