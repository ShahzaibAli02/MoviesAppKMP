package composables


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
 fun MovieCategories()
{
    Text(
            text = "Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color.White
    )
    Spacer(modifier = Modifier.height(6.dp))
    Row {
        Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFdf4258)),
                modifier = Modifier,
                shape = RoundedCornerShape(20.dp),
                onClick = {

                },
        ) {
            Text(
                    text = "All",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
            )
        }

        Spacer(modifier = Modifier.width(6.dp))
        Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2f466c)),
                modifier = Modifier,
                shape = RoundedCornerShape(20.dp),
                onClick = {

                },
        ) {
            Text(
                    text = "Action",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2f466c)),
                modifier = Modifier,
                shape = RoundedCornerShape(20.dp),
                onClick = {

                },
        ) {
            Text(
                    text = "Comedy",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif
            )
        }


    }
}
