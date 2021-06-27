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

      animalGame.start()

      "When first move is yes" - {
        animalGame.nextRound("yes")
        //assert(animalGame.actualNode.yes.isInstanceOf[AnimalGuess])
      }
    }
  }
