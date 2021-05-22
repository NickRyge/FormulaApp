package viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.Formula
import models.FormulaManager
import models.FormulaRepository

class FormulaViewModel: ViewModel() {

    private lateinit var formulas: List<Formula>
    private lateinit var formulaHeadlines: Array<String?>
    lateinit var repo : FormulaRepository
    private var clickedFormula = MutableLiveData<Pair<Int, Formula>>()
    private lateinit var formulaManager : FormulaManager



    fun initialize() {
        formulaManager = FormulaManager(repo)
        initFormulas()
        initFormulaHeadlines()
    }
    private fun initFormulaHeadlines() {
        formulaHeadlines = formulaManager.getFormulaHeadlines()
    }

    private fun initFormulas() {
        formulas = formulaManager.getFormulas()
    }

    fun getFormulaHeadlines():Array<String?>{
        return formulaHeadlines
    }

    fun getFormula():List<Formula>{
        return formulas
    }

    fun setClickedFormula(clicked: Int){
        clickedFormula.value = Pair(clicked, formulas[clicked])
    }

    fun getClickedFormula(): LiveData<Pair<Int, Formula>>{
        return clickedFormula
    }



}