package com.example.formulaez

import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import viewmodels.FormulaViewModel

class FormulaListFragment : ListFragment() {

    private val formulaViewModel: FormulaViewModel by activityViewModels()
    val layout = android.R.layout.simple_list_item_activated_1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = ArrayAdapter(requireActivity(), layout, formulaViewModel.getFormulaHeadlines(""))
        }


    override fun onStart() {
        super.onStart()
        //hello

        if (parentFragmentManager.findFragmentById(R.id.description_fragment) != null) {
           listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {



        formulaViewModel.setClickedFormula(position)
        listView.setItemChecked(position, true)

    }

    public fun updateList(query:String) {
        listAdapter = ArrayAdapter(requireActivity(), layout, formulaViewModel.getFormulaHeadlines(query))
    }

}