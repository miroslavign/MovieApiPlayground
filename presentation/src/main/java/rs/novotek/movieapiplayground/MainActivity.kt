/*
 * MainActivity.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 11/30/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import rs.novotek.domain.backend.RestApi
import rs.novotek.movieapiplayground.features.latestmovies.LatestMoviesView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.controller_container)
    lateinit var container: ViewGroup

    private lateinit var router: Router

    @Inject
    lateinit var restApi: RestApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        MovieApiPlaygroundApp.appComponent.inject(this)
        setSupportActionBar(toolbar)

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(LatestMoviesView()))
        }

        //testRest()
    }

    private fun testRest() {
        restApi.restService
                .getMovie(157336)
                .subscribe()
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
