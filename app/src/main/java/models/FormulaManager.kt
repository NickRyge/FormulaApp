package models

import android.util.Log


class FormulaManager(repo: FormulaRepository) {

    private lateinit var formulas: List<Formula>
    var repository = repo

    init {
        Log.d("LOGGER", "init : FormulaManager")

        makeFormulaDatabase()
        makeFormulaList()
    }

    private fun makeFormulaDatabase(){
       for (i in 1..10){
           var formula = Formula()
           //formula.uid = i
           formula.name = "Name"
           formula.category = "Category"
           formula.description = "Description"
           formula.mathJaxForm = "Mathjax"
           formula.form = "Form"
           repository.insert(formula)
        }
    }

    private fun makeFormulaList(){
        formulas = repository.formulas
    }
    fun getFormulaHeadlines(): Array<String?> {
        val formulaHeadlines = arrayOfNulls<String>(formulas.size)

        formulas.forEachIndexed{i, formula -> formulaHeadlines[i] = formula.name + " " + formula.category + " " + formula.mathJaxForm}

        return formulaHeadlines
    }

    fun getFormulas(): List<Formula> {
        return formulas
    }
}