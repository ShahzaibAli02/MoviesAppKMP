package composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import moviesproject.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable fun MoviesHeader(
    listOfImages: List<DrawableResource>,
    currentIndex: Int,
)
{
    Box(modifier = Modifier.fillMaxWidth().height(250.dp)) {

        Image(
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxWidth().height(250.dp),
                painter = painterResource(listOfImages[currentIndex]),
                contentDescription = ""
        )

        LazyRow(modifier = Modifier.align(Alignment.BottomCenter)) {
            items(listOfImages.size) {
                Dot(
                        color = if (it == currentIndex) Color.Red else Color.Gray,
                        selected = it == currentIndex
                )
            }
        }
    }
}

@Composable
fun Dot (modifier: Modifier = Modifier, color: Color,selected:Boolean)
{
    val animatableWidth = remember { Animatable(if (selected) 25f else 0f) }

    LaunchedEffect(selected) {
        animatableWidth.animateTo(
                if (selected) 25f else 0f,
                animationSpec = tween(durationMillis = 500, easing = LinearEasing)
        )
    }
    Box(
            modifier = modifier.zIndex(2f).padding(
                    start = 5.dp,
                    bottom = 10.dp
            ).size(width=if(selected) animatableWidth.value.dp else 7.dp,height=7.dp).background(
                    color = color,
                    shape = RoundedCornerShape(10.dp)
            )
    )
}