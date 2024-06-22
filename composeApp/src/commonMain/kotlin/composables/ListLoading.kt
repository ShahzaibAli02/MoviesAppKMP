package composables
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun LazyListScope.ListLoading(visible:Boolean)
{

    items(3) {
        if (it != 0) Spacer(modifier = Modifier.width(10.dp))

        AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
        ) {
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
}