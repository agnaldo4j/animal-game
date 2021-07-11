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
  val message: String = "You win!",
  val yes: BinTreeNode = null,
  val no: BinTreeNode = null
) extends BinTreeNode(
  statement = message,
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

// case class NextInteraction(message: String, rootNode: BinTreeNode, actualNode: BinTreeNode)

object AnimalGame:
  def build(): AnimalGame = {
    val newCharacteristic =
      CharacteristicGuess(characteristic = "Does the animal meow?",
       yes = AnimalGuess(characteristic =  "Is it a cat?"),
       no = AnimalGuess(characteristic = "Is the animal a dog?!?")
      )
    new AnimalGame(newCharacteristic)
  }

class AnimalGame(val root : BinTreeNode):

  def isAnimalGuess(animalGuess: BinTreeNode) = animalGuess match {
    case AnimalGuess(_,_,_) => true
    case _ => false
  }

  def isReady(): Boolean = root match {
    case CharacteristicGuess(_, yes, no) if (isAnimalGuess(yes) && isAnimalGuess(no)) => true
    case _ => false
  }

  def start(): (String, NewGame) = {
    ("Pense em um animal para iniciar o jogo e pressione enter", new NewGame(root, root)) // back to initial game state
  }

//  def nextRound(nextInteraction: NextInteraction): NextInteraction = {
//    NextInteraction(
//      message=nextInteraction.actualNode.statement,
//      nextInteraction.actualNode,
//      nextInteraction.actualNode
//    )
//  }

class NewGame(val rootNode : BinTreeNode, val currentNode : BinTreeNode):
  def getStatement(): String = currentNode.statement

  def nextRound(answer: String ):NewGame = answer match {
    case "yes" if (isCharacteristicGuess(currentNode))  => new NewGame(rootNode, currentNode.left)
    case "yes" if (isAnimalGuess(currentNode))  => new NewGame(rootNode, currentNode.left)
    case "no" if (isCharacteristicGuess(currentNode)) => new NewGame(rootNode, currentNode.right)
    case "no" if (isAnimalGuess(currentNode)) => new NewGame(rootNode, currentNode.right)
  }

  def isCharacteristicGuess(characteristicGuess: BinTreeNode) = characteristicGuess match {
    case CharacteristicGuess(_,_,_) => true
    case _ => false
  }

  def isAnimalGuess(characteristicGuess: BinTreeNode) = characteristicGuess match {
    case AnimalGuess(_,_,_) => true
    case _ => false
  }

