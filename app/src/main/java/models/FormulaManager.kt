package models


class FormulaManager {

    private lateinit var formulas: ArrayList<Formula>

    init {
        makeFormulaList()
    }

    private fun makeFormulaList(){
        formulas.add(
                Formula(
                        "Lorem ipsum", "Fysik", "5*5*5", "666", "LAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANG BESKRIVELSE"
                )
        )
        formulas.add(
                Formula(
                        "Lorem ipsum", "Fysik", "5*5*5", "667", "LAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANG BESKRIVELSE"
                )
        )
        formulas.add(
                Formula(
                        "Lorem ipsum", "Fysik", "5*5*5", "668", "LAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANG BESKRIVELSE"
                )
        )
    }
    fun getFormulaHeadlines(): Array<String?> {
        val formulaHeadlines = arrayOfNulls<String>(formulas.size)

        formulas.forEachIndexed{i, formula -> formulaHeadlines[i] = formula.name + " " + formula.category + " " + formula.mathJaxForm}

        return formulaHeadlines
    }

    fun getFormulas(): ArrayList<Formula> {
        return formulas
    }
}