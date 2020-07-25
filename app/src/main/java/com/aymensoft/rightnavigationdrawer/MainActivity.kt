package com.aymensoft.rightnavigationdrawer

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLanguage.setLocale(this@MainActivity, "ar")
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false);
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        navigationSetOnClickListener()
        supportFragmentManager.beginTransaction()
                .replace(R.id.view, HomeFragment())
                .commit()
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return false
    }

    fun navigationSetOnClickListener(){
        val nav_home = findViewById<View>(R.id.nav_home) as TextView
        val nav_resume = findViewById<View>(R.id.nav_resume) as TextView
        val nav_github = findViewById<View>(R.id.nav_github) as TextView
        val nav_blog = findViewById<View>(R.id.nav_blog) as TextView
        val nav_portfolio = findViewById<View>(R.id.nav_portfolio) as TextView

        nav_home.setOnClickListener {
            nav_home.setTextColor(Color.BLACK)
            nav_resume.setTextColor(R.color.unselectedColor)
            nav_github.setTextColor(Color.BLACK)
            nav_blog.setTextColor(Color.BLACK)
            nav_portfolio.setTextColor(Color.BLACK)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.view, HomeFragment())
                    .commit()
        }
        nav_resume.setOnClickListener {
            nav_resume.setTextColor(Color.BLACK)
            nav_home.setTextColor(Color.BLACK)
            nav_github.setTextColor(Color.BLACK)
            nav_blog.setTextColor(Color.BLACK)
            nav_portfolio.setTextColor(Color.BLACK)
            Toast.makeText(this, "RESUME", Toast.LENGTH_LONG).show()
        }
        nav_github.setOnClickListener {
            Toast.makeText(this, "GITHUB", Toast.LENGTH_LONG).show()
        }
        nav_blog.setOnClickListener {
            Toast.makeText(this, "BLOG", Toast.LENGTH_LONG).show()
        }
        nav_portfolio.setOnClickListener {
            Toast.makeText(this, "PORTFOLIO", Toast.LENGTH_LONG).show()
        }

    }
}