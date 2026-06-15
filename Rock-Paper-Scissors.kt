import kotlin.random.Random

fun main() {

    var userScore = 0
    var computerScore = 0
    var roundsPlayed = 0
    val maxRounds = 3

    println("Welcome to Rock-Paper-Scissors! Let's start the game.")

    while (roundsPlayed < maxRounds) {
        println("\n--- Round ${roundsPlayed + 1} ---")

        val userChoice = getUserChoice()
        val computerChoice = getComputerChoice()

        println("You chose: $userChoice")
        println("Computer chose: $computerChoice")

        val roundWinner = determineRoundWinner(userChoice, computerChoice)

        when (roundWinner) {
            "User" -> {
                println("Result: You win this round!")
                userScore++
            }
            "Computer" -> {
                println("Result: Computer wins this round!")
                computerScore++
            }
            "Draw" -> {
                println("Result: It's a draw! No points awarded.")
            }
        }

        roundsPlayed++
    }

    println("\n=== Game Over! ===")
    println("Final Score -> You: $userScore | Computer: $computerScore")

    if (userScore > computerScore) {
        println("Congratulations! You scored higher and are the overall winner!")
    } else if (computerScore > userScore) {
        println("The computer scored higher. Better luck next time!")
    } else {
        println("It's a perfect tie!")
    }
}

fun getUserChoice(): String {
    var isValid = false
    var choice = ""

    while (!isValid) {
        print("Enter your choice (Rock, Paper, or Scissors): ")
        val input = readlnOrNull()?.trim()?.uppercase()

        if (input == "ROCK" || input == "PAPER" || input == "SCISSORS") {
            choice = input
            isValid = true
        } else {
            println("Invalid input. Please type Rock, Paper, or Scissors.")
        }
    }
    return choice
}

fun getComputerChoice(): String {
    val choices = arrayOf("ROCK", "PAPER", "SCISSORS")
    return choices.random()
}

fun determineRoundWinner(user: String, computer: String): String {
    if (user == computer) {
        return "Draw"
    }

    return when (user) {
        "ROCK" -> if (computer == "SCISSORS") "User" else "Computer"
        "PAPER" -> if (computer == "ROCK") "User" else "Computer"
        "SCISSORS" -> if (computer == "PAPER") "User" else "Computer"
        else -> "Draw"
    }
}