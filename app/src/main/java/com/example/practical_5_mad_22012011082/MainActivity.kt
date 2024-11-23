package com.example.practical_5_mad_22012011082

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.practical_5_mad_22012011082.screen.Login
import com.example.practical_5_mad_22012011082.screen.RegisterPage
import com.example.practical_5_mad_22012011082.ui.theme.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}