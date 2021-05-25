package models

import android.util.Log


class FormulaManager(repo: FormulaRepository) {
    val nameArray: Array<String> = arrayOf("Kapitalformel","Annuitetsopsparing","Kvadratsætning 1", "Kvadratsætning 2", "Kvadratsætning 3", "Phytagoras")
    val descriptionArray: Array<String> = arrayOf("Startkapital K0 \n Rente p% pr. termin  \n Kapital K efter n terminer","Terminsindbetaling b \n Rentefod r  \n Antal indbetalinger n  \n Kapital A efter sidste indbetaling"
    , "Kvadratsætning", "Kvadratsætninger", "Kvadratsætninger", "Find længden af hypotanusen")
    val categoryArray: Array<String> = arrayOf("Økonomi", "Økonomi", "Matematik", "Matematik", "Matematik", "Trigonometri")
    val mathjaxArray: Array<String> = arrayOf("K = k0 * (1+r)^n", "A=b*(((1+r)^n-1)/r)","(a+b)^2 = a^2 + b^2 + 2a*b","(a-b)^2 = a^2 + b^2 - 2a*b","(a+b)*(a-b) = a^2 - b^2", "c^2 = a^2 + b^2")
    private lateinit var formulas: List<Formula>
    var repository = repo

    init {
        Log.d("LOGGER", "init : FormulaManager")

        if(repository.formulas.isEmpty()){makeFormulaDatabase()}

        makeFormulaList()
    }

    private fun makeFormulaDatabase(){
       for (i in 0..5){
           var formula = Formula()

           formula.name = nameArray[i]
           formula.category = categoryArray[i]
           formula.description = descriptionArray[i]
           formula.mathJaxForm = mathjaxArray[i]
           formula.form = "Form"
           repository.insert(formula)
        }
    }

    private fun makeFormulaList(){

        formulas = repository.formulas
    }
    fun getFormulaHeadlines(query : String): Array<String?> {

        repository.updateFormula(query)
        formulas = repository.formulas

        val formulaHeadlines = arrayOfNulls<String>(formulas.size)

        formulas.forEachIndexed{i, formula -> formulaHeadlines[i] = "Formula: " + formula.name + "\n" + "Category: " +formula.category + "\n" + formula.mathJaxForm}

        return formulaHeadlines
    }

    fun getFormulas(): List<Formula> {
        return formulas
    }
}