package com.dli46.entertainment

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.preference.PreferenceManager
import com.dli46.entertainment.App.Companion.EFFECT_SELECTION
import com.dli46.entertainment.App.Companion.SHOW_MESSAGE_AT_START
import com.dli46.entertainment.App.Companion.SHOW_NOW_IMAGE

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment

    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Entertainment)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.let {
                it.title = when (destination.id) {

                    // display responding title to cover the Action Bar
                    R.id.infoFragment -> getString(R.string.app_info)
                    R.id.settingsFragment -> getString(R.string.settings)
                    R.id.webviewFragment -> getString(R.string.webview)
                    R.id.webviewFragment -> getString(R.string.colorview)
                    else -> getString(R.string.app_name)
                }
            }
        }

        if (savedInstanceState == null) {
            if (prefs.getBoolean(SHOW_MESSAGE_AT_START, true)) {
                welcomeAlert()
            }
        }

    }

    override fun onSupportNavigateUp() =
        Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.reset_menuItem -> {
                // doesn't notify listeners
//                prefs.edit().clear().apply()
                with(prefs.edit()) {
                    remove(SHOW_MESSAGE_AT_START)
                    remove(SHOW_NOW_IMAGE)
                    remove(EFFECT_SELECTION)
                    apply()
                }
                true
            }
            // if click on action_info, go to info Fragment
            R.id.info_menuItem -> {
                navHostFragment.navController.navigate(R.id.action_mainFragment_to_infoFragment)
                true
            }
            // if click on action_settings, go to settings Fragment
            R.id.settings_menuItem -> {
                navHostFragment.navController.navigate(R.id.action_mainFragment_to_settingsFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }


    private fun welcomeAlert() {
        val msg = resources.getString(R.string.welcome_msg)
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.welcome)
            setMessage(msg)
//            setIcon(R.drawable.entertainments)
            setPositiveButton(R.string.ok, null)
            show()
        }
    }


}