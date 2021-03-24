package com.example.formulaez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import viewmodels.FormulaViewModel
import androidx.fragment.app.activityViewModels


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val formulaViewModel: FormulaViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById<View?>(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return
            }

            // Create an instance of ExampleFragment
            val firstFragment = FormulaListFragment()

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.arguments = intent.extras

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
    }
}