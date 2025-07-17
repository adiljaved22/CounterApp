package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel = viewModel()
            CounterAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),
                    color = MaterialTheme.colorScheme.background


                ) {
                    CounterApp(viewModel)
                }
            }
        }
    }

}

@Composable
fun CounterApp(viewModel: CounterViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Counter:${viewModel.count.value}",
            fontSize = 23.sp,
            fontWeight = Bold
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row {
            Button(onClick = { viewModel.increment() })
            {
                Text("Increment")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick =
                {
                    viewModel.decrement()
                    }
            )
            {
                Text("Decrement")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    CounterAppTheme {
            CounterApp(viewModel())
            }
}
