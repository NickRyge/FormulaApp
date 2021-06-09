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
        initFormulaHeadlines()
        initFormulas()

    }

    //Runs the SQL query. (Its just get * from formulas)
    private fun initFormulas() {
        formulas = formulaManager.getFormulas()
    }

    private fun initFormulaHeadlines() {
        //formulaHeadlines = formulaManager.getFormulaHeadlines()
    }

    fun getFormulaHeadlines(query: String):Array<String?>{
        return formulaManager.getFormulaHeadlines(query)
    }

    //This is never used, we use getFormulaHeadlines
    fun getFormula():List<Formula>{
        return formulas
    }

    //This is never used, we use getFormulaHeadlines
    fun getFormula(query: String):List<Formula>{
        return formulas
    }

    fun setClickedFormula(clicked: Int){
        clickedFormula.value = Pair(clicked, formulas[clicked])
    }

    fun getClickedFormula(): LiveData<Pair<Int, Formula>>{
        return clickedFormula
    }

}