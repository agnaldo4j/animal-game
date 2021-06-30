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
      val (startGameMessage, gameRound1) = animalGame.start()

      "Given a ready game a start must return a proper message and a newGame instance" in {
        assert("Pense em um animal para iniciar o jogo e pressione enter" === startGameMessage)
        assert(gameRound1.isInstanceOf[NewGame])
      }

      "With the very first game round, the round question must match the root node question" in {
        assert(gameRound1.getQuestion() === "Does the animal meow?")
      }

      "From the first game round, answer `yes` goes to the Cat Animal" in {
        val gameRound2 = gameRound1.nextRound(answer = "yes")
        assert(gameRound2.getQuestion() === "Is it a cat?")
      }

      "From the first game round, answer `no` goes to the Dog Animal" in {
        val gameRound2 = gameRound1.nextRound(answer = "no")
        assert(gameRound2.getQuestion() === "Is the animal a dog?!?")
      }

      "Referential transparency check" in {
        assert(gameRound1.getQuestion() === "Does the animal meow?")
      }
    }
  }

// startGame()
// askQuestion()
// checkAnswer()