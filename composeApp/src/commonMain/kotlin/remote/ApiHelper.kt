package remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import model.Movie

class ApiHelper
{

    val BASE_URL = "https://api.themoviedb.org/3"
    val API_POPULAR = "$BASE_URL/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc"
    val API_UPCOMING = "$BASE_URL/movie/upcoming?language=en-US&page=1c"
    val bearerToken = "AUTH_TOKEN"

    val client = HttpClient()
    suspend fun getPopularMovies(): sealed.Result<List<Movie>>
    {

        return try
        {
            val response = client.get(API_POPULAR) {
                headers {
                    append(
                            "Authorization",
                            "Bearer $bearerToken"
                    )
                }
            }
            val movies = parseMovies(response)
            sealed.Result.Success(movies)
        } catch (e: Exception)
        {
            sealed.Result.Error("Failed to load movies")
        }

    }

    suspend fun getUpcomingMovies(): sealed.Result<List<Movie>>
    {

        return try
        {
            val response = client.get(API_UPCOMING) {
                headers {
                    append(
                            "Authorization",
                            "Bearer $bearerToken"
                    )
                }
            }
            val movies = parseMovies(response)
            sealed.Result.Success(movies)
        } catch (e: Exception)
        {
            sealed.Result.Error("Failed to load movies")
        }

    }

    private suspend fun parseMovies(response: HttpResponse): List<Movie>
    {
        val jsonElement = Json.parseToJsonElement(response.bodyAsText())
        val jsonObject = jsonElement.jsonObject
        val jsonArray = jsonObject["results"]?.jsonArray
        val movies = mutableListOf<Movie>()
        if (jsonArray != null)
        {
            for (element in jsonArray)
            {
                val adult: Boolean = element.jsonObject["adult"]?.jsonPrimitive?.boolean ?: false
                val backdrop_path: String = element.jsonObject["backdrop_path"]?.jsonPrimitive?.contentOrNull
                    ?: ""
                val id: Int = element.jsonObject["id"]?.jsonPrimitive?.int ?: 0
                val original_title: String = element.jsonObject["original_title"]?.jsonPrimitive?.contentOrNull
                    ?: ""
                val overview: String = element.jsonObject["overview"]?.jsonPrimitive?.contentOrNull
                    ?: ""
                val popularity: Double = element.jsonObject["popularity"]?.jsonPrimitive?.double
                    ?: 0.0
                val poster_path: String = element.jsonObject["poster_path"]?.jsonPrimitive?.contentOrNull
                    ?: ""
                val release_date: String = element.jsonObject["release_date"]?.jsonPrimitive?.contentOrNull
                    ?: ""
                val title: String = element.jsonObject["title"]?.jsonPrimitive?.contentOrNull ?: ""
                val video: Boolean = element.jsonObject["video"]?.jsonPrimitive?.boolean ?: false
                val movie = Movie(
                        adult,
                        backdrop_path,
                        id,
                        original_title,
                        overview,
                        popularity,
                        poster_path,
                        release_date,
                        title,
                        video
                )
                movies.add(movie)
            }
        }
        return movies
    }
}