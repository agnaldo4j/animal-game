import org.scalatest.freespec.AnyFreeSpec

class AnimalGameSpec extends AnyFreeSpec:
  "The Animal Game" - {
    val animalGame = AnimalGame.build()

    "When setting up the game" - {
      "animal game should be ready" in {
        assert(animalGame.isReady() === true)
      }
    }

    "When playing the game" - {
      val nextInteraction = animalGame.start()

      "Given a ready game I start the interaction" in {
        assert("Pense em um animal para iniciar o jogo e pressione enter" === nextInteraction.message)
      }

      "Given the first interaction I receive the characteristic question " in {
        val newNextInteraction = animalGame.nextRound(nextInteraction)
        assert(newNextInteraction.message = "Does the animal meow?")
      }
    }
  }
