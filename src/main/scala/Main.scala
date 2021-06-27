class BinTreeNode(
  val statement: String,
  val left: BinTreeNode,
  val right: BinTreeNode
)

case class CharacteristicGuess(
  val characteristic: String,
  val yes: BinTreeNode, // TODO accept only CharacteristicGuess and AnimalGuess types
  val no: BinTreeNode   // TODO accept only CharacteristicGuess and AnimalGuess types
) extends BinTreeNode(
  statement = characteristic,
  left = yes,
  right = no
)

case class AnimalGuess(
  val characteristic: String,
  val yes: AnimalFound = AnimalFound(),
  val no: AnimalNotFound = AnimalNotFound()
) extends BinTreeNode(
  statement = characteristic,
  left = yes,
  right = no
)

case class AnimalFound(
  val name: String = "You win!",
  val yes: BinTreeNode = null,
  val no: BinTreeNode = null
) extends BinTreeNode(
  statement = name,
  left = yes,
  right = no
)

case class AnimalNotFound(
  val message: String = "Animal Not Found!",
  val yes: BinTreeNode = null,
  val no: BinTreeNode = null
) extends BinTreeNode(
  statement = message,
  left = yes,
  right = no
)

object AnimalGame:
  def build(): AnimalGame = {
    val newCharacteristic =
         CharacteristicGuess(characteristic = "Does the animal meow?",
         yes = AnimalGuess(characteristic =  "Is it a cat?"),
         no = AnimalGuess(characteristic = "Is the animal a dog?!?")
      )
    new AnimalGame(newCharacteristic)
  }

class AnimalGame(val root : CharacteristicGuess):

  def isAnimalGuess(animalGuess: BinTreeNode) = animalGuess match {
    case AnimalGuess(_,_,_) => true
    case _ => false
  }

  def isReady(): Boolean = root match {
    case CharacteristicGuess(_, yes, no) if (isAnimalGuess(yes) && isAnimalGuess(no)) => true
    case _ => false
  }

  def start(): Unit = {

  }

  def nextRound(answer: String): Unit = {

  }

//@main def hello: Unit = {
//  println("Animal Game!")

//  val dog = AnimalGuess("Is the animal a dog?!?")
//  println(s"$dog")
//
//  val yes = dog.yes match {
//    case AnimalFound(name, yes, no) => name
//    case _ => println("Error!")
//  }
//
//  val no = dog.no match {
//    case AnimalNotFound(message, yes, no) => message
//    case _ => println("Error!")
//  }
//
//  println(s"yes $yes, no $no")



 // val newCharacteristic =
//     CharacteristicGuess(characteristic = "Does the animal meow?",
//     yes = AnimalGuess(characteristic =  "Is it a cat?"),
//      no = AnimalGuess(characteristic = "Is the animal a dog?!?")
//  )
//
//  println(newCharacteristic)
//}
