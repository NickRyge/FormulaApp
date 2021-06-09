package com.example.formulaez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import viewmodels.FormulaViewModel
import androidx.fragment.app.activityViewModels
import models.Formula
import models.FormulaDatabase
import models.FormulaManager
import models.FormulaRepository


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LOGGER", "her : MainActivity")
        val db = FormulaDatabase.getFormulaDatabase(this)
        val repository = FormulaRepository(db!!.formulaDao())
        val formulaViewModel: FormulaViewModel by viewModels()
        formulaViewModel.repo = repository
        formulaViewModel.initialize()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment,

        // In case this activity was started with special instructions from an Intent,
        // pass the Intent's extras to the fragment as arguments
        var firstFragment: FormulaListFragment ?= null


        if (findViewById<View?>(R.id.fragment_container) != null) {

            firstFragment = FormulaListFragment()

            firstFragment.arguments = intent.extras

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return
            }

            // Add the fragment to the 'fragment_container' FrameLayout
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit()

        }

        formulaViewModel.getClickedFormula().observe(this, Observer{
// The user selected the headline of an article from the HeadlinesFragment

            // Capture the article fragment from the activity layout
            val articleFrag =
                    supportFragmentManager.findFragmentById(R.id.description_fragment) as FormulaDescriptionFragment?
            if (articleFrag == null) {

                val newFragment = FormulaDescriptionFragment()
                val transaction = supportFragmentManager.beginTransaction()
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, newFragment).addToBackStack(null)
                // Commit the transaction
                transaction.commit()
            }
        })

        var edit = findViewById<EditText>(R.id.input)
        edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                return
            }

            override fun afterTextChanged(s: Editable?) {
                   if (firstFragment != null) {

                       firstFragment.updateList(s.toString())

                   } else {

                       val temp = supportFragmentManager.findFragmentById(R.id.list_fragment) as FormulaListFragment?
                       temp!!.updateList(s.toString())

                   }
            }
        })
    }
}