import org.scalatest.freespec.AnyFreeSpec

class AnimalGameSpec extends AnyFreeSpec:
  "The Animal Game" - {
    "when I prepare a new game" - {
      val animalGame = AnimalGame.build()

      "animal game should be ready" in {
        assert(animalGame.isReady() === true)
      }

//      "should have just one Characteristic Node" in {
//
//        assert(2 === 2)
//      }
    }
  }
