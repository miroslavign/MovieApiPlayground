/*
 * PerScreen.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/10/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.di

import javax.inject.Scope

/**
 * Custom Scope for each Screen
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScreen