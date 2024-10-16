<?php
require "./presentation.php";

function answerOf($question)
{
    echo $question;
    return trim(fgets(STDIN));
}

function library_management()
{
    echo chr(27) . chr(codepoint: 91) . 'H' . chr(27) . chr(91) . 'J';
    echo "Welcome to the Books List Manager\n\n";

    $exitProgram = false;
    while (!$exitProgram) {
        echo "+------------------------------------+\n";
        echo "|          My Book Library           |\n";
        echo "|------------------------------------|\n";
        echo "|         Select an option :         |\n";
        echo "|------------------------------------| \n";
        echo "| [v] - Display all the books        |\n";
        echo "| [a] - Add a new Book               |\n";
        echo "| [exit] - Exit the Library          |\n";
        echo "+------------------------------------+\n\n";

        $action = answerOf("Your choice: ");
        switch (strtolower($action)) {
            case 'v':
                $presentation = new presentation();
                $presentation->displayBooks();
                break;

            case 'a':
                $presentation = new presentation();
                $presentation->addBooks();
                break;

            case 'exit':
                $exitProgram = true;
                break;

            default:
                echo "Invalid choice. Please try again.\n";
                break;
        }
    }
    echo "Exiting the program. Goodbye!\n";
}

library_management();