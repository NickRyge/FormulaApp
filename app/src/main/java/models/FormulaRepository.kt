package models

class FormulaRepository(private val formulaDao: FormulaDao) {

    var formulas = formulaDao.getformulas()

    fun updateFormula(query: String) {
        formulas = formulaDao.getSearchedFormula("%" + query + "%")
    }

    fun insert(formula: Formula) {
        formulaDao.insert(formula)
    }
}