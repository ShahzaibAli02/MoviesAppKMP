package composables
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import model.Movie
import sealed.Result

@Composable
fun MoviesRow(listPopularMovies: Result<List<Movie>>)
{

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(200) // Delay to allow the LazyRow to layout before animating
        visible = true
    }
    LazyRow {

        if (listPopularMovies is Result.Loading)
        {
            ListLoading(visible)
        }
        if (listPopularMovies is Result.Success)
        {

            itemsIndexed((listPopularMovies as Result.Success<List<Movie>>).data) { index, item ->
                if (index != 0) Spacer(modifier = Modifier.width(10.dp))
                MyAsyncImage(url = "https://image.tmdb.org/t/p/w500${item.poster_path}")
            }

        }


    }
}
