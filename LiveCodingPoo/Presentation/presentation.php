<?php
require "../Services/bookService.php";
require "../Enteties/book.php";
class presentation
{
    public function displayBooks()
    {
        $bookService = new bookService();
        $books = $bookService->getBooks();
        if (!empty($books)) {
            foreach ($books as $book) {
                echo "Title: " . $book->getTitle() . "\n";
                echo "ISBN: " . $book->getISBN() . "\n";
                echo "ID: " . $book->getId() . "\n";
                echo "--------------------------------\n";
            }
        } else {
            echo "book was not found";
        }
    }

    public function addBooks()
    {
        $title = answerOf("Enter book title: ");
        if (strtolower($title) === "exit") {
            return;
        }
        $ISBN = answerOf("Enter ISBN of the book: ");
        if (strtolower($ISBN) === answerOf("exit")) {
            return;
        }

        $books = new books($title, $ISBN);
        $bookService = new bookService();
        $bookService->setBooks($books);
        echo "book was added successfully!\n\n";
    }
}