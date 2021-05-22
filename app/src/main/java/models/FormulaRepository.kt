package models

class FormulaRepository(private val formulaDao: FormulaDao) {

    val formulas = formulaDao.getformulas()

    fun insert(formula: Formula) {
        formulaDao.insert(formula)
    }
}