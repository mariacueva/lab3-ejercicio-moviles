package com.example.application1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.application1.ui.theme.Application1Theme

private val Fondo = Color(0xFFD5E8D4)
private val VerdeAndroid = Color(0xFF087F5B)
private val AzulLogo = Color(0xFF003B49)
private val VerdeRobot = Color(0xFF3DDC84)
private val TextoOscuro = Color(0xFF26352D)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Application1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Fondo
                ) {
                    PerfilAndroid()
                }
            }
        }
    }
}

@Composable
fun PerfilAndroid() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logotipo centrado
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AndroidLogo()

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Maria Cueva",
                fontSize = 30.sp,
                fontWeight = FontWeight.Light,
                color = TextoOscuro,
                textAlign = TextAlign.Center,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Android Developer Pro",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = VerdeAndroid,
                textAlign = TextAlign.Center
            )
        }

        // Datos de contacto en la parte inferior
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.65f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Contacto(
                icono = "☎",
                texto = "+51 988 770 780"
            )
            Spacer(modifier = Modifier.height(12.dp))


            Contacto(
                icono = "◎",
                texto = "https://github.com/mariacueva"
            )
            Spacer(modifier = Modifier.height(12.dp))

            Contacto(
                icono = "✉",
                texto = "maria.cueva@tecsup.edu.pe"
            )
        }
    }
}

@Composable
fun AndroidLogo() {
    Column(
        modifier = Modifier
            .size(108.dp)
            .background(
                color = AzulLogo,
                shape = RoundedCornerShape(0.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Canvas(
            modifier = Modifier
                .width(68.dp)
                .height(54.dp)
        ) {
            val w = size.width
            val h = size.height

            // Antenas
            drawLine(
                color = VerdeRobot,
                start = Offset(w * 0.32f, h * 0.25f),
                end = Offset(w * 0.20f, h * 0.02f),
                strokeWidth = 3f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = VerdeRobot,
                start = Offset(w * 0.68f, h * 0.25f),
                end = Offset(w * 0.80f, h * 0.02f),
                strokeWidth = 3f,
                cap = StrokeCap.Round
            )

            // Cabeza del robot
            drawRoundRect(
                color = VerdeRobot,
                topLeft = Offset(w * 0.12f, h * 0.22f),
                size = Size(w * 0.76f, h * 0.48f),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                    w * 0.38f, h * 0.38f
                )
            )

            // Ojos
            drawCircle(
                color = AzulLogo,
                radius = 2.5f,
                center = Offset(w * 0.35f, h * 0.42f)
            )

            drawCircle(
                color = AzulLogo,
                radius = 2.5f,
                center = Offset(w * 0.65f, h * 0.42f)
            )

            // Cuerpo
            drawRoundRect(
                color = VerdeRobot,
                topLeft = Offset(w * 0.18f, h * 0.73f),
                size = Size(w * 0.64f, h * 0.22f),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                    3f, 3f
                )
            )
        }

        Text(
            text = "android",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun Contacto(
    icono: String,
    texto: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = icono,
            color = VerdeAndroid,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(32.dp),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = texto,
            color = TextoOscuro,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaPerfil() {
    Application1Theme {
        PerfilAndroid()
    }
}
