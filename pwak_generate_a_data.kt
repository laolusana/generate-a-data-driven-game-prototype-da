// pwak_generate_a_data.kt

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class GameData(
    val id: Int,
    val title: String,
    val description: String,
    val genres: List<String>,
    val platforms: List<String>,
    val releaseDate: String
)

@Serializable
data class GamePrototype(
    val id: Int,
    val gameId: Int,
    val prototypeName: String,
    val prototypeDescription: String,
    val data: GameData
)

@Serializable
data class DashboardData(
    val totalGames: Int,
    val totalPrototypes: Int,
    val popularGames: List<GameData>,
    val newPrototypes: List<GamePrototype>
)

fun main() {
    val json = Json {
        prettyPrint = true
        indent = "    "
    }

    val gameData = GameData(
        id = 1,
        title = "Elder Scrolls V: Skyrim",
        description = "Action role-playing game",
        genres = listOf("Action", "RPG", "Adventure"),
        platforms = listOf("PC", "PS3", "PS4", "Xbox One", "Nintendo Switch"),
        releaseDate = "2011-11-11"
    )

    val gamePrototype = GamePrototype(
        id = 1,
        gameId = 1,
        prototypeName = "Skyrim Prototype",
        prototypeDescription = "A prototype for the Elder Scrolls V: Skyrim game",
        data = gameData
    )

    val dashboardData = DashboardData(
        totalGames = 10,
        totalPrototypes = 5,
        popularGames = listOf(gameData),
        newPrototypes = listOf(gamePrototype)
    )

    println(json.stringify(DashboardData.serializer(), dashboardData))
}