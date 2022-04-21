package com.example.ui_herolist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.ImageLoader
import com.example.core.ProgressBarState
import com.example.ui_herolist.components.HeroListItem

@Composable
fun HeroList(
    state: HeroListState,
    imageLoader: ImageLoader,
    navigateToDetailScreen:(Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        LazyColumn {
            items(
                state.heros.size
            ) {
                HeroListItem(
                    hero = state.heros[it],
                    onSelectHero = {
                        navigateToDetailScreen(it)
                    },
                    imageLoader = imageLoader
                )
            }
        }

        if (state.progressBarState is ProgressBarState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}

