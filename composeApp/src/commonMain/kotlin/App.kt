import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import composables.BottomNavigation
import composables.MovieCategories
import composables.MovieSection
import composables.MoviesHeader
import composables.MoviesRow
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import model.Movie
import moviesproject.composeapp.generated.resources.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import remote.ApiHelper
import sealed.Result

@Composable @Preview fun App()
{
    MaterialTheme {
        var currentIndex by remember { mutableStateOf(0) }
        var listPopularMovies by remember {
            mutableStateOf<Result<List<Movie>>>(Result.Loading(""))
        }
        var listUpcomingMovies by remember {
            mutableStateOf<Result<List<Movie>>>(Result.Loading(""))
        }
        val listOfImages = remember {
            listOf(
                    Res.drawable.img1,
                    Res.drawable.img3,
                    Res.drawable.img4
            )
        }


        LaunchedEffect(Unit) {
            async {
                listPopularMovies = ApiHelper().getPopularMovies()
            }
            async {
                listUpcomingMovies = ApiHelper().getUpcomingMovies()
            }

        }
        LaunchedEffect(Unit) {
            while (isActive)
            {
                delay(1500)
                currentIndex = (currentIndex + 1) % listOfImages.size
            }
        }
        Scaffold(bottomBar = {
            BottomNavigation()
        }) {
            Column(
                    modifier = Modifier.fillMaxSize().padding(it)
                        .background(color = Color(0xFF01011f)).verticalScroll(rememberScrollState())
            ) {


                MoviesHeader(
                        listOfImages,
                        currentIndex
                )


                Column(
                        modifier = Modifier.padding(
                                start = 15.dp,
                                end = 15.dp,
                                top = 10.dp
                        )
                ) {

                    MovieCategories()

                    Spacer(modifier = Modifier.height(5.dp))

                    MovieSection(sectionName = "Popular")
                    Spacer(modifier = Modifier.height(10.dp))
                    MoviesRow(listPopularMovies)

                    Spacer(modifier = Modifier.height(10.dp))

                    MovieSection(sectionName = "Upcoming")
                    Spacer(modifier = Modifier.height(10.dp))

                    MoviesRow(listUpcomingMovies)

                    Spacer(modifier = Modifier.height(20.dp))


                }


            }
        }
    }
}












