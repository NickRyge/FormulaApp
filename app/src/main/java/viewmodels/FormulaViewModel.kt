package viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.Formula
import models.FormulaManager

class FormulaViewModel: ViewModel() {

    private lateinit var formulas: ArrayList<Formula>
    private lateinit var formulaHeadlines: Array<String?>
    private var clickedFormula = MutableLiveData<Pair<Int, Formula>>()
    private val formulaManager = FormulaManager()


    init {
        Log.d("LOGGER", "init : FormulaViewModel")
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

    fun getFormula():ArrayList<Formula>{
        return formulas
    }

    fun setClickedFormula(clicked: Int){
        clickedFormula.value = Pair(clicked, formulas[clicked])
    }

    fun getClickedFormula(): LiveData<Pair<Int, Formula>>{
        return clickedFormula
    }

}