package com.app.vocab.features.home.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.app.vocab.features.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val words = homeViewModel.words.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { homeViewModel.clearData() }) {
            Text(text = "Clear me")
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(words.itemCount, key = words.itemKey { it.word }) { index ->
                val word = words[index]
                if (word != null) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .border(
                                BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(vertical = 8.dp, horizontal = 12.dp),
                        text = word.word,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 34.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            words.apply {
                when {
                    loadState.refresh is androidx.paging.LoadState.Loading -> {
                        item { CircularProgressIndicator() }
                    }

                    loadState.append is androidx.paging.LoadState.Loading -> {
                        item { CircularProgressIndicator() }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreView() {
    HomeScreen(PaddingValues(0.dp))
}