package viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.Formula
import models.FormulaManager

class FormulaViewModel: ViewModel() {

    private lateinit var formulas: ArrayList<Formula>
    private lateinit var formulaHeadlines: Array<String?>
    private var selectedFormula = MutableLiveData<Pair<Int, Formula>>()
    private val formulaManager = FormulaManager()


    init {
        initFormulas()
        initFormulaHeadlines()
    }

    private fun initFormulaHeadlines() {
        formulaHeadlines = formulaManager.getFormulaHeadlines()
    }

    private fun initFormulas() {
        formulas = formulaManager.getFormulas()
    }

}