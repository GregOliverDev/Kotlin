import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.example.viewers.PlayerMenu
import models.player.Player

class PlayerMenuTest {

    @Test
    fun `should create player and return correct Player object`() {
        val playerName = "John Doe"
        val nextId = 1

        val playerMenu = PlayerMenu(nameProvider = { playerName })

        val player = playerMenu.createPlayerMenu(nextId)

        assertNotNull(player)
        assertEquals(nextId, player.id)
        assertEquals(playerName, player.namePlayer)
        assertNull(player.characterSheet)
    }
}
