package composables
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MyAsyncImage(modifier:Modifier=Modifier, url: String)
{
    var showLoading by remember { mutableStateOf(false) }
    AsyncImage(
            modifier = modifier.size(
                    100.dp,
                    150.dp
            ).clip(shape = RoundedCornerShape(10.dp)),
            onLoading = {
                showLoading=true
            },
            onError = {
                showLoading=false
            },
            onSuccess = {
                showLoading=false
            },
            contentScale = ContentScale.Crop,
            model = url, // replace with working URL
            contentDescription = null
    )
    if(showLoading)
    {
        Box(
                modifier = Modifier.size(
                        100.dp,
                        150.dp
                ).clip(shape = RoundedCornerShape(10.dp)).background(Color(0xFF2f466c)),
        ) {
            CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center).size(20.dp),
                    color = Color.White
            )
        }
    }

}
