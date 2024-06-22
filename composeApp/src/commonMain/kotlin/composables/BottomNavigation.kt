package composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moviesproject.composeapp.generated.resources.Res
import moviesproject.composeapp.generated.resources.ic_home
import moviesproject.composeapp.generated.resources.ic_person
import moviesproject.composeapp.generated.resources.ic_search
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable @Preview fun BottomNavigation(modifier: Modifier = Modifier)
{
    Row(
            modifier = modifier.fillMaxWidth().background(color = Color(0xFF25233C)).padding(10.dp)
    ) {
        Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.ic_home),
                    contentDescription = "Home"
            )
            Text(
                    text = "Home",
                    color = Color(0xFFdf4258),
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
            )
        }
        Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.ic_search),
                    contentDescription = "Home"
            )
            Text(
                    text = "Search",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
            )
        }

        Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.ic_person),
                    contentDescription = "Home"
            )
            Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.SansSerif,
            )
        }

    }
}